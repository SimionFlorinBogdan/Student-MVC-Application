package sudentapplication.student.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

// password : parola123

@Configuration
public class StudentSecurity {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers("/", "/showStudent").hasRole("STUDENT")
                .requestMatchers("/showStudent", "/addStudent", "/updateStudent", "/updateSpecificStudent").hasRole("DIRECTOR")
                .requestMatchers("/deleteStudent", "/deleteSpecificStudent").hasRole("ADMIN")
                .anyRequest().authenticated())
        .formLogin(form -> form
                .loginPage("/showLoginPage")
                .loginProcessingUrl("/processLogin")
                .permitAll())
        .logout(logout -> logout.permitAll())
        .exceptionHandling(configurer -> configurer
                .accessDeniedPage("/accessDenied"));

        return http.build();
    }

}
