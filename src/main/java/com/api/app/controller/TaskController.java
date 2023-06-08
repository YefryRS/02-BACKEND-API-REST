package com.api.app.controller;

import com.api.app.model.Task;
import com.api.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTask() {
        return taskService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Task> getTask(@PathVariable Long id) {
        return taskService.findById(id);
    }
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveOrUpdate(task);
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,@RequestBody Task task) {
        Task updateTask = taskService.findById(id).get();
        updateTask.setTitulo(task.getTitulo());
        updateTask.setDescripcion(task.getDescripcion());
        updateTask.setFechaCreacion(task.getFechaCreacion());
        updateTask.setEstadoFinalizacion(task.isEstadoFinalizacion());

        return taskService.saveOrUpdate(updateTask);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.delete(id);
    }

}
