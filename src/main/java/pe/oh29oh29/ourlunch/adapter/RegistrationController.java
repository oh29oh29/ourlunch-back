package pe.oh29oh29.ourlunch.adapter;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.application.InitialRegistrationFacade;
import pe.oh29oh29.ourlunch.application.value.InitalRegistrationCommand;
import pe.oh29oh29.ourlunch.model.Response;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/initialization")
public class RegistrationController {

    private final InitialRegistrationFacade initialRegistrationFacade;

    @ApiOperation(
            value = "점심팸 생성 API",
            notes = "점심팸을 생성합니다."
    )
    @PostMapping
    public Response regist(
            @ApiIgnore final OAuth2AuthenticationToken authentication,
            @Valid @RequestBody final InitalRegistrationCommand.Regist command
    ) {
        /**
         * production code:
         * final String userId = authentication.getPrincipal().getName();
         * */
        final String userId = "testUserId";

        initialRegistrationFacade.regist(
                userId,
                command.getUserName(),
                command.getAppetite(),
                command.getCompanyName(),
                command.getFamilyName()
        );

        return Response.ok();
    }
}
