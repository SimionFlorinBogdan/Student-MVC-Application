package sudentapplication.student.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage(){

        return "log-in";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){

        return "access-denied";
    }
}
