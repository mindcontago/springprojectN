package service;

import daoReposit.TaskRep;
import models.Task;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServImpl implements TaskService {
    private final TaskRep taskRepository;

    @Autowired
    public TaskServImpl(TaskRep taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Task createTask(String desc, User user) {
        return taskRepository.createTask(desc, user);
    }

    @Override
    public boolean deleteTask(Long id) {
        return taskRepository.deleteTaskById(id);
    }

    @Override
    public List<Task> findAllTasksByUser(Long userId) {
        return taskRepository.findAllTaskByUserId(userId);
    }

    @Override
    public void pointTaskAsComplete(Long taskId) {
        taskRepository.pointTaskAsComplete(taskId);
    }

    @Override
    public void pointTaskAsNotComplete(Long taskId) {
        taskRepository.pointTaskAsNotComplete(taskId);
    }
}
