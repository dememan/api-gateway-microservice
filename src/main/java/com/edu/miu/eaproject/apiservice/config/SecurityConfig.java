package com.edu.miu.eaproject.apiservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()

                .withUser("admin").password("{noop}admin").roles("ADMIN", "READER", "COMMENTOR").and()
                .withUser("commentor").password("{noop}123").roles("COMMENTOR","READER").and()
                .withUser("reader").password("{noop}123").roles("READER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic().and()
                .authorizeRequests().antMatchers("/login", "/logout", "/index").permitAll().and()
                .authorizeRequests().antMatchers(HttpMethod.GET, "/users", "/posts", "/comments").permitAll().and() //public
                .authorizeRequests().antMatchers(HttpMethod.GET, "/users/**", "/posts/**", "/comments/**").hasRole("READER").and() //reader
                .authorizeRequests().antMatchers(HttpMethod.POST, "/comments/**").hasAnyRole("COMMENTOR").and() //commentor
                .authorizeRequests().antMatchers("/**").hasRole("ADMIN").and()   //anything else CRUD operations by Admin
                .formLogin().and() //not required ;enable for testing
                .logout();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/WEB-INF/**", "/css/**").and()
                .debug(true);
    }
}

