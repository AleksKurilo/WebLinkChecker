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
                var respContent = "<div class=\"alert alert-success\">" +
                    "<span class='label-remove-project'><strong>Success!</strong> Project was deleted</span></div>";
                $("#alerts").html(respContent);
                if ($(".remove-project").length == 0) {
                    setTimeout(function () {
                        document.location.href = "/projects/";
                    }, 1000);
                }
            },
            error: function (e) {
                var respContent  = "<div class=\"alert alert-danger\">" +
                    "<span class='label-remove-project'><strong>Fail!</strong> Can not delete this project</span></div>";
                $("#alerts").html(respContent);
            }
        });
        return false;
    });
});