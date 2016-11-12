<#include "carusel.ftl">
<#include "base.ftl">

<#macro content>
    <@carusel/>

<div class="container">

    <div class="row">


        <div style="padding-top: 40px; margin-bottom: 100px">
            <p class="h3">Cosmos project(SpaceX).<br>Основана в 2002 году прежним владельцем PayPal и CEO Tesla Motors Илоном Маском с целью сократить расходы на полёты в космос, открывая путь к колонизации Марса. Компания разработала ракеты-носители Falcon 1 и Falcon 9, с самого начала преследуя цель сделать их многоразовыми, и космический корабль Dragon (выводимый на орбиту теми же Falcon 9), предназначенный для пополнения запасов на Международной космической станции. Пассажирская версия корабля Dragon V2 для транспортировки астронавтов на МКС находится в финальной фазе разработки. С 2015 года участвует также в реализации проекта вакуумного поезда Hyperloop.С целью контроля над качеством и стоимостью, разработка, производство и тестирование большинства компонентов продукции производится с опорой на внутренние ресурсы, включая ракетные двигатели Merlin, Kestrel, Draco и SuperDraco, используемые на ракетах-носителях Falcon и корабле Dragon. Это позволяет SpaceX предлагать самые низкие цены на рынке, а также заметно снижает время производства.</p>
            <hr/>
            <h3 style="font-size: 25px;">Контактные данные:</h3>
            <p style="font-size: 25px;"><b>Почта: </b></p>
            <p style="font-size: 25px;"><b>Адрес: </b></p>
            <p style="font-size: 25px;"><b>Телефон: </b></p>
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