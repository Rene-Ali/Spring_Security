package at.guenueruen.springsecurityvideodemo.rest;

import at.guenueruen.springsecurityvideodemo.rest.models.AuthRequest;
import at.guenueruen.springsecurityvideodemo.rest.models.AuthResponse;
import at.guenueruen.springsecurityvideodemo.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    private final JwtUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    public AuthRestController(JwtUtil jwtTokenUtil,
                              UserDetailsService userDetailsService,
                              AuthenticationManager authenticationManager) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public AuthResponse auth(@RequestBody AuthRequest authRequest){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);

        return new AuthResponse(token);


    }
}
