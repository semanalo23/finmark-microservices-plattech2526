package org.example.finmark_userauth_micro.config;

import org.example.finmark_userauth_micro.util.JwtAuthSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationFinmark {

    private final JwtAuthSuccessHandler jwtSuccessHandler;

    public SecurityConfigurationFinmark(JwtAuthSuccessHandler jwtSuccessHandler) {
        this.jwtSuccessHandler = jwtSuccessHandler;
    }

    @Bean
    public UserDetailsService userDetailsService(){

        return username -> {
            if ("admin".equals(username)) {
                return User.withUsername("admin")
                        .password("{noop}admin123")
                        .roles("ADMIN")
                        .build();
            } else if ("testuser".equals(username)) {
                return User.withUsername("testuser")
                        .password("{noop}password123")
                        .roles("USER")
                        .build();
            }
            throw new UsernameNotFoundException("User not found: " + username);
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register", "/reset", "/css/**", "/js/**").permitAll()
                        .requestMatchers("/cart/**").permitAll()
                        .requestMatchers("/home").authenticated()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(jwtSuccessHandler) // custom handler
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/auth/logout")
                        .logoutSuccessUrl("/auth/logout-success")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }
}
