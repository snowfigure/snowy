package ink.fdq.snowy.portal.controller.api;

import com.jfinal.aop.Inject;
import com.jfinal.plugin.ehcache.CacheKit;
import ink.fdq.snowy.core.vo.json.Menu;
import ink.fdq.snowy.portal.service.AdminMenuService;

public class AdminApiMenuController extends AdminApiBaseController {

    @Inject
    private AdminMenuService adminMenuService;

    public void get(){
        Menu menu = CacheKit.get("systemMenu", "admin_menu_get");
        if(menu == null){
            menu = adminMenuService.getAdminMenu();
            CacheKit.put("systemMenu", "admin_menu_get", menu);
        }
        renderJson(menu);
    }
}
