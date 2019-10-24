package service;

import models.Task;
import models.User;

import java.util.List;

public interface TaskService {
    Task createTask (String desc, User user);

    boolean deleteTask(Long id);

    List<Task> findAllTasksByUser(Long userId);

    void pointTaskAsComplete(Long taskId);

    void pointTaskAsNotComplete(Long taskId);
}
