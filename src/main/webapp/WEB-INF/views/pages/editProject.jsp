<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ufimtsev
  Date: 01.09.2017
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="content-wrapper">
    <div class="container-fluid">
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="#">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">My Dashboard</li>
        </ol>
        <div class="card w-50">
            <div class="card-body">
                <h4 class="card-title">Edit Project</h4>
                <p class="card-text">You can change project name and his description.</p>
                <form class="edit-project-form-edit">
                    <div class="form-group">
                        <input class="form-control" type="text" placeholder="${project.projectId}" hidden="hidden" name="projectId" value="${project.projectId}">
                        <label class="form-control-label" for="formGroupExampleInput">project creator: </label>
                        <input class="form-control" type="text" placeholder="${project.projectCreator.firstName} ${project.projectCreator.lastName}" readonly>
                        <label class="form-control-label" for="formGroupExampleInput">create date: </label>
                        <input class="form-control" type="text" placeholder="${project.createDate}" readonly>
                        <label class="form-control-label" for="formGroupExampleInput">project name: </label>
                        <input type="text" class="form-control project-name-inpt" id="formGroupExampleInput" placeholder="${project.projectName}" name="projectName">

                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">project description: </label>
                        <textarea class="form-control project-desc-inpt" id="exampleFormControlTextarea1" rows="3"placeholder="${project.projectDescription}" name="projectDescription"></textarea>
                    </div>
                    <button type="button" class="btn btn-outline-primary edit-project-btn-edit">Edit</button>
                    <button type="button" class="btn btn-outline-secondary cancel-project-btn">Cancel</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
