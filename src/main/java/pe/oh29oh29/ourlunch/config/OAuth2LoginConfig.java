package pe.oh29oh29.ourlunch.config;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import pe.oh29oh29.ourlunch.oauth2.CustomOAuth2Provider;

import java.util.List;

@Profile("!dev")
@Configuration
public class OAuth2LoginConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(
            @Value("${spring.security.oauth2.client.registration.kakao.client-id}") String clientId,
            @Value("${spring.security.oauth2.client.registration.kakao.client-secret}") String clientSecret
    ) {
        List<ClientRegistration> clientRegistrations =
                ImmutableList.of(CustomOAuth2Provider.KAKAO.getBuilder("kakao")
                        .clientId(clientId)
                        .clientSecret(clientSecret)
                        .jwkSetUri("temp")
                        .build()
                );

        return new InMemoryClientRegistrationRepository(clientRegistrations);
    }
}
