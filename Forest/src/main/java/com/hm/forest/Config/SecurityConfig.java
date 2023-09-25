package com.hm.forest.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.hm.forest.Handler.CustomAuthenticationSuccessHandler;
import com.hm.forest.Handler.CustomLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 인메모리 사용자를 위한 사용자 서비스 빈 설정
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
        		.password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
        		.password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
	        .antMatchers("/admin/**").hasRole("ADMIN") // ADMIN 권한을 가진 사용자에게만 /admin/** 경로 허용
	        .antMatchers("/home").authenticated() // 로그인한 사용자에게만 /home 경로 허용
	        .anyRequest().permitAll() // 그 외의 모든 요청은 허용
	        .and()
	        .formLogin()
	            .loginPage("/login")
	            .successHandler(authenticationSuccessHandler())
	            .failureUrl("/login?error=true")
	            .permitAll()
	        .and()
	        .logout()
	            .logoutUrl("/logout") // 로그아웃 URL 지정
	            .logoutSuccessUrl("/")
	            .permitAll()
	        .and()
	        .rememberMe()
	            .key("uniqueAndSecretKey")
	            .userDetailsService(userDetailsService())
	            .tokenValiditySeconds(86400)
	        .and()
	        .logout()
	            .permitAll();

    }
    
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
    
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
