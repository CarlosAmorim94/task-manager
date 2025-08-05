package br.com.carlosamorim.taskmanager.service;

import br.com.carlosamorim.taskmanager.model.Task;
import br.com.carlosamorim.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public Task save(Task task) {
       var user = this.userService.findById(task.getUser().getId());
       task.setUser(user);
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(String id) {
        return this.taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    public void completed(String id) {
        Task task = this.findById(id);
        task.setCompleted(true);
        this.save(task);
    }

    public void delete(String id) {
        this.taskRepository.deleteById(id);
    }
}
