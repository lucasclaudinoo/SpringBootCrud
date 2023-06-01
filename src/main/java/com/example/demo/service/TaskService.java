package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

@Service

public class TaskService {
    
    @Autowired
    private TaskRepository repository;

    public Task addTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    public List<Task> getTasks() {
        return repository.findAll();
    }

    public Task getTaskById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Task> getTaskBySeverity(int severity) {
        return repository.findBySeverity(severity);
    }

    public List<Task> getTaskByAssignee(String assignee) {
        return repository.findByAssignee(assignee);
    }

    public String deleteTask(String id) {
        repository.deleteById(id);
        return "Task removed !! " + id;
    }

    public Task updateTask(Task task) {
        Task existingTask = repository.findById(task.getTaskId()).orElse(null);
        existingTask.setDescription(task.getDescription());
        existingTask.setSeverity(task.getSeverity());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setStoryPoint(task.getStoryPoint());
        return repository.save(existingTask);
    }

    public List<Task> findAll() {
        return null;
    }


}
