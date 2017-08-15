<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<!DOCTYPE html>
<meta charset="utf-8" xmlns:form="http://www.w3.org/1999/html" xmlns:form="http://www.w3.org/1999/html">
<html>
<head>
    <title>Add Project</title>
</head>
<body>
    <h1>Add Project</h1>
    <hr color="#008000" size="1" noshade>
    <form method="post" action="/projects/save">
       <p>Project Name: <input name="name" value="" type="text" placeholder="Enter name Project"/></p>
        <input:errors  path="name"  />
        <p>
            <input type="submit" value="Submit"/>
        </p>
    </form>

</body>
</html>
