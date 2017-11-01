<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayaout "Projects">
    <h1>Projects</h1>
    <div id="formResponse"></div>
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
                        <i class="glyphicon glyphicon-pencil" aria-hidden="true">&nbsp;</i>
                    </a>
                    <a href="/projects/${projectProjection.uuid}/delete" class="remove-project" data-toggle="confirmation">
                        <i class="glyphicon glyphicon-remove" aria-hidden="true"></i>
                    </a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
    <#import "layout/pagination.ftl" as pagination>
    <@pagination.pagination currentPage projectProjectionPage.getTotalPages()/>
     <script src="/js/ajax-delete.js"> </script>
     <script>
        $(document).ready(function () {
            if ($(".remove-project").length ==0) {
                var respContent = "";
                respContent += "<div class=\"alert alert-warning\">" +
                        "<span class='success'><strong>WARNING!</strong> You do not have any Projects</span></div>";
                $("#formResponse").html(respContent);
            }
        });
     </script>
</@layout.defaultLayaout>
