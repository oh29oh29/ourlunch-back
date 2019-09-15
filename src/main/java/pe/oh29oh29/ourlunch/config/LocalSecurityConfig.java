package pe.oh29oh29.ourlunch.config;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Profile("local")
@EnableWebSecurity
public class LocalSecurityConfig extends SecurityConfig {

    @Override
    public void configure(WebSecurity web) {
        // 허용되어야 할 경로들
        web.ignoring().antMatchers(
                "/static/**", "/js/**", "/css/**", "/img/**",
                "/swagger-ui.html", "/webjars/**", "/swagger-resources/**", "/v2/**"
        );
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/login/**", "/oauth2/**", "/console/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .oauth2Login()
                .loginPage("/login")
                .defaultSuccessUrl("/login/success")
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));

        http.csrf().disable()
                .headers().frameOptions().disable();
    }
}