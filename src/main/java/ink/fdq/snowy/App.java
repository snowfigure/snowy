package ink.fdq.snowy;

import com.jfinal.server.undertow.UndertowServer;
import ink.fdq.snowy.core.config.SnowyConfig;
import ink.fdq.snowy.core.factory.P;

public class App {
    /**
     * 启动入口
     * @param args
     */
    public static void main(String[] args){
        UndertowServer.start(SnowyConfig.class, P.BIND_PORT, P.DEV_MODE);
    }
}
