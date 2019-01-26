package ink.fdq.snowy.develop.controller.page;

public class DevelopPageBootstrapController extends DevelopPageBaseController {
    public void icon(){
        render("/WEB-INF/page/develop/bootstrap/icon.ftl");
    }

    public void panel(){
        render("/WEB-INF/page/develop/bootstrap/panel.ftl");
    }
    public void dataTable(){
        render("/WEB-INF/page/develop/bootstrap/dataTable.ftl");
    }

}
