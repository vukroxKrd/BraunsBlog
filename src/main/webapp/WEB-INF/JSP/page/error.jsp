<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 2/19/2021
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="callout alert">
    <c:choose>
        <c:when test="${is404 && url != null}">
            <h6>Requested resource<strong>${url}</strong> not found</h6>
        </c:when>
        <c:when test="${is404}">
            <h6>Requested resource was not found</h6>
        </c:when>
        <c:otherwise>
            <h6>Error, please try again later...</h6>
        </c:otherwise>
    </c:choose>
</div>