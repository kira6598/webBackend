package com.example.webbanhangfinal.SecurityConfig.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.webbanhangfinal.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserRepository userRepository;

    
    @Bean
    public UserDetailsService userDetailsService(){
        return username-> userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("not found user"));
    }
    @Bean 
    public AuthenticationProvider AuthenticationProvider(){
        
        System.out.println("ahaha");
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    // theo phỏng đoán, AuthenticationManager sẽ get tất cả các AuthenticationPrivider qua method getAuthenticationManager
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
//     @Bean
// public CorsFilter corsFilter() {
//     final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//     final CorsConfiguration config = new CorsConfiguration();
//     config.setAllowCredentials(true);
//     // Don't do this in production, use a proper list  of allowed origins
//     config.setAllowedOrigins(Collections.singletonList("*"));
//     config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
//     config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
//     source.registerCorsConfiguration("/**", config);
//     return new CorsFilter(source);
// }
}
