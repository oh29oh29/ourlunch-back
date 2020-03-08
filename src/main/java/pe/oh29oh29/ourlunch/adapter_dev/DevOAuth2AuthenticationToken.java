package pe.oh29oh29.ourlunch.adapter_dev;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class DevOAuth2AuthenticationToken {

    @Setter
    @Getter
    private OAuth2AuthenticationToken authentication;
}
