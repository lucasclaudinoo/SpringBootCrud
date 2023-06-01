package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Task;
import java.util.List;



public interface TaskRepository extends MongoRepository<Task, String> {
    
    List<Task> findBySeverity(int severity);

    @Query("{'assignee': ?0}")
    List<Task> findByAssignee(String assignee);
}
