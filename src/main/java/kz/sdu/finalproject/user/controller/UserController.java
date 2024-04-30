package kz.sdu.finalproject.user.controller;

import kz.sdu.finalproject.user.entity.UserEntity;
import kz.sdu.finalproject.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/")
    public ResponseEntity<UserEntity> getUserById(@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(service.loadUserById(id));
    }

    @GetMapping("/")
    public ResponseEntity<UserEntity> getUserByUsername(@RequestParam(value = "name") String username){
        return ResponseEntity.ok(service.loadUserByUsername(username));
    }

}
