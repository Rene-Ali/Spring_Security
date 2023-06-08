package at.guenueruen.springsecurityvideodemo.repositories;

import at.guenueruen.springsecurityvideodemo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String userName);
}
