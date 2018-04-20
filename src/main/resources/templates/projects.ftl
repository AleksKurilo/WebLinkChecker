<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "layout/defaultLayout.ftl" as layout>
<#assign title = "Projects">
<@layout.defaultLayaout title>
    <h1>Projects</h1>
    <p>
        <a href="/projects/save" class="btn btn-primary">Add</a>
    </p>
    <#if projectProjectionPage.getContent()?has_content>
        <div id="alerts">
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th class="text-center">Actions</th>
            </tr>
            </thead>
            <tbody>
                <#list projectProjectionPage.getContent() as projectProjection>
                <tr>
                    <td><a href="/projects/${projectProjection.uuid}/links/"> ${projectProjection.name} </a></td>
                    <td class="text-center">
                        <a href="/projects/${projectProjection.uuid}/update">
                            <i class="glyphicon glyphicon-pencil">&nbsp;</i>
                        </a>
                        <a href="/projects/${projectProjection.uuid}/delete" class="remove-project">
                            <i class="glyphicon glyphicon-remove"></i>
                        </a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
        <#import "layout/pagination.ftl" as pagination>
        <@pagination.pagination projectProjectionPage.getNumber() projectProjectionPage.getTotalPages()/>
        <script src="/js/ajax-delete.js"></script>
    <#else>
        <div class="alert alert-warning">
           <span>You do not have any projects</span>
        </div>
    </#if>
</@layout.defaultLayaout>
