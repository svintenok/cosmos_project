<#include "base.ftl">

<#macro content>

<div class="container">

    <div class="row" style="margin-top: 40px">

        <div class="col-md-8 col-md-offset-2">

            <form action="/about_editing" id="f1" method="post">

                <h3>Телефон</h3>
                <input type="text" name="phone" required="" class="form-control" value="${company_info.phone}"/>
                <h3>Адрес офиса</h3>
                <input type="text" name="address" required="" class="form-control" value="${company_info.address}"/>
                <h3>Почта</h3>
                <input type="text" name="email" required="" class="form-control" value="${company_info.email}"/>


                <div class="row">
                    <div class="col-md-12">
                        <h3>О компании</h3>
                        <textarea name="about" required="" class="form-control input-contrast comment-form-textarea field" value="${company_info.text}" style="max-height: 400px; height: 400px;">${company_info.text}</textarea>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12" style="margin-bottom: 20px; margin-top: 20px;">

                        <button type="submit"  class="btn gg">Сохранить изменения</button>

                    </div>
                </div>

            </form>

        </div>

    </div>
</div>

</#macro>


<#macro style>


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
    .gg{
        font-size: 22px;
    }

</style>

</#macro>