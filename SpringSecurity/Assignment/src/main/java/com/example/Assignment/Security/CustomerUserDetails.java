package com.example.Assignment.Security;

import com.example.Assignment.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomerUserDetails implements UserDetails {

    private String user;

    public CustomerUserDetails(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(
                new SimpleGrantedAuthority("ROLE_"+user.getRole().getName());
        );
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String getUser(){
        return user.getPassword();
    }

}
