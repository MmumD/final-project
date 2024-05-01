package kz.sdu.finalproject.user.controller;

import kz.sdu.finalproject.user.dto.UserCreateRequest;
import kz.sdu.finalproject.user.dto.UserUpdateRequest;
import kz.sdu.finalproject.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerUser(@RequestBody UserCreateRequest request){
        return ResponseEntity.ok(service.registerUser(request));
    }

    @PutMapping("/update/role")
    public ResponseEntity<Boolean> updateRole(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(service.updateRole(token));
    }


    @PutMapping("/update")
    public ResponseEntity<Boolean> updatePassword(@RequestHeader("Authorization") String token, @RequestBody UserUpdateRequest request){
        return ResponseEntity.ok(service.updatePassword(token, request));
    }



}
