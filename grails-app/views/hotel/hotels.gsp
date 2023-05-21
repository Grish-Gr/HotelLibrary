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
    <g:each in="${listHotel}" var="hotel">
        <div class="list_item_container">
            <div>
                <p>Рейтинг: ${hotel.rating} звезды</p>
                <g:link url="hotel/${hotel.id}">
                    <p>Отель: ${hotel.name}</p>
                </g:link>
            </div>
            <p>Местоположение: ${hotel.country.name}, ${hotel.country.capital}</p>
        </div>
    </g:each>
</div>
</body>
</html>