package com.websystique.springmvc.controller;

import com.websystique.springmvc.domain.Project;
import com.websystique.springmvc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;


@Controller
@RequestMapping("/")
public class AppController {
    @Autowired
    ProjectService projectService;

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = { "/products"}, method = RequestMethod.GET)
	public String productsPage(ModelMap model) {
		return "products";
	}

	@RequestMapping(value = { "/contactus"}, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		return "contactus";
	}
	@RequestMapping(value = { "/login"}, method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "pages/login";
	}
	@RequestMapping(value = { "/register"}, method = RequestMethod.GET)
	public String register(ModelMap model) {
		return "pages/register";
	}
	@RequestMapping(value = { "/forgot-password"}, method = RequestMethod.GET)
	public String forgotPassword(ModelMap model) {
		return "pages/forgot-password";
	}
	@RequestMapping(value = { "/blank"}, method = RequestMethod.GET)
	public String blank(ModelMap model) {
		return "pages/blank";
	}

    @RequestMapping(value = { "/getListProject.do"}, method = RequestMethod.GET)
    public List<Project> getListProject(ModelMap model) throws SQLException{
	    return (List)projectService.getAllProjects();
    }
}