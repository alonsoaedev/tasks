package edu.alonsoaedev.portfolio.tasks.services;

import java.util.List;

import edu.alonsoaedev.portfolio.tasks.entities.Task;
import edu.alonsoaedev.portfolio.tasks.exceptions.DuplicateTaskException;
import edu.alonsoaedev.portfolio.tasks.exceptions.EmptyTaskContentException;
import edu.alonsoaedev.portfolio.tasks.exceptions.TaskNotFoundException;

public interface TaskService {
    List<Task> list();
    Task add(String content) throws EmptyTaskContentException, DuplicateTaskException;
    Task retrieve(Long id) throws TaskNotFoundException;
    Task modify(Long id, String content) throws EmptyTaskContentException, DuplicateTaskException, TaskNotFoundException;
    void remove(Long id);
    Task check(Long id) throws TaskNotFoundException;
}
