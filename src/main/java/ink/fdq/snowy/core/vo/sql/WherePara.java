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
 * Time  : 8:17 PM
 * Author: fengduqing
 **/

package ink.fdq.snowy.core.vo.sql;

import java.util.ArrayList;
import java.util.List;

public class WherePara {
    private List<String> where = new ArrayList<>();
    private List<Object> paras = new ArrayList<>();

    private void add(String mode, String sql, Object para){
        if(where.size() == 0){
            where.add(sql);
        }else{
            where.add(mode + " " + sql);
        }
        paras.add(para);
    }

    public WherePara and(String column, String op, Object para){
        if(op.equals("like")){
            add("and",column + " " + op + " '%?%' ", para);
        }else{
            add("and",column + op + " ?", para);
        }

        return this;
    }

    public WherePara andEqual(String column, Object para){
        return and(column, "=", para);
    }

    public WherePara andLike(String column, Object para){
        return and(column, "=", para);
    }

    public WherePara or(String column, String op, Object para){
        if(op.equals("like")){
            add("or",column + " " + op + " '%?%' ", para);
        }else{
            add("or",column + op + "?", para);
        }

        return this;
    }

    public String sql(){
        String sql = "";
        if(where.size()==0){
            return "";
        }
        for(String str : where){
            sql += " " + str;
        }

        return " where " + sql;
    }

}
