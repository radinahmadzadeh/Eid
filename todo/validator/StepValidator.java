package todo.validator;

import db.Entity;
import db.Validator;
import db.exception.InvalidEntityException;
import todo.entity.Step;
import db.Database;
import todo.entity.Task;

public class StepValidator implements Validator {
    @Override
    public void validate(Object obj) {
        if (!(obj instanceof Step)) {
            throw new IllegalArgumentException("Invalid object type. Expected Step.");
        }
        Step step = (Step) obj;
        if (step.getTitle() == null || step.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Step title cannot be empty.");
        }
        Task task = (Task) Database.findById(step.getTaskRef());
        if (task == null) {
            throw new IllegalArgumentException("Cannot find task with ID=" + step.getTaskRef());
        }
    }

    @Override
    public void validate(Entity entity) throws InvalidEntityException {

    }
}
