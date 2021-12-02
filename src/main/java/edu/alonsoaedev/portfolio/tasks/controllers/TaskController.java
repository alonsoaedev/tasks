package edu.alonsoaedev.portfolio.tasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.alonsoaedev.portfolio.tasks.services.TaskService;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(@Qualifier("default") TaskService taskService) {
        this.taskService = taskService;
    }
}
