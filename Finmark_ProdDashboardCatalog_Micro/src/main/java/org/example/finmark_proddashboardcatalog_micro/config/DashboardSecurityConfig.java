package org.example.finmark_proddashboardcatalog_micro.config;

import org.example.finmark_proddashboardcatalog_micro.util.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class DashboardSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtRequestFilter jwtFilter) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/dashboard/**").authenticated()
                        .requestMatchers("/cart/**").permitAll()
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().permitAll()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
