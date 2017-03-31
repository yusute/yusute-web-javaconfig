package com.yusute.core.security;

import com.yusute.web.mapper.po.User;
import com.yusute.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusutehot on 3/30/2017.
 */
public class UserSecurityService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserSecurityService.class);

    public UserSecurityService(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User spitter = userService.loadUserByUsername(username);
        logger.info("这是一个log4j2 测试");
        if(spitter != null){
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

            return new org.springframework.security.core.userdetails.User(spitter.getUsername(), spitter.getPassword(), authorities);
        }

        throw new UsernameNotFoundException(username + " not found");
    }
}
