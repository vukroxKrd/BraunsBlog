<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 13.02.2021
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" language="java" %>

<div id="new-comment-container" class="media-object comment-item new-comment">
    <div class="media-object-section">
        <img class="avatar" src="http://placehold.it/80x80" alt="anonym">
    </div>
    <div class="media-object-section" style="width: 100%;">
        <textarea id="comment-content" name="comment-content" placeholder="Type a new comment"></textarea>
        <span class="form-error">Comment is required. </span>
        <a href="#" class="float-right button" style="margin:7px 0 0;">Submit</a>
    </div>
</div>
