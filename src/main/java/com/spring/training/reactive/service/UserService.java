package com.spring.training.reactive.service;

import com.spring.training.reactive.exception.EntityNotFoundException;
import com.spring.training.reactive.model.User;
import com.spring.training.reactive.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService {

    final UserRepository repository;

    public Flux<User> getUsers() {
        return repository.findAll();
    }

    public Mono<User> getUser(String id) {
        return Mono.just(id)
                .flatMap(repository::findById)
                .switchIfEmpty(Mono.error(new EntityNotFoundException("user not found with id " + id)));
    }

    public Mono<User> createUser(User user) {
        return repository.save(user);
    }

    public Mono<User> updateUser(String id, User user) {
        return Mono.just(id)
                .flatMap(repository::findById)
                .flatMap(entity -> {
                    user.setId(id);
                    return repository.save(user);
                }).switchIfEmpty(Mono.error(new EntityNotFoundException("user not found with id " + id)));
    }

    public Mono<Void> deleteUser(String id) {
        return repository.deleteById(id);
    }

}