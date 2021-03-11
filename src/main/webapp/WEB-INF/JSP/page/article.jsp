<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 13.02.2021
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="article thumbnail">
    <c:set var="category" value="${CATEGORY_MAP[article.idCategory] }"/>
    <img src="${article.logo}" alt="${article.title}"/>
    <div class="data">
        <%-- ----------------------------------------- Article content ----------------------------------------- --%>
        <h3>${article.title }</h3>
        <ul class="vertical large-horizontal menu">
            <li><i class="fi-folder"></i><a href="/news${category.url}">${category.name }</a></li>
            <li><i class="fi-comments"></i><fmt:formatNumber value="${article.comments }"/> comments</li>
            <li><i class="fi-clock"></i><fmt:formatDate value="${article.created }" dateStyle="FULL" timeStyle="SHORT"
                                                        type="both"/></li>
            <li><i class="fi-eye"></i>Hits: <fmt:formatNumber value="${article.views }"/></li>
        </ul>
        <hr/>
        <div class="content">${article.content }</div>
        <%-- ----------------------------------------- Social buttons ----------------------------------------- --%>
        <div class="row columns social">
            <img src="http://placehold.it/32x32?text=f" alt="social"/>
            <img src="http://placehold.it/32x32?text=t" alt="social"/>
            <img src="http://placehold.it/32x32?text=g" alt="social"/>
            <img src="http://placehold.it/32x32?text=f" alt="social"/>
            <img src="http://placehold.it/32x32?text=t" alt="social"/>
            <img src="http://placehold.it/32x32?text=g" alt="social"/>
        </div>
        <br>
        <%-- ----------------------------------------- Comments section ----------------------------------------- --%>
        <div class="comments">
            <jsp:include page="../fragment/new-comment.jsp"/>
            <div id="comments-list-container">
                <jsp:include page="../fragment/comments.jsp"/>
            </div>
            <div id="comments-load-more-ctrl" class="row column text-center">
                <a class="button hollow expanded load-more-btn" ${article.comments > fn:length(comments) ? '' : style="display:none"}>Load
                    More</a>
            </div>
        </div>
    </div>
</div>