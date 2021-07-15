package pl.coderslab.finalproject.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.repository.UserRepository;

import java.util.Optional;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
@RequiredArgsConstructor
public class BirdUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(userName);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(userName);
        }

        return withUsername(userName)
                .password(user.get().getPassword())
                .authorities("user")
                .build();
    }
}
