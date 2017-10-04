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
               <a class="navbar-brand" href="/projects/">Логотип</a>
             </div>
          </div>
     </div>

    <!-- body -->
    <div class="container">
        <h1>Projects</h1>
        <p>
            <a href="/projects/save" class="btn btn-primary">Add</a>
        </p>
        <table class="table table-striped">
            <thead >
            <tr>
                <th>Name</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <#list projectPage as project>
            <tr>
               <td>${project.name}</td>
                <td>
                  <a href="/projects/${project.uuid}/update">
                      <i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>
                      <!--Edit-->
                  </a>
                  <a href="/projects/${project.uuid}/delete">
                      <i class="glyphicon glyphicon-remove" aria-hidden="true"></i>
                      <!--Delete &nbsp;-->
                  </a>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>

        <!-- Pagination -->
         <#macro pagination currentPage totalPages >
            <#if (totalPages > 1)>
                <div id="pagination">
                <#-- Previous page -->
                    <#if (currentPage > 1)>
                        <a href="/projects/${currentPage-1}">Prev</a>
                    </#if>

                <#-- Page number -->
                    <#list 1 .. totalPages as pageNumber>
                        <#if (pageNumber == currentPage)>
                            <div id="currentPage">${pageNumber}</div>
                        <#else>
                            <div><a href="/projects/${pageNumber}">${pageNumber}</a></div>
                        </#if>
                    </#list>

                <#-- Next page -->
                    <#if (currentPage < totalPages)>
                        <a href="#">Next</a>
                    </#if>
                </div>
            </#if>
        </#macro>

        <h3><@pagination ${currentPage?round} 10/></h3>


    </div>
  </body>
</html>
