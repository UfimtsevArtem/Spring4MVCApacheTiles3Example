package com.websystique.springmvc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Entity
@Table(name = "dbo.projects")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long projectId = null;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_description")
    private String projectDescription;
    @Column(name = "create_date")
    @Temporal(value = TemporalType.DATE)
    private Date createDate = new Date();
    @OneToOne
    @JoinColumn(name = "project_creator_id")
    private User projectCreator = null;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "project_workers",
            joinColumns = { @JoinColumn(name = "project_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<User> workers = null;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "project_tasks",
            joinColumns = { @JoinColumn(name = "project_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") })
    private Set<Task> tasks = null;

    public Project() {
    }

    public Project(String projectName, String projectDescription) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getProjectCreator() {
        return projectCreator;
    }

    public void setProjectCreator(User projectCreator) {
        this.projectCreator = projectCreator;
    }

    public Set<User> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<User> workers) {
        this.workers = workers;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", createDate=" + createDate +
                ", projectCreator=" + projectCreator +
                ", workers=" + workers +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (projectId != null ? !projectId.equals(project.projectId) : project.projectId != null) return false;
        if (projectName != null ? !projectName.equals(project.projectName) : project.projectName != null) return false;
        if (projectDescription != null ? !projectDescription.equals(project.projectDescription) : project.projectDescription != null)
            return false;
        if (createDate != null ? !createDate.equals(project.createDate) : project.createDate != null) return false;
        if (projectCreator != null ? !projectCreator.equals(project.projectCreator) : project.projectCreator != null)
            return false;
        if (workers != null ? !workers.equals(project.workers) : project.workers != null) return false;
        return tasks != null ? tasks.equals(project.tasks) : project.tasks == null;
    }

    @Override
    public int hashCode() {
        int result = projectId != null ? projectId.hashCode() : 0;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (projectDescription != null ? projectDescription.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (projectCreator != null ? projectCreator.hashCode() : 0);
        result = 31 * result + (workers != null ? workers.hashCode() : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        return result;
    }
}
