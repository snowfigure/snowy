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
 * Time  : 3:51 PM
 * Author: fengduqing
 **/

package ink.fdq.snowy.core.base.controller;

import ink.fdq.snowy.core.factory.M;
import ink.fdq.snowy.core.vo.json.Menu;

public class BasePageController extends BaseController {
    @Override
    public void render(String view) {
        /*
        System.out.println(getControllerKey());
        System.out.println(getViewPath());
        System.out.println(getRequest().getMethod());
        System.out.println(getRequest().getRequestURI());
        System.out.println(getRequest().getRequestURL());
        */
        String uri = getRequest().getRequestURI();
        int index = uri.toLowerCase().indexOf(".html");
        if (index != -1) {
            // 从url中截取.html
            uri = uri.substring(0, index);
        }

        Menu menu = M.getMenu(uri);
        if(menu != null){
            if(menu.getPid() != null){
                setAttr("navBarParentId", menu.getPid());
            }else{
                setAttr("navBarParentId", "__nav_bar_ignore_id__");
            }
            setAttr("navBarCurrentId", menu.getId());
        }else{
            setAttr("navBarParentId", "__nav_bar_ignore_id__");
            setAttr("navBarCurrentId", "__nav_bar_ignore_id__");

        }


        super.render(view);
    }
}
