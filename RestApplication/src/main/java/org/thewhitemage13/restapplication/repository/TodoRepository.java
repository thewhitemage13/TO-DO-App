package org.thewhitemage13.restapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.thewhitemage13.restapplication.entity.TodoEntity;

public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
}
