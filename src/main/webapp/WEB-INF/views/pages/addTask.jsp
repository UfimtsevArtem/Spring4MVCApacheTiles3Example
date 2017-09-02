<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.09.2017
  Time: 16:07
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
                <h4 class="card-title">Add Task</h4>
                <p class="card-text">Write task name and his description.</p>
                <form class="add-task-form-add">
                    <div class="form-group">
                        <label class="form-control-label" for="formGroupExampleInput">task name: </label>
                        <input type="text" class="form-control project-name-inpt" id="formGroupExampleInput" placeholder="Name" name="taskName">
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">task description: </label>
                        <textarea class="form-control project-desc-inpt" id="exampleFormControlTextarea1" rows="3"placeholder="Description" name="taskDescription"></textarea>
                    </div>
                    <button type="button" class="btn btn-outline-success add-task-btn" id="">Add</button>
                    <button type="button" class="btn btn-outline-secondary cancel-project-btn">Cancel</button>
                </form>
                <div class="project-id-value" hidden="hidden" data-id="${project.projectId}">
            </div>
        </div>
    </div>
</div>
</body>
</html>

