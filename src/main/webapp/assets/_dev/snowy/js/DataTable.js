var DataTable = function(id){
    this.id = id;

    this.component_id = {
        btn_ctn_id : this.id + "_btn_s",
        search_ctn_id : this.id + "_simple_search",
        table_ctn_id  : this.id + "_table",
        pagination_ctn_id : this.id + "_pagination",
        pagination : {
            pageSelect_id : this.id + "_pagination"+ "_pageSelect",
            refresh_id : this.id + "_pagination" + "_refresh",
            pageSizeSelect_id : this.id + "_pagination" + "_pageSizeSelect",
            totalItems_id : this.id + "_pagination" + "_totalItems",
            gotoPage_id : this.id + "_pagination" + "_gotoPage"
        }
    };
};

$.extend(DataTable.prototype,{
    init : function(){
        var that = this;
        that.initHtmlFrame();
        that.initTableBodyFrame();
        that.initPaginationBodyFrame();
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

    initPaginationBodyFrame : function(){
        var that = this;
        var htmlArr = [];

        htmlArr.push(String.format("<ul class='pagination' id='{0}'></ul>", that.component_id.pagination.pageSelect_id));
        htmlArr.push(String.format("<ul class='pagination' id='{0}'></ul>", that.component_id.pagination.refresh_id));
        htmlArr.push(String.format("<ul class='pagination' id='{0}'></ul>", that.component_id.pagination.pageSizeSelect_id));
        htmlArr.push(String.format("<ul class='pagination' id='{0}'></ul>", that.component_id.pagination.totalItems_id));
        htmlArr.push(String.format("<ul class='pagination' id='{0}'></ul>", that.component_id.pagination.gotoPage_id));

        $("#" + that.component_id.pagination_ctn_id).html(htmlArr.join(""));
    }
});

