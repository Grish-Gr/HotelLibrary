<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Главная</title>
    <asset:stylesheet src="main.css"/>
    <asset:stylesheet src="home.css"/>
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
    <div class="search_container">
        <div class="form_search">
            <h3 class="title_form_search">Справочник отелей</h3>
            <g:form controller="home" action="search" class="form">
                <div class="form-group">
                    <g:textField name="searchName" placeholder="Название отеля"/>
                </div>
                <div class="form-group">
                    <g:select name="country" from="${countries}"
                              optionValue="" optionKey=""
                              noSelection="${[null: "Любая"]}"/>
                </div>
                <fieldset class="submit">
                    <g:submitButton name="send" value="Найти" class="btn btn-success" />
                </fieldset>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>