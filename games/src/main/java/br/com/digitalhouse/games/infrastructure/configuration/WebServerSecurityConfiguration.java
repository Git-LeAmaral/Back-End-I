package br.com.digitalhouse.games.infrastructure.configuration;

import jakarta.servlet.FilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebServerSecurityConfiguration {

    @Bean
    public SecurityFilterChain configuration(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                (authorize) -> authorize
                        .requestMatchers(HttpMethod.POST, "/").hasAnyAuthority("ADMIN")
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
        );
        return http.build();
    }
}
