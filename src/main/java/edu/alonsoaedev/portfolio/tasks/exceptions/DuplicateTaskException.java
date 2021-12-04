package edu.alonsoaedev.portfolio.tasks.exceptions;

public class DuplicateTaskException extends Exception {
    public DuplicateTaskException() {
        super("Task duplicated");
    }
}
