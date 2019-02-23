package ink.fdq.snowy.core.service.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import ink.fdq.snowy.core.base.BaseService;
import ink.fdq.snowy.core.model.table.SysIcon;
import ink.fdq.snowy.core.vo.json.PagePara;

public class SysIconService extends BaseService {
    private SysIcon dao = new SysIcon().dao();
    @Override
    public Model<?> getDao() {
        return dao;
    }

    public Page<SysIcon> paginate(PagePara pagePara, int pid){
        String sqlExceptSelect = "from " + getTable() + " where pid = ?";
        return dao.paginate(pagePara.getPageNumber(), pagePara.getPageSize(), "select *", sqlExceptSelect, pid);
    }
}
