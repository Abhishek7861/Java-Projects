package com.example.asyncWebClient.model

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String email;

    Integer getId() {
        return id
    }

    void setId(Integer id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }
}
