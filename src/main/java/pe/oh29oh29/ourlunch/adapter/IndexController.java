package pe.oh29oh29.ourlunch.adapter;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {

    @RequestMapping(value = {"/startFamily", "/main"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String html5Forwarding() {
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
