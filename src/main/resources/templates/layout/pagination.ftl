<#macro pagination currentPage totalPages >
<nav aria-label="Page navigation">
    <div class="text-center">
        <ul class="pagination">
            <#if (totalPages > 1)>

            <#-- Previous page -->
                <#if (currentPage > 0)>
                    <li><a href="/projects/?page=${currentPage - 1}">Prev</a></li>
                </#if>

            <#-- Page number -->
                <#list 0 .. totalPages-1 as pageNumber>
                    <#if (pageNumber == currentPage)>
                        <li class="active"><a href="#">${pageNumber+1}</a></li>
                    <#else>
                        <li><a href="/projects/?page=${pageNumber}">${pageNumber+1}</a></li>
                    </#if>
                </#list>

            <#-- Next page -->
                <#if (currentPage < totalPages-1)>
                    <li><a href="/projects/?page=${currentPage + 1}">Next</a></li>
                </#if>
            </#if>
        </ul>
    </div>
</nav>
</#macro>