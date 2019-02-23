package ink.fdq.snowy.develop.service;

import com.jfinal.plugin.activerecord.Page;
import ink.fdq.snowy.core.model.table.SysIcon;
import ink.fdq.snowy.core.service.base.SysIconService;
import ink.fdq.snowy.core.vo.json.PagePara;

public class DevelopBootstrapService {
    private SysIconService iconService = new SysIconService();
    public Page<SysIcon> paginate(PagePara pagePara){
        return iconService.paginate(pagePara, 10);
    }
}
