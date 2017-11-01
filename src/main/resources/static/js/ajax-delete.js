$(document).ready(function () {
    $(document).on("click", ".remove-project", function () {
        var rowToDelete = $(event.target).closest("tr");
        $.ajax({
            beforeSend: function (request) {
                if (confirm('Are you sure you want to delete this?')) {
                }
                else {
                    return false;
                }
            },
            url: $(this).attr("href"),
            type: "DELETE",
            dataType: "text",
            success: function (response) {
                rowToDelete.remove();
                var respContent = "";
                respContent += "<div class=\"alert alert-success\">" +
                    "<span class='success'><strong>Success!</strong> Project was deleted</span></div>";
                $("#formResponse").html(respContent);
                if ($(document).is(".remove-project")) {
                } else {
                    setTimeout(function(){
                        document.location.href = "/projects/";
                    }, 1000);
                }
            },
            error: function (e) {
                alert("Project doesn't found" + e);
            }
        });
        return false;
    });
});