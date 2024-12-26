package com.aaron.identity_service.configuration;

import com.aaron.identity_service.entity.User;
import com.aaron.identity_service.repository.RoleRepository;
import com.aaron.identity_service.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationInitConfig {

    private static final Logger log = LoggerFactory.getLogger(ApplicationInitConfig.class);

    @Bean
    public ApplicationRunner applicationRunner(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            if(userRepository.getUserByUsername("admin").isEmpty()) {
                User user = new User();

                user.setUsername("admin");
                user.setPassword(passwordEncoder().encode("admin123"));
                user.setRole(roleRepository.findRoleByName("ADMIN"));

                userRepository.save(user);

                log.warn("admin account has been created with username = admin and password = admin123");
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
