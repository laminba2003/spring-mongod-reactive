package com.spring.training.reactive.controller;

import com.spring.training.reactive.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("{id}")
    public Mono<Student> getStudent(@PathVariable("id") Long id) {
        return Mono.just(new Student(1L, "Mamadou Lamine", "Ba"));
    }

}
