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
<div id="tabs">
    <ul>
        <li>
            <div id="tabs_index"><a href="" class="hover"><span class="icon-play"></span> 主页</a></div>
        </li>
        <li>
            <div id="tabs_main"><a href="" class="hover"><span class="icon-refresh"></span> 后台</a></div>
        </li>
        <li>
            <div id="tabs_new"><a href="" class="hover"><span class="icon-edit"></span> 新建</a></div>
        </li>
        <li>
            <div class="tabs_parent" id="tabs_manage"><span class="icon-article"></span> 管理 <span
                    class="icon-chevron-down right"></span></div>
            <ul class="none">
                <li>
                    <div id="tabs_manage_article"><a href="">文章</a></div>
                </li>
                <li>
                    <div id="tabs_manage_draft"><a href="">草稿</a></div>
                </li>
                <li>
                    <div id="tabs_manage_comment"><a href="">评论</a></div>
                </li>
            </ul>
        </li>
        <li>
            <div class="tabs_parent" id="tabs_setting"><span class="icon-setting"></span> 工具 <span
                    class="icon-chevron-down right"></span></div>
            <ul class="none">
                <li>
                    <div id="tabs_setting_preference"><a href="">偏好</a></div>
                </li>
                <li>
                    <div id="tabs_setting_plugin"><a href="">插件</a></div>
                </li>
                <li>
                    <div id="tabs_setting_others"><a href="">其他</a></div>
                </li>
            </ul>
        </li>
    </ul>
</div>
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
    //var snowy = new SnowyAdmin("http://localhost:8080");
    //snowy.setMenu("tabs", "http://localhost:8080/admin/api/menu/get").initMenu();
</script>
</#macro>