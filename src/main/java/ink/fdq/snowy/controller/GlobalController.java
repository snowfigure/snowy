package ink.fdq.snowy.controller;

import com.jfinal.core.Controller;
import ink.fdq.snowy.util.factory.P;
import ink.fdq.snowy.util.factory.S;

public class GlobalController extends Controller {

    @Override
    public void render(String view) {
        setAttr("Version", S.VERSION);
        setAttr("Server", P.SERVER);
        setAttr("ResVersion", S.RES_VERSION );
        super.render(view);
    }
}
