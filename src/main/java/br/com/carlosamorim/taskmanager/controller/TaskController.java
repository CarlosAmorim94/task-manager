package br.com.carlosamorim.taskmanager.controller;

import br.com.carlosamorim.taskmanager.model.Task;
import br.com.carlosamorim.taskmanager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        var tasks = this.taskService.findAll();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable String id) {
        var task = this.taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody Task task) {
        task = this.taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/{id}/completed")
    public ResponseEntity<Void> completed(@PathVariable String id) {
        this.taskService.completed(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
