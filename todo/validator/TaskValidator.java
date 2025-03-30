package todo.validator;

import db.Entity;
import db.Validator;
import db.exception.InvalidEntityException;
import todo.entity.Task;

public class TaskValidator implements Validator {
    @Override
    public void validate(Object obj) {
        if (!(obj instanceof Task)) {
            throw new IllegalArgumentException("Invalid object type. Expected Task.");
        }
        Task task = (Task) obj;
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be empty.");
        }
    }

    @Override
    public void validate(Entity entity) throws InvalidEntityException {

    }
}
