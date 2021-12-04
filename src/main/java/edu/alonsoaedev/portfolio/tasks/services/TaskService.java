package edu.alonsoaedev.portfolio.tasks.services;

import java.util.List;

import edu.alonsoaedev.portfolio.tasks.entities.Task;
import edu.alonsoaedev.portfolio.tasks.exceptions.DuplicateTaskException;
import edu.alonsoaedev.portfolio.tasks.exceptions.EmptyTaskContentException;

public interface TaskService {
    List<Task> list();
    Task add(String content) throws EmptyTaskContentException, DuplicateTaskException;
    Task retrieve(Long id);
    Task modify(Long id, String content);
    void remove(Long id);
    Task check(Long id);
}
