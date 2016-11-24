<#include "carusel.ftl">
<#include "base.ftl">

<#macro content>
    <@carusel/>

<div class="container">

    <#if current_user??><#if current_user.role.role="admin">
        <div style="padding-top: 10px">
            <form action="/tour_creating">
                <button type="submit" class="btn btn-primary btn-lg" style="margin-top: 30px;"> <span class="glyphicon glyphicon-pencil" style="margin-right: 7px"></span> Добавить тур</button>
            </form>
        </div>
    </#if></#if>

    <div class="row">

    <div class="row">
    <div class="col-md-4">

        <form action="/tours" method="GET" class="navbar-form" style="padding-top: 20px">
            <div class="input-group" style="width: 300px;">
                <input type="hidden" class="form-control" name="page" value="1">
                <input type="text"  class="form-control" placeholder="Search" name="search" id="search-input">
                    <span class="input-group-btn">
                        <button class="btn btn-default" id="srchbtn" type="submit">
                            <i class="fa fa-search" aria-hidden="true">
                                <span class="glyphicon glyphicon-search"></span>
                            </i>
                        </button>
                    </span>
            </div>
        </form>

    </div>
    <div class="col-md-4">

        <div class="dropdown" style="margin-top: 27px">
            <div class="btn-group" role="group">

            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                Сортировать
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu">
                <li><a style="font-size: 18px" href="/tours?page=1<#if search??>&search=${search}</#if>&sorting=date">По дате вылета</a></li>
                <li><a style="font-size: 18px" href="/tours?page=1<#if search??>&search=${search}</#if>&sorting=rating">По рейтингу</a></li>
                <li><a style="font-size: 18px" href="/tours?page=1<#if search??>&search=${search}</#if>&sorting=cost">По цене</a></li>
            </ul>

            <#if back_order??>
                <a href="tours?page=1<#if search??>&search=${search}</#if><#if sorting??>&sorting=${sorting}</#if>" class="btn btn-default">
                    <span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>
                </a>
            <#else>
                <a href="tours?page=1<#if search??>&search=${search}</#if><#if sorting??>&sorting=${sorting}</#if>&back_order=true" class="btn btn-default">
                    <span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>
                </a>
            </#if>

            </div>
        </div>

    </div>

    <div class="col-md-4">

        <ul class="pager" style="float: right;">
            <li <#if !page?? || page=1 >class="disabled" </#if> >
                <a  <#if page?? && (page>1)>
                        href="/tours?page=${page-1}<#if search??>$search=${search}</#if><#if sorting??>}&sorting=${sorting}</#if><#if back_order??>&back_order=true</#if>"
                </#if>style="font-size: 20px;">&larr; Предыдущая</a>
            </li>
            <li <#if tours?size<limit >class="disabled" </#if> >
                <a <#if (tours?size=limit) >
                        href="/tours?page=${page + 1}<#if search??>$search=${search}</#if><#if sorting??>&sorting=${sorting}</#if><#if back_order??>&back_order=true</#if>"
                </#if> style="font-size: 20px;">Следующая &rarr;</a>
            </li>
        </ul>

    </div>
    </div>

        <div style="padding-top: 20px">
            <ul class ="list-group">
            <#list tours as tour>
                <#if tour.departureDate??>
                <li class ="list-group-item">
                    <div class="row">
                        <div class="col-md-9">
                            <a href="\tours?id=${tour.id}">${tour.title}</a>
                            <hr/>
                            <div class="row">
                                <div class="col-md-12">
                                    <h5 style="color: black;"><b>Место: </b>${tour.place}</h5>
                                    <h5 style="color: black;"><b>Ракета: </b>${tour.rocket}</h5>
                                    <h5 style="color: black;"><b>Дата вылета: </b>${tour.departureDate.date}</h5>
                                    <h5 style="color: black;"><b>Стоимость: </b>${tour.cost}</h5>
                                    <h5 style="color: black;"><b>Мест осталось: </b>${tour.seatsNumber - tour.bookingCount} из ${tour.seatsNumber}</h5>
                                <#if tour.rating != 0>
                                    <h5 style="color: black;"><b>Рейтинг: </b></h5>
                                    <div class="progress ff col-md-6">
                                        <div class="progress-bar" role="progressbar" aria-valuenow="${tour.rating}" aria-valuemin="0" aria-valuemax="5" style="width: ${tour.rating * 100 / 5}%;">
                                            ${tour.rating} из 5
                                        </div>
                                    </div>
                                <#else>
                                    <h5 style="color: black;"><b>Рейтинг: </b> Тур еще никто не оценил</h5>
                                </#if>

                                 </div>
                             </div>
                        </div>
                        <div class="col-md-3">
                            <img src="http://localhost:8080/files/tours_photo/${tour.id}.jpg" width="100%">
                        </div>
                    </div>
                </li>
                </#if>
            </#list>
            </ul>
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

    a{
        font-size: 40px;
        color: black;
    }
    a:hover{
        color:grey;
    }

</style>
</#macro>