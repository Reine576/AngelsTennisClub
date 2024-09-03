package com.reine.AngelsTennisClub.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetail extends User implements UserDetails {
    /*Inheritance: The class CustomUserDetail extends User, meaning
     it inherits all the properties and methods from the User class.
     Interface Implementation: It implements the UserDetails interface,
     which requires certain methods to be overridden for integrating with Spring Security.*/
    public UserDetail(User user){
        super(user);
        /*The constructor takes a User object and passes it
        to the User class's constructor (which is a copy constructor in this case)*/
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //Returns a collection of authorities (roles) that the user has.
        List<GrantedAuthority> authorityList = new ArrayList<>();
        super.getRoles().forEach(role -> {
            authorityList.add(new SimpleGrantedAuthority(role.getName()));
        });
        return authorityList;
    }

    @Override
    public String getUsername() { //Returns the username of the user.
        return super.getEmail(); //In this case, it returns the user's email as the username.
    }

    @Override
    public String getPassword() { //Returns the password of the user.
        return super.getPassword(); //It directly returns the password from the User object.
    }

    @Override
    public boolean isAccountNonExpired() { // Indicates whether the user's account has expired
        return true; /*Returns true, meaning the account is not expired.
        This is a placeholder; Actual logic might be implemented
         to check if the account is expired based on your application's requirements.*/
    }

    @Override
    public boolean isAccountNonLocked() {//Indicates whether the user's account is locked.
        return true; //Returns true, meaning the account is not locked. Like isAccountNonExpired(), this is a placeholder.
    }

    @Override
    public boolean isCredentialsNonExpired() {//Indicates whether the user's credentials (password) have expired.
        return true;//Returns true, meaning the credentials are not expired. This is a placeholder as well.
    }

    @Override
    public boolean isEnabled() { //Indicates whether the user's account is enabled.
        return true; // Returns true, meaning the account is enabled. This is a placeholder and can be modified to check actual account status.
    }
}





