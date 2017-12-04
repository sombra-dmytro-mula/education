//package org.somrainc.com.conf;
//
//import org.somrainc.com.common.UserRole;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import java.util.Collections;
//
//@TestExecutionListeners
//@EnableWebMvc
//public class SpringSecurityWebAuxTestConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/api/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("test").password("test").roles("USER");
//    }
//
//    @Bean
//    @Primary
//    public UserDetailsService userDetailsService() {
//        UserDetails basicActiveUser = new User("test", "test", Collections.singletonList(
//                new SimpleGrantedAuthority(UserRole.ADMIN.name())
//        ));
//
//        return new InMemoryUserDetailsManager(Collections.singletonList(basicActiveUser));
//    }
//}
