$(document).ready(function () {
    $(document).on("click", ".remove-project", function () {
        var $this = $(this);
        $.ajax({
            beforeSend: function (request) {
                return confirm('Are you sure you want to delete this project ?');
            },
            url: $(this).attr("href"),
            type: "DELETE",
            success: function (response) {
                $($this).closest("tr").remove();
                var responseContent = "<div class=\"alert alert-success\">" +
                    "<span><strong>Success!</strong> Project was deleted</span></div>";
                $("#alerts").html(responseContent);
                if ($(".remove-project").length == 0) {
                    setTimeout(function () {
                        document.location.href = "/projects/";
                    }, 1000);
                }
            },
            error: function (e) {
                var responseContent  = "<div class=\"alert alert-danger\">" +
                    "<span><strong>Fail!</strong> Can not delete this project</span></div>";
                $("#alerts").html(responseContent);
            }
        });
        return false;
    });
});