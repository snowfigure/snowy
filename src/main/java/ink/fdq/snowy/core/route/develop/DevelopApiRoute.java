package ink.fdq.snowy.core.route.develop;

import com.jfinal.config.Routes;
import ink.fdq.snowy.develop.controller.api.*;
import ink.fdq.snowy.develop.controller.api.DevelopApiBootstrapController;

public class DevelopApiRoute extends Routes {
    @Override
    public void config() {
        add("/develop/api/menu", DevelopApiMenuController.class);
        add("/develop/api/bootstrap", DevelopApiBootstrapController.class);
    }
}
