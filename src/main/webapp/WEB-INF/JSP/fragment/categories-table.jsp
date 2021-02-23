<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 13.02.2021
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<table>
    <tbody>
    <tr>
        <th style="width:270px;">Categories</th>
    </tr>
    <c:forEach var="categoryEntry" items="${CATEGORY_MAP}">
        <c:set var="cat" value="${categoryEntry.value}"/>
    <tr>
        <td class="${selectedCategory.id == categoryEntry.key ? 'selected ' : '' }item">
            <a href="/news/${cat.name.toLowerCase()}">${cat.name}<span>(${cat.articles})</span></a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>