package at.guenueruen.springsecurityvideodemo.repositories;

import at.guenueruen.springsecurityvideodemo.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @Test
    void findByUsername_found() {
        User JDoe = userRepository.findByUsername("JDoe");
        Assertions.assertNotNull( JDoe );
    }

    @Test
    void findByUsername_not_found() {
        User notExistingUser = userRepository.findByUsername("JD");
        Assertions.assertNull( notExistingUser );
    }
}