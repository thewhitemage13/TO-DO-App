package org.thewhitemage13.restapplication.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thewhitemage13.restapplication.entity.UserEntity;
import org.thewhitemage13.restapplication.exception.UserAlreadyExist;
import org.thewhitemage13.restapplication.exception.UserNotFoundException;
import org.thewhitemage13.restapplication.model.User;
import org.thewhitemage13.restapplication.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity registration(UserEntity user) throws UserAlreadyExist {
        if(userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExist("We have user with username" + user.getUsername());
        }
        return userRepository.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if(userRepository.findById(id).get() == null) {
            throw new UserNotFoundException("User not found");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}






















