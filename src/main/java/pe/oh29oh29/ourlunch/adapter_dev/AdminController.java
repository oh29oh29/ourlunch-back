package pe.oh29oh29.ourlunch.adapter_dev;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.model.Response;

import java.sql.Timestamp;
import java.util.Map;

@RequiredArgsConstructor

@Profile("dev")
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final DevOAuth2AuthenticationToken devOAuth2AuthenticationToken;

    @PostMapping("/login")
    public Response login() {
        final String nameAttributeKey = "name";
        final Map<String, Object> attributes = ImmutableMap.of(nameAttributeKey, generateDevId());
        final ImmutableList<OAuth2UserAuthority> authorities = ImmutableList.of(new OAuth2UserAuthority(attributes));
        final OAuth2User principal = new DefaultOAuth2User(
                authorities,
                attributes,
                nameAttributeKey
        );
        devOAuth2AuthenticationToken.setAuthentication(new OAuth2AuthenticationToken(principal, authorities, "dev"));
        return Response.ok();
    }

    private String generateDevId() {
        return String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
    }
}
