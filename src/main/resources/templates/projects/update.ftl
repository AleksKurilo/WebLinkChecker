<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.model.Project"-->
<#import "/spring.ftl" as spring/>
<#import "../layout/defaultLayout.ftl" as layout>
<#assign title = "Edit Project">
<@layout.defaultLayaout title>

    <ul class="breadcrumb">
        <li><a href="/projects/">Projects</a></li>
        <li class="active">${project.name}</li>
    </ul>

    <h1>Edit</h1>
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