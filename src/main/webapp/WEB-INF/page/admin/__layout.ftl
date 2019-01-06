<!DOCTYPE html><#macro layout>
<html>
<head>
    <title></title>
    <#include "/WEB-INF/page/admin/__head.ftl" />

</head>

<body>
<div id="allPanel">
    <div id="top">
        <span class="right" style="margin-right: 100px">
            <a href="http://localhost:8080" title="首页">
                <div class="avatar" style="background-image: url(http://localhost:8080/assets/images/logo.png)"></div>
                snowfigure
            </a>
            <a href="#" title="登出">登出</a>
        </span>
    </div>

    </div>
    <div id="tabs"></div>
    <div class="tabsPanel">  <#nested> </div>

    <div class="footer">
        <span>
            &copy; 2013 - 2019
            <a href="http://localhost:8080">雪意随语SnowyImage</a>
            <a href="http://www.miitbeian.gov.cn/" style="text-decoration: none;" target="_blank">蜀ICP备18036945号</a>
        </span>
    </div>
</div>
</body>
</html>

    <#include "/WEB-INF/page/admin/__footer.ftl" />
<script type="text/javascript">
    var snowy = new SnowyAdmin("http://localhost:8080");
    snowy.setMenu("tabs", "http://localhost:8080/admin/api/menu/get").initMenu();
</script>
</#macro>
