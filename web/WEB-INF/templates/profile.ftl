<#include "base.ftl">


<#macro content>

<div class="container">

    <div class="col-md-12" style="margin-top: 40px; margin-bottom: 20px" >
        <div class="col-md-5"  style="margin-left: 12px;">
            <h2>${user.login}</h2>
        </div>
    </div>

    <div class="row" style="margin-top: 80px">

        <div class="col-md-4">
            <img src="data/users_photo/${user.login}.jpg" style="max-height: 500px; max-width: 317px; margin-bottom: 20px; margin-left: 41px">
            <ul style="margin-top: 10px; margin-bottom: 40px">
                <#if user.name??><li class="list-group-item"><p><b>Имя: </b>${user.name}</p></li></#if>
                <li class="list-group-item"><p><b>Почта: </b>${user.email}</p></li>
                <#if user.country??><li class="list-group-item"><p><b>Страна: </b>${user.country}</p></li></#if>
                <li class="list-group-item"><p><b>Путешествий: </b> ${travels_number}</p></li>
            </ul>
        <#if current_user??><#if current_user.login == user.login>
            <button type="button" class="btn" style="margin-left: 41px; margin-bottom: 30px">
                <span class="glyphicon glyphicon-cog" style="margin-right: 5px"></span>
                <a href="settings.html">Настройки</a>
            </button>
        </#if></#if>
        </div>

        <div class="col-md-1"></div>

        <div class="col-md-7" style="margin-top: 10px">
            <ul>
                <p class="kk">История путешествий</p>
                <#list travels as travel>
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-8">
                                <a href="#">${travel.departureDate.tour.title}</a>
                            </div>
                            <div class="col-md-4">
                                <p align="right">${travel.departureDate.date}</p>
                            </div>
                        </div>
                    </li>
                </#list>
            </ul>
    <#if current_user??><#if current_user.login == user.login>
            <button type="button" class="btn btn-primary" style="margin-top: 30px; margin-left: 41px;">
                <span class="glyphicon glyphicon-plane" style="margin-right: 7px"></span>
                <a href="reservationses.html" style="color: white">Мои бронирования</a></button>
    </#if></#if>
        </div>


    </div>
</div>

</#macro>


<#macro style>
<style type="text/css">
    .text{
        font-family: "Gabriola";
        font-size: 20px;
        font-style: italic;
        color: white;
        text-shadow:0 0 10px black;
    }
    .item{
        background: #333;
        text-align: center;
        height: 350px !important;
    }
    .carousel{
        margin-top: 50px;
        margin-left: 41px;
    }
</style>

<style>

    h5{
        font-size: 20px;
        color: rgba(255,255,255,1);
        font-style: normal;
        font-family: "Dotum";
    }
    h5:hover{
        color: rgba(158, 152, 152, 1);
        text-shadow: 0 0 10px rgba(255,255,255,1);
    }

    html,
    body {
        height: 100%;
        background:rgba(245, 245, 245, 1);
        padding: 10px;
        font-family: 'Dotum';
    }

    header {
        padding: 20px 0;
    }
    footer {
        position: absolute;
        width: 100%;
        background: #7e7e7e;
        color: #dbdbdb;
        font-size: 11px;
    }


    #footer {
        max-width: 960px;
        margin: auto;
        padding: 10px 0;
        height: 90px;
    }
    #footer-logo {
        float: right;
        margin-top: 20px;
        font-size: 12px;
        text-align: right;
    }

    H1{
        font: 39px Tahoma, sans-serif;
    }

    h3{
        font-size: 20px;
        color: rgba(0,0,0,1);
        font-style: normal;
    }

    .kk{
        font-size: 20px;
        color: rgba(100,100,100,1);
    }

    a{
        font-size: 18px;
        color: black;
        font-family: "Chiller";
    }
    a:hover{
        color:grey;
    }

</style>
</#macro>