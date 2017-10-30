$(document).ready(function() {
    alert('test');
    $(document).on("click", ".remove-project", function () {
        var rowToDelete = $(event.target).closest("tr");
        $.ajax({
            url: $(this).attr("href"),
            type: "DELETE",
            dataType: "text",
            success: function (response) {
                rowToDelete.remove();
                var respContent = "";
                respContent += "<div class=\"alert alert-success\">" +
                    "<span class='success'><strong>Success!</strong> Project was delete</span></div>";
                $("#formResponse").html(respContent);
            },
            error: function (e) {
                alert("Project doesn't found" + e);
            }
        });
        return false;
    });
});