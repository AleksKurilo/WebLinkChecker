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
             <input name="${spring.status.expression}" value="${spring.status.value?html}" type="text" placeholder="Enter name Project"/>
             <br>
                <#if spring.status??>
                    <#list spring.status.errorMessages as error>
                        <b>${error}</b>
                        <br>
                    </#list>
                </#if>
             <br>
         </p>
         <p>
            <input type="submit" value="Submit"/>
        </p>
    </form>


</body>
</html>
