<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "layout/defaultLayout.ftl" as layout>
<#assign title = "Projects">
<@layout.defaultLayaout title>
    <h1> ${projectProjection.name} links</h1>
    <p>
        <a href="/links/project/${projectProjection.uuid}/save" class="btn btn-primary">Add link</a>
    </p>
    <#if projectProjection.getLinks()?has_content>
        <div id="alerts">
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Anchor</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
                <#list projectProjection.getLinks() as linkProjection>
                <tr>
                    <td>${linkProjection.anchor}</td>
                    <td>
                        <a href="/links/project/${projectProjection.uuid}/link/${linkProjection.id}">
                            <i class="glyphicon glyphicon-pencil">&nbsp;</i>
                        </a>
                        <a href="/links/link/${linkProjection.id}/delete" class="remove-link">
                            <i class="glyphicon glyphicon-remove"></i>
                        </a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    <!-- for delete -->
    <script src="/js/ajax-delete-link.js"></script>
    </#if>
</@layout.defaultLayaout>
