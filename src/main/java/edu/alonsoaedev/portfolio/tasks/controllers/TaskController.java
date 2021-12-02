package edu.alonsoaedev.portfolio.tasks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import edu.alonsoaedev.portfolio.tasks.services.TaskService;
import edu.alonsoaedev.portfolio.tasks.entities.Task;

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
}
