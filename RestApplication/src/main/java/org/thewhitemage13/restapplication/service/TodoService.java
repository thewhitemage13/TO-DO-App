package org.thewhitemage13.restapplication.service;

import org.springframework.stereotype.Service;
import org.thewhitemage13.restapplication.entity.TodoEntity;
import org.thewhitemage13.restapplication.entity.UserEntity;
import org.thewhitemage13.restapplication.model.Todo;
import org.thewhitemage13.restapplication.repository.TodoRepository;
import org.thewhitemage13.restapplication.repository.UserRepository;

@Service
public class TodoService {
    private TodoRepository todoRepository;
    private UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public Todo createTodo(TodoEntity todoEntity, Long userId) {
        UserEntity user = userRepository.findById(userId).get();
        todoEntity.setUser(user);
        return Todo.toModel(todoRepository.save(todoEntity));
    }

    public Todo complete(Long id) {
        TodoEntity todoEntity = todoRepository.findById(id).get();
        todoEntity.setCompleted(!todoEntity.getCompleted());
        return Todo.toModel(todoRepository.save(todoEntity));
    }
}
