package ink.fdq.snowy.core.route.develop;

import com.jfinal.config.Routes;
import ink.fdq.snowy.develop.controller.api.DevelopApiBaseController;

public class DevelopApiRoute extends Routes {
    @Override
    public void config() {
        add("/develop/api/menu", DevelopApiBaseController.class);
    }
}
