package ink.fdq.snowy.core.route.admin;

import com.jfinal.config.Routes;
import ink.fdq.snowy.portal.controller.api.AdminApiMenuController;

public class AdminApiRoute extends Routes {
    @Override
    public void config() {
        add("/admin/api/menu", AdminApiMenuController.class);
    }
}
