package com.websystique.springmvc.controller;

import com.websystique.springmvc.domain.Project;
import com.websystique.springmvc.domain.Task;
import com.websystique.springmvc.domain.User;
import com.websystique.springmvc.service.ProjectService;
import com.websystique.springmvc.service.TaskService;
import com.websystique.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/")
public class AppController {
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
	TaskService taskService;

	@GetMapping(value = { "/"})
	public String homePage(ModelMap model) throws SQLException {
		List<Project> projects = (List) projectService.getAllProjects();
		model.addAttribute("projects", projects);
		return "home";
	}
	@GetMapping(value = { "/showProject"})
	public String showProject(@RequestParam("id")Long id, ModelMap model) throws SQLException {
		Project project = projectService.getProjectById(id);
		model.addAttribute("project", project);
		model.addAttribute("tasks", project.getTasks());
		return "showProject";
	}
	@GetMapping(value = { "/showTask"})
	public String showTask(@RequestParam("id")Long id, ModelMap model) throws SQLException {
		Task task = taskService.getTaskById(id);
		model.addAttribute("task", task);
		return "showTask";
	}
	@GetMapping(value = { "/addProject"})
	public String addProject(ModelMap model) throws SQLException {
		return "addProject";
	}
	@GetMapping(value = { "/addTask"})
	public String addTask(@RequestParam("projectId")Long id,ModelMap model) throws SQLException {
		Project project = projectService.getProjectById(id);
		model.addAttribute("project", project);
		return "addTask";
	}
	@GetMapping(value = { "/editProject"})
	public String editProject(@RequestParam("id")Long id, ModelMap model) throws SQLException {
		Project project = projectService.getProjectById(id);
		model.addAttribute("project", project);
		return "editProject";
	}
	@GetMapping(value = { "/editTask"})
	public String editTask(@RequestParam("id")Long id, ModelMap model) throws SQLException {
		Task task = taskService.getTaskById(id);
		model.addAttribute("task", task);
		return "editTask";
	}

	@PostMapping(value = "/addProject.do", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addProjectForm(@RequestBody Project project) throws SQLException {
		project.setProjectCreator(userService.getUserById(1l));
		projectService.saveOrUpdateProject(project);
		return ResponseEntity.ok().build();
	}
	@PostMapping(value = "/addTask.do", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addTaskForm(@RequestBody Task task,@RequestParam("projectId")Long id) throws SQLException {
		Project project = projectService.getProjectById(id);
		User user = userService.getUserById(1l);
		task.setTaskCreator(userService.getUserById(1l));
		task.setCreateDate(new Date());
		task.setTaskCreator(user);
		project.getTasks().add(task);
		projectService.saveOrUpdateProject(project);
		return ResponseEntity.ok().build();
	}
	@PostMapping(value = "/editProject.do", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> editProjectForm(@RequestBody Project project) throws SQLException {
		projectService.updateProjectWithParams(project);
		return ResponseEntity.ok().build();
	}
	@PostMapping(value = "/editTask.do", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> editTasktForm(@RequestBody Task task) throws SQLException {
		taskService.updateTaskWithParams(task);
		return ResponseEntity.ok().build();
	}
	@PostMapping(value = "/deleteProject.do", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteProject(@RequestBody Project project) throws SQLException {
		Project projectDelete = projectService.getProjectById(project.getProjectId());
		projectService.deleteProject(projectDelete);
		return ResponseEntity.ok().build();
	}
	@PostMapping(value = "/deleteTask.do", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteTask(@RequestBody Task task,@RequestParam("projectId")Long id) throws SQLException {
		Project project = projectService.getProjectById(id);
		Task taskFnl = taskService.getTaskById(task.getTaskId());
		project.getTasks().remove(taskFnl);
		projectService.saveOrUpdateProject(project);
		taskService.deleteTask(task);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = { "/products"})
	public String productsPage(ModelMap model) {
		return "products";
	}

	@GetMapping(value = { "/contactus"})
	public String contactUsPage(ModelMap model) {
		return "contactus";
	}
	@GetMapping(value = { "/login"})
	public String login(ModelMap model) {
		return "pages/login";
	}
	@GetMapping(value = { "/register"})
	public String register(ModelMap model) {
		return "pages/register";
	}
	@GetMapping(value = { "/forgot-password"})
	public String forgotPassword(ModelMap model) {
		return "pages/forgot-password";
	}

    @GetMapping(value = { "/getListProject.do"})
    public List<Project> getListProject(ModelMap model) throws SQLException{
	    return (List)projectService.getAllProjects();
    }
}