package com.employee.testscotia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
				.withUser("any").password(encoder.encode("e79b1c21-8013-407b-8e34-98d47af49eb2")).roles("USER")
				.and()
				.withUser("100001").password(encoder.encode("563b6bc4-f31a-40b2-bbd2-c475c7a375bd")).roles("USER")
				.and()
				.withUser("100002").password(encoder.encode("a33dcad9-8d66-4b7d-890f-99d92c6491c2")).roles("USER")
				.and()
				.withUser("100003").password(encoder.encode("c0455fe9-3106-4a7a-b347-eb4fd2c6d166")).roles("USER")
				.and()
				.withUser("100004").password(encoder.encode("2d8bbc22-0106-40c3-819f-0cebacffbc19")).roles("USER")
				.and()
				.withUser("100005").password(encoder.encode("6318f8ae-ff59-46a7-8e78-7599f91971f5")).roles("USER")
				.and()
				.withUser("100006").password(encoder.encode("50a63c32-09bc-4202-b526-95d80c6bb1e2")).roles("USER")
				.and()
				.withUser("100007").password(encoder.encode("06778cfd-db6f-49f2-af9b-13f0e14ac24f")).roles("USER")
				.and()
				.withUser("100008").password(encoder.encode("91697fc2-4c18-42b4-bf00-2289de213d13")).roles("USER")
				.and()
				.withUser("100009").password(encoder.encode("0fafdd17-0225-4f9d-aea0-eae6f4d8c9a0")).roles("USER")
				.and()
				.withUser("100010").password(encoder.encode("09386208-c018-4725-859e-5ff69012b98e")).roles("USER"); 
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/v1/employees/**").hasRole("USER");
		
	}

}
