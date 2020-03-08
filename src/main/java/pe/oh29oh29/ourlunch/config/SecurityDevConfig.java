package pe.oh29oh29.ourlunch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Profile("dev")
@Configuration
@EnableWebSecurity
public class SecurityDevConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        // 허용되어야 할 경로들
        web.ignoring().antMatchers(
                "/images/**",
                "/css/**",
                "/js/**",
                "/swagger-ui.html",
                "/swagger-resources/**",
                "/webjars/**",
                "/v2/**"
        );
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

}