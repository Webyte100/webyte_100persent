/**
* This class describes Security Configuration.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.security.configuration;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ibm.services.DatabaseUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  
  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
  httpSecurity

		.cors()
	        .and()
	    .csrf()
	        .disable()
	    .exceptionHandling()
	        .and()
	    .sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        .and()
	    .authorizeRequests()
	        .antMatchers("/", "/**").permitAll();
	
  }
  @Autowired  
  private DatabaseUserDetailsService databaseUserDetailsService;
  
  
  @Bean
  public AuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider provider = 
      new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder());
    provider.setUserDetailsService(this.databaseUserDetailsService);
    return provider;
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Bean
  public ModelMapper modelMapper() {
	  ModelMapper mapper = new ModelMapper();
	  mapper.getConfiguration()
	  	.setPropertyCondition(Conditions.isNotNull())
	  	.setFieldMatchingEnabled(true)
	  	.setFieldAccessLevel(AccessLevel.PRIVATE);
	  return mapper;
  }
  
}