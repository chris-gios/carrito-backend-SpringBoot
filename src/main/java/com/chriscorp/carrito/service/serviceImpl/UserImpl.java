package com.chriscorp.carrito.service.serviceImpl;

import com.chriscorp.carrito.model.User;
import com.chriscorp.carrito.repository.UserRepository;
import com.chriscorp.carrito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }

    @Override
    public User postUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User putUser(long id, User user){
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    @Override
    public Path pathUser(long id, String varUser) {
        return null;
    }

}
