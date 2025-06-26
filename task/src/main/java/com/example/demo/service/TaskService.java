package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.repo.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

   
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return ResponseEntity.ok(tasks); // status 200
    }

   
    public ResponseEntity<Task> getTaskById(Integer id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
        return ResponseEntity.ok(task); // status 200
    }

    
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addTask(Task task) {
        taskRepository.save(task);
        return ResponseEntity.ok("Task added successfully");
    }

    
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateTask(Task task) {
        taskRepository.save(task);
        return ResponseEntity.ok("Task updated successfully");
    }

   
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteTask(Integer id) {
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.ok("Task not found with ID: " + id);
        }
        taskRepository.deleteById(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
