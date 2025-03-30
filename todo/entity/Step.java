package todo.entity;

import db.Entity;

public class Step extends Entity {
    private String title;
    private Status status;
    private int taskRef;

    @Override
    public Entity copy() {
        return null;
    }

    public enum Status {
        NotStarted,
        Completed
    }

    public Step(String title, int taskRef) {
        this.title = title;
        this.status = Status.NotStarted;
        this.taskRef = taskRef;
    }

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getTaskRef() {
        return taskRef;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "\nTitle: " + title + "\nStatus: " + status;
    }
}
