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
 * Time  : 9:24 AM
 * Author: fengduqing
 **/

package ink.fdq.snowy.develop.controller.api;

import ink.fdq.snowy.core.vo.json.PagePara;
import ink.fdq.snowy.develop.controller.DevelopController;

public class DevelopApiBaseController extends DevelopController {

    protected PagePara getPagePara(){
        int pageSize = getParaToInt("pageSize", 10);
        int pageNumber = getParaToInt("pageNumber", 1);
        PagePara para  = new PagePara();
        para.setPageNumber(pageNumber);
        para.setPageSize(pageSize);

        return para;
    }

}
