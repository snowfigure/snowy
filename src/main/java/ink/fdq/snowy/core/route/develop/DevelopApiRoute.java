package ink.fdq.snowy.core.route.develop;

import com.jfinal.config.Routes;
import ink.fdq.snowy.develop.controller.api.*;

public class DevelopApiRoute extends Routes {
    @Override
    public void config() {
        add("/develop/api/menu", DevelopApiMenuController.class);
        add("/develop/api/bootstrap", DevelopApiBootstrapController.class);
    }
}
