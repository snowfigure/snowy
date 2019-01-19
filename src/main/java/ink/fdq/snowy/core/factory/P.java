package ink.fdq.snowy.core.factory;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

/**
 * 系统基础配置静态扩展类
 */
public class P {
    private static Prop prop;

    /**
     * 先加载开发环境配置，然后尝试加载生产环境配置，生产环境配置不存在时不会抛异常
     * 在生产环境部署时后动创建 snowy_pro.properties，添加的配置项可以覆盖掉
     * snowy_dev.properties 中的配置项
     */
    private synchronized static void loadConfig(){
        if(prop == null){
            prop = PropKit.use("snowy_dev.properties").
                    appendIfExists("snowy_pro.properties");
        }
    }

    public synchronized static Prop getProp(){
        if(prop == null){
            loadConfig();
        }
        return prop;
    }



    /**
     * 获取开发模式
     * @return
     */
    public final static boolean DEV_MODE = getProp().getBoolean("mode.dev", false);

    public final static boolean DEV_MIN_MODE = getProp().getBoolean("mode.min", false);
    /**
     * 获取JFinal启动web时的监听端口
     */
    public final static int BIND_PORT = getProp().getInt("mode.port", 80);


    /**
     * 当前web服务对外提供的访问协议、域名、端口组成的URL
     */
    public final static String SERVER = String.format("%s://%s:%s",
            getProp().get("server.scheme", "http"),
            getProp().get("server.host", "127.0.0.1"),
            getProp().getInt("server.port", 80)
    );

    /**
     * JDBC驱动
     */
    public final static String JDBC_DRIVER = getProp().get("jdbc.driver");
    /**
     * JDBC数据库连接池
     */
    public final static String JDBC_URL = getProp().get("jdbc.url");
    /**
     * JDBC用户名
     */
    public final static String JDBC_USERNAME = getProp().get("jdbc.username");
    /**
     * JDBC密码
     */
    public final static String JDBC_PASSWORD = getProp().get("jdbc.password");

    /**
     * 数据库表前缀
     */
    public final static String JDBC_TABLE_PREFIX = getProp().get("jdbc.tablePrefix");



}
