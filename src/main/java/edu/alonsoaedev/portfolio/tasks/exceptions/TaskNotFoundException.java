package edu.alonsoaedev.portfolio.tasks.exceptions;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException() {
        super("Task not found");
    }
}
