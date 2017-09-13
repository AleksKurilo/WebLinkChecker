<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<!DOCTYPE html>
<meta charset="utf-8">
<html>

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

    <title>Project Page</title>
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
        <h1>Projects</h1>
        <table class="table table-striped">
            <thead >
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
                  <a href="/projects/${projectProjection.uuid}/delete">Delete &nbsp;</a>
                  <a href="/projects/${projectProjection.uuid}/update">Edit</a>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>

        <p>
          <a href="/projects/save" class="btn btn-primary">Add Project</a>
        </p>
    </div>
  </body>
</html>
