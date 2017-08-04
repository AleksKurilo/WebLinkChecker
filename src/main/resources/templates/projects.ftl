<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.akproject.WebLinkChecker.model.Project"-->
<!DOCTYPE html>
<meta charset="utf-8">
<html>
<head>
 <title>Project Page</title>
</head>
<body>
<h1>Project table</h1>
<hr color="#008000" size="1" noshade>
<table border="1" cellpadding="5" cellspacing="0" width="200" height="75">
  <thead>
   <tr>
     <th>Id</th>
     <th>Name</th>
     <th>Edit</th>
   </tr>
 </thead>
 <tbody>
   <#list projects as project>
   <tr>
     <td>${project.id}</td>
     <td>${project.name}</td>
     <td>
        <form>
           <a href="/projects/{id}/delete" method="post" name="id">Delete</a>
         </form>

     </td>
   </tr>
   </#list>
   </tbody>
</table>
<p>
<form method="get" action="/projects/save">
  <button type="submit">Add project</button>
</form>
</p>
</body>
</html>
