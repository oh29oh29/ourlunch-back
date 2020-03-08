package pe.oh29oh29.ourlunch.adapter_dev;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.adapter.RegistrationController;
import pe.oh29oh29.ourlunch.application.value.InitalRegistrationCommand;
import pe.oh29oh29.ourlunch.application.value.InitalRegistrationRepresentation;
import pe.oh29oh29.ourlunch.model.Response;

import javax.validation.Valid;

@RequiredArgsConstructor

@Profile("dev")
@RestController
@RequestMapping("/dev/api/v1/initialization")
public class DevRegistrationController {

    private final DevOAuth2AuthenticationToken devOAuth2AuthenticationToken;
    private final RegistrationController registrationController;

    @PostMapping
    public Response<InitalRegistrationRepresentation.Regist> regist(@Valid @RequestBody final InitalRegistrationCommand.Regist command) {
        return registrationController.regist(devOAuth2AuthenticationToken.getAuthentication(), command);
    }
}
