package pe.oh29oh29.ourlunch.adapter_dev;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.adapter.api.FamilyController;
import pe.oh29oh29.ourlunch.application.value.FamilyRepresentation;
import pe.oh29oh29.ourlunch.model.Response;

@RequiredArgsConstructor

@Profile("dev")
@RestController
@RequestMapping("/dev/api/v1/family")
public class DevFamilyController {

    private final FamilyController familyController;

    @GetMapping("/{familyId}/members")
    public Response<FamilyRepresentation.GetMembers> getMembers(@PathVariable String familyId) {
        return familyController.getMembers(familyId);
    }
}
