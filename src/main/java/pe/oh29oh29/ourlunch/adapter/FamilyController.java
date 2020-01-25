package pe.oh29oh29.ourlunch.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.application.FamilyCommandService;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/family")
public class FamilyController {

    private final FamilyCommandService familyCommandService;

}
