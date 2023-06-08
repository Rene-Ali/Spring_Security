package at.guenueruen.springsecurityvideodemo.rest.models;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
