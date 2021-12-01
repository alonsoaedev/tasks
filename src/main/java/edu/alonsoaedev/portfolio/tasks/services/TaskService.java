package edu.alonsoaedev.portfolio.tasks.services;

import java.util.List;

import edu.alonsoaedev.portfolio.tasks.entities.Task;

public interface TaskService {
    List<Task> list();
    Task add(String content);
    Task retrieve(Long id);
    Task modify(Long id, String content);
    void remove(Long id);
    Task check(Long id);
}
