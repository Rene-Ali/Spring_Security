package at.guenueruen.springsecurityvideodemo.services;

import at.guenueruen.springsecurityvideodemo.domain.User;
import at.guenueruen.springsecurityvideodemo.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public DefaultUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        List<SimpleGrantedAuthority> roles = List.of(new SimpleGrantedAuthority(user.getRole().getName()));

        org.springframework.security.core.userdetails.User secUser
                = new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), roles);

        return secUser;

    }
}
