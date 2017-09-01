<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<!DOCTYPE html>
<meta charset="utf-8">
<html>

<head>
    <title>Project Page</title>
</head>

<body>

    <h1>Projects</h1>
    <table border="1" cellpadding="5" cellspacing="0" width="200" height="75">
        <thead>
        <tr>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <#list projectProjections as projectProjection>
        <tr>
            <td>${projectProjection.name}</td>
            <td>
              <a href="/projects/${projectProjection.uuid}/delete">Delete</a>
              <a href="/projects/${projectProjection.uuid}/update">Edit</a>
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
