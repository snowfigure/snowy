<#include "/WEB-INF/page/develop/__layout.ftl" />

<@layout >
<div class="row-12">

    <div id="panel-container">

    </div>
</div>
<div class="row-12">

    <pre>
        <code class="html">
 &lt;#include "/WEB-INF/page/admin/__layout.ftl" /&gt;

 &lt;@layout &gt;
 &lt;div class="row-12"&gt;

	 &lt;div id="panel-container"&gt;

	 &lt;/div&gt;
 &lt;/div&gt;
 &lt;/@layout &gt;
 &lt;script type="text/javascript"&gt;
	var panel = new Panel("panel-container");
	panel.init();
	panel.setHeading(" &lt;h3&gt;这是标题 &lt;/h3&gt;");
	panel.setBody(" &lt;h1&gt;正文标题 &lt;/h1&gt;  &lt;br/&gt; 这是正文 ");
	panel.setFooter("尾注");
 &lt;/script&gt;
    </code>
    </pre>
</div>
</@layout >
<script type="text/javascript">
    PanelInfo = {
        panel : new Panel("panel-container"),
        init : function(){
            this.panel.init();
            this.panel.setHeading("<h3>这是标题</h3>");
            this.panel.setBody("<h1>正文标题</h1> <br/> 这是正文 ");
            this.panel.setFooter("尾注");
        }

    };

</script>

<script>
   $(function(){
       PanelInfo.init();
       hljs.initHighlightingOnLoad();
   });

</script>