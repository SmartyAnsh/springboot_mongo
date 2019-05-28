package com.smartdiscover.impl;

import com.smartdiscover.pojo.User;
import com.smartdiscover.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartdiscover.RegistrationInterface;
import java.util.List;

@Service
public class RegistrationImpl implements RegistrationInterface<String, User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) throws Exception {
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserData(String userId) throws Exception {
        User user = userRepository.findById(userId);
        return user;
    }

    public List<User> getAllUser() throws Exception {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public void deleteUser(String userId) throws Exception {
        if(userId == null){
            throw new Exception("user id is null");
        }else{
            userRepository.delete(userId);
        }
    }
}
