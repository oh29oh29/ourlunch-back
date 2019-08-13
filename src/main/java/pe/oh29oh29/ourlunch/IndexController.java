package pe.oh29oh29.ourlunch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = {"/{path:[^\\\\.]*}", "/**/{path:[^\\\\.]*}"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String html5Forwarding() {
        return "forward:/index.html";
    }
}
