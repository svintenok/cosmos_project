<#ftl encoding="utf-8"/>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">

    <title>Cosmos project</title>

    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.css">

    <@style/>

    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>

</head>


<body>


<header>
    <nav class="navbar navbar-fixed-top navbar-inverse">
        <div class="container">
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><img src="data/logo.jpg" style="height: 81px; width: 223px; margin-right: 40px;"/></li>
                <#if current_user??>
                    <li><a href="/profile?id=${current_user.id}"><h5>Профиль</h5></a></li>
                    <li><br><h5>|</h5></li>
                </#if>
                    <li><a href="/tours"><h5>Туры</h5></a></li>
                    <li><br><h5>|</h5></li>
                    <li><a href="/news"><h5>Новости</h5></a></li>
                    <li><br><h5>|</h5></li>
                    <li><a href="forum.html"><h5>Форум</h5></a></li>
                    <li><br><h5>|</h5></li>
                    <li><a href="about.html"><h5>О нас</h5></a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                <#if current_user??>
                    <li><a href="/logout"><h5>Выход</h5></a></li>
                <#else>
                    <li><a href="/login"><h5>Вход</h5></a></li>
                </#if>
                </ul>
            </div>
        </div>
    </nav>
</header>

<@content/>

<footer>
    <div id="footer">
        <div id="footer-logo">Copyright © 2016 Cosmos project creation</p></div>
    </div>
</footer>

</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>

</html>