<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.akproject.WebLinkChecker.model.Project"-->
<!DOCTYPE html>
<html>
    <head>
        <title>Project Page</title>
    </head>

    <body>
        <h1>Project table</h1>
        <hr color="#008000" size="1" noshade>
        <table border="1" cellpadding="5"cellspacing="0"width="200" height="75">
            <thead>
                 <tr>
                    <th>Id</th>
                    <th>Name</th>
                 </tr>
            </thead>
            <tbody>
             <#list projects as project>
            <tr>
                <td>${project.id}</td>
                <td>${project.name}</td>
            </tr>
            </#list>
            </tbody>
        </table>
        <p>
            <form method="get" action="http://localhost:8080/weblinkcheker/projects/save">
                <button type="submit" >Add project</button>
            </form>
        </p>
    </body>
</html>
