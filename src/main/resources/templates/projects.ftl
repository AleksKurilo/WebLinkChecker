<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.akproject.WebLinkChecker.model.Project"-->
<!DOCTYPE html>
<meta charset="utf-8">
<html>

<head>
    <title>Project Page</title>
</head>

<body>

<h1>Project table</h1>
<table border="1" cellpadding="5" cellspacing="0" width="200" height="75">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Delete project</th>
    </tr>
    </thead>
    <tbody>
    <#list projects as project>
    <tr>
        <td>${project.id}</td>
        <td>${project.name}</td>
        <td>
            <a href="/projects/${project.id}/delete">Delete</a>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
<p>
   <a href="/projects/save">Add Project</a>
</p>

</body>
</html>