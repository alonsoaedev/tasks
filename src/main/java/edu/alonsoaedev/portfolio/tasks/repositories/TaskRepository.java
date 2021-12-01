package edu.alonsoaedev.portfolio.tasks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.alonsoaedev.portfolio.tasks.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
