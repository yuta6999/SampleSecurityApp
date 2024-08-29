//▼リスト7-34
package com.example.samplesecurityapp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SampleSecurityConfig {
  @Autowired
  private DataSource dataSource;
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http)
      throws Exception {
    http.csrf().disable();
    http.authorizeHttpRequests(authorize -> {
      authorize.anyRequest().permitAll();
    });
//    ▼リスト7-36
    http.formLogin(form -> {
      form.defaultSuccessUrl("/secret")
        .loginPage("/login");
    });
    return http.build();
  }

  @Bean
  public UserDetailsManager userDetailsManager(){
    return new JdbcUserDetailsManager(this.dataSource);
  }
}