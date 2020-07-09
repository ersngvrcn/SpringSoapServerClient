package com.works.fourdays.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DriverManagerDataSource db;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(db)
		.authoritiesByUsernameQuery(" select mail,role from admin where mail = ? ")
		.usersByUsernameQuery(" select mail,pass,statu from admin where mail = ? ");
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    	.httpBasic()
    	.and()
    	.authorizeRequests()
    	//.antMatchers("/**").hasRole("PRODUCT")
    	.antMatchers("/product/**").hasRole("PRODUCT")
    	.antMatchers("/user/**").hasRole("USER")
    	.anyRequest()
    	.authenticated();
    	
    	http.csrf().disable();
    }
    
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
    	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
