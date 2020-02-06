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
 * Time  : 4:12 PM
 * Author: fengduqing
 **/

package ink.fdq.snowy.core.factory;

import ink.fdq.snowy.core.model.table.SysResc;
import ink.fdq.snowy.core.service.MenuService;
import ink.fdq.snowy.core.service.base.SysRescService;
import ink.fdq.snowy.core.vo.json.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M {
    private static Map<String, Menu> menuMap;

    public static synchronized  void __initMap(){
        MenuService menuService = new MenuService();
        SysRescService sysRescService = new SysRescService();

        /*PID = -1,查出所有的子系统*/
        List<SysResc> rootList = sysRescService.findByPid(-1);

        for(SysResc rootResc : rootList){

            /* PID= 子系统ID，查出当前子系统的第一级菜单 */
            List<SysResc> subSystemList = sysRescService.findByPid(rootResc.getRescId());
            for(SysResc subSysResc : subSystemList){

                /*确定第一级菜单的每个菜单是否是独立菜单*/
                List<SysResc> currList = sysRescService.findByPid(subSysResc.getRescId());
                Menu menu = menuService.convertToMenu(subSysResc);

                if(currList.size() == 0){
                    /*独立菜单*/
                    menuMap.put(menu.getUrl(), menu);
                }else{
                    /*含有子菜单*/
                    for(SysResc childResc : currList){
                        Menu childMenu = menuService.convertToMenu(childResc);
                        childMenu.setPid(menu.getId());
                        menuMap.put(childMenu.getUrl(), childMenu);
                    }
                }
            }
        }
    }

    public static synchronized void reinit(){
        menuMap = new HashMap<>();
        __initMap();
    }
    public static synchronized void init(){
        if(menuMap == null){
            menuMap = new HashMap<>();
        }
        __initMap();
    }

    public static synchronized Menu getMenu(String url){

        for(Map.Entry<String, Menu> entry: menuMap.entrySet())
        {
            System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue().getId() + "  " + entry.getValue().getPid());
        }


        if(menuMap == null){
            reinit();
        }
        if(menuMap.containsKey(url)){
            return menuMap.get(url);
        }
        return null;
    }
}
