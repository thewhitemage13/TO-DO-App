package org.thewhitemage13.restapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.thewhitemage13.restapplication.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
