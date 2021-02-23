<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 13.02.2021
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" language="java" %>

<ul id="mobile-category-menu" class="categories dropdown menu align-right hide-for-large" data-dropdown-menu>
    <li>
        <a href="javascript:void(0);">Categories</a>
        <ul class="menu" style="display:none;">
            <c:forEach var="categoryEntry" items="${CATEGORY_MAP }">
                <c:set var="cat" value="${categoryEntry.value}" />
                <li class="${selectedCategory.id == categoryEntry.key ? 'selected ' : '' }sitem">
                    <a href="/news/${cat.url.toLowerCase() }">${cat.name} <span>(${cat.articles })</span></a>
                </li>
            </c:forEach>
        </ul>
    </li>
</ul>