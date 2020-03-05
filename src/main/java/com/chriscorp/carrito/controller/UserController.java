package com.chriscorp.carrito.controller;

import com.chriscorp.carrito.model.User;
import com.chriscorp.carrito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    private List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    private Optional<User> getUserById(@PathVariable(name = "id") long id){
        return userService.getUserById(id);
    }

    @PostMapping("/new")
    private User postUser(@RequestBody User user){
        return userService.postUser(user);
    }

    @DeleteMapping("/{id}")
    private void deleterUserById(@PathVariable(name = "id") long id){
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    private User putUserById(@PathVariable(name = "id") long id, @RequestBody User user) throws Exception {
        return userService.getUserById(id).map(newObj -> {
            newObj.setNombre(user.getNombre());
            newObj.setEdad(user.getEdad());
            newObj.setCiudad(user.getCiudad());
            newObj.setDireccion(user.getDireccion());
            return postUser(newObj);
        }).orElseThrow(() -> new Exception("News with id " + id + "not found"));
    }
}
