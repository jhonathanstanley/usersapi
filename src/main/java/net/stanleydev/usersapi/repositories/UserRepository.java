package net.stanleydev.usersapi.repositories;

import net.stanleydev.usersapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {



}
