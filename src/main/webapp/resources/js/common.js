$(document).ready(function () {

    $(".add-project-btn").on("click", function () {
        var result = {};
        $.each($('.add-project-form-add').serializeArray(), function() {
            result[this.name] = this.value;

        });
        $.ajax({
            url: "/addProject.do",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(result), //Stringified Json Object
            cache: false,    //This will force requested pages not to be cached by the browser
            processData: false, //To avoid making query String instead of JSON
            success: function (resposeJsonObject) {
                window.location.href = "/";
            },
            error: function () {
                alert("error add")
            }
        });
    });
    $(".add-task-btn").on("click", function () {
        var result = {};
        $.each($('.add-task-form-add').serializeArray(), function() {
            result[this.name] = this.value;
        });
        var projectId = $('.project-id-value').attr("data-id");
        $.ajax({
            url: "/addTask.do?projectId="+projectId,
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(result), //Stringified Json Object
            cache: false,    //This will force requested pages not to be cached by the browser
            processData: false, //To avoid making query String instead of JSON
            success: function (resposeJsonObject) {
                window.location.href = "/showProject?id="+projectId;
            },
            error: function () {
                alert("error add")
            }
        });
    });
    $(".add-task-btn-showP").on("click", function () {
        window.location.href = "/addTask?projectId="+this.value;
    });

    $(".delete-project-btn-index").on("click", function () {
        let that=$(this);
        var result = {};
        result[this.name] = this.value;
        var id = this.value;
        $.ajax({
            url: "/deleteProject.do",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(result), //Stringified Json Object
            success: function (resposeJsonObject) {
                $("#"+id).remove();
            },
            error: function () {

            }
        });
    });
    $(".delete-project-btn-showP").on("click", function () {
        let that=$(this);
        var result = {};
        result[this.name] = this.value;
        var id = this.value;
        $.ajax({
            url: "/deleteProject.do",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(result), //Stringified Json Object
            success: function (resposeJsonObject) {
                window.location.href = "/";
            },
            error: function () {

            }
        });
    });

    $(".delete-task-btn-showP").on("click", function () {
        let that=$(this);
        var result = {};
        result[this.name] = this.value;
        var id = this.value;
        var projectId = $('.project-id-value').attr("data-id");
        $.ajax({
            url: "/deleteTask.do?projectId="+projectId,
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(result), //Stringified Json Object
            success: function (resposeJsonObject) {
                $("#"+id).remove();
            },
            error: function () {

            }
        });
    });

    $(".edit-project-btn-index").on("click", function () {
        window.location.href = "/editProject?id="+this.value;
    });
    $(".edit-project-btn-showP").on("click", function () {
        window.location.href = "/editProject?id="+this.value;
    });



    $(".edit-task-btn-showP").on("click", function () {
        window.location.href = "/editTask?id="+this.value;
    });

    $(".edit-task-btn-edit").on("click", function () {
        var result = {};
        $.each($('.edit-task-form-edit').serializeArray(), function() {
            result[this.name] = this.value;
        });
        var taskId = $('.task-id-value').attr("data-id");
        $.ajax({
            url: "/editTask.do",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(result), //Stringified Json Object
            cache: false,    //This will force requested pages not to be cached by the browser
            processData: false, //To avoid making query String instead of JSON
            success: function (resposeJsonObject) {
                window.location.href = "/showTask?id="+taskId;
            },
            error: function () {
                alert("error edit")
            }
        });
    });

    $(".cancel-project-btn").on("click", function () {
        history.go(-1);
    });
});

