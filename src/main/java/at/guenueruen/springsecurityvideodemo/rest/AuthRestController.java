package at.guenueruen.springsecurityvideodemo.rest;

import at.guenueruen.springsecurityvideodemo.rest.models.AuthRequest;
import at.guenueruen.springsecurityvideodemo.rest.models.AuthResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    private final AuthenticationManager authenticationManager;

    public AuthRestController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public AuthResponse auth(@RequestBody AuthRequest authRequest){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        return new AuthResponse("token...");


    }
}
