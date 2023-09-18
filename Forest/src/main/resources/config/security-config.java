import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public UserDetailsService userDetailsService() {
	    // 비밀번호를 BCrypt로 인코딩하여 저장
	    UserDetails user = User.builder()
	        .username("user")
	        .password("{bcrypt}$2a$10$zQbPImiS3tWdWJFTDhCfCuxsKh8hPsuThOBibnLWzwFOH5/TzLW2y") // BCrypt 인코딩된 비밀번호
	        .roles("USER")
	        .build();

	    return new InMemoryUserDetailsManager(user);
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/**", "/js/**").permitAll()
                .antMatchers("/enroll").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessURL("/", true) // 로그인 성공 시 홈 화면으로 이동
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll();
    }
}
