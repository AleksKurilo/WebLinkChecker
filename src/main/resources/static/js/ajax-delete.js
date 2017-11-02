$(document).ready(function () {
    $(document).on("click", ".remove-project", function () {
        var rowToDelete = $(this).closest("tr");
        $.ajax({
            beforeSend: function (request) {
                if (confirm('Are you sure you want to delete this project ?')) {
                }
                else {
                    return false;
                }
            },
            url: $(this).attr("href"),
            type: "DELETE",
            success: function (response) {
                rowToDelete.remove();
                var respContent = "<div class=\"alert alert-success\">" +
                    "<span class='success'><strong>Success!</strong> Project was deleted</span></div>";
                $("#formResponse").html(respContent);
                if ($(".remove-project").length ==0) {
                    setTimeout(function(){
                        document.location.href = "/projects/";
                    }, 1000);
                }
            },
            error: function (e) {
                var respContent  = "<div class=\"alert alert-danger\">" +
                    "<span class='success'><strong>Fail !</strong> Project doesn't found</span></div>";
            }
        });
        return false;
    });
});