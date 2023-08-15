package net.stanleydev.usersapi.controllers;
import net.stanleydev.usersapi.dto.UserDTO;
import net.stanleydev.usersapi.entities.User;
import net.stanleydev.usersapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public  UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public UserDTO findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping
    public UserDTO insertUser(@RequestBody UserDTO userDTO){
        return userService.insertUser(userDTO);
    }
}
