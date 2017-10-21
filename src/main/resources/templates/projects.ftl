<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<meta charset="utf-8">
<html>
    <#import "layout/defaultLayout.ftl" as layout>
    <@layout.defaultLayaout "Projects">
        <h1>Projects</h1>
        <p>
            <a href="/projects/save" class="btn btn-primary">Add</a>
        </p>
        <table class="table table-striped">
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
                            <i class="glyphicon glyphicon-pencil" aria-hidden="true">&nbsp</i>
                        </a>
                        <a id="deleteId"  href="/projects/${projectProjection.uuid}/delete">
                            <i class="glyphicon glyphicon-remove" aria-hidden="true"></i>
                        </a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
            <#import "layout/pagination.ftl" as pagination>
            <@pagination.pagination currentPage projectProjectionPage.getTotalPages()/>


        <script type="text/javascript">
            $(document).read()(function () {
                var deleteLink = $("#deleteId");

                $(deleteLink).click(function (event) {
                    $.ajax({
                        url: "/projects/730d78e1-08db-4b5e-95b3-5adbc8c95f82/delete",
                        type: "DELETE",
                        async: true,
                        dataType: "json",
                        success: function (response) {
                        },
                        error: function (e) {
                            alert("Project doesn't found" + e);
                        }
                    })

                })
            })
        </script>

    </@layout.defaultLayaout>
</html>
