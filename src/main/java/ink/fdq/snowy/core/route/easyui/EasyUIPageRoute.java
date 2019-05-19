package ink.fdq.snowy.core.route.easyui;

import com.jfinal.config.Routes;
import ink.fdq.snowy.easyui.controller.page.EasyUIPageIndexController;

public class EasyUIPageRoute extends Routes {
    @Override
    public void config() {
        add("/easyui/page", EasyUIPageIndexController.class);
    }
}
