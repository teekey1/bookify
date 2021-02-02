package com.codecool.bookify.security;

import com.codecool.bookify.auth.ApplicationUserService;
import com.codecool.bookify.jwt.JwtConfig;
import com.codecool.bookify.jwt.JwtTokenVerifier;
import com.codecool.bookify.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Collections;

import static com.codecool.bookify.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
//@RequiredArgsConstructor
@EnableSwagger2
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

//    @Autowired
//    MyUserDetailsService myUserDetailsService;

    @Autowired
    public SecurityConfiguration(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService, SecretKey secretKey, JwtConfig jwtConfig) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/register", "/index").permitAll()
                .antMatchers("/").permitAll();
//                .antMatchers("/categories").authenticated()
//                .anyRequest()
//                .authenticated();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
//                "/categories",
//                "/companies/**",
                "/webjars/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.applyPermitDefaultValues();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
        configuration.setExposedHeaders(Arrays.asList("Authorization", "content-type", "x-auth-token"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/login", configuration);
        source.registerCorsConfiguration("/users", configuration);
        source.registerCorsConfiguration("/register", configuration);
        source.registerCorsConfiguration("/", configuration);
        source.registerCorsConfiguration("/**", configuration);
        source.registerCorsConfiguration("/categories", configuration);
        source.registerCorsConfiguration("/categories/**", configuration);
        source.registerCorsConfiguration("/companies/**", configuration);
        source.registerCorsConfiguration("/swagger-ui.html", configuration);

        return source;
    }

}

