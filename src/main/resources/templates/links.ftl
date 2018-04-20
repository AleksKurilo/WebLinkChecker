<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "layout/defaultLayout.ftl" as layout>
<#assign title = "Projects">
<@layout.defaultLayaout title>
    <h1>Project ${projectProjection.name} links</h1>
    <p>
        <a href="/projects/${projectProjection.uuid}/links/save" class="btn btn-primary">Add link</a>
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
                        <a href="/projects/${projectProjection.uuid}/links/${linkProjection.uuid}/update">
                            <i class="glyphicon glyphicon-pencil">&nbsp;</i>
                        </a>
                        <a href="/projects/${projectProjection.uuid}/links/${linkProjection.uuid}/delete" class="remove-link">
                            <i class="glyphicon glyphicon-remove"></i>
                        </a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    <!-- for delete -->
    <script src="/js/ajax-delete-link.js"></script>
    <#else>
        <div class="alert alert-warning">
            <span>You do not have any links</span>
        </div>
    </#if>
</@layout.defaultLayaout>
