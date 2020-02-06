package ink.fdq.snowy.core.route.develop;

import com.jfinal.config.Routes;
import ink.fdq.snowy.develop.controller.api.DevelopApiBaseController;
import ink.fdq.snowy.develop.controller.page.DevelopPageBootstrapController;
import ink.fdq.snowy.develop.controller.page.DevelopPageIndexController;
import ink.fdq.snowy.develop.controller.page.DevelopPageThirdPluginController;

public class DevelopPageRoute extends Routes {
    @Override
    public void config() {
        add("/develop/page", DevelopPageIndexController.class);
        add("/develop/page/bootstrap", DevelopPageBootstrapController.class);
        add("/develop/page/3rdPlugin", DevelopPageThirdPluginController.class);

    }
}
