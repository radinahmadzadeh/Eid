package todo.entity;

import db.Entity;
import db.Trackable;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Task extends Entity implements Trackable {
    private String title;
    private String description;
    private Date dueDate;
    private Status status;

    @Override
    public void setCreationDate(Date date) {

    }

    @Override
    public Date getCreationDate() {
        return null;
    }

    @Override
    public void setLastModificationDate(Date date) {

    }

    @Override
    public Date getLastModificationDate() {
        return null;
    }

    public enum Status {
        NotStarted,
        InProgress,
        Completed
    }

    public Task(String title, String description, Date dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = Status.NotStarted;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "ID: " + getId() +
                "\nTitle: " + title +
                "\nDue Date: " + sdf.format(dueDate) +
                "\nStatus: " + status;
    }

    @Override
    public Task copy() {
        Task copy = new Task(this.title, this.description, new Date(this.dueDate.getTime()));
        copy.id = this.getId();
        copy.status = this.status;
        return copy;
    }
}
