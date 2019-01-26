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