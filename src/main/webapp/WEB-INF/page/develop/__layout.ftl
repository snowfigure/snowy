<!DOCTYPE html><#macro layout>
<html>
<head>
    <title></title>
    <#include "/WEB-INF/page/develop/__head.ftl" />

</head>

<body>
<div id="allPanel">
    <div id="top">
         <#include "/WEB-INF/page/develop/__top_menu.ftl" />
    </div>

    <div id="nav-bar">

    </div>

    <div id="main-container">
           <#nested>
    </div>

    <div class="footer">
        <#include "/WEB-INF/page/develop/__copyright.ftl" />
    </div>
</div>
</body>
</html>

    <#include "/WEB-INF/page/develop/__footer.ftl" />
<script type="text/javascript">

    var snowy = new SnowyAdmin("${Server}");
    snowy.setMenu("nav-bar", "${Server}/develop/api/menu/get").initMenu().selectMenu("${navBarCurrentId}","${navBarParentId}");
</script>
</#macro>
