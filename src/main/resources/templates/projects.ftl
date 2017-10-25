<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayaout "Projects">
    <h1>Projects</h1>
    <div id="formResponse"></div>
    <p>
        <a href="/projects/save" class="btn btn-primary">Add</a>
    </p>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
            <#list projectProjectionPage.getContent() as projectProjection>
            <tr>
                <td>${projectProjection.name}</td>
                <td>
                    <a href="/projects/${projectProjection.uuid}/update">
                        <i class="glyphicon glyphicon-pencil" aria-hidden="true">&nbsp;</i>
                    </a>
                    <a href="/projects/${projectProjection.uuid}/delete" class="remove-project">
                        <i class="glyphicon glyphicon-remove" aria-hidden="true"></i>
                    </a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
    <#import "layout/pagination.ftl" as pagination>
    <@pagination.pagination currentPage projectProjectionPage.getTotalPages()/>
    <script>
        $(function () {
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
                                                "<span class='success'><strong>Success!</strong> Project was delete</span>" +
                                             "</div>";
                            $("#formResponse").html(respContent);
                    },
                    error: function (e) {
                        alert("Project doesn't found" + e);
                    }
                });
                return false;
            });
        });
    </script>
</@layout.defaultLayaout>
