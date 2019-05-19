<#include "/WEB-INF/page/easyui/__layout.ftl" />

<@layout >
    <div data-options="region:'north'" style="height:80px"></div>
    <div data-options="region:'south',split:true" style="height:30px;"></div>

    <div data-options="region:'west',split:true" title="菜单" style="width:200px;">
        <div id="LeftMenu" style="">
        </div>
    </div>

    <div data-options="region:'center',iconCls:'icon-ok'" title="信用卡进件管理" >
        <div class="easyui-tabs" data-options="fit:true">

            <div title="进件跟踪" style="padding:1px">
                <div class="easyui-layout" data-options="fit:true">
                    <div data-options="region:'west',split:true" title="搜索" style="width:260px"></div>
                    <div data-options="region:'east',split:true" title="详情" style="width:260px;"></div>
                    <div data-options="region:'center' " title="信用卡进件数据"></div>
                </div>
            </div>

            <div title="分行预审" style="padding:1px">
                <div class="easyui-layout" data-options="fit:true">
                    <div data-options="region:'west',split:true" title="搜索" style="width:260px"></div>
                    <div data-options="region:'east',split:true" title="预审" style="width:260px;"></div>
                    <div data-options="region:'center' " title="信用卡进件审核 - 分行预审"></div>
                </div>
            </div>

            <div title="主任预审" style="padding:1px">
                <div class="easyui-layout" data-options="fit:true">
                    <div data-options="region:'west',split:true" title="搜索" style="width:260px"></div>
                    <div data-options="region:'east',split:true" title="预审" style="width:260px;"></div>
                    <div data-options="region:'center' " title="信用卡进件审核 - 主任预审"></div>
                </div>
            </div>

            <div title="进件统计" style="padding:1px">

            </div>

        </div>


    </div>
</@layout >

<script type="text/javascript">
    $(function () {
        $('#LeftMenu').sidemenu({
            data: [{
                text: 'Item1',
                iconCls: 'icon-sum',
                state: 'open',
                children: [{
                    text: 'Option1',
                    iconCls : 'icon-search'
                }, {
                    text: 'Option2',
                    iconCls : 'icon-search'
                }, {
                    text: 'Option3',
                    iconCls: 'icon-search',
                    children: [{
                        text: 'Option31',
                        iconCls: 'icon-search'
                    }, {
                        text: 'Option32',
                        iconCls: 'icon-search'
                    }]
                }]
            }, {
                text: 'Item2',
                iconCls: 'icon-more',
                children: [{
                    text: 'Option4',
                    iconCls: 'icon-search'
                }, {
                    text: 'Option5',
                    iconCls: 'icon-search'
                }, {
                    text: 'Option6',
                    iconCls: 'icon-search'
                }]
            }],
            border: false
        });
    });
</script>