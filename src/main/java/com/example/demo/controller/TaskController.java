package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/task")

public class TaskController {
    
    @Autowired
    private TaskService service;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return service.findAll();
    }

    @GetMapping("/{tanksId}")
        public Task getTaskById(@PathVariable("taskId") String taskId) {
            return service.getTaskById(taskId);
        }

    @GetMapping("/tasks")
    public List<Task> findTaskUsingSeverity(int severity) {
        return service.getTaskBySeverity(severity);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> findTaskUsingAssignee(String assignee) {
        return service.getTaskByAssignee(assignee);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskByAssignee(String assignee) {
        return service.getTaskByAssignee(assignee);
    }

    @PutMapping("/update")
    public Task modifyTask(@RequestBody Task task) {
        return service.updateTask(task);
    }

    @DeleteMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable String taskId) {
        return service.deleteTask(taskId);
    }


}
