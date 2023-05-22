<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Страны</title>
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
        <g:link controller="country" action="country">
            <button type="button" class="btn btn-outline-secondary">Добавить страну в базу</button>
        </g:link>
    </div>
    <g:each in="${listCountry}" var="country">
        <div class="list_item_container">
            <g:link controller="country" action="country" params="[id: country.id]">
                <p>Название: ${country.name}</p>
            </g:link>
            <p>Столица: ${country.capital}</p>
        </div>
    </g:each>
</div>
<footer>
    <div class="pagination_container">
        <div style="text-align: right">
            <g:if test="${hasPrev}">
                <g:link controller="country" action="countries" params="[page: page - 1]">
                    <button type="button" class="btn btn-outline-secondary">Назад</button>
                </g:link>
            </g:if>
        </div>
        <div>
            <g:if test="${hasNext}">
                <g:link controller="country" action="countries" params="[page: page + 1]">
                    <button type="button" class="btn btn-outline-secondary">Дальше</button>
                </g:link>
            </g:if>
        </div>
    </div>
</footer>
</body>
</html>