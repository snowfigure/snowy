package ink.fdq.snowy.core.route;

import com.jfinal.config.Routes;
import ink.fdq.snowy.core.route.admin.AdminApiRoute;
import ink.fdq.snowy.core.route.admin.AdminPageRoute;
import ink.fdq.snowy.core.route.develop.DevelopApiRoute;
import ink.fdq.snowy.core.route.front.FrontApiRoute;
import ink.fdq.snowy.core.route.front.FrontPageRoute;
import ink.fdq.snowy.core.route.develop.DevelopPageRoute;

public class SnowyRoute {
    public static void add(Routes me){
        me.add(new AdminApiRoute());
        me.add(new AdminPageRoute());

        me.add(new FrontApiRoute());
        me.add(new FrontPageRoute());

        //if(P.DEV_MODE){
            me.add(new DevelopPageRoute());
            me.add(new DevelopApiRoute());
        //}
    }
}
