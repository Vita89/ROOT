<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список дисциплин</title>
    <link rel="stylesheet" href="../../resources/css/styles.css" type='text/css' media='all'/>
    <script src="../../resources/js/functions.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


</head>
<body>
<h1>Система управления студентами и их успеваемостью</h1>
<c:choose>
    <c:when test="${login=='true'}">
        <a href="/logout" class="logout-link">Logout</a>
    </c:when>
    <c:otherwise>
        <a href="/registration-form" class="logout-link">Login</a>
    </c:otherwise>
</c:choose>
<a href="/" class="links main-link">На главную</a>
<h3>Список дисциплин</h3>

<div class="container" id="discipline-list-page">
    <table class="main-info-table ">
        <tr>
<c:if test="${role == '1'}">
            <th class="checkbox-narrow"></th>
</c:if>
            <th>Наименование дисциплины</th>
        </tr>

        <c:forEach items="${disciplines}" var="dis">
            <tr>
                <c:if test="${role == '1'}">
                <td class="aling-right"><input type="checkbox" value="${dis.id}" id="${dis.id}"></td>
                </c:if>
                <td>${dis.name}</td>
            </tr>
        </c:forEach>


    </table>
    <div>
        <form action="/discipline-create" method="get">
<c:if test="${role == '1'}">
            <input type="submit" value="Создать дисциплину..." class="big-button">
</c:if>
        </form>

<c:if test="${role == '1'}">
            <input type="submit" value="Модифицировать дисциплину..." class="big-button" onclick="modifyDiscipline()">
</c:if>
        <form action="/discipline-modify", method="get" id="discipline-modify-form">
            <input type="hidden" name="selectedId" id="selectedId">
        </form>
<c:if test="${role == '1'}">
        <input type="submit" value="Удалить дисциплину" class="big-button" onclick="deleteDiscipline()">
</c:if>
    </div>
    <form action="/discipline-delete" method="post" id="delete-discipline-form">
        <input type="hidden" name="idDelete" id="idDelete">
    </form>
</div>

</body>
</html>
