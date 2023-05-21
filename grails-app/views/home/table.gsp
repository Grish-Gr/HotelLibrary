<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Результат поиска</title>
    <asset:stylesheet src="main.css"/>
    <asset:stylesheet src="table.css"/>
    <asset:stylesheet src="bootstrap.css"/>
</head>

<body>
    <nav class="navigation_block">
        <ul>
            <g:link controller="home" action="home">Главная</g:link>
            <g:link controller="hotel" action="hotels">Отели</g:link>
            <g:link controller="country" action="index">Страны</g:link>
        </ul>
    </nav>
    <div class="main">
        <p>Количество найденных отелей: ${list.size()}</p>
        <g:link controller="home" action="home">Начать новый поиск</g:link>
        <table>
            <tr><th>Звездность</th><th>Название</th><th>Страна</th></tr>
            <g:each in="${list}" var="hotel">
                <tr><td>${hotel.rating}</td><td>${hotel.name}</td><td>${hotel.country.name}</td></tr>
            </g:each>
        </table>
    </div>
</body>
</html>