<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 2/25/2021
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="pagination" required="true" type="net.braun.blog.model.Pagination" %>

<c:if test = "${pagination != null}">
    <ul class="pagination text-center" role="navigation" aria-label="Pagination">
        <li class="pagination-previous${pagination.previous ? '' : ' disabled'}">
            <c:choose>
                <c:when test="${pagination.previous}"><a href="${pagination.previousUrl}" aria-label="Previous">Previous</a></c:when>
                <c:otherwise>Previous</c:otherwise>
            </c:choose>
        </li>
        <c:forEach var="page" items="${pagination.pages}">
            <c:choose>
                <c:when test="${page.current}"><li class="current">${page.caption}</li></c:when>
                <c:when test="${page.ellipsis}"><li class="ellipsis"></li></c:when>
                <c:otherwise><li><a href="${page.url}" aria-label="Page ${page.caption}">${page.caption}</a></li></c:otherwise>
            </c:choose>
        </c:forEach>
        <li class="pagination-next${pagination.next ? '' : ' disabled'}">
            <c:choose>
                <c:when test="${pagination.next}"><a href="${pagination.nextUrl}" aria-label="Next page">Next</a></c:when>
                <c:otherwise>Next</c:otherwise>
            </c:choose>
        </li>
    </ul>
</c:if>