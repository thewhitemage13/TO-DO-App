package org.thewhitemage13.restapplication.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TodoEntity> todoEntityList = new ArrayList<TodoEntity>();

    public UserEntity() {

    }

    public List<TodoEntity> getTodoEntityList() {
        return todoEntityList;
    }

    public void setTodoEntityList(List<TodoEntity> todoEntityList) {
        this.todoEntityList = todoEntityList;
    }

    public Long getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
