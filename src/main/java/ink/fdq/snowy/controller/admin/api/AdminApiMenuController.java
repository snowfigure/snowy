package ink.fdq.snowy.controller.admin.api;

import ink.fdq.snowy.util.factory.P;
import ink.fdq.snowy.util.jsonBean.Menu;

import java.util.ArrayList;
import java.util.List;

public class AdminApiMenuController extends AdminApiBaseController {

    public void get(){
        Menu adminMenu = new Menu("", "", "");
        List<Menu> mainMenu = new ArrayList<>();
        mainMenu.add(new Menu("menu_nav_index", "主页","glyphicon glyphicon-home"));
        mainMenu.add(new Menu("menu_nav_main", "后台","glyphicon glyphicon-th-large"));
        mainMenu.add(new Menu("menu_nav_new", "新建","glyphicon glyphicon-pencil"));

        List<Menu> manageMenu = new ArrayList<>();
        manageMenu.add(new Menu("menu_nav_sub_manage_article", "文章",""));
        manageMenu.add(new Menu("menu_nav_sub_manage_draft", "草稿",""));
        manageMenu.add(new Menu("menu_nav_sub_manage_comment", "评论",""));
        mainMenu.add(new Menu("menu_nav_manage", "管理","glyphicon glyphicon-briefcase", manageMenu));

        List<Menu> settingMenu = new ArrayList<>();
        settingMenu.add(new Menu("menu_nav_sub_setting_preference", "偏好",""));
        settingMenu.add(new Menu("menu_nav_sub_setting_plugin", "插件",""));
        settingMenu.add(new Menu("menu_nav_sub_setting_others", "其他",""));

        mainMenu.add(new Menu("menu_nav_setting", "设置","glyphicon glyphicon-wrench", settingMenu));

        List<Menu> devToolMenu = new ArrayList<>();
        devToolMenu.add(new Menu("menu_nav_devTool_bootstrap_icon", "Bootstrap ICON", P.SERVER + "/admin/page/devTool/bootstrap_icon"));

        mainMenu.add(new Menu("menu_nav_devTool", "工具","glyphicon glyphicon-console", devToolMenu));



        adminMenu.setSubMenu(mainMenu);
        renderJson(adminMenu);
    }
}
