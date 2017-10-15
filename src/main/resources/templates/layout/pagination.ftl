<#macro pagination currentPage totalPages >
<nav aria-label="Page navigation">
    <div class="text-center">
        <ul class="pagination">
            <#if (totalPages > 1)>

            <#-- Previous page -->
                <#if (currentPage > 1)>
                    <li><a href="/projects/?currentPage=${currentPage - 1}">Prev</a></li>
                </#if>

            <#-- Page number -->
                <#list 1 .. totalPages as pageNumber>
                    <#if (pageNumber == currentPage)>
                        <li class="active"><a href="#">${pageNumber}</a></li>
                    <#else>
                        <li><a href="/projects/?currentPage=${pageNumber}">${pageNumber}</a></li>
                    </#if>
                </#list>

            <#-- Next page -->
                <#if (currentPage < totalPages)>
                    <li><a href="/projects/?currentPage=${currentPage + 1}">Next</a></li>
                </#if>
            </#if>
        </ul>
    </div>
</nav>
</#macro>