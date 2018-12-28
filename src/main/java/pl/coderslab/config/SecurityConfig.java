package pl.coderslab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

//    @Bean
//    public SpringDataUserDetailsService customUserDetailsService() {
//        return new SpringDataUserDetailsService();
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/admin").authenticated()
//                .and().formLogin();
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN") // require login in this path
                .anyRequest().authenticated() // permit all for the rest of paths

                .and()
                .formLogin()
                .loginPage("/login").permitAll() // login page set to /login and all users are permitted to visit it
                .usernameParameter("email")
                .defaultSuccessUrl("/") // redirect after successful login
                .failureUrl("/login?error") // redirect after unsuccessful login

                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // path /logout is mapped
                .logoutSuccessUrl("/") // redirect after logout
                .invalidateHttpSession(true) // invalidate session
                .deleteCookies("JSESSIONID") // delete session cookie
                .permitAll()
                .and()
                .httpBasic();
    }

}