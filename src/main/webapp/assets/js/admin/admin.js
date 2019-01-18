
var SnowyAdmin = function(server){
    this.server = server;
    this.menu = undefined;
};

$.extend(SnowyAdmin.prototype,{

    /**
     * 设置菜单
     * @param id    菜单的tab标签id（必须唯一）
     * @param url   菜单加载使用的URL（必须JSON格式）
     * @returns {Snowy}
     */
    setMenu : function(id,url){
        var that = this;
        that.menu = new NavBar(id,url);
        return that;
    },

    /**
     * 初始化菜单
     * @returns {Snowy}
     */
    initMenu : function(){
        var that = this;
        that.menu.init();
        return that;
    }
});