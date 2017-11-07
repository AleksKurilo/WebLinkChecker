<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "/spring.ftl" as spring/>
<#import "layout/defaultLayout.ftl" as layout>
<#assign title = "Add Project">
<@layout.defaultLayaout title>
    <h1>Add Project</h1>
    <form method="post" action="/projects/save">
        <p><label for="name-project">Project Name:</label>
        <@spring.bind "project.name"/>
            <input type="text" name="name" value="${project.name!}" id="name-project">
        <#if spring.status.error>
            <span><@spring.showErrors separator="," /></span>
        </#if>
        </p>
        <p>
            <input type="submit" value="Submit" class="btn btn-primary"/>
        </p>
    </form>
</@layout.defaultLayaout>
