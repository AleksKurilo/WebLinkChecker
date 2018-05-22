<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.model.Project"-->
<#import "../layout/defaultLayout.ftl" as layout>
<#assign title = "Projects">
<@layout.defaultLayaout title>

    <ul class="breadcrumb">
        <li class="active">Projects</a></li>
    </ul>

    <h1>Projects</h1>
    <p>
        <a href="/projects/insert" class="btn btn-primary">Add</a>
    </p>
    <#if projectProjectionPage.getContent()?has_content>
        <div id="alerts">
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th class="text-center table-alignment">Name</th>
                <th class="text-center table-alignment">Created</th>
                <th class="text-center table-alignment">Modified</th>
                <th class="text-center table-alignment">Actions</th>
            </tr>
            </thead>
            <tbody>
                <#list projectProjectionPage.getContent() as projectProjection>
                <tr>
                    <td class="text-center table-alignment"><a
                            href="/projects/${projectProjection.uuid}/links/"> ${projectProjection.name} </a></td>
                    <td class="text-center table-alignment">${projectProjection.created}</td>
                    <td class="text-center table-alignment">
                        <#if projectProjection.modified??>
                            ${projectProjection.modified}
                        <#else> -
                        </#if>
                    </td>
                    <td class="text-center">
                        <a href="/projects/${projectProjection.uuid}/update">
                            <i class="glyphicon glyphicon-pencil">&nbsp;</i>
                        </a>
                        <a href="/projects/${projectProjection.uuid}/delete" class="remove-project">
                            <i class="glyphicon glyphicon-remove"></i>
                        </a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
        <#import "../layout/pagination.ftl" as pagination>
        <@pagination.paginationProjects projectProjectionPage.getNumber() projectProjectionPage.getTotalPages()/>
        <script src="/js/ajax-delete.js"></script>
    <#else>
        <div class="alert alert-warning">
            <span>You do not have any projects</span>
        </div>
    </#if>
</@layout.defaultLayaout>
