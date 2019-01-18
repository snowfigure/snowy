<#include "/WEB-INF/page/admin/__layout.ftl" />

<@layout >
<div class="row-12">

    <div id="panel-container">

    </div>
</div>
</@layout >
<script type="text/javascript">
    var panel = new Panel("panel-container");
    panel.init();
    panel.setHeading("<h3>这是标题</h3>");
    panel.setBody("<h1>正文标题</h1> <br/> 这是正文 ");
    panel.setFooter("尾注");
</script>