package com.covinoc.crud.adapter.api.security.service;

import com.covinoc.crud.adapter.api.security.models.*;
import com.covinoc.crud.adapter.api.security.mock.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSecurityService implements UserDetailsService {
    private final UserAppRepository repository;

    @Autowired
    public UserSecurityService(UserAppRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp userApp=repository.findById(username);
        if(userApp==null){
            throw new UsernameNotFoundException("User "+username+" not found");
        }
        String[] roles=userApp.getRoles().stream().map(UserRole::getRole).toArray(String[]::new);
        return User.builder()
                .username(userApp.getUsername())
                .password(userApp.getPassword())
                .authorities(this.grantedAuthorities(roles))
                .accountLocked(userApp.isLocked())
                .disabled(userApp.isDisabled())
                .build();
    }
    private String[] getAuthorities(String role){
        if("ADMIN".equals(role) || "CUSTOMER".equals(role)){
            return new String[]{"random_order"};
        }
        return new String[]{};
    }

    private List<GrantedAuthority> grantedAuthorities(String[] roles){
        List<GrantedAuthority> authorities=new ArrayList<>(roles.length);
        for (String role:roles
             ) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
            for (String authority:this.getAuthorities(role)
                 ) {
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }
        return authorities;
    }
}
