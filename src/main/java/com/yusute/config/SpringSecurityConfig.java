package com.yusute.config;

import com.yusute.core.security.UserSecurityService;
import com.yusute.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by yusutehot on 3/29/2017.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username, password, true from users where username = ?")
//                .authoritiesByUsernameQuery("SELECT username, authority from authorities where username = ?")
//        .passwordEncoder(new Md5PasswordEncoder());

        auth.userDetailsService(new UserSecurityService(userService)).passwordEncoder(new Md5PasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 静态资源
        web.ignoring().antMatchers("/css/**","/js/**", "/image/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login.html", "/logout.html").permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/index.html")
                .failureUrl("/login-error.html")
                .and()
                .logout()
                .logoutSuccessUrl("/index.html");
    }
}
