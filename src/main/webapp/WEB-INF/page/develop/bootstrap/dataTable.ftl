<#include "/WEB-INF/page/develop/__layout.ftl" />

<@layout >
<div class="row-12">

    <div id="dataTable-container">

    </div>
</div>
<div class="row-12">

    <pre>
        <code class="html">

        </code>
    </pre>
</div>
</@layout >
<script type="text/javascript">
    var dataTable = new DataTable("dataTable-container");
    dataTable.init();
</script>

<script>
    hljs.initHighlightingOnLoad();
</script>