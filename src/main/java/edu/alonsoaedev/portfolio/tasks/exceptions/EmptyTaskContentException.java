package edu.alonsoaedev.portfolio.tasks.exceptions;

public class EmptyTaskContentException extends Exception {
    public EmptyTaskContentException() {
        super("Task empty");
    }
}
