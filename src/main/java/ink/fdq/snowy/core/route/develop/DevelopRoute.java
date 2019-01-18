package ink.fdq.snowy.core.route.develop;

import com.jfinal.config.Routes;
import ink.fdq.snowy.develop.controller.page.BootstrapIndexController;

public class DevelopRoute extends Routes {
    @Override
    public void config() {
        add("/develop/bootstrap", BootstrapIndexController.class);
    }
}
