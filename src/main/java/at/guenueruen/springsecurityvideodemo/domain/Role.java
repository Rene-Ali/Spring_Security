package at.guenueruen.springsecurityvideodemo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name="roles")
@Entity
@Getter
@Setter
public class Role {

    @Id
    private String name;
}
