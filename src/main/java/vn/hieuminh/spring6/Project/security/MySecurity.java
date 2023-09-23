package vn.hieuminh.spring6.Project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class MySecurity {

    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT username,password,enable FROM users WHERE username=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT username,role FROM users WHERE username=?");
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(
            configurer->configurer
//                    .requestMatchers("/home").permitAll()
                    .requestMatchers("/").permitAll()
                    .anyRequest().authenticated()
        ).formLogin(
            form->form
                    .loginPage("/showLoginPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
        ).logout(
                logout->logout
                        .permitAll()
        ).exceptionHandling(
                configurer->configurer
                        .accessDeniedPage("/showPage403")
        );
        return http.build();
    }
}
