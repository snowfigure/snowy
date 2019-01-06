package ink.fdq.snowy.config.route.admin;

import com.jfinal.config.Routes;
import ink.fdq.snowy.controller.admin.page.AdminPageIndexController;

public class AdminPageRoute extends Routes {
    @Override
    public void config() {
        add("/admin/page", AdminPageIndexController.class);
    }
}
