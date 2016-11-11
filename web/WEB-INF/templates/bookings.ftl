<#include "carusel.ftl">
<#include "base.ftl">

<#macro content>
    <@carusel/>
<div class="container">

    <div class="row">
        <div class="col-md-8  col-md-offset-2">

        <div style="padding-top: 40px">
            <h3>Мои бронирования</h3>
        </div>

        <div style="padding-top: 20px">


            <#if bookings?has_content>
                <ul class ="list-group">

                    <#list bookings as booking>
                        <li class="list-group-item" style="margin-bottom: 20px">
                            <div class="row">
                                <div class="col-md-6">
                                    <a href="/tours?id=${booking.departureDate.tourId}">${booking.departureDate.tour.title}</a>
                                </div>
                                <div class="col-md-2">
                                    <p>${booking.departureDate.date}</p>
                                </div>
                                <div class="col-md-4" style="float: right">
                                    <button class="btn btn-danger btn-md" data-toggle="modal"  data-target="#BookingModal${booking.departureDateId}">Отменить бронирование</button>
                                </div>
                            </div>
                        </li>

                        <!-- Modal -->
                        <div class="modal fade" id="BookingModal${booking.departureDateId}" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title">Отмена бронирования</h4>
                                    </div>
                                    <div class="modal-body">
                                        <p>Вы действительно хотите отменить бронирование билета на ${booking.departureDate.date}?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <form action="/tours" method="POST">
                                            <input type="hidden" name="tour" value="${booking.departureDate.tourId}">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                                            <button type="submit" class="btn btn-primary" >ДА</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </#list>
                </ul>
            <#else>
            <p>Бронирований нет</p>
            </#if>

        </div>

        </div>
    </div>

</div>

</#macro>




<#macro style>

<style type="text/css">
    .text{
        font-family: "Gabriola";
        font-size: 35px;
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
        margin-top: 13px;
        margin-left: -20px;
        width: 103%;
    }
</style>

<style>

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
        bottom: 0;
        margin-left: -20px;
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
        font-size: 25px;
        color: rgba(0,0,0,1);
        font-family: "Batang";
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