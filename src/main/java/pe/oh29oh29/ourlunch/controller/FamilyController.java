package pe.oh29oh29.ourlunch.controller;

import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.service.FamilyService;

@RestController
public class FamilyController {

    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }
}
