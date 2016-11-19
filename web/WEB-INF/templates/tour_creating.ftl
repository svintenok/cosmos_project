<#include "base.ftl">

<#macro content>

<div class="container">

    <div class="row">

        <div class="col-md-8 col-md-offset-2">

        <form <#if tour??>action="/tour_editing?id=${tour.id}"<#else>action="/tour_creating"</#if> id="f1" method="post" enctype="multipart/form-data" >
            <#if tour??>
                <h1 style="margin-top: 40px">Изменение тура</h1>
            <#else>
                <h1 style="margin-top: 40px">Добавление тура</h1>
            </#if>

            <h3>Название</h3>
            <input type="text" name="title" required="" class="form-control" <#if tour??>value="${tour.title}"</#if>/>
            <h3>Место</h3>
            <input type="text" name="place" required="" class="form-control" <#if tour??>value="${tour.place}"</#if>/>
            <h3>Ракета</h3>
            <input type="text" name="rocket" required="" class="form-control" <#if tour??>value="${tour.rocket}"</#if>/>
            <h3>Стоимость</h3>
            <input type="number" name="cost" required="" class="form-control" <#if tour??>value="${tour.cost?c}"</#if>/>
            <#if !tour??>
            <h3>Дата вылета</h3>
            <input type="date" name="date" required="" class="form-control"/>
            </#if>
            <h3>Интервал</h3>

            <div class="checkbox">
                <label>
                    <input type="checkbox" id="not-repeat" name="not-repeat" value="true"> не повторять рейс
                </label>
            </div>
            <div class="row" style="margin: 20px;" id="interval">
                <div class="col-md-4">
                    <div class="form-group" >
                        <label for="inputYears" class="col-md-4 control-label">Годы:</label>
                        <div class="col-md-8">
                            <select class="form-control" name="years_interval">
                                <#list 0..20 as i>
                                <option value="${i}" <#if tour??><#if tour.interval??><#if tour.interval.years=i> selected="selected" </#if></#if></#if>>${i}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="inputMonths" class="col-md-4 control-label">Месяцы:</label>
                        <div class="col-md-8">
                            <select class="form-control" name="months_interval">
                                <#list 0..11 as i>
                                    <option value="${i}" <#if tour??><#if tour.interval??><#if tour.interval.months=i> selected="selected" </#if></#if></#if>>${i}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                </div>
            </div>

            <script type="text/javascript">
                $(document).ready(function(){
                    $('#not-repeat').click(function(){
                        if ($(this).is(":checked"))
                            $("#interval").hide();
                        else
                            $("#interval").show();
                    });
                });
            </script>
            <h3>Количество мест</h3>
            <input type="number" name="seats_number" required="" class="form-control" <#if tour??>value="${tour.seatsNumber?c}"</#if>/>

            <#if tour??>
                <h3>Изменить фотографию</h3>
            <#else>
                <h3>Фотография</h3>
            </#if>
            <input type="file" name="tour_photo" id="file-field" class="image" />
            <br>
            <div id="photo_copy"></div>

            <script>
                $(function(){
                    $(".image").change(showPreviewImage_click);
                })
                function showPreviewImage_click(e) {
                    var $input = $(this);
                    var inputFiles = this.files;
                    if(inputFiles == undefined || inputFiles.length == 0) return;
                    var inputFile = inputFiles[0];
                    var img = $('<img/>',{'class':'preview'});
                    $('#photo_copy img').remove();
                    img.appendTo($('#photo_copy'));
                    var reader = new FileReader();
                    reader.onload = function(event) {
                        img.attr("src", event.target.result);
                    };
                    reader.onerror = function(event) {
                        alert("I AM ERROR: " + event.target.error.code);
                    };
                    reader.readAsDataURL(inputFile);
                }
            </script>

            <div class="row">
                <div class="col-md-12">
                    <h3>Описание</h3>
                    <textarea name="description" required="" class="form-control input-contrast comment-form-textarea field" <#if tour??>value="${tour.description}"</#if> style="max-height: 400px; height: 400px;"><#if tour??>${tour.description}</#if></textarea>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12" style="margin-bottom: 20px; margin-top: 20px;">
                    <#if tour??>
                        <button type="submit"  class="btn gg">Сохранить изменения</button>
                    <#else>
                        <button type="submit"  class="btn gg">Создать</button>
                    </#if>
                </div>
            </div>

        </form>

        </div>

    </div>
</div>

</#macro>


<#macro style>


<style type="text/css">
    .preview{
        max-height: 350px;
        max-width: 600px;
    }
    .min {
        width: 45px;
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
    .gg{
        font-size: 22px;
    }

</style>

</#macro>