package com.websystique.springmvc.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Entity
@Table(name = "dbo.tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long taskId;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_descripton")
    private String taskDesription;
    @Column(name = "create_date")
    @Temporal(value = TemporalType.DATE)
    private Date createDate;
    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "task_workers",
            joinColumns = { @JoinColumn(name = "task_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<User> workers;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "task_comments",
            joinColumns = { @JoinColumn(name = "task_id") },
            inverseJoinColumns = { @JoinColumn(name = "comment_id") })
    private Set<Comment> comments;
    @OneToOne
    @JoinColumn(name = "task_creator_id")
    private User taskCreator;

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDesription='" + taskDesription + '\'' +
                ", createDate=" + createDate +
                ", status=" + status +
                ", workers=" + workers +
                ", comments=" + comments +
                ", taskCreator=" + taskCreator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (taskId != null ? !taskId.equals(task.taskId) : task.taskId != null) return false;
        if (taskName != null ? !taskName.equals(task.taskName) : task.taskName != null) return false;
        if (taskDesription != null ? !taskDesription.equals(task.taskDesription) : task.taskDesription != null)
            return false;
        if (createDate != null ? !createDate.equals(task.createDate) : task.createDate != null) return false;
        if (status != null ? !status.equals(task.status) : task.status != null) return false;
        if (workers != null ? !workers.equals(task.workers) : task.workers != null) return false;
        if (comments != null ? !comments.equals(task.comments) : task.comments != null) return false;
        return taskCreator != null ? taskCreator.equals(task.taskCreator) : task.taskCreator == null;
    }

    @Override
    public int hashCode() {
        int result = taskId != null ? taskId.hashCode() : 0;
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + (taskDesription != null ? taskDesription.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (workers != null ? workers.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (taskCreator != null ? taskCreator.hashCode() : 0);
        return result;
    }
}
