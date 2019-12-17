package pe.oh29oh29.ourlunch.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.application.InitialRegistrationFacade;
import pe.oh29oh29.ourlunch.model.Response;
import springfox.documentation.annotations.ApiIgnore;

@RequiredArgsConstructor

@RestController
public class RegistrationController {

    private final InitialRegistrationFacade initialRegistrationFacade;

    @PostMapping("")
    public Response regist(
            @ApiIgnore final OAuth2AuthenticationToken authentication
    ) {
        return null;
    }
}
