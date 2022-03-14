package com.spring.training.reactive.service;

import com.spring.training.reactive.model.User;
import com.spring.training.reactive.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public Flux<User> getUsers() {
        return repository.findAll();
    }

    public Mono<User> getUser(String id) {
        return repository.findById(id);
    }

}