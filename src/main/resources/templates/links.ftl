<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "layout/defaultLayout.ftl" as layout>
<#assign title = "Projects">
<@layout.defaultLayaout title>
    <h1>Projects</h1>
    <p>
        <a href="/projects/save" class="btn btn-primary">Add</a>
    </p>
    <#if linkProjections?has_content>
        <div id="alerts">
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
                <#list linkProjections as linkProjection>
                <tr>
                    <td>${linkProjection.anchor}</td>
                    <td>
                        <a href="/projects/${linkProjection.id}/update">
                            <i class="glyphicon glyphicon-pencil">&nbsp;</i>
                        </a>
                        <a href="/projects/${linkProjection.id}/delete" class="remove-project">
                            <i class="glyphicon glyphicon-remove"></i>
                        </a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>

    </#if>
</@layout.defaultLayaout>
