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
                        <a href="/projects/${projectProjection.uuid}/delete">
                            <i class="glyphicon glyphicon-remove" aria-hidden="true"></i>
                        </a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
            <#import "layout/pagination.ftl" as pagination>
            <@pagination.pagination currentPage projectProjectionPage.getTotalPages()/>

    <h2> Welcom to jQuery</h2>
    <button id="btnn1">jQuery</button>

    <script type="text/javascript">
        $(function() {
            $("#btnn1").click(function () {
                $(this).css('background-color', 'red');
                alert('Word jQuery')
            })
        })
    </script>


    </@layout.defaultLayaout>
</html>
