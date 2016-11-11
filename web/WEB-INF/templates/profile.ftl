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
            <img src="http://localhost:8080/files/users_photo/${user.login}.jpg" style="max-height: 500px; max-width: 317px; margin-bottom: 20px; margin-left: 41px">
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
            <#if travels?has_content>
            <ul>
                <p class="kk">История путешествий</p>
                <#list travels as travel>
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">
                                <a href="#">${travel.departureDate.tour.title}</a>
                            </div>
                            <div class="col-md-3">
                                <#if !travel.recall??>
                                <button class="btn btn-default btn-md" data-toggle="modal"  data-target="#RecallModal${travel.departureDateId}">Оставить отзыв</button>
                                </#if>
                            </div>
                            <div class="col-md-3">
                                <p align="right">${travel.departureDate.date}</p>
                            </div>
                        </div>
                    </li>

                    <!-- Modal -->
                    <div class="modal fade" id="RecallModal${travel.departureDateId}" tabindex="-1" role="dialog" aria-labelledby="RecallModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="RecallModalLabel">Отзыв</h4>
                                </div>

                                <form action="/profile" method="POST">

                                <div class="modal-body">
                                    <div class="row">
                                        <div class="col-md-12">


                                        <div class="form-group">
                                            <p class="hh">Поставьте оценку: </p>
                                            <div id="reviewStars-input">
                                                <input id="star-4" type="radio" name="estimate" value="5"/>
                                                <label title="gorgeous" for="star-4"></label>

                                                <input id="star-3" type="radio" name="estimate" value="4"/>
                                                <label title="good" for="star-3"></label>

                                                <input id="star-2" type="radio" name="estimate" value="3"/>
                                                <label title="regular" for="star-2"></label>

                                                <input id="star-1" type="radio" name="estimate" value="2"/>
                                                <label title="poor" for="star-1"></label>

                                                <input id="star-0" type="radio" name="estimate" value="1"/>
                                                <label title="bad" for="star-0"></label>
                                            </div>
                                        </div>

                                        <div class="row">
                                        <div  class="col-md-12" style="margin-top: 20px">
                                                    <p class="hh">Напишите отзыв: </p>
                                                    <textarea name="recall" class="form-control input-contrast comment-form-textarea field" style="max-height: 233px; height: 100px;" required></textarea>
                                        </div>
                                        </div>

                                        <input type="hidden" name="departure_date" value="${travel.departureDateId}">

                                        </div>

                                    </div>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                                    <button type="submit" class="btn btn-primary" >Отправить</button>
                                </div>

                                </form>
                            </div>
                        </div>
                    </div>
                </#list>
            </ul>
            </#if>
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

    #reviewStars-input input:checked ~ label, #reviewStars-input label, #reviewStars-input label:hover, #reviewStars-input label:hover ~ label {
        background: url('http://positivecrash.com/wp-content/uploads/ico-s71a7fdede6.png') no-repeat;
    }

    #reviewStars-input {

        overflow: hidden;
        *zoom: 1;

        position: relative;
        float: left;
    }

    #reviewStars-input input {
        filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=0);
        opacity: 0;

        width: 43px;
        height: 40px;

        position: absolute;
        top: 0;
        z-index: 0;
    }

    #reviewStars-input input:checked ~ label {
        background-position: 0 -40px;
        height: 40px;
        width: 43px;
    }

    #reviewStars-input label {
        background-position: 0 0;
        height: 40px;
        width: 43px;
        float: right;
        cursor: pointer;
        margin-right: 10px;

        position: relative;
        z-index: 1;
    }

    #reviewStars-input label:hover, #reviewStars-input label:hover ~ label {
        background-position: 0 -40px;
        height: 40px;
        width: 43px;
    }

    #reviewStars-input #star-0 {
        left: 0px;
    }
    #reviewStars-input #star-1 {
        left: 53px;
    }
    #reviewStars-input #star-2 {
        left: 106px;
    }
    #reviewStars-input #star-3 {
        left: 159px;
    }
    #reviewStars-input #star-4 {
        left: 212px;
    }
    #reviewStars-input #star-5 {
        left: 265px;
    }
</style>
</#macro>