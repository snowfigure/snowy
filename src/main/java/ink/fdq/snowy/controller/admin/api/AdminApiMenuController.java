package ink.fdq.snowy.controller.admin.api;

import ink.fdq.snowy.util.jsonBean.Menu;

import java.util.ArrayList;
import java.util.List;

public class AdminApiMenuController extends AdminApiBaseController {

    public void get(){
        Menu adminMenu = new Menu("", "", "");
        List<Menu> mainMenu = new ArrayList<>();
        mainMenu.add(new Menu("tabs_index", "主页","icon-play"));
        mainMenu.add(new Menu("tabs_main", "后台","icon-refresh"));
        mainMenu.add(new Menu("tabs_new", "新建","icon-edit"));

        List<Menu> manageMenu = new ArrayList<>();
        manageMenu.add(new Menu("tabs_manage_article", "文章",""));
        manageMenu.add(new Menu("tabs_manage_draft", "草稿",""));
        manageMenu.add(new Menu("tabs_manage_comment", "评论",""));
        mainMenu.add(new Menu("tabs_manage", "管理","icon-article", manageMenu));

        List<Menu> settingMenu = new ArrayList<>();
        settingMenu.add(new Menu("tabs_setting_preference", "偏好",""));
        settingMenu.add(new Menu("tabs_setting_plugin", "插件",""));
        settingMenu.add(new Menu("tabs_setting_others", "其他",""));

        mainMenu.add(new Menu("tabs_setting", "工具","icon-setting", settingMenu));


        adminMenu.setSubMenu(mainMenu);
        renderJson(adminMenu);
    }
}
