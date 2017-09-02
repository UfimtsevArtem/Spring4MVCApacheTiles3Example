<%--
  Created by IntelliJ IDEA.
  User: ufimtsev
  Date: 31.08.2017
  Time: 12:51
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
                <h4 class="card-title">Add Project</h4>
                <p class="card-text">Write project name and his description.</p>
                <form class="add-project-form-add">
                    <div class="form-group">
                        <label class="form-control-label" for="formGroupExampleInput">project name: </label>
                        <input type="text" class="form-control project-name-inpt" id="formGroupExampleInput" placeholder="Name" name="projectName">
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">project description: </label>
                        <textarea class="form-control project-desc-inpt" id="exampleFormControlTextarea1" rows="3"placeholder="Description" name="projectDescription"></textarea>
                    </div>
                    <button type="button" class="btn btn-outline-success add-project-btn" id="">Add</button>
                    <button type="button" class="btn btn-outline-secondary cancel-project-btn">Cancel</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
