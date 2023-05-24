<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Отели</title>
    <asset:stylesheet src="main.css"/>
    <asset:stylesheet src="bootstrap.css"/>
</head>

<body>
<nav class="navigation_block">
    <ul>
        <g:link controller="home" action="home">Главная</g:link>
        <g:link controller="hotel" action="hotels">Отели</g:link>
        <g:link controller="country" action="countries">Страны</g:link>
    </ul>
</nav>
<div class="main">
    <div style="margin: 16px 6px">
        <g:link controller="hotel" action="hotel">
            <button type="button" class="btn btn-outline-secondary">Добавить отель в базу</button>
        </g:link>
    </div>
    <g:each in="${listHotel}" var="hotel">
        <div class="list_item_container">
            <div>
                <p>Рейтинг: ${hotel.rating} звезды</p>
                <g:link controller="hotel" action="hotel" params="[id: hotel.id]">
                    <p>Отель: ${hotel.name}</p>
                </g:link>
            </div>
            <p>Местоположение: ${hotel.country.name}</p>
        </div>
    </g:each>
</div>
<footer>
    <div class="pagination_container">
        <g:link controller="hotel" action="hotels" params="[page: 0]">
            <button type="button" class="btn btn-outline-secondary" style="margin-right: 4px"><<</button>
        </g:link>
        <g:each in="${listPaginationPages}" var="page">
            <g:link controller="hotel" action="hotels" params="[page: page - 1]">
                <g:if test="${page - 1 == currentPage}">
                    <button type="button" class="btn btn-secondary">${page}</button>
                </g:if>
                <g:else>
                    <button type="button" class="btn btn-outline-secondary">${page}</button>
                </g:else>
            </g:link>
        </g:each>
        <g:link controller="hotel" action="hotels" params="[page: lastPage - 1]">
            <button type="button" class="btn btn-outline-secondary" style="margin-left: 4px">>></button>
        </g:link>
    </div>
</footer>
</body>
</html>