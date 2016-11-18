<#include "base.ftl">

<#macro content>

<div class="container">

    <#if current_user??><#if current_user.role.role="admin">
    <div class="row">
        <div class="col-md-6">
            <a href="/tour_editing?id=${tour.id}" class="btn btn-primary" style="margin-top: 40px; color: white; font-size: 20px"><span class="glyphicon glyphicon-pencil" style="margin-right: 7px"></span>Редактировать</a>
        </div>
    </div>
    </#if></#if>

    <div class="row">
        <div class="col-md-12" style="margin-top: 20px; margin-bottom: 30px; text-align: center">
            <p><h1>${tour.title}</h1></p>
        </div>
    </div>

    <div class="row" style="margin-bottom: 40px">
        <div class="col-md-7" >
            <h5 style="color: black;"><b>Место: </b>${tour.place}</h5>
            <h5 style="color: black;"><b>Ракета: </b>${tour.rocket}</h5>
            <h5 style="color: black;"><b>Стоимость: </b>${tour.cost}</h5>
            <#if current_user??><#if current_user.role.role="admin"><#if tour.interval??>
            <h5 style="color: black;"><b>Интервал: </b>${tour.interval}</h5>
            </#if></#if></#if>
            <hr/>

            <p style="font-size: 20px">${tour.description}</p>
        </div>

        <div class="col-md-5">
            <img src="http://localhost:8080/files/tours_photo/${tour.id}.jpg" width="100%" style="float: right; margin: 20px; margin-top: 0px" class = "ff">
        </div>
    </div>



     <div class="row"  style="margin-bottom: 40px">

            <div class="col-md-4">
                <p class="gg" style="text-align: center">Дата вылета: <#if tour.departureDate??>${tour.departureDate.date}<#else>Рейс не планируется</#if></p>
            </div>
            <div class="col-md-3">
                <p class="gg" style="text-align: center;">Мест осталось: ${tour.seatsNumber - tour.bookingCount} из ${tour.seatsNumber}</p>
            </div>
            <div class="col-md-1"></div>
            <#if tour.departureDate??>
            <div class="col-md-4">
                <#if user_booking??>
                <button class="btn btn-default btn-lg" data-toggle="modal"  data-target="#BookingModal">Отменить бронирование</button>
                <#else>
                <button class="btn btn-default btn-lg" data-toggle="modal"  data-target="#BookingModal">Забронировать</button>
                </#if>
            </div>
            </#if>
     </div>

    <#if tour.departureDate??>
    <!-- Modal -->
    <div class="modal fade" id="BookingModal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><#if user_booking??>Отмена бронирования<#else>Бронирование</#if></h4>
                </div>
                <div class="modal-body">
                    <#if current_user??>
                        <#if user_booking??>
                            <p>Вы действительно хотите отменить бронирование билета на ${tour.departureDate.date}?</p>
                        <#else>
                            <p>Вы потверждаете бронирование билета на ${tour.departureDate.date}?</p>
                        </#if>
                    <#else>
                        <p><a href="/login">Войдите</a>, чтобы забронировать </p>
                    </#if>
                </div>
                <div class="modal-footer">
                    <form action="/tours" method="POST">
                        <input type="hidden" name="tour" value="${tour.id}">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                    <#if current_user??>
                        <button type="submit" class="btn btn-primary" >ДА</button>
                    </#if>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </#if>

    <#if tour.rating!=0>
    <div class="row">
        <div class="col-md-12"  style="margin-bottom: 40px">
            <div class="col-md-6">
                <div class="row">
                    <p class="col-md-6 hh">Оценка пользователей:</p>
                    <div class="col-md-5">
                        <div class="progress ff">
                            <div class="progress-bar" role="progressbar" aria-valuenow="${tour.rating}" aria-valuemin="0" aria-valuemax="5" style="width: ${tour.rating * 100 / 5}%;">
                                ${tour.rating} из 5
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </#if>


    <div class="row">
        <div class="col-md-12">
        <ul class ="list-group">
            <#list tour.recallList as recall>
            <li class ="list-group-item">
                <h><a href="/profile?id=${recall.userId}">${recall.user.login}</a></h>
                <hr/>
                <p><b>Оценка: </b>${recall.estimate}</p>
                <p><b>Отзыв: </b>${recall.text}</p>
                <p align="right">${recall.date}</p>
            </li>
            </#list>
        </ul>
    </div>
    </div>


</div>

</#macro>


<#macro style>
<style>

    .ff{
        border: 2px inset rgba(46, 26, 26, 1);
        border-radius: 5px 5px 5px 5px;
        background: rgba(255, 245, 245, 1);
    }
    .gg{
        font-size: 30px;
    }

    .hh{
        font-size: 21px;
    }

    a{
        font-family: "Chiller";
    }
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
        margin-left: -20px;
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


</style>

</#macro>