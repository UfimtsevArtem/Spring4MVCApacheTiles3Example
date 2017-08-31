$(document).ready(function () {
    $("#add-project-btn").on("click", function () {
        var result = {};

        $.each($('#add-project-form').serializeArray(), function() {
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
                alert("error")
            }
        });
    });
});

