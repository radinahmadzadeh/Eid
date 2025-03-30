package todo.service;

import db.Database;
import todo.entity.Step;

public class StepService {
    public static void saveStep(int taskRef, String title) {
        Step step = new Step(title, taskRef);
        Database.save(step);
    }

    public static void updateStepStatus(int stepId, Step.Status status) {
        Step step = (Step) Database.findById(stepId);
        if (step != null) {
            step.setStatus(status);
            Database.update(step);
        }
    }
}
