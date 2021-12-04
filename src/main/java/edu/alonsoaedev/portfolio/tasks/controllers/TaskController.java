package edu.alonsoaedev.portfolio.tasks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.alonsoaedev.portfolio.tasks.services.TaskService;
import edu.alonsoaedev.portfolio.tasks.entities.Task;
import edu.alonsoaedev.portfolio.tasks.exceptions.DuplicateTaskException;
import edu.alonsoaedev.portfolio.tasks.exceptions.EmptyTaskContentException;
import edu.alonsoaedev.portfolio.tasks.exceptions.TaskNotFoundException;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(@Qualifier("default") TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    ResponseEntity<List<Task>> listTasks() {
        return ResponseEntity.ok(taskService.list());
    }

    @PostMapping
    ResponseEntity<Task> addTask(@RequestBody Task newTask) {
        try {
            return ResponseEntity.status(201).body(taskService.add(newTask.getContent()));
        } catch (DuplicateTaskException duplicateTaskException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, duplicateTaskException.getMessage(), duplicateTaskException);
        } catch (EmptyTaskContentException emptyTaskContentException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, emptyTaskContentException.getMessage(), emptyTaskContentException);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Task> retrieveOneTask(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(taskService.retrieve(id));
        } catch (TaskNotFoundException taskNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, taskNotFoundException.getMessage(), taskNotFoundException);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Task> modifyTask(@PathVariable Long id, @RequestBody Task task) {
        try {
            return ResponseEntity.ok(taskService.modify(id, task.getContent()));
        } catch (EmptyTaskContentException emptyTaskContentException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, emptyTaskContentException.getMessage(), emptyTaskContentException);
        } catch (DuplicateTaskException duplicateTaskException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, duplicateTaskException.getMessage(), duplicateTaskException);
        } catch (TaskNotFoundException taskNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, taskNotFoundException.getMessage(), taskNotFoundException);
        }
    }
}
