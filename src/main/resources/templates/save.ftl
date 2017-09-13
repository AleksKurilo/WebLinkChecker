<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

    <title>Add Project</title>
</head>

<body>
  <!-- Navigation panel -->
  <div class="navbar navbar-inverse navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
                    <span class="sr-only">Открыть навигацию</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/projects/">Логотип</a>
            </div>
        </div>
  </div>

  <!-- body -->
  <div class="container">
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
  </div>

</body>
</html>
