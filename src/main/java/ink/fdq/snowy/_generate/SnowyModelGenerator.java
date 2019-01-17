package ink.fdq.snowy._generate;

import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;
import ink.fdq.snowy.config.SnowyConfig;
import ink.fdq.snowy.util.factory.P;

public class SnowyModelGenerator {

    public static void main(String[] args){

        /** base model 所使用的包名 */
        String baseModelPackageName = "ink.fdq.snowy.model.table.base";
        /** base model 文件保存路径 */
        String baseModelOutputDir = PathKit.getWebRootPath() + "/src/main/java/ink/fdq/snowy/model/table/base";

        /** model 所使用的包名 (MappingKit 默认使用的包名) */
        String modelPackageName = "ink.fdq.snowy.model.table";
        /** model 文件保存路径 (MappingKit 与 DataDictionary 文件默认保存路径) */
        String modelOutputDir = PathKit.getWebRootPath() + "/src/main/java/ink/fdq/snowy/model/table";

        /** 创建生成器 */
        DruidPlugin druidPlugin = SnowyConfig.createDruidPlugin();
        druidPlugin.start();
        Generator generator = new Generator(druidPlugin.getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);

        generator.setBaseModelTemplate("_generate/base_model_template.jf");
        generator.setModelTemplate("_generate/model_template.jf");
        generator.setMappingKitTemplate("_generate/mapping_kit_template.jf");

        /**  设置数据库方言*/
        generator.setDialect(new MysqlDialect());
        /**  设置是否生成链式 setter 方法 */
        generator.setGenerateChainSetter(true);
        /** 添加不需要生成的表名*/
        //generator.addExcludedTable("adv");
        /**  设置是否在 Model 中生成 dao 对象 */
        generator.setGenerateDaoInModel(true);
        /** 设置是否生成字典文件 */
        generator.setGenerateDataDictionary(true);
        /** 设置需要被移除的表名前缀用于生成modelName。例如表名 "snowy_user_info"，移除前缀 "snowy_"后生成的model名为 "UserInfo"而非 SnowyUserInfo */
        generator.setRemovedTableNamePrefixes(P.JDBC_TABLE_PREFIX);
        /** 生成 */
        generator.generate();
    }
}
