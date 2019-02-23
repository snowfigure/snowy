<#include "/WEB-INF/page/develop/__layout.ftl" />

<@layout >

<div class="row-12">
    <div class='col-xs-9' style=''>
        <button type='button' class='btn btn-sm btn-primary'><span class='glyphicon glyphicon-plus'>  </span></button>
        <button type='button' class='btn btn-sm btn-success'><span class='glyphicon glyphicon-edit'>  </span></button>
        <button type='button' class='btn btn-sm btn-info'><span class='glyphicon glyphicon-exclamation-sign'>  </span></button>
        <button type='button' class='btn btn-sm btn-danger'><span class='glyphicon glyphicon-trash'>  </span></button>
    </div>
    <div class='col-xs-3' style='padding-left:0'>
        <div class='input-group'>
            <input type='text' class='form-control' placeholder='Search rule'>
            <span class='input-group-btn'>
				<button class='btn btn-default' type='button' >
					<span class='glyphicon glyphicon-search'></span>
				</button>
			</span>
        </div>
    </div>
    <div class='col-xs-12' style='padding-left:0'>
        <table class='table table-striped table-bordered table-hover table-condensed'>
            <thead>
            <tr>
                <th>#</th>
                <th>Firstname</th>
                <th>Gender</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Anna</td>
                <td>Male</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Debbie</td>
                <td>Female</td>
            </tr>
            <tr>
                <td>3</td>
                <td>John</td>
                <td>Female</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class='col-xs-12' style='padding-left:0'>

        <ul class='pagination'>
            <li class='disabled'><a href='#'>&lt;&lt;</a></li>
            <li class='disabled'><a href='#'> &lt; </a></li>
            <li class='active'><a href='#'>1</a></li>
            <li><a href='#'>2</a></li>
            <li><a href='#'>3</a></li>
            <li><a href='#'>4</a></li>
            <li><a href='#'>5</a></li>
            <li><a href='#'>6</a></li>
            <li><a href='#'> &gt; </a></li>
            <li><a href='#'>&gt;&gt;</a></li>
        </ul>
        <ul class='pagination'>
            <li><span class='glyphicon glyphicon-refresh' style='top: 0'></span></li>
        </ul>
        <ul class='pagination'>
            <li><span class='glyphicon glyphicon-list' style='top: 0'></span></li>
            <li>
			<span style='padding:0px; border:0;'>
				<select class='form-control' style='width: 45px;height: 34px;padding:1px;box-shadow: none;border: 1px solid #ddd;border-radius: 0px 4px 4px 0'>
				  <option>10</option>
				  <option>20</option>
				  <option>30</option>
				  <option>40</option>
				  <option>50</option>
				</select>
			</span>
            </li>
        </ul>

        <ul class='pagination'>
            <li><span style='border:0' >共 169 条</span></li>
            <li><span style='border:0' >共 17 页</span></li>


        </ul>

        <ul class='pagination'>
            <li><span style='border:0;margin:0;padding:6px 3px' >到</span></li>
            <li><span style='border:0;margin:0;padding:0' ><input type='text' class='form-control' style='width: 30px;height: 30px;padding:1px; text-align: center;' value='1'></span></li>
            <li><span style='border:0;margin:0;padding:6px 3px' >页</span></li>
        </ul>
    </div>
</div>

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