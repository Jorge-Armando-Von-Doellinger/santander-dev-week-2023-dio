package me.dio.santander_dev_week_2023_dio.controller;

import jakarta.servlet.Servlet;
import me.dio.santander_dev_week_2023_dio.domain.model.User;
import me.dio.santander_dev_week_2023_dio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = service.findById(id);
        System.out.println("Testew");
        return ResponseEntity.ok(user);
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        var userCreated = service.create(user); // Alteracoes aplicadas, sem necessidade de instanciar novamente, visto que esta utilizando a referencia em memoria...
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.ok(userCreated);
    }
}
