import configuration.AppConfig;
import controller.UserController;
import models.Task;
import models.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();//???????

        UserController userController = ctx.getBean(UserController.class);
        userController.regNewUser("Masha Sidorova", "masha@aol.com", "1234");

        User user1 = userController.signIn("alex@gmail.com", "4321");
        User user2 = userController.signIn("masha@aol.com", "1234");
        Task task = userController.createTask("be a moderator", user2);

        userController.regNewUser("Alex Ivanov", "alex@gmail.com", "4321");

        userController.createTask("delete all politics conversations", user1);
        userController.createTask("be admin", user2);
        userController.findAllUsersTasks(user1.getId());
        userController.findAllUsersTasks(user2.getId());

        userController.markTaskAsCompleted(task.getTaskId());

        userController.findAllUsersTasks(user1.getId());
        userController.findAllUsersTasks(user2.getId());
        userController.markTaskAsCompleted(3l);
        userController.findAllUsersTasks(user2.getId());
    }
}
