package com.noodleesystem.users.controller;

import java.util.List;

import com.noodleesystem.users.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.noodleesystem.users.model.UserApiModel;
import com.noodleesystem.users.repository.UserRepository;

@RestController
public class UsersControler {
    @Autowired
	private UserRepository usersRepository;

    @GetMapping("/users")
    List<UserApiModel> getAllUsers() {
        return usersRepository.findAll();
	}

    @GetMapping("/users/{id}")
    UserApiModel getUser(@PathVariable int id) {
        UserApiModel user = usersRepository.getUserById(id);

        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException(id);
        }
    }
}
