package pe.oh29oh29.ourlunch.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.ourlunch.model.RequestDTO;
import pe.oh29oh29.ourlunch.model.ResponseDTO;
import pe.oh29oh29.ourlunch.service.FamilyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/family")
public class FamilyController {

    private final FamilyService familyService;

    @PostMapping("")
    public ResponseDTO createFamily(@RequestBody RequestDTO.FamilyCreationRequest request) {
        return new ResponseDTO(familyService.createFamily(request));
    }

}
