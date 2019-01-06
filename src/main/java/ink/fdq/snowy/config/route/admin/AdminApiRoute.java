package ink.fdq.snowy.config.route.admin;

import com.jfinal.config.Routes;
import ink.fdq.snowy.controller.admin.api.AdminApiMenuController;

public class AdminApiRoute extends Routes {
    @Override
    public void config() {
        add("/admin/api/menu", AdminApiMenuController.class);
    }
}
