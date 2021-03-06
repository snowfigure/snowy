<script src="${Server}/assets/lib/jquery/1.12.4/jquery.${dev_min_mode}js"></script>
<script src="${Server}/assets/lib/bootstrap/3.3.7/js/bootstrap.${dev_min_mode}js"></script>

<!--[if lte IE 6]>
<script type="text/javascript" src="${Server}/assets/lib/bsie/js/bootstrap-ie.js"></script>
<![endif]-->

<script src="${Server}/assets/lib/highlight/highlight.pack.js?${ResVersion}"></script>

<#if dev_mode>
<script src="${Server}/assets/_dev/snowy/js/global.js?${ResVersion}"></script>
<script src="${Server}/assets/_dev/snowy/js/base/Common.js?${ResVersion}"></script>
<script src="${Server}/assets/_dev/snowy/js/base/FormGroup.js?${ResVersion}"></script>
<script src="${Server}/assets/_dev/snowy/js/base/Modal.js?${ResVersion}"></script>
<script src="${Server}/assets/_dev/snowy/js/base/Panel.js?${ResVersion}"></script>

<script src="${Server}/assets/_dev/snowy/js/DataTable.js?${ResVersion}"></script>
<script src="${Server}/assets/_dev/snowy/js/Tree.js?${ResVersion}"></script>
<script src="${Server}/assets/_dev/snowy/js/NavBar.js?${ResVersion}"></script>
<script src="${Server}/assets/js/admin/admin.js?${ResVersion}"></script>

<#else>
<script src="${Server}/assets/lib/snowy/js/snowy.${dev_min_mode}js?${ResVersion}"></script>
<script src="${Server}/assets/js/admin/admin.js?${ResVersion}"></script>
</#if>