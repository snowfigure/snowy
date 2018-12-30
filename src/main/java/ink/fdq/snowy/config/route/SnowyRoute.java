package ink.fdq.snowy.config.route;

import com.jfinal.config.Routes;
import ink.fdq.snowy.config.route.admin.AdminApiRoute;
import ink.fdq.snowy.config.route.admin.AdminPageRoute;
import ink.fdq.snowy.config.route.front.FrontApiRoute;
import ink.fdq.snowy.config.route.front.FrontPageRoute;
import ink.fdq.snowy.config.route.test.TestRoute;
import ink.fdq.snowy.util.factory.P;

public class SnowyRoute {
    public static void add(Routes me){
        me.add(new AdminApiRoute());
        me.add(new AdminPageRoute());

        me.add(new FrontApiRoute());
        me.add(new FrontPageRoute());

        if(P.getDevMode()){
            me.add(new TestRoute());
        }
    }
}
