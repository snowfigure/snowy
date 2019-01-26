package ink.fdq.snowy.core.config;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import ink.fdq.snowy.core.factory.M;
import ink.fdq.snowy.core.factory.P;
import ink.fdq.snowy.core.handle.HtmlHandler;
import ink.fdq.snowy.core.plugin.ActiveRecordPluginKit;
import ink.fdq.snowy.core.plugin.DruidPluginKit;
import ink.fdq.snowy.core.plugin.EhCachePluginKit;
import ink.fdq.snowy.core.route.SnowyRoute;

public class SnowyConfig extends JFinalConfig {



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
        System.out.println(Routes.getRoutesList().size());
        for(Routes routes : Routes.getRoutesList()){
            for(Routes.Route route : routes.getRouteItemList()){
                System.out.println(route.getControllerKey());
                Class<?> ctlClass = route.getControllerClass();
            }

        }
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
        DruidPlugin druidPlugin = DruidPluginKit.createDruidPlugin();
        me.add(druidPlugin);

        ActiveRecordPlugin arp = ActiveRecordPluginKit.createActiveRecordPlugin(druidPlugin);
        me.add(arp);

        /** 加载EhCache配置文件*/
        EhCachePlugin ecp = EhCachePluginKit.createEhCachePlugin();
        me.add(ecp);
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

    @Override
    public void afterJFinalStart() {

        M.init();
        M.getMenu("");
    }

    @Override
    public void beforeJFinalStop() {
        super.beforeJFinalStop();
    }
}
