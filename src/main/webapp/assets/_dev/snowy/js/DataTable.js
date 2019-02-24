
/**
 var DataTable = function(id){
    this.id = id;
    this.component_id = {

search_ctn_id : this.random_id + "_simple_search",
    table_ctn_id  : this.random_id + "_table",
    pagination_ctn_id : this.random_id + "_pagination",
    pagination : {
    pageSelect_id :this.id + "_pagination"+ "_pageSelect",
        refresh_id : this.id + "_pagination" + "_refresh",
        pageSizeSelect_id : this.id + "_pagination" + "_pageSizeSelect",
        totalItems_id : this.id + "_pagination" + "_totalItems",
        gotoPage_id : his.id + "_pagination" + "_gotoPage"
    }
};
this.dataTablePara;
};
 */
var DataTable = function(id){
    this.id = id;
    this.component_id = {
        btn_ctn_id : __randomString(32) ,
        search_ctn_id : __randomString(32) ,
        table_ctn_id  : __randomString(32) ,
        pagination_ctn_id : __randomString(32) ,
        pagination : {
            pageSelect_id : __randomString(32) ,
            refresh_id : __randomString(32) ,
            pageSizeSelect_id : __randomString(32) ,
            totalItems_id : __randomString(32) ,
            gotoPage_id : __randomString(32)
        }
    };

    this.dataTablePara;
    this.dataTablePage = {
        totalRow:0,
        pageNumber:1,
        totalPage:0,
        pageSize:10
    };
};

$.extend(DataTable.prototype,{
    init : function(dataTablePara){
        var that = this;
        that.dataTablePara = dataTablePara;
        that.initHtmlFrame();
        that.initTableBodyFrame();
        that.initPaginationBodyFrame();

        that.__loadData();
        that.__fillTableThead();
        that.__fillTableBody();
        that.__fillTablePagination();
        return this;
    },

    initHtmlFrame : function(){

        var that = this;
        var htmlArr = [];

        htmlArr.push(String.format("<div class='col-sm-9' style='padding-left:0' id='{0}'></div>", that.component_id.btn_ctn_id));
        htmlArr.push(String.format("<div class='col-sm-3' style='padding-left:0' id='{0}'></div>", that.component_id.search_ctn_id));
        htmlArr.push(String.format("<div class='col-xs-12' style='padding-left:0' id='{0}'> </div>",that.component_id.table_ctn_id));
        htmlArr.push(String.format("<div class='col-xs-12' style='padding-left:0' id='{0}'> </div>", that.component_id.pagination_ctn_id));

        $("#" + that.id).html(htmlArr.join(""));
    },

    initTableBodyFrame : function(){
        var that = this;
        var htmlArr = [];

        htmlArr.push(String.format("<table class='table table-striped table-bordered table-hover table-condensed' id='{0}'>", that.component_id.table_ctn_id));
        htmlArr.push(String.format("    <thead><tr></tr></thead>"));
        htmlArr.push(String.format("<tbody></tbody>"));
        htmlArr.push(String.format("</table>"));

        $("#" + that.component_id.table_ctn_id).html(htmlArr.join(""));


    },

    __getTableCols : function(configKey){
        var that = this;
        if(__IsEmpty(that.dataTablePara)){
            return undefined;
        }
        var tableCols = that.dataTablePara.tableCols;
        if(__IsEmpty(tableCols)){
            that.dataTablePara.tableCols = undefined;
            return undefined;
        }
        var tableConfig = tableCols[configKey];
        if(__IsEmpty(tableCols)){
            that.dataTablePara.tableCols[configKey] = undefined;
            return undefined;
        }
        return tableConfig;
    },

    __getTableConfig : function(configKey){
        var that = this;
        if(__IsEmpty(that.dataTablePara)){
            return undefined;
        }
        var tableConfig = that.dataTablePara.tableConfig;
        if(__IsEmpty(tableConfig)){
            that.dataTablePara.tableConfig = undefined;
            return undefined;
        }

        var config = tableConfig[configKey];
        if(__IsEmpty(config)){
            that.dataTablePara.tableConfig[configKey] = undefined;
            return undefined;
        }
        return config;
    },

    __isMultiSelect : function(){
        var that = this;
        return __IsTrue(that.__getTableConfig('multiSelect'));
    },
    __isShowSelect : function(){
        var that = this;
        return __IsTrue(that.__getTableConfig('showSelect'));
    },


    __fillTableThead : function(){
        var that = this;
        var theadCols = that.__getTableCols('theadCols');
        if(__IsEmpty((theadCols))){
            return;
        }

        var htmlArr = [];
        var showSelect = __IsTrue(that.__isShowSelect()) ? '' : 'none';
        htmlArr.push(String.format("<th  class='{0}' style='width:30px'></th>", showSelect));

        for(var idx = 0; idx < theadCols.length; idx++){
            var col = theadCols[idx];

            var title = __IsEmpty(col.title) ? col.id : col.title;
            var style = __IsEmpty(col.style) ? "" : col.style;
            var visible = __IsTrue(col.visible) ? "" : "none";

            htmlArr.push(String.format("<th class='{0}' style='{1}'>{2}</th>", visible, style, title));

        }

        $("#" + that.component_id.table_ctn_id + " thead > tr ").html(htmlArr.join(""));
    },

    /**
     * 加载数据
     * @private
     */
    __loadData : function(){
        var that = this;
        var tbodyCols  = that.__getTableCols('tbodyCols');
        if(__IsEmpty((tbodyCols))){
            return;
        }
        if( "url" === tbodyCols.mode){
            var url = tbodyCols.url;
            $.ajax({
                type: "post",
                url: url,
                data : that.dataTablePage,
                cache:false,
                async:false,
                success: function(data){
                    tbodyCols.data = data;
                    that.dataTablePage.totalRow = data.totalRow;
                    that.dataTablePage.pageNumber = data.pageNumber;
                    that.dataTablePage.totalPage = data.totalPage;
                    that.dataTablePage.pageSize = data.pageSize;
                }
            });
        }

    },

    /**
     * 填充数据
     * @private
     */
    __fillTableBody : function(){
        var that = this;
        var htmlArr = [];
        var tbodyCols  = that.__getTableCols('tbodyCols');
        var theadCols = that.__getTableCols('theadCols');
        if(__IsEmpty((tbodyCols)) || __IsEmpty((theadCols)) || __IsEmpty(tbodyCols.data) || __IsEmpty(tbodyCols.data.rows) ){
            return;
        }
        var rows = tbodyCols.data.rows;
        var showSelect = __IsTrue(that.__isShowSelect()) ? '' : 'none';
        var multiSelect = __IsTrue(that.__isMultiSelect()) ? 'checkbox' : 'radio';

        for(var idx = 0; idx < rows.length; idx++){
            var row = rows[idx];
            var randomKey =  __randomString(8);
            var rkValue = __randomString(32);
            row['randomKey'] = randomKey;
            row[randomKey] = rkValue;

            htmlArr.push(String.format("<tr {0}='{1}'>", randomKey, rkValue));
            htmlArr.push(String.format("<td  class='{0}' style='width:30px'><input type='{1}'></td>",showSelect, multiSelect));

            for(var colIdx = 0; colIdx < theadCols.length; colIdx++){
                var headCol = theadCols[colIdx];
                var colValue = row[headCol.id];
                var formatFunc = headCol.formatFunc;
                var style = __IsEmpty(headCol.style) ? "" : headCol.style;
                var visible = __IsTrue(headCol.visible) ? "" : "none";
                colValue = __IsEmpty(formatFunc) ? colValue : formatFunc(row);
                htmlArr.push(String.format("<td  class='{0}' style='{1}'>{2}</td>",visible, style, colValue));
            }

            htmlArr.push("</tr>");
        }

        $("#" + that.component_id.table_ctn_id + " tbody ").html(htmlArr.join(""));
    },

    __getPageSize : function(){
        var that = this;
        var pageSizeSelect_id = "#" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.pageSizeSelect_id;

        var value = $(pageSizeSelect_id + " select").find("option:selected").text();
        return value;
    },
    __reloadDataTable : function(pageSize, pageNumber){
        var that = this;
        that.dataTablePage.pageSize = pageSize;
        that.dataTablePage.pageNumber = pageNumber;

        that.__loadData();
        that.__fillTableThead();
        that.__fillTableBody();
        that.__fillTablePagination();
    },
    /**
     * @Todo 页面处理
     * @private
     */
    ____fillTablePagination__pageSelect : function(){
        var that = this;
        var htmlArr = [];
        var tbodyCols  = that.__getTableCols('tbodyCols');
        if(__IsEmpty((tbodyCols)) || __IsEmpty(tbodyCols.data) ){
            return;
        }

        /* 总页数 */
        var totalPage = tbodyCols.data.totalPage;
        /* 当前页码 */
        var pageNumber = tbodyCols.data.pageNumber;
        /* 每次显示页码个数 */
        var maxShowPage = 5;
        var TP = totalPage;
        var MSP = maxShowPage;

        /* 页码个数的中间值，向上取整*/
        var HMSP = MSP % 2 === 0 ? MSP / 2 : (MSP + 1) / 2;
        var PN = pageNumber;

        /*开始页*/
        var SP = HMSP + 1 <= PN ?  PN - HMSP + 1 : 1;
        SP = SP + MSP <= TP ? SP : TP - MSP + 1;
        /*结束页*/
        var EP = MSP + SP <= TP ? MSP + SP - 1 : TP;

        /*前一页、首页按钮是否可点击*/
        var enablePre = PN === 1 ? 'disabled' : '';
        /*下一页、尾页按钮是否可点击*/
        var enableNext = PN === TP ? 'disabled' : '';

        /*前一页的页码*/
        var prePage = PN === 1 ? '1' : PN - 1;
        /*后一页的页码*/
        var nextPage = PN === TP ? TP : PN + 1;

        /* 页码列表的html组装 */
        htmlArr.push(String.format("<li class='{0}' page='{1}'><a >&lt;&lt;</a></li>", enablePre, "1"));
        htmlArr.push(String.format("<li class='{0}' page='{1}'><a > &lt; </a></li>", enablePre, prePage));
        for(var P = SP; P <= EP ; P++){
            var enableActive = PN === P ? 'active' : '';
            htmlArr.push(String.format("<li class='{0}' page='{1}'><a >{2}</a></li>" , enableActive, P, P));
        }
        htmlArr.push(String.format("<li class='{0}' page='{1}'><a > &gt; </a></li>", enableNext, nextPage));
        htmlArr.push(String.format("<li class='{0}' page='{1}'><a >&gt;&gt;</a></li>", enableNext, totalPage));

        /*指定dom节点下填充html*/
        var id = "#" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.pageSelect_id;
        $(id).html(htmlArr.join(""));

        /*每个 li > a 标签添加一个点击操作*/
        $(id).children('li').each(function(){
            var li_dom = this;
            $(li_dom).children('a').each(function(){
                var a_dom = this;
                $(a_dom).click(function(){
                    /* 获取当前页码*/
                    var pageNumber = $(this).parent().attr('page');
                    /* 获取分页大小*/
                    var pageSize = that.__getPageSize();
                    /* 重新加载数据 */
                    that.__reloadDataTable(pageSize, pageNumber);
                });
            });
        })

    },
    /**
     * @Todo 刷新
     * @private
     */
    ____fillTablePagination__refresh: function(){
        var that = this;
        var htmlArr = [];

        var temp = "<li><span class='glyphicon glyphicon-refresh' style='top: 0'></span></li>";
        htmlArr.push(temp);
        $("#" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.refresh_id).html(htmlArr.join(""));
    },

    /**
     * @Todo 实现分页
     * @private
     */
    ____fillTablePagination__pageSizeSelect: function(){
        var that = this;
        var htmlArr = [];

        var temp =
            "<li><span class='glyphicon glyphicon-list' style='top: 0'></span></li>" +
            "<li>" +
            "<span style='padding: 0;border: 0;'>" +
            "  <select class='form-control' >" +
            "    <option>10</option>" +
            "    <option>20</option>" +
            "    <option>30</option>" +
            "    <option>40</option>" +
            "    <option>50</option>" +
            "  </select>" +
            "</span>" +
            "</li>";

        htmlArr.push(temp);
        var pageSizeSelect_id = "#" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.pageSizeSelect_id;
        $(pageSizeSelect_id).html(htmlArr.join(""));
    },
    ____fillTablePagination__totalItems: function(){
        var that = this;
        var htmlArr = [];
        var tbodyCols  = that.__getTableCols('tbodyCols');
        if(__IsEmpty((tbodyCols)) || __IsEmpty(tbodyCols.data) ){
            return;
        }
        var totalRow = tbodyCols.data.totalRow;
        var totalPage = tbodyCols.data.totalPage;

        var temp = String.format("<li><span>共{0} 条</span></li><li><span>共 {1} 页</span></li>", totalRow, totalPage);
        htmlArr.push(temp);
        $("#" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.totalItems_id).html(htmlArr.join(""));
    },

    /**
     * @Todo 跳转
     * @private
     */
    ____fillTablePagination__gotoPage: function(){
        var that = this;
        var htmlArr = [];

        var temp =
            "<li><span style='padding:6px 3px' >到</span></li>" +
            "<li><span><input type='text' class='form-control' value='1'></span></li>" +
            "<li><span style='padding:6px 3px' >页</span></li>";
        htmlArr.push(temp);
        $("#" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.gotoPage_id).html(htmlArr.join(""));
    },

    __fillTablePagination : function(){
        var that = this;
        that.____fillTablePagination__pageSelect();
        that.____fillTablePagination__refresh();
        that.____fillTablePagination__pageSizeSelect();
        that.____fillTablePagination__totalItems();
        that.____fillTablePagination__totalItems();
        that.____fillTablePagination__gotoPage();
    },

    initPaginationBodyFrame : function(){
        var that = this;
        var htmlArr = [];

        htmlArr.push(String.format("<ul class='pagination pageSelect' id='{0}'></ul>", that.component_id.pagination.pageSelect_id));
        htmlArr.push(String.format("<ul class='pagination pageRefresh' id='{0}'></ul>", that.component_id.pagination.refresh_id));
        htmlArr.push(String.format("<ul class='pagination pageSizeSelect' id='{0}'></ul>", that.component_id.pagination.pageSizeSelect_id));
        htmlArr.push(String.format("<ul class='pagination pageTotalItems' id='{0}'></ul>", that.component_id.pagination.totalItems_id));
        htmlArr.push(String.format("<ul class='pagination pageGotoPage' id='{0}'></ul>", that.component_id.pagination.gotoPage_id));

        $("#" + that.component_id.pagination_ctn_id).html(htmlArr.join(""));
    }
});

