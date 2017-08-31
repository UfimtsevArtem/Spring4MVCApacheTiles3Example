package com.websystique.springmvc.controller;

import com.websystique.springmvc.domain.Project;
import com.websystique.springmvc.domain.Task;
import com.websystique.springmvc.service.ProjectService;
import com.websystique.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@GetMapping(value = { "/"})
	public String homePage(ModelMap model) throws SQLException {
		List<Project> projects = (List) projectService.getAllProjects();
		model.addAttribute("projects", projects);
		return "home";
	}
	@GetMapping(value = { "/editProject"})
	public String editProject(@RequestParam("id")Long id, ModelMap model) throws SQLException {
		Project project = projectService.getProjectById(id);

		Set<Task> tasks = project.getTasks();
		tasks.add(new Task("taskname1","description1", new Date()));
		tasks.add(new Task("taskname2","description2", new Date()));
		tasks.add(new Task("taskname3","description3", new Date()));
		tasks.add(new Task("taskname4","description4", new Date()));
		tasks.add(new Task("taskname5","description5", new Date()));
		project.setTasks(tasks);
		projectService.updateProject(id,project);
		model.addAttribute("project", project);
		model.addAttribute("tasks", project.getTasks());
		return "editProject";
	}
	@GetMapping(value = { "/addProject"})
	public String addProject(ModelMap model) throws SQLException {
		return "addProject";
	}

	@PostMapping(value = "/addProject.do", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long addProjectForm(@RequestBody Project project) throws SQLException {
		project.setProjectCreator(userService.getUserById(1l));
		projectService.saveProject(project);
		return project.getProjectId();
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