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


var SnowyMenu = function(id, url){
    this.id = id;
    this.url = url;
};

$.extend(SnowyMenu.prototype,{
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
                        menuHtml.push(String.format("<li><div id='{0}'><a href='{1}' class='hover'><span class='{2}'></span> {3}</a></div></li>",
                            main.id, main.url, main.iconClass, main.name));
                    }else{
                        menuHtml.push(String.format("<li><div class='tabs_parent' id='{0}' class=''><span class='{1}'></span> {2} <span class='icon-chevron-down right'></span></div><ul class='none'>",
                            main.id + "_" + i_main, main.iconClass, main.name));
                        var subMenu = main.subMenu;
                        for(var j_main = 0; j_main < subMenu.length; j_main++){
                            var sub = subMenu[j_main];
                            menuHtml.push(String.format("<li><div id='{0}'><a href='{1}'>{2}</a></div></li>", sub.id, sub.url, sub.name));
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
        $("#" + that.id + " ul ").find("li").each(function(){
            $(this).click(function(){

                $(this).find("div").each(function(){
                    if($(this).hasClass("tab-current")){
                        $(this).removeClass("tab-current");
                    }else{
                        $(this).addClass("tab-current");
                    }

                    $(this).find("span").each(function(){
                        if($(this).hasClass("icon-chevron-down")){
                            $(this).removeClass("icon-chevron-down");
                            $(this).addClass("icon-chevron-up");
                            return;
                        }

                        if($(this).hasClass("icon-chevron-up")){
                            $(this).removeClass("icon-chevron-up");
                            $(this).addClass("icon-chevron-down");
                        }
                    });
                });

                $(this).find("ul").each(function(){
                    $(this).parent().find("ul").each(function(){
                        if($(this).hasClass("none")){
                            $(this).removeClass("none");
                            $(this).addClass("display");
                        }else{
                            $(this).removeClass("display");
                            $(this).addClass("none");
                        }
                    });
                });

            });
        });


    }




});