package org.thewhitemage13.restapplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thewhitemage13.restapplication.entity.UserEntity;
import org.thewhitemage13.restapplication.exception.UserAlreadyExist;
import org.thewhitemage13.restapplication.exception.UserNotFoundException;
import org.thewhitemage13.restapplication.repository.UserRepository;
import org.thewhitemage13.restapplication.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity register(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Successfully registered");
        }catch (UserAlreadyExist e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Exception occured");
        }
    }

    //RequestParam параметр поисковой строки который помечается ?

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam  Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Exception occured");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Exception occured");
        }
    }
}



























