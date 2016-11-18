<#include "carusel.ftl">
<#include "base.ftl">

<#macro content>
    <@carusel/>

<div class="container">

    <div class="row">

        <#if current_user??><#if current_user.role.role="admin">
            <div class="row">
                <div class="col-md-6"">
                    <a href="/about_editing" class="btn btn-primary" style="margin-top: 30px; color: white; font-size: 20px"><span class="glyphicon glyphicon-pencil" style="margin-right: 7px"></span>Редактировать</a>
                </div>
            </div>
        </#if></#if>

        <div style="padding-top: 20px; margin-bottom: 100px">
            <p class="h3">${company_info.text}</p>
            <hr/>
            <p class="h3">Контактные данные:<p>
            <p style="font-size: 25px;"><b>Почта: </b>${company_info.email}</p>
            <p style="font-size: 25px;"><b>Адрес офиса: </b>${company_info.address}</p>
            <p style="font-size: 25px;"><b>Телефон: </b>${company_info.phone}</p>
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

    .h3{
        font-size: 25px;
        color: black;
        text-align: center;
        line-height: 2em;
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
        margin-left: -20px;
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