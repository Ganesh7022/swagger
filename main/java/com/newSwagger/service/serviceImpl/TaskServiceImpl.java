package com.newSwagger.service.serviceImpl;

// TaskServiceImpl.java

import com.newSwagger.entity.Task;
import com.newSwagger.repository.TaskRepository;
import com.newSwagger.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id).orElse(null);

        if (existingTask != null) {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setCompleted(updatedTask.isCompleted());
            return taskRepository.save(existingTask);
        }

        return null;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
