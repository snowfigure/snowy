package ink.fdq.snowy;

import com.jfinal.server.undertow.UndertowServer;
import ink.fdq.snowy.config.SnowyConfig;

public class App {
    /**
     * 启动入口
     * @param args
     */
    public static void main(String[] args){
        UndertowServer.start(SnowyConfig.class);
    }
}
