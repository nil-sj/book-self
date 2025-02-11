package com.bookself.bookself_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/login", "/api/users/create").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginProcessingUrl("/api/users/login")  // Login endpoint
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/api/users/logout")  // Logout endpoint
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")  // Remove session cookie
                        .permitAll()
                );

        return http.build();
    }
}
