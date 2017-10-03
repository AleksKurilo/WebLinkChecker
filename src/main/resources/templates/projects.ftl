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
        <#function max x y>
            <#if (x<y)><#return y><#else><#return x></#if>
        </#function>

        <#function min x y>
            <#if (x<y)><#return x><#else><#return y></#if>
        </#function>

        <#macro pages totalPages p>
            <#assign size = totalPages?size>
            <#if (p <= 5)> <#-- p among first 5 pages -->
                <#assign interval = 1..(min(p + 2, size))>
            <#elseif ((size-p)<5)> <#-- p among last 5 pages -->
                <#assign interval = (max(1, (p - 2)))..size >
            <#else>
                <#assign interval = (p - 2)..(p + 2)>
            </#if>
            <#if !(interval?seq_contains(1))>
                <a href="?page=1">1</a> ... <#rt>
            </#if>
            <#list interval as page>
                <#if page=p>
                <${page}> <#t>
                <#else>
                    <a href="?page=${page?c}">${page}</a> <#t>
                </#if>
            </#list>
            <#if !(interval?seq_contains(size))>
                ... <a href="?page=${size?c}">${size}</a><#lt>
            </#if>
        </#macro>

        <h2><@pages 1..100 20 /></h2>

        <nav>
            <ul class="pagination justify-content-center">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="/projects/0">1</a></li>
                <li class="page-item"><a class="page-link" href="/projects/1">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                </li>
            </ul>
        </nav>

    </div>
  </body>
</html>
