package net.stanleydev.usersapi.services;
import net.stanleydev.usersapi.dto.UserDTO;
import net.stanleydev.usersapi.entities.User;
import net.stanleydev.usersapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> findAll(){
        List<User> entity = repository.findAll();
        List<UserDTO> dto = new ArrayList<UserDTO>();
        for (User user : entity) {
            dto.add(new UserDTO(user));
        }
        return dto;
    }

    public UserDTO findById(Long id){
        User entity = repository.findById(id).orElse(null);
        return new UserDTO(entity);
    }

    public UserDTO insertUser(UserDTO userDto){
        User entity = new User(userDto);
        repository.save(entity);
        return userDto = new UserDTO(entity);
    }
}
