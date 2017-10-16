<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
    <#import "layout/defaultLayaout.ftl" as layout>
    <@layout.defaultLayaout "Add Project">
        <h1>Add Project </h1>
        <form method="post" action="/projects/save">
            <p>Project Name:
            <@spring.bind "project.name"/>
                <input type="text" name="name" value="${project.name!}">
            <#if spring.status.error>
                <span><@spring.showErrors separator="," /></span>
            </#if>
            </p>
            <p>
                <input type="submit" value="Submit" class="btn btn-primary"/>
            </p>
        </form>
    </@layout.defaultLayaout>
</html>
