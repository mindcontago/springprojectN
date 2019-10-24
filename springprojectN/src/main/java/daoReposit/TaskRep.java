package daoReposit;

import models.Task;
import models.User;
import java.util.List;

public interface TaskRep {
    Task createTask(String description, User user);

    boolean deleteTaskById(Long taskId);

    List<Task> findAllTaskByUserId(Long userId);

    void pointTaskAsComplete(Long taskId);

    void pointTaskAsNotComplete(Long taskId);
}
