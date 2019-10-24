package daoReposit;

import models.Task;
import models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskDao implements TaskRep {
    private List<Task> listOfTasks;

    private long countTaskId;

    public TaskDao() {
        this.listOfTasks = new ArrayList<>();
        this.countTaskId = 1;
    }

    @Override
    public Task createTask(String description, User user) {
        Task task = new Task(user.getId(), countTaskId++, description, false);
        //Task task = new Task();
        listOfTasks.add(task);
        return task;
    }

    @Override
    public boolean deleteTaskById(Long taskId) {
        for (Task task : listOfTasks) {
            if (task.getTaskId().equals(taskId)) {
                listOfTasks.remove(task);
            }
        }
        return false;
    }

    @Override
    public List<Task> findAllTaskByUserId(Long userId) {
        return listOfTasks.stream()
                .filter(task -> task.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public void pointTaskAsComplete(Long taskId) {
        listOfTasks.stream()
                .filter(task -> task.getTaskId().equals(taskId))
                .forEach(task -> task.setTaskIsComplete(true));
    }

    @Override
    public void pointTaskAsNotComplete(Long taskId) {
        listOfTasks.stream()
                .filter(task -> task.getTaskId().equals(taskId))
                .forEach(task -> task.setTaskIsComplete(false));

    }
}
