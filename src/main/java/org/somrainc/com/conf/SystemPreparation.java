package org.somrainc.com.conf;

import org.somrainc.com.common.UserRole;
import org.somrainc.com.model.User;
import org.somrainc.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SystemPreparation implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        User test = userRepository.findByUsername("test");
        if (test != null) {
            return;
        }
        User user = new User()
                .setAge(23L)
                .setPassword(passwordEncoder.encode("test"))
                .setEmail("test@gmail.com")
                .setBirthday(LocalDate.now().minusYears(20))
                .setRole(UserRole.ADMIN)
                .setUsername("test");
        userRepository.save(user);
    }
}
