package com.example.PracticeSpringSecurity.service;

import com.example.PracticeSpringSecurity.repository.UserRepository;
import com.example.PracticeSpringSecurity.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//このクラスの役割は、usernameからユーザ情報(User)を取得すること。
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(username + " not found."));
        return user;
    }
}
