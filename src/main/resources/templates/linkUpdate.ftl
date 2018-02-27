<#--@ftlvariable name="links" type="java.util.List"-->
<#-- @ftlvariable name="links" type="com.web.link.checker.project.model.Link"-->
<#import "/spring.ftl" as spring/>
<#import "layout/defaultLayout.ftl" as layout>
<#assign title = "Update link">
<@layout.defaultLayaout title>
    <h1>Update Link</h1>
    <form method="post" action="/links/project/${projectProjection.uuid}/link/${link.id}">
        <table>
            <tbody>
            <tr>
                <td>Link anchor:</td>
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
                <td>Link follow:</td>
                <td>
                    <p><label for="link-follow"></label>
                         <@spring.bind "link.follow"/>
                        <input type="text" name="follow" value="${link.follow!}" id="link-follow">
                         <#if spring.status.error>
                         <span><@spring.showErrors separator="," /></span>
                         </#if>
                    </p>
                </td>
            <tr>

            <tr>
                <td>Link location:</td>
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
                <td>Link dofollow:</td>
                <td>
                    <p><label for="link-dofollow"></label>
                         <@spring.bind "link.dofollow"/>
                        <input type="checkbox" checked="checked" name="dofollow" value="true" id="link-dofollow">
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