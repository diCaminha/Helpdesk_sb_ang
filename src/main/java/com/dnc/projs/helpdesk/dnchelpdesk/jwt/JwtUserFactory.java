package com.dnc.projs.helpdesk.dnchelpdesk.jwt;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.User;
import com.dnc.projs.helpdesk.dnchelpdesk.domain.enums.ProfileEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtUserFactory {

    private JwtUserFactory() {

    }

    public static JwtUser create(User user) {
        return new JwtUser( user.getId(),
                            user.getEmail(),
                            user.getPassword(),
                            mapToGrantedAuthorities(user.getProfile())
        );
    }

    private static Collection<? extends GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profile) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(profile.toString()));
        return authorities;
    }
}
