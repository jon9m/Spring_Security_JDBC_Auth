package com.mmk.SpringSecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//Add reference to to security datasource
	@Autowired
	private DataSource securityDataSource;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

//In-memory		
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// Add users for the in memory authentication
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication().withUser(users.username("manoj").password("test123").roles("ADMIN"))
//				.withUser(users.username("sam").password("test123").roles("USER", "GUSET"))
//				.withUser(users.username("mmk").password("test123").roles("GUSET"))
//				.withUser(users.username("jon").password("test123").roles("ADMIN", "USER"));
//	}


	// Custom Login Form
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
				
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/showLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
			.and()
			
			.exceptionHandling().accessDeniedPage("/accessDenied")
			.and()
			
			.logout()			
			.permitAll();
	}

}
