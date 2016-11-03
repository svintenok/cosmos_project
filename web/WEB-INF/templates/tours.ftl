<#include "carusel.ftl">
<#include "base.ftl">

<#macro content>
    <@carusel/>

<div class="container">

    <div class="row">



        <div class="row" style="padding-top: 40px; padding-left: 20px">
            <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-pencil" style="margin-right: 7px"></span><a href="\tour_сreating" style="color: white; font-size: 20px">Создать тур</a></button>
        </div>


        <form class="navbar-form" role="search" style="padding-top: 20px">
            <div class="input-group" style="width: 300px;">
                <input type="text" autocomplete="off" class="form-control" placeholder="Search" name="search" id="search-input">
                    <span class="input-group-btn">
                        <button class="btn" id="srchbtn" type="btn-default">
                            <i class="fa fa-search" aria-hidden="true">
                                <span class="glyphicon glyphicon-search"></span>
                            </i>
                        </button>
                    </span>
            </div>

            <select class="form-control">
                <option>По дате</option>
                <option>По имени</option>
                <option>По цене</option>
            </select>

        </form>

        <div style="padding-top: 20px">
            <ul class ="list-group">
                <li class ="list-group-item"><a href="#">Тур</a></li>
                <li class ="list-group-item"><a href="#">Тур</a></li>
                <li class ="list-group-item"><a href="#">Тур</a></li>
                <li class ="list-group-item"><a href="#">Тур</a></li>
                <li class ="list-group-item"><a href="#">Тур</a></li>
                <li class ="list-group-item"><a href="#">Тур</a></li>
                <li class ="list-group-item"><a href="#">Тур</a></li>
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
        font-family: "Chiller";
    }
    a:hover{
        color:grey;
    }

</style>
</#macro>