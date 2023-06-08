package com.api.app.service;

import com.api.app.model.Task;
import com.api.app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveOrUpdate(Task task) {
        return taskRepository.save(task);
    }
    public List<Task> getAll() {
        return taskRepository.findAll();
    }
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }


}
