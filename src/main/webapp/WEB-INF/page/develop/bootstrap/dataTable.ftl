<#include "/WEB-INF/page/develop/__layout.ftl" />

<@layout >

<div class="row-12 col-sm-12">
    <div id="dataTable-container">

    </div>
</div>


<div class="row-12 col-sm-12">

    <pre>
        <code class="html">

        </code>
    </pre>
</div>
</@layout >
<script type="text/javascript">
    function iconValueFormat(row){
        var value = row['value'];
        return String.format("<span class='{0}'></span>", value);
    }
    dataTable = {
        dataTable : new DataTable("dataTable-container"),

        dataTablePara : {
            tableConfig : {
                multiSelect : true,
                showSelect : true,
                primaryKey : 'id'
            },
            tableCols: {
                theadCols: [
                    {id: 'id',   title: '编号',   visible: true, editable: true, style : 'width:120px; max-width:120px'},
                    {id: 'pid',  title: '父编号', visible: false, editable: true, style : 'width:120px; max-width:120px'},
                    {id: 'name', title: '名称',   visible: true, editable: true},
                    {id: 'icon', title: '图标',   visible: true, editable: false, style : 'width:120px; max-width:120px', formatFunc : iconValueFormat},

                    {id: 'value', title: '描述', visible: true, editable: true}
                ],
                tbodyCols : {
                    mode : 'url',
                    url : '${Server}/develop/api/bootstrap/iconPage',
                    data : {
                        totalRow:0,
                        pageNumber:0,
                        totalPage:0,
                        pageSize:0,
                        rows:[{}]
                    }
                }
            },
            btnFunc : {
                create : {func: undefined, class : '' },
                modify : {func: undefined, class : '' },
                delete : {func: undefined, class : '' },
                detail : {func: undefined, class : '' },
            }
        },
        init : function(){
            this.dataTable.init(this.dataTablePara);
        }
    }

</script>

<script>
    $(function(){
        dataTable.init();
        hljs.initHighlightingOnLoad();
    });

</script>