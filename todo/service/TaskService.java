package todo.service;

import db.Database;
import todo.entity.Step;
import todo.entity.Task;

public class TaskService {
    public static void setAsCompleted(int taskId) {
        Task task = (Task) Database.findById(taskId);
        if (task != null) {
            task.setStatus(Task.Status.Completed);
            Database.update(task);
            // Update all steps related to this task
            Database.getAll(Task.class.getSimpleName().hashCode()).forEach(entity -> {
                if (entity instanceof Step && ((Step) entity).getTaskRef() == taskId) {
                    ((Step) entity).setStatus(Step.Status.Completed);
                    Database.update(entity);
                }
            });
        }
    }
}
