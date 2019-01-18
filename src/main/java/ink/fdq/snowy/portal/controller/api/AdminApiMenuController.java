package ink.fdq.snowy.portal.controller.api;

import com.jfinal.aop.Inject;
import ink.fdq.snowy.portal.service.AdminMenuService;

public class AdminApiMenuController extends AdminApiBaseController {

    @Inject
    private AdminMenuService adminMenuService;

    public void get(){

        renderJson(adminMenuService.getAdminMenu());
    }
}
