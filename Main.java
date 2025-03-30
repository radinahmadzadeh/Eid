import java.util.Date;
import java.util.Scanner;
import db.exception.InvalidEntityException;
import todo.entity.Task;
import todo.validator.TaskValidator;
import db.Database;
import db.Validator;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter a command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add task":
                    addTask();
                    break;
                case "add step":
                    addStep();
                    break;
                case "update task":
                    updateTask();
                    break;
                case "update step":
                    updateStep();
                    break;
                case "delete":
                    deleteEntity();
                    break;
                case "get task-by-id":
                    getTaskById();
                    break;
                case "get all-tasks":
                    getAllTasks();
                    break;
                case "get incomplete-tasks":
                    getIncompleteTasks();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
    private static void addTask() {
        System.out.println("Enter task title: ");
        String title = scanner.nextLine();
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();
        System.out.println("Enter due date (yyyy-mm-dd): ");
        String dueDateStr = scanner.nextLine();
        Task task = new Task(title, description, new Date());
        Validator validator = new TaskValidator();
        try {
            validator.validate(task);
            Database.save(task);
            System.out.println("Task saved successfully.\nID: " + task.getId());
        } catch (IllegalArgumentException | InvalidEntityException e) {
            System.out.println("Cannot save task.\nError: " + e.getMessage());
        }
    }
    private static void addStep() {
    }
    private static void updateTask() {
    }
    private static void updateStep() {
    }
    private static void deleteEntity() {
    }
    private static void getTaskById() {
    }
    private static void getAllTasks() {
    }
    private static void getIncompleteTasks() {
    }
}
