<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <asset:stylesheet src="main.css"/>
    <asset:stylesheet src="home.css"/>
</head>

<body>
    <nav class="navigation_block">
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Blog</a></li>
            <li><a href="#">Contact</a></li>
            <li><a class="active" href="#">Log In</a></li>
        </ul>
    </nav>
    <div class="main">
        <p>Num: ${num}</p>
        <table>
            <tr><th>Звездность</th><th>Название</th><th>Страна</th></tr>
            <g:each in="${list}" var="hotel">
                <tr><td>${hotel.rating}</td><td>${hotel.name}</td><td>${hotel.country.name}</td></tr>
            </g:each>
        </table>
    </div>
</body>
</html>