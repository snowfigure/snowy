package ink.fdq.snowy.core.base.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import ink.fdq.snowy.core.factory.P;
import ink.fdq.snowy.core.factory.S;
import ink.fdq.snowy.core.vo.json.Grid;

import java.util.List;

public class BaseController extends Controller {

    @Override
    public void render(String view) {
        setAttr("Version", S.VERSION);
        setAttr("Server", P.SERVER);
        setAttr("ResVersion", S.RES_VERSION );
        setAttr("dev_mode",P.DEV_MODE);
        if(P.DEV_MIN_MODE){
            setAttr("dev_min_mode","min.");
        }else{
            setAttr("dev_min_mode","");
        }
        super.render(view);
    }


    public void renderJson(Page<?> page){
        Grid grid = new Grid(page.getList(), page.getPageNumber(), page.getPageSize(), page.getTotalRow());

        renderJson(grid);
    }
}
