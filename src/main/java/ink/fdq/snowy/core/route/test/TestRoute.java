package ink.fdq.snowy.core.route.test;

import com.jfinal.config.Routes;
import ink.fdq.snowy.develop.controller.TestIndexController;

public class TestRoute extends Routes {
    @Override
    public void config() {
        add("/test/index", TestIndexController.class);
    }
}
