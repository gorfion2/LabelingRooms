package pl.labelingRooms.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Kamil S on 2016-03-05.
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            public boolean matches(CharSequence charSequence, String s) {
                return s.contentEquals(charSequence);
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/plan/**").permitAll().antMatchers("/js/bower_components/angular/angular.min.js",
                "/js/bower_components/angular-route/angular-route.min.js",
                "/js/bower_components/angular-resource/angular-resource.js",
                "/js/bower_components/jquery/dist/jquery.min.js",
                "/js/bower_components/bootstrap/dist/js/bootstrap.min.js",
                "/js/bower_components/bootstrap/dist/css/bootstrap.min.css",
                "/js/public/scheduleController.js",
                "/js/public/scheduleService.js",
                "/room/**/events",
                "/room/**/messages",
                "/room/**/public", "/login", "/data/version",
                "/teacher/logged").permitAll()
                .anyRequest()
                .access("hasRole('ROLE_TEACHER')").and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").and().csrf().disable();
    }

}