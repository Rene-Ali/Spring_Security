package at.guenueruen.springsecurityvideodemo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class SecuredInfoRestController {

    @RequestMapping
    public String securedInfo(){

        return "Info nur für angemeldete Benutzer";
    }
}
