package pe.oh29oh29.ourlunch.adapter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.application.InitialRegistrationFacade;
import pe.oh29oh29.ourlunch.application.value.InitalRegistrationCommand;
import pe.oh29oh29.ourlunch.application.value.InitalRegistrationRepresentation;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.model.Response;

import javax.validation.Valid;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/initialization")
public class RegistrationController {

    private final InitialRegistrationFacade initialRegistrationFacade;

    /**
     * 점심팽 생성 API
     * */
    @PostMapping
    public Response<InitalRegistrationRepresentation.Regist> regist(
            OAuth2AuthenticationToken authentication,
            @Valid @RequestBody InitalRegistrationCommand.Regist command
    ) {
        final String userId = authentication.getPrincipal().getName();

        final Family family = initialRegistrationFacade.regist(
                userId,
                command.getUserName(),
                command.getAppetite(),
                command.getCompanyName(),
                command.getFamilyName()
        );

        return new Response<>(
                InitalRegistrationRepresentation.Regist
                        .builder()
                        .familyId(family.getId())
                        .linkUrl(family.getLinkUrl())
                        .build()
        );
    }
}
