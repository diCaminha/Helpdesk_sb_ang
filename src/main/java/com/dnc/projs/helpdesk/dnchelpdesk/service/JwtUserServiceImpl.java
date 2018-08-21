package com.dnc.projs.helpdesk.dnchelpdesk.service;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.User;
import com.dnc.projs.helpdesk.dnchelpdesk.jwt.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JwtUserServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userService.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("NO user found."));
        } else {
            return JwtUserFactory.create(user);
        }

    }
}
