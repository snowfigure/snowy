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
 * Time  : 9:26 AM
 * Author: fengduqing
 **/

package ink.fdq.snowy.develop.controller.api;

import com.jfinal.aop.Inject;
import com.jfinal.plugin.ehcache.CacheKit;
import ink.fdq.snowy.core.vo.json.Menu;
import ink.fdq.snowy.develop.service.DevelopMenuService;

public class DevelopApiMenuController extends DevelopApiBaseController{
    @Inject
    DevelopMenuService developMenuService;

    public void get(){

        Menu menu = CacheKit.get("systemMenu", "develop_menu_get");
        if(menu == null){
            menu = developMenuService.getDevelopMenu();
            CacheKit.put("systemMenu", "develop_menu_get", menu);
        }
        renderJson(menu);
    }
}
