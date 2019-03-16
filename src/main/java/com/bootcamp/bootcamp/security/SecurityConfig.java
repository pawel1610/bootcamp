package com.bootcamp.bootcamp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  // naspisanie metody autentykacji, aby czytala z naszej bazy danych
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT email, password, 1 FROM user WHERE email=?") // 1 wpisaujemy bo wymagane sa 3 parametry(active)
                .authoritiesByUsernameQuery("SELECT u.email, r.role FROM user u inner join role r on r.id=u.role_id WHERE u.email=?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
                .antMatchers("/admin", "/admin/**").authenticated()
                .antMatchers("/userPanel", "/userPanel/**").authenticated()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")

                .and()
                .formLogin()
                .loginPage("/loginform")
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .passwordParameter("password");// gdybydmy chceili inczan znazwac te paramerty, mzomey je tu zdefiniowac, np emeila zamiast username

    }
}
