<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Список названий дисциплин</title>
    <link rel="stylesheet" href="../../resources/css/styles.css" type='text/css' media='all'/>
</head>
<body>
<h1>Система управления студентами и их успеваемостью</h1>
<a href="/logout" class="logout-link">Logout</a>
<a href="/" class="main-link links">На главную</a>
<div class="container">
    <div id="select-semestr">
        <label>Выбрать семестр</label>
        <form action="/select-term" method="get">
            <select name="selectTerm">
                <c:forEach items="${terms}" var="term">
                    <c:choose>
                        <c:when test="${term.id == selectedTerm.id}">
                            <option value="${term.id}" selected>${term.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${term.id}">${term.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>

            <input type="submit" value="Выбрать">
        </form>

    </div>
    <p>Длительность семестра ${selectedTerm.duration}</p>
    <p>Список дисциплин семестра</p>
    <div id="term-list-main-info">
        <table class="main-info-table">
            <tr>
                <th>Наименование дисциплины</th>
            </tr>
            <c:forEach items="${disciplines}" var="dis">
                <tr>
                    <td>${dis.name}</td>
                </tr>
            </c:forEach>

        </table>
        <div>
            <form action="/term-create" , method="get">
                <input type="submit" value="Создать семестр..." class="big-button">
            </form>
            <form action="/term-modify" method="get">
                <input type="submit" value="Модифицировать текущий семестр..." class="big-button">
            </form >

            <form action="/term-delete" method="post" id = "delete-term-form">
                <input type="hidden" name="idTermDelete" id="idTermDelete">
            </form>
            <input type="submit" value="Удалить текущий семестр" class="big-button" onclick="deleteTerm()">
        </div>
    </div>

</div>

</body>
</html>
