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

package ink.fdq.snowy.service;

import ink.fdq.snowy.model.table.SysResc;
import ink.fdq.snowy.util.jsonBean.Menu;

import java.util.ArrayList;
import java.util.List;

public class SysRescService {
    private SysResc sysResc = new SysResc();

    private Menu convertToMenu(SysResc sysResc){
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

    public Menu getAdminMenu(){
        Menu adminMenu = new Menu("", "", "");
        List<Menu> mainMenu = new ArrayList<>();
        List<SysResc> rescList = sysResc.findByPid(1);

        for(SysResc resc : rescList){
            Menu menu = convertToMenu(resc);
            List<Menu> subMenu = new ArrayList<>();
            List<SysResc> subRescList = sysResc.findByPid(resc.getRescId());

            for(SysResc subResc : subRescList){
                subMenu.add(convertToMenu(subResc));
            }

            menu.setSubMenu(subMenu);
            mainMenu.add(menu);

        }

        adminMenu.setSubMenu(mainMenu);


        return adminMenu;
    }
}
