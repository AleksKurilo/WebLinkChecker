<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "/spring.ftl" as spring/>
<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayaout "Edit Project">
    <h1>Edit Project</h1>
    <form method="post" action="update">
        <p>New Project Name:
        <@spring.bind "project.name"/>
            <input type="text" name="name" value="${project.name!}">
        <#if spring.status.error>
            <span><@spring.showErrors separator="," /></span>
        </#if>
        <p>
            <input type="submit" value="Submit" class="btn btn-primary"/>
        </p>
    </form>
</@layout.defaultLayaout>