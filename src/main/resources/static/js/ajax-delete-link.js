$(document).ready(function () {
    $(document).on("click", ".remove-link", function () {
        var $this = $(this);
        $.ajax({
            beforeSend: function (request) {
                return confirm('Are you sure you want to delete this link ?');
            },
            url: $(this).attr("href"),
            type: "DELETE",
            success: function (response) {
                $($this).closest("tr").remove();
                var responseContent = "<div class=\"alert alert-success\">" +
                    "<span><strong>Success!</strong> Link was deleted</span></div>";
                $("#alerts").html(responseContent);
             },
            error: function (e) {
                var responseContent  = "<div class=\"alert alert-danger\">" +
                    "<span><strong>Fail!</strong> Can not delete this link</span></div>";
                $("#alerts").html(responseContent);
            }
        });
        return false;
    });
});