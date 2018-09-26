package org.ivankov.technosphere.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
//                .withUser("temp").password(passwordEncoder().encode("temp")).roles("ADMIN")
            .withUser("temp").password("temp").roles("ADMIN")
            .and()
            .withUser("user").password("userPass").roles("USER")
                .and()
                .withUser("user1").password("userPass1").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//            .csrf().disable()
//            .exceptionHandling()
//            .authenticationEntryPoint(restAuthenticationEntryPoint)
//            .and()

//            .successHandler(authenticationSuccessHandler)
//            .failureHandler(new SimpleUrlAuthenticationFailureHandler())

            .authorizeRequests()
                .antMatchers("/", "/player/**", "/actuator/**").permitAll()
//            .antMatchers("/player/login").anonymous()
                .antMatchers("/chat/**").hasRole("USER")
//            .anyRequest()
//                .authenticated()
                .and()
            .formLogin()
                .loginPage("/player/login")
                .permitAll()
                .defaultSuccessUrl("/")
                .failureUrl("/player/login-error")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/login");
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}