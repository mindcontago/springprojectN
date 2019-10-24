package controller;

import exceptions.NoSuchUserException;
import exceptions.PasswordInvalidException;
import models.Task;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.TaskService;
import service.UserService;

@Component
public class UserController {
    private final UserService userService;
    private final TaskService taskService;

    @Autowired
    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    public void regNewUser(String name, String email, String password) {
        try {
            userService.regNewUser(name, email, password);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("User added.");
    }

    public User signIn(String email, String password) {
        User user = null;
        try {
            user = userService.signIn(email, password);
        } catch (NoSuchUserException | PasswordInvalidException e) {
            System.out.println(e.getMessage());
        }
        if (user != null) {
            System.out.println("User registered." + user.toString());
        }
        return user;
    }

    public Task createTask(String description, User user) {
        Task task = taskService.createTask(description, user);
        System.out.println("Task created: " + task.getTaskDesc());
        return task;
    }

    public void deleteTask(Long taskId) {
        if (taskService.deleteTask(taskId)) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("No task with this id.");
        }
    }

    public void findAllUsersTasks(Long userId) {
        for (Task t : taskService.findAllTasksByUser(userId)) {
            System.out.println(t.toString());
        }
    }

    public void markTaskAsCompleted(Long taskId) {
        taskService.pointTaskAsNotComplete(taskId);
    }
    
    public void markTaskAsNotCompeted(Long taskId) {
        taskService.pointTaskAsNotComplete(taskId);
    }
}
