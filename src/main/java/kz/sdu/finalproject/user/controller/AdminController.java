package kz.sdu.finalproject.user.controller;

import kz.sdu.finalproject.user.dto.UserView;
import kz.sdu.finalproject.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService service;

    @GetMapping("/get/by/id/")
    public ResponseEntity<UserView> getUserById(@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(service.loadUserById(id));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<UserView>> getAll(){
        return ResponseEntity.ok(service.loadAll());
    }

}
