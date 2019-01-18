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
 * Time  : 5:22 PM
 * Author: fengduqing
 **/

package ink.fdq.snowy.core.base;

import com.jfinal.plugin.activerecord.*;
import ink.fdq.snowy.core.vo.json.Grid;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseService {
    protected Logger logger = Logger.getLogger(getClass());


    public abstract Model<?> getDao();


    /**
     * 获取主键
     *
     * @return
     */
    public String getPK() {
        return _getTable().getPrimaryKey()[0];
    }

    /**
     * 获取表名
     *
     * @return
     */
    public String getTable() {
        return _getTable().getName();
    }

    /**
     * 获取表信息
     *
     * @return
     */
    protected Table _getTable() {
        if (getDao() == null) {
            logger.error("Imp");
        }

        return TableMapping.me().getTable(getDao().getClass());
    }

    /**
     * select * from getTable()
     *
     * @return
     */
    private String getSelectSql() {
        return "select * from " + getTable() + " ";
    }

    private String getCountSql() {
        return "select count(*)  as totalRow from " + getTable();
    }

    /**
     * 通用findById
     *
     * @param id
     * @return
     */
    public Model<?> findById(String id) {
        return getDao().findById(id);
    }

    /**
     * 通过字段查找对象数据
     *
     * @param pk    字段名
     * @param value 字段值
     * @return
     */
    public Model<?> findByPk(String pk, String value) {
        List<?> list = getDao().find(getSelectSql() + " where " + pk + "=?", value);
        if (list.size() > 0) {
            return (Model<?>) list.get(0);
        }
        return null;
    }

    /**
     * 通用save
     *
     * @param entity
     * @return
     */
    public boolean save(Model<?> entity) {
        //主键赋值uuid
        if (entity.get(getPK()) == null) {
            //entity.set(getPK(), IdKit.createUUID());
        }
        return entity.save();
    }

    /**
     * 通用update
     *
     * @param entity
     * @return
     */
    public boolean update(Model<?> entity) {
        return entity.update();
    }

    /**
     * 通用delete
     *
     * @param entity
     * @return
     */
    public boolean delete(Model<?> entity) {
        return entity.delete();
    }

    /**
     * 通用deleteById
     *
     * @param id
     * @return
     */
    public boolean deleteById(String id) {
        return getDao().deleteById(id);
    }

    /**
     * 通用deleteByIds
     *
     * @param ids
     */
    public void deleteByIds(List<String> ids) {
        Object[][] paras = new Object[ids.size()][1];
        for (int i = 0; i < ids.size(); i++) {
            paras[i][0] = ids.get(i);
        }
        String sql = "delete from " + getTable() + " where id=?";
        Db.batch(sql, paras, 100);
    }

    /**
     * 根据字段删除数据
     *
     * @param ids
     * @param pk
     */
    public void deleteByPk(List<String> ids, String pk) {
        Object[][] paras = new Object[ids.size()][1];
        for (int i = 0; i < ids.size(); i++) {
            paras[i][0] = ids.get(i);
        }
        String sql = "delete from " + getTable() + " where " + pk + "=?";
        Db.batch(sql, paras, 100);
    }

    /**
     * 是否存在对象数据
     *
     * @param pk
     * @param value
     * @return
     */
    public boolean isExit(String pk, String value) {
        List<?> list = Db.find(getSelectSql() + "where " + pk + "=? limit 1", value);
        if (list.size() == 1) {
            return true;
        }
        return false;
    }



    public List<Record> queryAllList() {
        return Db.find(getSelectSql());
    }

    public List<Record> queryAllList(String groupOrderBy) {
        return Db.find(getSelectSql() + groupOrderBy);
    }

    public List<Record> queryForList(String sql) {
        return Db.find(sql);
    }

    public List<Record> queryForList(String sql, Object... object) {
        return Db.find(sql, object);
    }

    public List<Record> queryForList(String sql, Record record) {
        return queryForList(sql, record, null);
    }

    public List<Record> queryForList(String sql, Record record, String groupOrderBy) {
        List<Object> paras = new ArrayList<>();
        sql = this.createQuerySql(sql, groupOrderBy, record, paras, "like");
        List<Record> list = Db.find(sql, paras.toArray());
        return list;
    }

    public List<Record> queryForListEq(String sql, Record record, String groupOrderBy) {
        List<Object> paras = new ArrayList<>();
        sql = this.createQuerySql(sql, groupOrderBy, record, paras, "=");
        List<Record> list = Db.find(sql, paras.toArray());
        return list;
    }

    /**
     * 自定义分页查询
     * <p>
     * public Grid queryForList(String sql, int pageNumber, int pageSize, Record record, String groupOrderBy) {
     * List<Object> paras = new ArrayList<>();
     * sql = this.createQuerySql(sql, groupOrderBy, record, paras, "like");
     * return getGrid(pageNumber, pageSize, sql, paras.toArray());
     * }
     * <p>
     * public Grid queryForListEq(String sql, String countSql, int pageNumber, int pageSize, Record record, String groupOrderBy) {
     * List<Object> paras = new ArrayList<>();
     * sql = this.createQuerySql(sql, groupOrderBy, record, paras, "=");
     * countSql = this.createQuerySql(countSql, groupOrderBy, record, paras, "=");
     * return getGrid(pageNumber, pageSize, sql,countSql, paras.toArray());
     * }
     * <p>
     * public Grid queryForList(int pageNumber, int pageSize, String sql) {
     * return getGrid(pageNumber, pageSize, sql);
     * }
     * <p>
     * public Grid queryForList(int pageNumber, int pageSize, String sql, Object... object) {
     * return getGrid(pageNumber, pageSize, sql, object);
     * }
     * <p>
     * public Grid queryForList(int pageNumber, int pageSize) {
     * return getGrid(pageNumber, pageSize, getSelectSql(), getCountSql());
     * }
     */

    public Grid queryForList(int pageNumber, int pageSize, Record record) {
        List<Object> paras = new ArrayList<>();
        String sql = createQuerySql(getSelectSql(), null, record, paras, "like");
        String countSql = createQuerySql(getCountSql(), null, record, paras, "like");
        return getGrid(pageNumber, pageSize, sql, countSql, paras.toArray());
    }

    public Grid queryForList(int pageNumber, int pageSize, Record record, String orderBygroupBySql) {
        List<Object> paras = new ArrayList<>();
        String sql = createQuerySql(getSelectSql(), orderBygroupBySql, record, paras, "like");
        String countSql = createQuerySql(getCountSql(), orderBygroupBySql, record, paras, "like");
        return getGrid(pageNumber, pageSize, sql, countSql, paras.toArray());
    }

    /**
     * 全等查询
     *
     * @param pageNumber
     * @param pageSize
     * @param record
     * @return
     */
    public Grid queryForListEq(int pageNumber, int pageSize, Record record) {
        List<Object> paras = new ArrayList<>();
        String sql = createQuerySql(getSelectSql(), null, record, paras, "=");
        String countSql = createQuerySql(getCountSql(), null, record, paras, "=");
        return getGrid(pageNumber, pageSize, sql, countSql, paras.toArray());
    }

    /**
     * 全等查询
     *
     * @param pageNumber
     * @param pageSize
     * @param record
     * @param orderBygroupBySql
     * @return
     */
    public Grid queryForListEq(int pageNumber, int pageSize, Record record, String orderBygroupBySql) {
        List<Object> paras = new ArrayList<>();
        String sql = createQuerySql(getSelectSql(), orderBygroupBySql, record, paras, "=");
        String countSql = createQuerySql(getCountSql(), orderBygroupBySql, record, paras, "=");
        return getGrid(pageNumber, pageSize, sql, countSql, paras.toArray());
    }

    /**
     * 分页,模糊查询
     *
     * @param grid
     * @param record columns查询元素集合
     * @return
     */
    public Grid queryForList(Grid grid, Record record) {
        List<Object> paras = new ArrayList<>();
        String sql = this.createQuerySql(getSelectSql(), null, record, paras, "like");
        String countSql = this.createQuerySql(getCountSql(), null, record, paras, "like");
        return getGrid(grid.getPageNumber(), grid.getPageSize(), sql, countSql, paras.toArray());
    }

    /**
     * 分页查询,分组排序
     *
     * @param grid
     * @param orderBygroupBySql
     * @return
     */
    public Grid queryForList(Grid grid, String orderBygroupBySql) {
        List<Object> paras = new ArrayList<>();
        String sql = this.createQuerySql(getSelectSql(), orderBygroupBySql, null, paras, "like");
        String countSql = this.createQuerySql(getCountSql(), orderBygroupBySql, null, paras, "like");
        return getGrid(grid.getPageNumber(), grid.getPageSize(), sql, countSql, paras.toArray());
    }

    /**
     * 分页,模糊查询,分组排序
     *
     * @param grid
     * @param record            columns查询元素集合
     * @param orderBygroupBySql 分组排序
     */
    public Grid queryForList(Grid grid, Record record, String orderBygroupBySql) {
        List<Object> paras = new ArrayList<>();
        String sql = this.createQuerySql(getSelectSql(), orderBygroupBySql, record, paras, "like");
        String countSql = this.createQuerySql(getCountSql(), orderBygroupBySql, record, paras, "like");
        return getGrid(grid.getPageNumber(), grid.getPageSize(), sql, countSql, paras.toArray());
    }

    private Grid getGrid(int pageNumber, int pageSize, String sql, String countSql, Object... paras) {
        int startIndex = (pageNumber - 1) * pageSize;
        List<Record> list = Db.find(sql + " limit " + startIndex + "," + pageSize, paras);
        List<Record> count = Db.find(countSql, paras);
        return new Grid(list, pageNumber, pageSize, count.get(0).getInt("total"));
    }

    private Grid getGrid(int pageNumber, int pageSize, String sql, String countSql) {
        int startIndex = (pageNumber - 1) * pageSize;
        List<Record> list = Db.find(sql + " limit " + startIndex + "," + pageSize);
        List<Record> count = Db.find(countSql);
        return new Grid(list, pageNumber, pageSize, count.get(0).getInt("total"));
    }

    /**
     * 拼接模糊查询条件
     *
     * @param sql
     * @param orderByGroupBySql
     * @param record            columns查询元素集合
     * @param paras
     * @param queryType         like or = ，模糊查询或者全等查询
     * @return
     */
    private String createQuerySql(String sql, String orderByGroupBySql, Record record, List<Object> paras,
                                  String queryType) {
        if (record == null) {
            return orderByGroupBySql == null ? sql : sql + " " + orderByGroupBySql;
        }

        Map<String, Object> columns = record.getColumns();
        Iterator<String> iter = columns.keySet().iterator();
        StringBuffer whereSql = new StringBuffer();

        while (iter.hasNext()) {
            String column = iter.next();
            Object value = columns.get(column);

            if (value != null && value.toString().trim().length() > 0) {
                if (whereSql.length() > 0) {
                    whereSql.append(" and ");
                }
                if ("=".equals(queryType)) {
                    whereSql.append(column + " = ? ");
                    paras.add(value);
                } else {
                    whereSql.append(column + " like ? ");
                    paras.add("%" + value + "%");
                }
            }
        }

        if (whereSql.length() > 0) {
            if (sql.contains("where")) {
                sql += " and " + whereSql.toString();
            } else {
                sql += " where " + whereSql.toString();
            }
        }

        if (orderByGroupBySql != null) {
            sql += " " + orderByGroupBySql;
        }

        return sql;
    }
}
