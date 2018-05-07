<#--@ftlvariable name="projects" type="java.util.List"-->
<#-- @ftlvariable name="projects" type="com.web.link.checker.model.Project"-->
<#import "../layout/defaultLayout.ftl" as layout>
<#assign title = "Projects">
<@layout.defaultLayaout title>
    <style>
        table {
            table-layout: fixed;
        }

        table th, table td {
            overflow: auto;
            text-align: center;
        }
    </style>

    <ul class="breadcrumb">
        <li><a href="/projects/">Projects ${projectProjection.name}</a></li>
        <li class="active">Links</li>
    </ul>

    <h1>Links</h1>
    <p>
        <a href="/projects/${projectProjection.uuid}/links/insert" class="btn btn-primary">Add link</a>
    </p>
    <#if linkPage.getContent()?has_content>
        <div id="alerts">
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th style="width: 30%">Anchor</th>
                <th style="width: 30%">Dofollow</th>
                <th style="width: 30%">Location</th>
                <th style="width: 30%">Href</th>
                <th style="width: 30%">Actions</th>
            </tr>
            </thead>
            <tbody>
                <#list linkPage.getContent() as linkProjection>
                <tr>
                    <td>${linkProjection.anchor}</td>
                    <td>${linkProjection.dofollow?then("true", "false")}</td>
                    <td>${linkProjection.location}</td>
                    <td>${linkProjection.href}</td>
                    <td>
                        <a href="/projects/${projectProjection.uuid}/links/${linkProjection.uuid}/update">
                            <i class="glyphicon glyphicon-pencil">&nbsp;</i>
                        </a>
                        <a href="/projects/${projectProjection.uuid}/links/${linkProjection.uuid}/delete"
                           class="remove-link">
                            <i class="glyphicon glyphicon-remove"></i>
                        </a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
        <#import "../layout/pagination.ftl" as pagination>
        <@pagination.paginationLinks projectProjection.uuid linkPage.getNumber() linkPage.getTotalPages()/>
    <!-- for delete -->
    <script src="/js/ajax-delete-link.js"></script>
    <#else>
        <div class="alert alert-warning">
            <span>You do not have any links</span>
        </div>
    </#if>
</@layout.defaultLayaout>
