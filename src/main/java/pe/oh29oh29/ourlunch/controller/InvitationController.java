package pe.oh29oh29.ourlunch.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.oh29oh29.ourlunch.service.InvitationService;

@Controller
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationService invitationService;

    @GetMapping("/invitation/{code}")
    public void invite(@PathVariable String code) {
        // 로그인 페이지로 보내야한다
    }
}
