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
 * Time  : 7:52 PM
 * Author: fengduqing
 **/

package ink.fdq.snowy.core.vo.json;

import java.util.List;

public class Grid {
    private int totalRow;
    private int pageNumber;
    private int pageSize;
    private int totalPage;
    private List<?> rows;

    public Grid(List<?> list, int pageNumber, int pageSize, int totalRow) {
        this.setRows(list);
        this.setPageNumber(pageNumber);
        this.setPageSize(pageSize);
        this.setTotalRow(totalRow);

       if ((totalRow % pageSize) == 0) {
           this.setTotalPage(totalRow / pageSize) ;
       } else {
           this.setTotalPage(totalRow / pageSize + 1);
       }
    }


    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
