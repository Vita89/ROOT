<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Модификация дисциплины</title>
    <link rel="stylesheet" href="../../resources/css/styles.css" type='text/css' media='all'/>
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
<a href="/disciplines" class="links back-link">Назад</a>
<h3>Для того, чтобы модифицировать дисциплину введите новое значение поля и нажмите кнопку «Применить»:</h3>
<div class="container" id="discipline-create-page">
    <form action="/discipline-modify" method="post">
        <input type="hidden" value="${discipline.id}" name="disId">
    <div>
        <label>Название</label>
        <input type="text" value="${discipline.name}" name="disName">
    </div>
    <input type="submit" value="Создать">
    </form>
</div>
</body>
</html>
