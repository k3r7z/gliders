package com.kertzware.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                        // 1. Allow internal forwards to Thymeleaf templates
               .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                // 2. Publicly accessible paths
                .requestMatchers(
                    "/",
                    "/index",
                    "/login",
                    "/css/**",
                    "/js/**",
                    "/image/**",
                    "/webjars/**",
                    "/contact").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                        // 3. Everything else requires login
                        .anyRequest().authenticated()
                )
                // H2 console runs in a frame; Spring Security blocks frames by default
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                // Disable CSRF for the console so you can log into it
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }
}
