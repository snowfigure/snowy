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
 * Date  : 2019-01-21
 * Time  : 9:28 AM
 * Author: fengduqing
 **/

package ink.fdq.snowy.core.service;

import ink.fdq.snowy.core.model.table.SysResc;
import ink.fdq.snowy.core.service.base.SysRescService;
import ink.fdq.snowy.core.vo.json.Menu;

import java.util.List;

public class MenuService {
    protected SysRescService sysRescService = new SysRescService();
    /**
     * 数据库的资源信息，转成前端可用的菜单信息
     * @param sysResc
     * @return
     */
    protected Menu convertToMenu(SysResc sysResc){
        Menu menu = new Menu();
        menu.setName(sysResc.getRescName() + "");
        menu.setIconClass(sysResc.getRescIconName() + "");
        menu.setUrl(sysResc.getRescUrl() + "");

        String htmlId = sysResc.getRescHtmlId();

        if(htmlId == null || htmlId.equals("")){
            htmlId = "menu_" + sysResc.getRescPid() + "_" + sysResc.getRescId();
        }
        menu.setId(htmlId);

        return menu;
    }

    /**
     * 获取后台管理菜单
     * @return
     */
    public Menu getAdminMenu(int pid){
        Menu adminMenu = new Menu("", "", "");
        List<SysResc> rescList = sysRescService.findByPid(pid);

        for(SysResc resc : rescList){
            Menu menu = convertToMenu(resc);
            List<SysResc> subRescList = sysRescService.findByPid(resc.getRescId());

            for(SysResc subResc : subRescList){
                menu.addSubMenu(convertToMenu(subResc));
            }
            adminMenu.addSubMenu(menu);
        }

        return adminMenu;
    }
}
