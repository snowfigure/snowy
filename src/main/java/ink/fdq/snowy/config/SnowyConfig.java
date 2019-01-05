package ink.fdq.snowy.config;

import com.jfinal.config.*;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import ink.fdq.snowy.config.handle.HtmlHandler;
import ink.fdq.snowy.config.route.SnowyRoute;
import ink.fdq.snowy.util.factory.P;

public class SnowyConfig extends JFinalConfig {


    public static DruidPlugin createDruidPlugin() {
        return new DruidPlugin(P.JDBC_URL, P.JDBC_USERNAME, P.JDBC_PASSWORD, P.JDBC_DRIVER);
    }
    /**
     * 配置常量
     * @param me
     */
    @Override
    public void configConstant(Constants me) {

        /*设置开发模式*/
        me.setDevMode(P.DEV_MODE);

        /*支持 Controller、Interceptor 之中使用 @Inject 注入业务层，并且自动实现 AOP*/
        me.setInjectDependency(true);

        /*设置页面渲染引擎*/
        me.setViewType(ViewType.FREE_MARKER);
    }

    /**
     * 配置路由
     * @param me
     */
    @Override
    public void configRoute(Routes me) {
        /*添加路由*/
        SnowyRoute.add(me);
    }

    @Override
    public void configEngine(Engine me) {

    }

    /**
     *  配置插件
     * @param me
     */
    @Override
    public void configPlugin(Plugins me) {
        /**配置 druid 数据库连接池插件*/
        DruidPlugin druidPlugin = createDruidPlugin();
        me.add(druidPlugin);


    }

    /**
     * 配置全局拦截器
     * @param me
     */
    @Override
    public void configInterceptor(Interceptors me) {

    }

    /**
     * 配置处理器
     * @param me
     */
    @Override
    public void configHandler(Handlers me) {
        me.add(new HtmlHandler());
    }
}
