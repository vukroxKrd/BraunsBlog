<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 13.02.2021
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" language="java" %>

<div class="callout primary" style="margin:0;">
    <div class="row">
        <div class="large-6 medium-6 columns">
            <h1>Blog name</h1>
        </div>
        <div class="large-6 medium-6 columns">
            <form action="/search" method="get">
                <div class="input-group" style="margin-top: 1em;">
                    <input id="search" class="input-group-field" name="query" placeholder="Search query"
                           type="text">
                    <div class="input-group-button">
                        <input class="button" value="Find" type="submit">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
