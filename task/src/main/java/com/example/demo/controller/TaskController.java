package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    
    @GetMapping("/getAllTasks")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Task>> getAllTasks() {
        return taskService.getAllTasks();
    }

    
    @GetMapping("/getTaskById/{taskId}")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer taskId) {
        return taskService.getTaskById(taskId);
    }

    
    @PostMapping("/createTask")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    
    @PutMapping("/updateTask")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    
    @DeleteMapping("/deleteTask/{taskId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> deleteTask(@PathVariable Integer taskId) {
        return taskService.deleteTask(taskId);
    }
}
