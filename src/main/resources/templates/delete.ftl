<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.akproject.WebLinkChecker.model.Project"-->
<!DOCTYPE html>
<html>
<head>
    <title>Delete Project</title>
</head>

<body>
<h1>Delete Project</h1>
<hr color="#008000" size="1" noshade>

<form method="post" action="/projects/delete">
    <p>Project ID: <input name="id" value="" type="text" placeholder="Enter name Project"/></p>
    <p>
        <input type="submit" value="Submit" />
        <input type="reset" value="Reset" />
    </p>
</form>


</body>
</html>