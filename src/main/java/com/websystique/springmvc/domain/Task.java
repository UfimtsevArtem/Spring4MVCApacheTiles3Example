package com.websystique.springmvc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Entity
@Table(name = "dbo.tasks")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long taskId;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_descripton")
    private String taskDescription;
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

    public Task(String taskName, String taskDescription, Date createDate, User taskCreator) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.createDate = createDate;
        this.taskCreator = taskCreator;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<User> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<User> workers) {
        this.workers = workers;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getTaskCreator() {
        return taskCreator;
    }

    public void setTaskCreator(User taskCreator) {
        this.taskCreator = taskCreator;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDesription='" + taskDescription + '\'' +
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
        if (taskDescription != null ? !taskDescription.equals(task.taskDescription) : task.taskDescription != null)
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
        result = 31 * result + (taskDescription != null ? taskDescription.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (workers != null ? workers.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (taskCreator != null ? taskCreator.hashCode() : 0);
        return result;
    }
}
