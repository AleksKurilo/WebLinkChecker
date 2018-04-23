<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "/spring.ftl" as spring/>
<#import "layout/defaultLayout.ftl" as layout>
<#assign title = "Edit Project">
<@layout.defaultLayaout title>

    <ol class="breadcrumb">
        <li><a href="/projects/">Projects</a></li>
        <li class="active">Update project</li>
    </ol>

    <h1>Edit Project</h1>
    <h2>${projectProjection.name} </h2>
    <form method="post" action="update">
        <p><label for="project-name">Name:</label>
        <@spring.bind "project.name"/>
            <input type="text" name="name" value="${project.name!}" id="project-name">
        <#if spring.status.error>
            <span><@spring.showErrors separator="," /></span>
        </#if>
        <p>
            <input type="submit" value="Submit" class="btn btn-primary"/>
        </p>
    </form>
</@layout.defaultLayaout>