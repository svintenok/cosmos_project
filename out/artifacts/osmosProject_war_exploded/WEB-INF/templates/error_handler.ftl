<#include "base.ftl">

<#macro content>
<body>
    <div class="container" style="margin-top: 40px;">
        <div class="row">
        <div class="col-md-12">
            <h1 align="center">404</h1>
            <h1 align="center">страницы не существует:(</h1>
        </div>
        </div>
    </div>
</#macro>

<#macro style>

<style>
    html,
    body {
        height: 100%;
        background:rgba(245, 245, 245, 1);
        padding: 10px;
        font-family: 'Dotum';
    }

    #wrapper {
        max-width: 960px;
        margin: auto;
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
        bottom: 0;
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

    p{
        padding-top: 30px;
        margin-top: 50px;
    }
    #f1{
        margin-top: 80px;
    }
    H1{
        font: 39px Tahoma, sans-serif;
    }
    h3{
        font: 20px Tahoma, sans-serif;
        margin-top: 20px;
    }
    .custom-btn-primary{
        font: 17px Tahoma, sans-serif;
        border-color: #8f8f8f;
        background: #8f8f8f;
        margin-top: 20px;
    }
    .custom-btn-primary:hover{
        border-color: #777777;
        background: #777777;
    }
    .radio{
        margin-top: 20px;
        font: 14px Tahoma, sans-serif;
    }
    .rbElem{
        margin-right: 20px;
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

</style>
</#macro>