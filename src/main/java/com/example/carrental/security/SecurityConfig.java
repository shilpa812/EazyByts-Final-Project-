
/*package com.example.carrental.security;           
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


     auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT email, password, enabled FROM users WHERE email = ?")
                .authoritiesByUsernameQuery("SELECT email, role FROM user_roles WHERE email = ?");
    }
    /*

    @SuppressWarnings("deprecation")
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeRequests(requests -> requests
                        .requestMatchers("/login", "/register").permitAll()
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/user/**").hasAuthority("USER")

                        .requestMatchers("/rental/**").hasAuthority("USER")
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .failureUrl("/login?error=true")
                        .defaultSuccessUrl("/", true)
                        .usernameParameter("email")
                        .passwordParameter("password"))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login"));
    }
    

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
*/
