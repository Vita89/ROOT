<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создание дисциплины</title>
    <link rel="stylesheet" href="../../resources/css/styles.css" type='text/css' media='all'/>
</head>
<body>
<h1>Система управления студентами и их успеваемостью</h1>
<a href="/logout" class="logout-link">Logout</a>
<c:choose>
    <c:when test="${login=='true'}">
        <a href="/logout" class="logout-link">Logout</a>
    </c:when>
    <c:otherwise>
        <a href="/registration-form" class="logout-link">Login</a>
    </c:otherwise>
</c:choose>
<a href="/" class="links main-link">На главную</a>
<a href="/disciplines" class="links back-link">Назад</a>
<h3>Для того, чтобы создать новую дисциплину заполните все поля и нажмите кнопку «Создать»</h3>
<div class="container" id="discipline-create-page">
    <form action="/discipline-create" method="post">
        <div>
            <label>Название</label>
            <input name="newDiscipline" type="text">
        </div>
        <input type="submit" value="Создать">
        <c:if test="${mm == 'qwerty'}">
            <div class="bad-writing">
                <i>Поля не должны быть пустыми!</i>
            </div>
        </c:if>
    </form>
</div>


</body>
</html>
