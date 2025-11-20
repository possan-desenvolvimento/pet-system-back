package com.petsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);

        config.setAllowedOrigins(Arrays.asList(
                "http://localhost:5500",           // Live Server
                "http://127.0.0.1:5500",           // Live Server alternativo
                "http://localhost:3000",           // React dev server
                "http://localhost:80",             // Nginx frontend (Docker)
                "http://localhost",                // Frontend rodando na porta 80
                "http://localhost:8080",           // Frontend na porta 8080
                "http://localhost:8081",           // ✅ ADICIONE ESTA LINHA!
                "http://127.0.0.1:80",            // Nginx alternativo
                "http://127.0.0.1",               // Localhost sem porta
                "http://127.0.0.1:8080",          // Frontend alternativo na 8080
                "http://127.0.0.1:8081"           // ✅ ADICIONE ESTA LINHA!
        ));

        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        http
                .cors(cors -> cors.configurationSource(source))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/api/auth/**", "/favicon.ico").permitAll()
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}