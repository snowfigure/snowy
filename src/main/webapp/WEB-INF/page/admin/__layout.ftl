<!DOCTYPE html><#macro layout><html>
<head>
    <title></title>
    <#include "/WEB-INF/page/admin/__head.ftl" />

</head>

<body>
<div id="allPanel">
    <div id="top">    </div>
    <div id="tabs">    </div>
    <div class="tabsPanel">  <#nested>  </div>

    <div class="footer">    </div>
</div>
</body>
</html>

<#include "/WEB-INF/page/admin/__footer.ftl" />
<script type="text/javascript">
    var snowy = new SnowyAdmin("http://127.0.0.1");
    snowy.setMenu("tabs", "http://localhost:8080/admin/api/menu/get").initMenu();
</script>
</#macro>