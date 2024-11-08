package com.noobie.Security_Demo.service;

import com.noobie.Security_Demo.model.CustomUser;
import com.noobie.Security_Demo.repositories.MyUserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    public MyUserRepo myUserRepo;
    public CustomUserDetailsService(MyUserRepo myUserRepo) {
        this.myUserRepo = myUserRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CustomUser(myUserRepo.findByUsername(username));
    }
}
