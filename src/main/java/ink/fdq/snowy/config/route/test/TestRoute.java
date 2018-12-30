package ink.fdq.snowy.config.route.test;

import com.jfinal.config.Routes;
import ink.fdq.snowy.controller.test.TestIndexController;

public class TestRoute extends Routes {
    @Override
    public void config() {
        add("/test/index/", TestIndexController.class);
    }
}
