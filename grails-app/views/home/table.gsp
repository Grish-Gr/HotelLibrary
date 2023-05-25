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
        <g:link controller="country" action="countries">Страны</g:link>
    </ul>
</nav>
<div class="main">
    <p>Количество найденных отелей: ${countEntries}</p>
    <g:link controller="home" action="home">
        <button class="btn btn-outline-secondary">Начать новый поиск</button>
    </g:link>
    <table>
        <g:if test="${hotels.size() > 0}">
            <tr>
                <th class="rating">
                    Рейтинг
                </th>
                <th>Название</th>
                <th>Сайт</th>
            </tr>
            <g:each in="${hotels}" var="hotel">
                <tr>
                    <td>${hotel.rating}</td>
                    <td>${hotel.name}</td>
                    <td>
                        <g:if test="${hotel.linkToWebsite != null}">
                            <g:link url="${hotel.linkToWebsite}">Перейти на сайт</g:link>
                        </g:if>
                        <g:else>Нет данных о сайте</g:else>
                    </td>
                </tr>
            </g:each>
        </g:if>
    </table>
</div>
<footer>
    <div class="pagination_container">
        <g:if test="${listPaginationPages.size() < lastPage}">
            <g:link controller="home" action="search"
                    params="[page: 0, searchName: params.searchName, country: params.country]">
                <button type="button" class="btn btn-outline-secondary" style="margin-right: 4px"><<</button>
            </g:link>
        </g:if>
        <g:each in="${listPaginationPages}" var="page">
            <g:link controller="home" action="search"
                    params="[page: page - 1, searchName: params.searchName, country: params.country]">
                <g:if test="${page - 1 == currentPage}">
                    <button type="button" class="btn btn-secondary">${page}</button>
                </g:if>
                <g:else>
                    <button type="button" class="btn btn-outline-secondary">${page}</button>
                </g:else>
            </g:link>
        </g:each>
        <g:if test="${listPaginationPages.size() < lastPage}">
            <g:link controller="home" action="search"
                    params="[page: lastPage - 1, searchName: params.searchName, country: params.country]">
                <button type="button" class="btn btn-outline-secondary" style="margin-left: 4px">>></button>
            </g:link>
        </g:if>
    </div>
</footer>
</body>
</html>