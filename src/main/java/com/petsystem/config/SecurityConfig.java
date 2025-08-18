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
                "http://localhost:5500",
                "http://127.0.0.1:5500",
                "http://localhost:3000",
                "http://localhost:9090", // frontend via nginx
                "http://localhost"       // acesso direto local
        ));

        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        http
                .cors(cors -> cors.configurationSource(source)) // Aplica configuração CORS
                .csrf(csrf -> csrf.disable())                   // Desabilita CSRF (útil para APIs)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Libera endpoints de autenticação
                        .anyRequest().permitAll()                   // Libera o restante (ajuste conforme necessário)
                );

        return http.build();
    }
}
