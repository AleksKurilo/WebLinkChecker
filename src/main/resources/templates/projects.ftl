<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.akproject.WebLinkChecker.model.Project"-->
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <table>
            <thead>
                 <tr>
                     <th>Id</th>
                     <th>Name</th>
                 </tr>
            </thead>

        <#list projects as project>
             <tr>
                <td>${project.id}</td>
                <td>${project.name}</td>
             </tr>
        </#list>
        </table>
    </body>
</html>
