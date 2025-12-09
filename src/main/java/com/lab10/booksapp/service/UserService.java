package com.lab10.booksapp.service;

import com.lab10.booksapp.model.User;
import com.lab10.booksapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean register(String email, String parola){
        if(userRepository.findByEmail(email)!=null){
            return false;
        }
        userRepository.save(new User(email, parola));
        return true;
    }

    public boolean login(String email , String parola){
        User user = userRepository.findByEmail(email);
        return user != null && user.getParola().equals(parola);
    }

}
