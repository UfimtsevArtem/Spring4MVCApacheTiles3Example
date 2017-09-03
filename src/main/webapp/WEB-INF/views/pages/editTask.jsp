<%--
  Created by IntelliJ IDEA.
  User: вадим
  Date: 03.09.2017
  Time: 1:59
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
                <h4 class="card-title">Edit task</h4>
                <p class="card-text">You can change task name and his description.</p>
                <form class="edit-task-form-edit">
                    <div class="form-group">
                        <input class="form-control" type="text" placeholder="${task.taskId}" hidden="hidden" name="taskId" value="${task.taskId}">
                        <label class="form-control-label" for="formGroupExampleInput">task creator: </label>
                        <input class="form-control" type="text" placeholder="${task.taskCreator.firstName} ${task.taskCreator.lastName}" readonly>
                        <label class="form-control-label" for="formGroupExampleInput">create date: </label>
                        <input class="form-control" type="text" placeholder="${task.createDate}" readonly>
                        <label class="form-control-label" for="formGroupExampleInput">task name: </label>
                        <input type="text" class="form-control task-name-inpt" id="formGroupExampleInput" placeholder="${task.taskName}" name="taskName">

                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">task description: </label>
                        <textarea class="form-control task-desc-inpt" id="exampleFormControlTextarea1" rows="3"placeholder="${task.taskDescription}" name="taskDescription"></textarea>
                    </div>
                    <button type="button" class="btn btn-outline-primary edit-task-btn-edit">Edit</button>
                    <button type="button" class="btn btn-outline-secondary cancel-task-btn">Cancel</button>
                </form>
                <div class="task-id-value" hidden="hidden" data-id="${task.taskId}">
            </div>
        </div>
    </div>
</div>
</body>
</html>
