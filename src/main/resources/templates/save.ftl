<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
    <title>Add Project</title>
</head>
<body>
  <h1>Add Project</h1>
  <hr color="#008000" size="1" noshade>
  <form method="post" action="/projects/save">
    <p>Project Name:
    <@spring.bind "project.name"/>
    <@spring.formInput "project.name"/>
    <#if spring.status.error>
        <@spring.showErrors separator="," />
     </#if>
        </p>
    <p>
        <input type="submit" value="Submit"/>
    </p>
  </form>
</body>
</html>
