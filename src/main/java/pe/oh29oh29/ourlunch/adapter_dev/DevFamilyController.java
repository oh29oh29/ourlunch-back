package pe.oh29oh29.ourlunch.adapter_dev;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.ourlunch.adapter.api.FamilyController;
import pe.oh29oh29.ourlunch.application.value.FamilyCommand;
import pe.oh29oh29.ourlunch.application.value.FamilyRepresentation;
import pe.oh29oh29.ourlunch.model.Response;

import javax.validation.Valid;

@RequiredArgsConstructor

@Profile("dev")
@RestController
@RequestMapping("/dev/api/v1/family")
public class DevFamilyController {

    private final DevOAuth2AuthenticationToken devOAuth2AuthenticationToken;
    private final FamilyController familyController;

    @PostMapping
    public Response<FamilyRepresentation.Create> create(@Valid @RequestBody FamilyCommand.Create command) {
        return familyController.create(devOAuth2AuthenticationToken.getAuthentication(), command);
    }

    @GetMapping("/{familyId}/members")
    public Response<FamilyRepresentation.GetMembers> getMembers(@PathVariable String familyId) {
        return familyController.getMembers(familyId);
    }
}
