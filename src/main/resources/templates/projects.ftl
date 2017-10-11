<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.project.model.Project"-->
<!DOCTYPE html>
<meta charset="utf-8">
<html>
  <#import "layout/header.ftl" as layout>
  <@layout.header "Projects"/>
 <body>
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
                          <!--Edit icon -->
                          <i class="glyphicon glyphicon-pencil" aria-hidden="true">&nbsp</i>
                      </a>
                      <a href="/projects/${projectProjection.uuid}/delete">
                          <!--Delete icon -->
                          <i class="glyphicon glyphicon-remove" aria-hidden="true"></i>
                      </a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
        <#import "layout/pagination.ftl" as layout>
        <@layout.pagination currentPage totalPages/>
      </div>
  </body>
</html>
