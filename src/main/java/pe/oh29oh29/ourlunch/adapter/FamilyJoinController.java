package pe.oh29oh29.ourlunch.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.oh29oh29.ourlunch.application.FamilyQueryService;

@RequiredArgsConstructor

@Controller
@RequestMapping("/join")
public class FamilyJoinController {

    private final FamilyQueryService familyQueryService;

    @GetMapping("/{code}")
    public String join(
            @PathVariable String code,
            RedirectAttributes redirect
    ) {
        if (!familyQueryService.existByCode(code)) {
            return "error/404";
        }

        redirect.addAttribute("family_code", code);
        return "redirect:/join";
    }

}
