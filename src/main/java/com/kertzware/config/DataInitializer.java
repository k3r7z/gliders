package com.kertzware.config;

import com.kertzware.model.User;
import com.kertzware.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() == 0){
            User pilot = new User();
            pilot.setUsername("piloto@cpae.com");
            pilot.setPassword(passwordEncoder.encode("glider123"));
            userRepository.save(pilot);
            System.out.println("Test user created: piloto@cpae.com / glider123");
        }
    }
}
