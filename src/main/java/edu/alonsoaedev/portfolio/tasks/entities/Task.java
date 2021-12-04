package edu.alonsoaedev.portfolio.tasks.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;

import edu.alonsoaedev.portfolio.tasks.exceptions.EmptyTaskContentException;

@Entity
@Table(name = "taks")
public class Task {
    @Id
    @SequenceGenerator(name = "tasks_sequence", sequenceName = "tasks_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_sequence")
    private Long id;
    private String content;
    private boolean checked;

    public Task() {
        content = "Ooops";
    }

    public Task(String content) throws EmptyTaskContentException {
        if (isEmpty(content)) throw new EmptyTaskContentException();
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) throws EmptyTaskContentException {
        if (isEmpty(content)) throw new EmptyTaskContentException();
        this.content = content;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    private boolean isEmpty(String content) {
        return content == null || content.isBlank();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return content.equalsIgnoreCase(task.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", checked=" + checked +
                '}';
    }
}
