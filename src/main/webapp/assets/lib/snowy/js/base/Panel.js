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