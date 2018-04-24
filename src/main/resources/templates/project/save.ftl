<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "/spring.ftl" as spring/>
<#import "../layout/defaultLayout.ftl" as layout>
<#assign title = "Add Project">
<@layout.defaultLayaout title>

    <ol class="breadcrumb">
        <li><a href="/projects/">Projects</a></li>
        <li class="active">Add project</li>
    </ol>

    <h1>Add Project</h1>
    <form method="post" action="/projects/save">
        <p><label for="project-name">Project Name:</label>
        <@spring.bind "project.name"/>
            <input type="text" name="name" value="${project.name!}" id="project-name">
        <#if spring.status.error>
            <span><@spring.showErrors separator="," /></span>
        </#if>
        </p>
        <p>
            <input type="submit" value="Submit" class="btn btn-primary"/>
        </p>
    </form>
</@layout.defaultLayaout>
