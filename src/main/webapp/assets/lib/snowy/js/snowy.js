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
var DataTable = function(id){
    this.id = id;
};

$.extend(DataTable.prototype,{
    init : function(){
        return this;
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
    this.url = url;
};

$.extend(NavBar.prototype,{
    init : function(){
        var that = this;
        /** 初始化HTML*/
        that.initHtml(that);

    },

    /**
     * 初始化html
     */
    initHtml : function(that){
        $.ajax({
            type:"POST",
            url : that.url,
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
                        menuHtml.push(String.format("<li><div class='nav-bar-parent' id='{0}' class=''><span class='nav-bar-left-span {1}'></span> {2} <span class='nav-bar-right-span glyphicon glyphicon-chevron-down'></span></div><ul class='sub-nav-bar none'>",
                            main.id + "_" + i_main, main.iconClass, main.name));
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
                $("#" + that.id).html(html);

                /** 绑定点击操作*/
                that.bindTabsClick(that);
            }
        });
    },

    bindTabsClick : function(that){

        $("#" + that.id + " ul").children("li").each(function(){
            $(this).click(function(){
                var that = this;
                $(this).parent("ul").children("li").each(function(){
                    if(that === this){
                        /***  点击的li添加选中项 **/
                        $(this).children("div").each(function(){
                            $(this).hasClass("nav-bar-current") ? $(this).removeClass("nav-bar-current") : $(this).addClass("nav-bar-current");

                            $(this).children(".glyphicon").each(function(){
                                if($(this).hasClass("glyphicon-chevron-up")){
                                    $(this).removeClass("glyphicon-chevron-up");
                                    $(this).addClass("glyphicon-chevron-down");
                                }else{
                                    $(this).removeClass("glyphicon-chevron-down");
                                    $(this).addClass("glyphicon-chevron-up");
                                }

                            });
                        });

                        $(this).children("ul").each(function(){
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

                    }else{
                        /** Start 关闭父节点所有的选中属性 ***/
                        $(this).children("ul").each(function(){
                            $(this).slideUp(function(){
                                $(this).removeClass("display");
                                $(this).addClass("none");
                            });

                        });/*** this.children ul each end **/

                        /*去除所有的 nav-bar-current*/
                        $(this).children("div").each(function(){
                            $(this).removeClass("nav-bar-current");

                            $(this).children(".glyphicon").each(function(){
                                $(this).removeClass("glyphicon-chevron-down");
                                $(this).removeClass("glyphicon-chevron-up");
                                $(this).addClass("glyphicon-chevron-down");
                            });

                        });/*** END this.children div each end **/
                        /*** END 关闭父节点所有的选中属性 **/
                    }

                });

            });
            /*** Click function End**/


        });

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