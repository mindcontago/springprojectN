package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private Long userId;
    private Long taskId;
    private String taskDesc;
    private boolean taskIsComplete;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return isTaskIsComplete() == task.isTaskIsComplete() &&
                Objects.equals(getUserId(), task.getUserId()) &&
                Objects.equals(getTaskId(), task.getTaskId()) &&
                Objects.equals(getTaskDesc(), task.getTaskDesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getTaskId(), getTaskDesc(), isTaskIsComplete());
    }

    @Override
    public String toString() {
        return "Task{" +
                "userId=" + userId +
                ", taskId=" + taskId +
                ", taskDesc='" + taskDesc + '\'' +
                ", taskIsComplete=" + taskIsComplete +
                '}';
    }
}
