<#include "carusel.ftl">
<#include "base.ftl">

<#macro content>
    <@carusel/>

    <div class="container">

        <div class="row">

        <#if login??><#if is_admin??>
            <div style="padding-top: 60px">
                <button type="button" class="btn btn-primary" style="margin-top: 30px;"><span class="glyphicon glyphicon-pencil" style="margin-right: 7px"></span><a href="news_creating" style="color: white; font-size: 20px">Добавить новость</a></button>
            </div>
        </#if></#if>


            <div style="padding-top: 40px; margin-bottom: 100px">
                <ul class ="list-group">


                <#list news_list as news>

                    <li class ="list-group-item" style="margin-bottom: 30px">
                        <div class="row">
                            <div class="col-md-7">
                                <p> <a href="/news?id=${news.id}" class="col-md-8">${news.title}</a></p>
                                <#if news.description??>
                                <div class="row">
                                    <div class="col-md-12">
                                        <p>${news.description}</p>
                                    </div>
                                </div>
                                </#if>
                            </div>
                            <div class="col-md-5">
                                <img src="photo\news_photo\${news.id}.jpg" width="100%">
                            </div>
                        </div>
                    </li>

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