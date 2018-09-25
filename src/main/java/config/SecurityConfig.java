package config;

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
            .withUser("temp").password(passwordEncoder().encode("temp")).roles("ADMIN")
            .and()
            .withUser("user").password(passwordEncoder().encode("userPass")).roles("USER")
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
            .antMatchers("/player/login").anonymous()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login.html")
            .defaultSuccessUrl("/homepage.html")
            .failureUrl("/login.html?error=true")
            .and()
            .logout().logoutSuccessUrl("/login.html");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}