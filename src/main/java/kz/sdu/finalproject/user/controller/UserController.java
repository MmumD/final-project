package kz.sdu.finalproject.user.controller;

import kz.sdu.finalproject.user.dto.UserCreateRequest;
import kz.sdu.finalproject.user.entity.UserEntity;
import kz.sdu.finalproject.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/get/by/id/")
    public ResponseEntity<UserEntity> getUserById(@RequestParam(value = "id") Long id){
        System.out.println("WORKS");
        return ResponseEntity.ok(service.loadUserById(id));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<UserEntity>> getAll(){
        System.out.println("WORKS");
        return ResponseEntity.ok(service.loadAll());
    }

    @PostMapping("/register")
    private ResponseEntity<Boolean> registerUser(@RequestBody UserCreateRequest request){
        return ResponseEntity.ok(service.registerUser(request));
    }

}
