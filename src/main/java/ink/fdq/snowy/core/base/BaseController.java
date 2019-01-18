package ink.fdq.snowy.core.base;

import com.jfinal.core.Controller;
import ink.fdq.snowy.core.factory.P;
import ink.fdq.snowy.core.factory.S;

public class BaseController extends Controller {

    @Override
    public void render(String view) {
        setAttr("Version", S.VERSION);
        setAttr("Server", P.SERVER);
        setAttr("ResVersion", S.RES_VERSION );
        super.render(view);
    }
}
