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

    $(".delete-project-btn").on("click", function () {
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

    $(".edit-project-btn-index").on("click", function () {
        window.location.href = "/editProject?id="+this.value;
    });

    $(".edit-project-btn-edit").on("click", function () {
        var result = {};
        $.each($('.edit-project-form-edit').serializeArray(), function() {
            result[this.name] = this.value;
        });
        alert(JSON.stringify(result));
        $.ajax({
            url: "/editProject.do",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(result), //Stringified Json Object
            cache: false,    //This will force requested pages not to be cached by the browser
            processData: false, //To avoid making query String instead of JSON
            success: function (resposeJsonObject) {
                window.location.href = "/";
            },
            error: function () {
                alert("error edit")
            }
        });
    });
});

