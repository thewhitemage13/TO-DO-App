package org.thewhitemage13.restapplication.model;

import org.thewhitemage13.restapplication.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String username;
    private List<Todo> todos;

    public static User toModel(UserEntity userEntity) {
        User model = new User();
        model.setId(userEntity.getId());
        model.setUsername(userEntity.getUsername());
        model.setTodos(userEntity.getTodoEntityList().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
