package ink.fdq.snowy.util.factory;

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

    public static String get(String key) {
        return getProp().get(key, null);
    }

    public static String get(String key, String defaultValue) {
        return getProp().get(key, defaultValue);
    }

    public static Integer getInt(String key) {
        return getInt(key, null);
    }

    public static Integer getInt(String key, Integer defaultValue) {
        return getProp().getInt(key,defaultValue);
    }

    public static Long getLong(String key) {
        return getLong(key, null);
    }

    public static Long getLong(String key, Long defaultValue) {
        return getProp().getLong(key,defaultValue);
    }

    public static Boolean getBoolean(String key) {
        return getBoolean(key, null);
    }

    public static Boolean getBoolean(String key, Boolean defaultValue){
        return getProp().getBoolean(key,defaultValue);
    }


    /**
     * 获取开发模式
     * @return
     */
    public static boolean getDevMode(){
        return getBoolean("mode.dev", false);
    }
}
