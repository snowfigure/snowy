/*
 *
 * Copyright (c) 2010-2018, 791211.com & fdq.ln.cn &
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Date  : 2019-01-17
 * Time  : 3:01 PM
 * Author: fengduqing
 **/

package ink.fdq.snowy.core.service.base;

import com.jfinal.plugin.activerecord.Model;
import ink.fdq.snowy.core.model.table.SysResc;
import ink.fdq.snowy.core.base.BaseService;
import ink.fdq.snowy.core.vo.sql.WherePara;

import java.util.List;

public class SysRescService extends BaseService {
    private SysResc dao = new SysResc().dao();

    @Override
    public Model<?> getDao() {
        return dao;
    }

    /**
     * 根据父ID查询资源信息
     * @param pid
     * @return
     */
    public List<SysResc> findByPid(int pid){
        WherePara para = new WherePara();
        String where_sql = para.
                andEqual("resc_pid", pid).
                andEqual("enable_status", 0).
                sql();



        String sql = String.format("select * from  %s  %s", getTable(), where_sql);

        return dao.find(sql, pid, 0);
    }


}
