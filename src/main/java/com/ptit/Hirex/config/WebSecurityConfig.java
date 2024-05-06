package com.ptit.Hirex.config;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ptit.Hirex.filters.JwtTokenFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtTokenFilter jwtTokenFilter;
    
    @Value("${api.prefix}")
    private String apiPrefix;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> {
                    requests
                            .requestMatchers(
                                    String.format("%s/users/register", apiPrefix),
                                    String.format("%s/users/login", apiPrefix),
                                    String.format("%s/users/updatePassword", apiPrefix),
                                    String.format("%s/users/uploadImage", apiPrefix)

                            )
                            .permitAll()
//                            .requestMatchers(GET, "/test")
//                            .hasAnyRole(Role.ADMIN)
                          .requestMatchers(GET, "/test").permitAll()
                          .requestMatchers(POST, String.format("%s/experiences/create", apiPrefix)).permitAll()
                          .requestMatchers(GET, String.format("%s/employees/**", apiPrefix)).permitAll()
                          .requestMatchers(DELETE, String.format("%s/experiences/**", apiPrefix)).permitAll()
                          .requestMatchers(PUT, String.format("%s/experiences/**", apiPrefix)).permitAll()
                          .requestMatchers(POST, String.format("%s/certifications/create", apiPrefix)).permitAll()
                          .requestMatchers(PUT, String.format("%s/employees/**", apiPrefix)).permitAll()
                          .requestMatchers(POST, String.format("%s/companies/create", apiPrefix)).permitAll()
                          .requestMatchers(GET, String.format("%s/employer/**", apiPrefix)).permitAll()



                          
                          .anyRequest().authenticated();
                })
                .csrf(AbstractHttpConfigurer::disable);
        
        return http.build();
    }
}
