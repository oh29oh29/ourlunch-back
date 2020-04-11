package pe.oh29oh29.ourlunch.adapter_dev;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.application.MemberCommandService;
import pe.oh29oh29.ourlunch.application.MemberQueryService;
import pe.oh29oh29.ourlunch.domain.member.Member;
import pe.oh29oh29.ourlunch.model.Response;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor

@Profile("dev")
@RestController
@RequestMapping("/dev")
public class DevLoginController {

    private final DevOAuth2AuthenticationToken devOAuth2AuthenticationToken;
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/login")
    public Response<Representation> login(@Valid @RequestBody DevLoginController.Command request) {
        final String nameAttributeKey = "name";
        final String id = request.id;
        final Map<String, Object> attributes = ImmutableMap.of(nameAttributeKey, id);
        final ImmutableList<OAuth2UserAuthority> authorities = ImmutableList.of(new OAuth2UserAuthority(attributes));
        final OAuth2User principal = new DefaultOAuth2User(
                authorities,
                attributes,
                nameAttributeKey
        );

        devOAuth2AuthenticationToken.setAuthentication(new OAuth2AuthenticationToken(principal, authorities, "dev"));

        if (!memberQueryService.exist(id)) {
            memberCommandService.signUp(id, "dev");
            return new Response<>(
                    Representation
                            .builder()
                            .path("Home")
                            .accessToken(generateFakeAccessToken())
                            .build()
            );
        }

        final Member member = memberQueryService.findById(id);
        if (!member.isJoinedFamily()) {
            return new Response<>(
                    Representation
                            .builder()
                            .path("Home")
                            .accessToken(generateFakeAccessToken())
                            .build()
            );
        }

        return new Response<>(
                Representation
                        .builder()
                        .path("Main")
                        .accessToken(generateFakeAccessToken())
                        .build()
        );
    }

    private String generateFakeAccessToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Getter
    private static class Command {
        @NotBlank
        private String id;
    }

    @Builder
    @Getter
    private static class Representation {
        private String path;
        private String accessToken;
    }
}
