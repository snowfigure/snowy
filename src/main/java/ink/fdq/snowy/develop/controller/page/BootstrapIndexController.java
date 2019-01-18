package ink.fdq.snowy.develop.controller.page;

import ink.fdq.snowy.core.base.BaseController;
import ink.fdq.snowy.core.factory.P;
import ink.fdq.snowy.core.factory.S;

import java.util.HashMap;
import java.util.Map;

public class BootstrapIndexController extends BaseController {
    public void icon(){
        render("/WEB-INF/page/develop/Bootstrap/icon.ftl");
    }

    public void panel(){
        render("/WEB-INF/page/develop/Bootstrap/panel.ftl");
    }

}
