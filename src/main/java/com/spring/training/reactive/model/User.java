package com.spring.training.reactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
@Data
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Field(value = "username")
    private String userName;
    private String password;

}
