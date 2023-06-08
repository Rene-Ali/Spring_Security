package at.guenueruen.springsecurityvideodemo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminInfoRestController {

    @RequestMapping
    public String securedInfo(){
        return "Info nur für Admin";
    }
}
