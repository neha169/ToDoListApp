import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    boolean isCompleted;

    Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }
}

public class ToDoListApp {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskCompleted();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        } while (choice != 5);
    }

    static void showMenu() {
        System.out.println("\n=== To-Do List Menu ===");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        tasks.add(new Task(title));
        System.out.println("Task added successfully!");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found. Please add a task first!");
            return;
        }
        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            String status = t.isCompleted ? "[Completed]" : "[Pending]";
            System.out.println((i + 1) + ". " + t.title + " " + status);
        }
    }

    static void markTaskCompleted() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to mark as completed. Please add a task first!");
            return;
        }
        viewTasks();
        System.out.print("Enter task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number!");
        } else {
            tasks.get(taskNumber - 1).isCompleted = true;
            System.out.println("Task marked as completed!");
        }
    }

    static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove. Please add a task first!");
            return;
        }
        viewTasks();
        System.out.print("Enter task number to remove: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number!");
        } else {
            tasks.remove(taskNumber - 1);
            System.out.println("Task removed successfully!");
        }
    }
}
