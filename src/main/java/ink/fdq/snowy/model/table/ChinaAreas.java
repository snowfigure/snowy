package ink.fdq.snowy.model.table;

import com.jfinal.plugin.activerecord.Page;
import ink.fdq.snowy.model.table.base.BaseChinaAreas;

import java.util.List;
/**
 * Generated by snowy.
 */
@SuppressWarnings("serial")
public class ChinaAreas extends BaseChinaAreas<ChinaAreas> {

    /**
     * pagination select
     */
    public final static String SQL_SELECT = "select *";

    /**
     * pagination except select
     */
    public final static String SQL_EXCEPT = "from  " + TABLE_NAME;

    /**
     * find select
     */
    public final static String SQL_SELECT_FROM = "select * from " + TABLE_NAME;

    public final static String  PAGE_CACHE = "PAGE_CACHE_" + TABLE_NAME.toUpperCase();
    public final static String  FIND_CACHE = "FIND_CACHE_" + TABLE_NAME.toUpperCase();

	public static final ChinaAreas dao = new ChinaAreas().dao();

	/**
     * 查询所有数据（不建议使用）
     * @return
     */
    public List<ChinaAreas> findAll(){
        return super.find(SQL_SELECT_FROM);
    }

    /**
     * 分页查询
     * @param pageNumber 页码，必须大于0
     * @param pageSize   每页条数，必须大于0
     * @return
     */
    public Page<ChinaAreas> paginate(int pageNumber, int pageSize) {
        return super.paginate(pageNumber, pageSize, SQL_SELECT, SQL_EXCEPT);
    }
}
