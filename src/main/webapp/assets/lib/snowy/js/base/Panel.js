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
    this.panel_id = id;
    this.heading_id = id + "_panel_heading";
    this.body_id = id + "_panel_body";
    this.footer_id = id + "_panel_footer";
};

$.extend(Panel.prototype,{
    init : function(){
        return this;
    },

    setHeading : function(html){
        var that = this;
        $("#" + that.panel_id + " #" + that.heading_id).html(html);
    },

    setBody : function(html){
        var that = this;
        $("#" + that.panel_id + " #" +  that.body_id).html(html);
    },

    setFooter : function(html){
        var that = this;
        $("#" + that.panel_id + " #" +  that.footer_id).html(html);
    }


});