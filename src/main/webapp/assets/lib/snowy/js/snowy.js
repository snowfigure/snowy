String.prototype.format = function(args) {
    var result = this;
    if (arguments.length > 0) {
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                if (args[key] != undefined) {
                    var reg = new RegExp("({" + key + "})", "g");
                    result = result.replace(reg, args[key]);
                }
            }
        }
        else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] != undefined) {
                    var reg = new RegExp("({)" + i + "(})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
    }
    return result;
};
String.format = function () {
    if (arguments.length == 0)
        return null;

    var str = arguments[0];
    for (var i = 1; i < arguments.length; i++) {
        var re = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
        str = str.replace(re, arguments[i]);
    }
    return str;
};

window.console = window.console || (function () {
    var c = {}; c.log = c.warn = c.debug = c.info = c.error = c.time = c.dir = c.profile
        = c.clear = c.exception = c.trace = c.assert = function () { };
    return c;
})();

var __IsEmpty = function(object){
    if(object === undefined){
        return true;
    }

    if(object === null){
        return true;
    }

    if(object === ""){
        return true;
    }

    if(object.length === 0){
        return true;
    }

    return false;
};

var __IsTrue = function(object){
    if(__IsEmpty(object)){
        return false;
    }
    if(true === object){
        return true;
    }

    return false;
};

var __IsFalse = function(object){
    if(__IsEmpty(object)){
        return true;
    }
    if(false === object){
        return true;
    }

    return false;
};

var __randomString = function(length){
    length = length || 32;
    var $chars = '_ABCD_EFGH_IJKLMN_OPQRSTUVWX_YZabcdefgh_ijklmnopqrstu_vwxyz01234_56789';
    var maxPos = $chars.length;
    var string = '';
    for (var idx = 0; idx < length; idx++) {
        string += $chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return string;
};
var xMode = {
    primary : "primary",
    success :　"success",
    info : "info",
    warning : "warning",
    danger : "danger"
};

var xDisplay = {
    block : "block",
    none : "none"
};
var FormGroup = function(id){
    this.id = id;
};

$.extend(FormGroup.prototype,{
    init : function(){
        return this;
    }
});
var Modal = function(id){
    this.id = id;
};

$.extend(Modal.prototype,{
    init : function(){
        return this;
    }
});
/**
 * Panel 构成要素
 *  panel_title
 *  panel_heading
 *  panel_body
 *  panel_footer
 *
 *      <div class="panel" id="panel_id">
 *          <div class="panel-heading" id="heading_id">
 *          </div>
 *          <div class="panel-body" id="body_id">
 *          </div>
 *          <div class="panel-footer" id="footer_id">
 *          </div>
 *      </div>
 *
 *
 */

var Panel = function(id){
    this.id = {
        panel_id : id,
        heading_id : id + "_panel_heading",
        body_id : id + "_panel_body",
        footer_id : id + "_panel_footer"
    };

    this.class = {
        xMode : "panel-default",
        display : {
            panel : "block",
            heading : "block",
            body : "block",
            footer : "block"
        }
    };

};

$.extend(Panel.prototype,{
    init : function(){
        var that = this;
        that.create(that);
        return that;
    },

    /**
     * 主题模式，取值范围见 Common.js中 xMode 定义
     * @param xMode
     */
    setContextual : function(xMode){
        var that = this;
        that.class.xMode = "panel-" + xMode;
        return that;

    },
    /**
     * 设置标题区域内Html
     * @param html
     */
    setHeading : function(html){
        var that = this;
        $("#" + that.id.panel_id + " #" + that.id.heading_id).html(html);
        return that;
    },

    /**
     * 设置Body区域内Html
     * @param html
     */
    setBody : function(html){
        var that = this;
        $("#" + that.id.panel_id + " #" +  that.id.body_id).html(html);
        return that;
    },

    /**
     * 设置Footer区域Html
     * @param html
     */
    setFooter : function(html){
        var that = this;
        $("#" + that.id.panel_id + " #" +  that.id.footer_id).html(html);
        return that;
    },

    __setHide: function(id , para,  hide){
        if(__IsTrue(hide)){
            para = xDisplay.none;
            $(id).removeClass(xDisplay.block);
            $(id).addClass(xDisplay.none);
        }else{
            para = xDisplay.block;
            $(id).removeClass(xDisplay.none);
            $(id).addClass(xDisplay.block);
        }
    },
    hidePanel : function(){
        var that = this;
        that.__setHide("#" + that.id.panel_id, that.class.display.panel, true);
    },
    hideHeading : function(){
        var that = this;
        that.__setHide("#" + that.id.panel_id + " #" + that.id.heading_id, that.class.display.panel, true);
    },
    hideBody : function(){
        var that = this;
        that.__setHide("#" + that.id.panel_id + " #" + that.id.body_id, that.class.display.panel, true);
    },
    hideFooter : function(){
        var that = this;
        that.__setHide("#" + that.id.panel_id + " #" + that.id.footer_id, that.class.display.panel, true);
    },

    showPanel : function(){
        var that = this;
        that.__setHide("#" + that.id.panel_id, that.class.display.panel, false);
    },
    showHeading : function(){
        var that = this;
        that.__setHide("#" + that.id.panel_id + " #" + that.id.heading_id, that.class.display.panel, false);
    },
    showBody : function(){
        var that = this;
        that.__setHide("#" + that.id.panel_id + " #" + that.id.body_id, that.class.display.panel, false);
    },
    showFooter : function(){
        var that = this;
        that.__setHide("#" + that.id.panel_id + " #" + that.id.footer_id, that.class.display.panel, false);
    },


    /**
     * 创建Html区域
     * @param that
     */
    create : function(that){
        var htmlArr = [];
        htmlArr.push(String.format("<div class='panel {0} {1}' id='{2}'>", that.class.xMode, that.class.display.heading, that.id.panel_id ));
        htmlArr.push(String.format("  <div class='panel-heading {0}' id='{1}'>", that.class.display.heading, that.id.heading_id));
        htmlArr.push(String.format("  </div>"));
        htmlArr.push(String.format("  <div class='panel-body {0}' id='{1}'>", that.class.display.body, that.id.body_id));
        htmlArr.push(String.format("  </div>"));
        htmlArr.push(String.format("   <div class='panel-footer {0}' id='{1}'>", that.class.display.footer, that.id.footer_id));
        htmlArr.push(String.format("   </div>"));
        htmlArr.push(String.format("</div>"));

        $("#" + that.id.panel_id).html(htmlArr.join(""));
    }


});

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
        htmlArr.push("<div>");
        htmlArr.push(String.format("<div class='col-sm-9' style='padding-left:0' id='{0}'></div>", that.component_id.btn_ctn_id));
        htmlArr.push(String.format("<div class='col-sm-3' style='padding-left:0' id='{0}'></div>", that.component_id.search_ctn_id));
        htmlArr.push(String.format("<div class='col-xs-12' style='padding-left:0;overflow-x: scroll;' id='{0}'> </div>",that.component_id.table_ctn_id));
        htmlArr.push(String.format("<div class='col-xs-12' style='padding-left:0' id='{0}'> </div>", that.component_id.pagination_ctn_id));
        htmlArr.push("</div>");
        $("#" + that.id).html(htmlArr.join(""));
    },

    initTableBodyFrame : function(){
        var that = this;
        var htmlArr = [];

        htmlArr.push(String.format("<table class='table table-striped table-bordered table-hover table-condensed' id='{0}'>", that.component_id.table_ctn_id));
        htmlArr.push(String.format("    <thead><tr></tr></thead>"));
        htmlArr.push(String.format("<tbody></tbody>"));
        htmlArr.push(String.format("</table>"));

        $("#" + that.id + " #" + that.component_id.table_ctn_id).html(htmlArr.join(""));


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

        $("#" + that.id + " #" + that.component_id.table_ctn_id + " thead > tr ").html(htmlArr.join(""));
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

        $("#" + that.id + " #" + that.component_id.table_ctn_id + " tbody ").html(htmlArr.join(""));
    },

    __getPageSize : function(){
        var that = this;
        var pageSizeSelect_id = "#" + that.id + " #" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.pageSizeSelect_id;

        var value = $(pageSizeSelect_id + " select").find("option:selected").text();
        return value;
    },

    ____reloadStart : function(that){
        var id = "#" + that.id + " #" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.refresh_id;
        $(id + "  span").removeClass("glyphicon glyphicon-refresh ");
        $(id + "  img").removeClass("none");
    },
    ____reloadStop : function(that){
        var id = "#" + that.id + " #" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.refresh_id;
        $(id + "  span").addClass("glyphicon glyphicon-refresh");
        $(id + "  img").addClass("none");
    },

    __reloadDataTable : function(pageSize, pageNumber){
        var that = this;
        that.dataTablePage.pageSize = pageSize;
        that.dataTablePage.pageNumber = pageNumber;
        that.__loadData();
        that.__fillTablePagination();

        that.____reloadStart(that);
        setTimeout(function(){

            that.__fillTableThead();
            that.__fillTableBody();
            that.____reloadStop(that);
        }, 100);

        

    },

    ___pageNumBindClick : function(that,id){
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
        });
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
        var id = "#" + that.id + " #" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.pageSelect_id;
        $(id).html(htmlArr.join(""));

        that.___pageNumBindClick(that, id);

    },

    ___pageNumBindClick : function(that,id){
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
        });
    },
    /**
     * @Todo 刷新
     * @private
     */
    ____fillTablePagination__refresh: function(){
        var that = this;
        var htmlArr = [];
        var tbodyCols  = that.__getTableCols('tbodyCols');
        if(__IsEmpty((tbodyCols)) || __IsEmpty(tbodyCols.data) ){
            return;
        }
        /* 当前页码 */
        var pageNumber = tbodyCols.data.pageNumber;

        var temp = String.format("<li page='{0}'><a><span class='glyphicon glyphicon-refresh' style='top: 0'><img src='/assets/images/loading/5-121204193949.gif' class='none'></span></a></li>", pageNumber);
        htmlArr.push(temp);
        var id = "#" + that.id + " #" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.refresh_id;
        $(id).html(htmlArr.join(""));
        that.___pageNumBindClick(that, id);
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
        var pageSizeSelect_id = "#" + that.id + " #" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.pageSizeSelect_id;
        $(pageSizeSelect_id).html(htmlArr.join(""));

        var tbodyCols  = that.__getTableCols('tbodyCols');
        if(__IsEmpty((tbodyCols)) || __IsEmpty(tbodyCols.data) ){
            return;
        }

        var pageSize = tbodyCols.data.pageSize;
        $(pageSizeSelect_id + " select").val(pageSize);
        $(pageSizeSelect_id + " select").change(function(){
            var pageNumber = 1;
            var pageSize = $(this).val();
            /* 重新加载数据 */
            that.__reloadDataTable(pageSize, pageNumber);
        });
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
        $("#" + that.id + " #" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.totalItems_id).html(htmlArr.join(""));
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
        var id = "#" + that.id + " #" + that.component_id.pagination_ctn_id + " #" + that.component_id.pagination.gotoPage_id;
        $(id).html(htmlArr.join(""));

        var tbodyCols  = that.__getTableCols('tbodyCols');
        if(__IsEmpty((tbodyCols)) || __IsEmpty(tbodyCols.data) ){
            return;
        }

        $(id + " input").val(tbodyCols.data.pageNumber);
        $(id + " input").bind('keypress',function(event){
            if(event.keyCode == "13"){
                var pageNumber = parseInt($(this).val());
                if(isNaN(pageNumber) || pageNumber+ "" !== $(this).val()){
                    $(this).val(tbodyCols.data.pageNumber);
                    return;
                }
                if(pageNumber > tbodyCols.data.totalPage){
                    pageNumber = tbodyCols.data.totalPage;
                    $(this).val(pageNumber);
                }
                if(pageNumber <=0 ){
                    pageNumber = 1;
                    $(this).val(pageNumber);
                }
                var pageSize = that.__getPageSize();
                /* 重新加载数据 */
                that.__reloadDataTable(pageSize, pageNumber);
            }
        });
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

        $("#" + that.id + " #" + that.component_id.pagination_ctn_id).html(htmlArr.join(""));
    }
});


/**
 *  JSON 定义
 * {
 *  "name":"","id":"","url":"","iconClass":"",
 *  "subMenu":
 *  [
 *      {"subMenu":[],"name":"主页","id":"tabs_index","url":"","iconClass":"icon-play"},
 *      {"subMenu":[],"name":"后台","id":"tabs_main","url":"","iconClass":"icon-refresh"},
 *      {"subMenu":[],"name":"新建","id":"tabs_new","url":"","iconClass":"icon-edit"},
 *      {"subMenu":[
 *              {"subMenu":[],"name":"文章","id":"tabs_manage_article","url":"","iconClass":""},
 *              {"subMenu":[],"name":"草稿","id":"tabs_manage_draft","url":"","iconClass":""},
 *              {"subMenu":[],"name":"评论","id":"tabs_manage_comment","url":"","iconClass":""}],"name":"管理","id":"tabs_manage","url":"","iconClass":"icon-article"},
 *      {"subMenu":[
 *              {"subMenu":[],"name":"偏好","id":"tabs_setting_preference","url":"","iconClass":""},
 *              {"subMenu":[],"name":"插件","id":"tabs_setting_plugin","url":"","iconClass":""},
 *              {"subMenu":[],"name":"其他","id":"tabs_setting_others","url":"","iconClass":""}],"name":"工具","id":"tabs_setting","url":"","iconClass":"icon-setting"}
 *    ]
 * }
 *
 * Java Bean
 * public class Menu {
    private String id;
    private String name;
    private String iconClass;
    private String url;
    private List<Menu> subMenu;
}
 */


var NavBar = function(id, url){
    this.id = id;
    this.nav_bar_header_id = this.id + "-header";
    this.nav_bar_menu_id = this.id + "-menu";
    this.nav_bar_footer_id = this.id + "-footer";
    this.url = url;
    this.invalid_id = "__nav_bar_ignore_id__";
};

$.extend(NavBar.prototype,{
    init : function(){
        var that = this;
        that.initHtmlFrame(that);
        /** 初始化HTML*/
        that.initHtml(that);

    },

    initHtmlFrame : function(that){
        var htmlArr = [];

        htmlArr.push(String.format("<div id='{0}'></div>", that.nav_bar_header_id));
        htmlArr.push(String.format("<div id='{0}'></div>", that.nav_bar_menu_id));
        htmlArr.push(String.format("<div id='{0}'></div>", that.nav_bar_footer_id));

        var html = htmlArr.join("");
        $("#" + that.id).html(html);
    },
    /**
     * 初始化html
     */
    initHtml : function(that){
        $.ajax({
            type:"POST",
            url : that.url,
            async:false,
            cache : false,
            dataType : "json",
            success: function (data) {
                var menuHtml=[];
                if(__IsEmpty(data) || __IsEmpty(data.subMenu)){
                    return;
                }

                menuHtml.push("<ul>");
                var mainMenu = data.subMenu;
                that.parents_id = [];
                for(var i_main = 0; i_main < mainMenu.length; i_main++){
                    var main = mainMenu[i_main];
                    if(__IsEmpty(main.subMenu)){
                        menuHtml.push(String.format("<li id='{0}'><div><a href='{1}' class='hover'><span class='nav-bar-left-span {2}'></span> {3}</a></div></li>",
                            main.id, main.url, main.iconClass, main.name));
                    }else{
                        menuHtml.push(String.format("<li id='{0}'><div class='nav-bar-parent' class=''><span class='nav-bar-left-span {1}'></span> {2} <span class='nav-bar-right-span glyphicon glyphicon-chevron-down'></span></div><ul class='sub-nav-bar none'>",
                            main.id , main.iconClass, main.name));
                        var subMenu = main.subMenu;
                        for(var j_main = 0; j_main < subMenu.length; j_main++){
                            var sub = subMenu[j_main];
                            menuHtml.push(String.format("<li id='{0}'><div><a href='{1}'>{2}</a></div></li>", sub.id, sub.url, sub.name));
                        }

                        menuHtml.push("</ul></li>");

                    }

                }

                menuHtml.push("</ul>");
                var html = menuHtml.join("");
                $("#" + that.nav_bar_menu_id).html(html);

                /** 绑定点击操作*/
                that._bindTabsClick(that);
            }
        });
    },

    __clickNodeChange : function(click_node){
        /***  点击的li添加选中项 **/
        click_node.children("div").each(function(){
            $(this).hasClass("nav-bar-current") ? $(this).removeClass("nav-bar-current") : $(this).addClass("nav-bar-current");

            $(this).children(".glyphicon").each(function(){
                if($(this).hasClass("glyphicon-chevron-up")){
                    $(this).removeClass("glyphicon-chevron-up");
                    $(this).addClass("glyphicon-chevron-down");
                }else if($(this).hasClass("glyphicon-chevron-down")){
                    $(this).removeClass("glyphicon-chevron-down");
                    $(this).addClass("glyphicon-chevron-up");
                }

            });
        });

        click_node.children("ul").each(function(){
            if($(this).hasClass("display")){
                $(this).slideUp(function(){
                    $(this).removeClass("display");
                    $(this).addClass("none");
                });

            }else{
                $(this).slideDown(function(){
                    $(this).removeClass("none");
                    $(this).addClass("display");
                });

            }

        });/*** this.children ul each end **/
    },

    __brotherNodeChange:function(brother_node){
        /** Start 关闭父节点所有的选中属性 ***/
        brother_node.children("ul").each(function(){
            $(this).slideUp(function(){
                $(this).removeClass("display");
                $(this).addClass("none");
            });

        });/*** this.children ul each end **/

        /*去除所有的 nav-bar-current*/
        brother_node.children("div").each(function(){
            $(this).removeClass("nav-bar-current");

            $(this).children(".glyphicon").each(function(){
                $(this).removeClass("glyphicon-chevron-down");
                $(this).removeClass("glyphicon-chevron-up");
                $(this).addClass("glyphicon-chevron-down");
            });

        });/*** END this.children div each end **/
        /*** END 关闭父节点所有的选中属性 **/
    },

    _bindTabsClick : function(that){

        $("#" + that.nav_bar_menu_id + " ul").children("li").each(function(){
            $(this).click(function(){
                var click_node_this = this;
                var click_node = $(click_node_this);

                click_node.parent("ul").children("li").each(function(){
                    var brother_node_this = this;
                    var brother_node = $(brother_node_this);

                    if(click_node_this === brother_node_this){
                        that.__clickNodeChange(click_node);
                    }else{
                        that.__brotherNodeChange(brother_node);
                    }

                });

            });
            /*** Click function End**/
        });

    },

    selectMenu : function(that, nav_id, nav_pid){
        if(that.invalid_id === nav_pid){
            var node_this    = "#" + that.nav_bar_menu_id + " #" + nav_id + " > div";
            $(node_this).addClass("nav-bar-current");

        }else{
            var node_p_this    = "#" + that.nav_bar_menu_id + " #" + nav_pid + " > div";
            var node_this    = "#" + that.nav_bar_menu_id + " #" + nav_id + " > div";
            var node_ul_this = "#" + that.nav_bar_menu_id + " #" + nav_pid + " > ul";
            $(node_p_this).addClass("nav-bar-current");
            $(node_this).addClass("sub-nav-bar-current");

            $(node_ul_this).slideDown(function(){
                $(this).removeClass("none");
                $(this).addClass("display");
            });
        }


    }




});
var Tree = function(id){
    this.id = id;
};

$.extend(Tree.prototype,{
    init : function(){
        return this;
    }
});