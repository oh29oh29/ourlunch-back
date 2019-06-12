package pe.oh29oh29.ourlunch.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.service.FamilyService;

@RestController
@RequiredArgsConstructor
public class FamilyController {

    private FamilyService familyService;

}
