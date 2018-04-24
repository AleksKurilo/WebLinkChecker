<#--@ftlvariable name="links" type="java.util.List"-->
<#-- @ftlvariable name="links" type="com.web.link.checker.link.model.Link"-->
<#import "/spring.ftl" as spring/>
<#import "../layout/defaultLayout.ftl" as layout>
<#assign title = "Update link">
<@layout.defaultLayaout title>

    <ul class="breadcrumb">
        <li><a href="/projects/">Projects</a></li>
        <li><a href="/projects/${projectProjection.uuid}/links/">Links</a></li>
        <li class="active">Update</li>
    </ul>

    <h1>Project ${projectProjection.name}</h1>
    <h2>Update Link</h2>

    <form method="post" action="/projects/${projectProjection.uuid}/links/${linkProjection.uuid}/update">

        <table>
            <tbody>
            <tr>
                <td>Anchor:</td>
                <td>
                    <p><label for="link-anchor"></label>
                        <@spring.bind "link.anchor"/>
                        <input type="text" name="anchor" value="${link.anchor!}" id="link-anchor">
                        <#if spring.status.error>
                        <span><@spring.showErrors separator="," /></span>
                        </#if>
                    </p>
                </td>
            <tr>

            <tr>
                <td>Href:</td>
                <td>
                    <p><label for="link-href"></label>
                         <@spring.bind "link.href"/>
                        <input type="text" name="href" value="${link.href!}" id="link-href">
                         <#if spring.status.error>
                         <span><@spring.showErrors separator="," /></span>
                         </#if>
                    </p>
                </td>
            <tr>

            <tr>
                <td>Location:</td>
                <td>
                    <p><label for="link-location"></label>
                         <@spring.bind "link.location"/>
                        <input type="text" name="location" value="${link.location!}" id="link-location">
                        <#if spring.status.error>
                        <span><@spring.showErrors separator="," /></span>
                        </#if>
                    </p>
                </td>
            <tr>

            <tr>
                <td>Dofollow:</td>
                <td>
                    <p><label for="link-dofollow"></label>
                         <@spring.bind "link.dofollow"/>
                        <input type="checkbox" checked="checked" name="dofollow" value="true" id="link-dofollow">
                        <input type="hidden" checked="checked" name="dofollow" value="false" name="_link-dofollow"/>
                        <#if spring.status.error>
                        <span><@spring.showErrors separator="," /></span>
                        </#if>
                    </p>
                </td>
            <tr>

            </tbody>
        </table>
        <p>
            <input type="submit" value="Submit" class="btn btn-primary"/>
        </p>
    </form>
</@layout.defaultLayaout>