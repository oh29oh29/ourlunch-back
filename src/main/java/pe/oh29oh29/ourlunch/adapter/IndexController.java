package pe.oh29oh29.ourlunch.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor

@Controller
public class IndexController {

    @RequestMapping(value = {"/startFamily", "/main"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String html5Forwarding(
            @RequestParam("access_token") String accessToken,
            final HttpServletRequest request
    ) {
        request.setAttribute("access_token", accessToken);
        return "forward:/index.html";
    }

    @GetMapping("/redirect")
    public void goHome(
            final HttpServletResponse response,
            final OAuth2AuthenticationToken authentication
    ) throws IOException {
        if (authentication.isAuthenticated()) {
            response.sendRedirect("/login/success");
        } else {
            response.sendRedirect("/login");
        }
    }
}
