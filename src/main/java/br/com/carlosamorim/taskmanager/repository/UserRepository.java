package br.com.carlosamorim.taskmanager.repository;

import br.com.carlosamorim.taskmanager.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}