package com.capgemini.projetospring.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.capgemini.projetospring.filter.JwtTokenFilter;
import com.capgemini.projetospring.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
    @Autowired private JwtTokenFilter jwtTokenFilter;
	@Autowired private UserRepository userRepository;
	
	@Bean
	public UserDetailsService userDetailsService() {

		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

				return userRepository.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("Usuário " + username + " não localizado"));
			}
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(passwordEncoder());
		
		return provider;
	}	
	
	// new to jwt
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				
        http.authorizeRequests()
        	.antMatchers("/api/clientes/**").authenticated()
        	.anyRequest().permitAll();
 
        
//        http.authorizeRequests()
//        	.antMatchers("/clientes/novo/").hasAnyRole("ADMIN", "GUEST")
//        	.antMatchers("/produtos/lista/").authenticated()
//        	.antMatchers("/pedidos/**").anonymous()
//        	.and()
//        	.formLogin().loginPage("/usuarios/login").permitAll()
//        	.and()
//        	.logout().permitAll();

        
        
        
        
        http.exceptionHandling()
            .authenticationEntryPoint(
                (request, response, ex) -> {
                    response.sendError(
                        HttpServletResponse.SC_UNAUTHORIZED,
                        ex.getMessage()
                    );
                }
        );
 
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);		
		
		return http.build();
	}
	
}

