package ink.fdq.snowy.controller.admin.api;

import com.jfinal.aop.Inject;
import ink.fdq.snowy.service.SysRescService;
import ink.fdq.snowy.util.factory.P;
import ink.fdq.snowy.util.jsonBean.Menu;

import java.util.ArrayList;
import java.util.List;

public class AdminApiMenuController extends AdminApiBaseController {

    @Inject
    private SysRescService sysRescService;

    public void get(){

        renderJson(sysRescService.getAdminMenu());
    }
}
