package com.chriscorp.carrito.service;


import com.chriscorp.carrito.model.User;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<User> getAllUser();

    Optional<User> getUserById(long id);

    User postUser(User user);

    User putUser(long id, User user);

    void deleteUser(long id);

    Path pathUser(long id, String varUser);
}
