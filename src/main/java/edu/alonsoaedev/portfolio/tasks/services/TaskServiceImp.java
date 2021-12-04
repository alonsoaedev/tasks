package edu.alonsoaedev.portfolio.tasks.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;

import edu.alonsoaedev.portfolio.tasks.entities.Task;
import edu.alonsoaedev.portfolio.tasks.repositories.TaskRepository;
import edu.alonsoaedev.portfolio.tasks.exceptions.EmptyTaskContentException;
import edu.alonsoaedev.portfolio.tasks.exceptions.DuplicateTaskException;

@Service
@Qualifier("default")
public class TaskServiceImp implements TaskService{
    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> list() {
        return taskRepository.findAll();
    }

    @Override
    public Task add(String content) throws EmptyTaskContentException, DuplicateTaskException {
        Task newTask = new Task(content);
        boolean exist = taskRepository.findAll().stream().anyMatch(task -> task.equals(newTask));
        if (exist) throw new DuplicateTaskException();
        return taskRepository.save(newTask);
    }

    @Override
    public Task retrieve(Long id) {
        return null;
    }

    @Override
    public Task modify(Long id, String content) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Task check(Long id) {
        return null;
    }
}
