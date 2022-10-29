package com.spring.training.reactive.controller;

import com.spring.training.reactive.model.User;
import com.spring.training.reactive.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    final UserService service;

    @GetMapping("{id}")
    public Mono<User> getUser(@PathVariable("id") String id) {
        return service.getUser(id);
    }

    @GetMapping
    public Flux<User> getUsers() {
        return service.getUsers();
    }

}
