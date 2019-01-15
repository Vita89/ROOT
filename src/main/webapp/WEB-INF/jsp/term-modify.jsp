<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Модификация семестра</title>
    <link rel="stylesheet" href="../../resources/css/styles.css" type='text/css' media='all'/>
</head>
<body>
<h1>Система управления студентами и их успеваемостью</h1>
<a href="/logout" class="logout-link">Logout</a>
<a href="/" class="links main-link">На главную</a>
<a href="/terms" class="links back-link">Назад</a>
<h3>Для модификации семестра отредактируйте данные и нажмите кнопку «Применить».</h3>
<div class="container" id="term-create-page">
    <form action="/term-modify" method="post">
        <div class="one-row">
            <div class="for-label">
                <input type="hidden" value="${term.id}" name="termId">
                <label>Длительность (в неделях)</label>
            </div>
            <input type="text" name="duration">
        </div>
        <div class="one-row">
            <div class="for-label">
                <label>Дисциплины в семестре</label>
            </div>
            <select multiple size="8" name="disciplines">

                <c:forEach items="${disciplines}" var="dis">
                    <option>${dis.name}</option>
                </c:forEach>

            </select>
        </div>
        <input type="submit" value="Создать">
    </form>
</div>
</body>
</html>
