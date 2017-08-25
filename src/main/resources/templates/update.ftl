<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<meta charset="utf-8">
<html>
<head>
    <title>Edit Project</title>
</head>
<body>
    <h1>Edit Project</h1>
    <form method="post" action="update">
        <p>Project Name:
        <@spring.bind "project.name"/>
            <input type="text" name="name" value="${project.name!}">
        <#if spring.status.error>
            <span><@spring.showErrors separator="," /></span>
        </#if>
        <p>
            <input type="submit" value="Submit"/>
        </p>
    </form>

</body>
</html>