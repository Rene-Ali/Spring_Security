package at.guenueruen.springsecurityvideodemo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique=true)
    private String username;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_name")
    private Role role;
}
