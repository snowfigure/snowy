package ink.fdq.snowy.core.route.admin;

import com.jfinal.config.Routes;
import ink.fdq.snowy.portal.controller.page.AdminPageDevToolController;
import ink.fdq.snowy.portal.controller.page.AdminPageIndexController;

public class AdminPageRoute extends Routes {
    @Override
    public void config() {

        add("/admin/page", AdminPageIndexController.class);
        add("/admin/page/devTool", AdminPageDevToolController.class);
    }
}
