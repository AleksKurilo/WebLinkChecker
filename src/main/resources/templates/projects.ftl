<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<!DOCTYPE html>
<meta charset="utf-8">
<html>

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

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
                <#list projectProjectionPage as projectProjection>
                <tr>
                   <td>${projectProjection.name}</td>
                    <td>
                      <a href="/projects/${projectProjection.uuid}/update">
                          <i class="glyphicon glyphicon-pencil" aria-hidden="true">&nbsp</i>
                          <!--Edit icon -->
                      </a>
                      <a href="/projects/${projectProjection.uuid}/delete">
                          <i class="glyphicon glyphicon-remove" aria-hidden="true"></i>
                          <!--Delete icon -->
                      </a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>

        <!-- Pagination -->
         <#macro pagination currentPage totalPages >
             <nav aria-label="Page navigation">
                 <div class="text-center">
                 <ul class="pagination">
                     <#if (totalPages > 1)>

                        <#-- Previous page -->
                            <#if (currentPage > 1)>
                                <li><a href="/projects/page/?currentPage=${currentPage - 1}">Prev</a></li>
                            </#if>

                        <#-- Page number -->
                            <#list 1 .. totalPages as pageNumber>
                                <#if (pageNumber == currentPage)>
                                    <li class="active"><a href="#">${pageNumber}</a></li>
                                <#else>
                                    <li><a href="/projects/page/?currentPage=${pageNumber}">${pageNumber}</a></li>
                                </#if>
                            </#list>

                        <#-- Next page -->
                            <#if (currentPage < totalPages)>
                                <li><a href="/projects/page/?currentPage=${currentPage + 1}">Next</a></li>
                            </#if>
                      </#if>
                   </ul>
                 </div>
              </nav>
        </#macro>

        <@pagination currentPage totalPages/>

    </div>
  </body>
</html>
