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
 * Time  : 11:20 AM
 * Author: fengduqing
 **/

package ink.fdq.snowy.core.plugin;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import ink.fdq.snowy.core.factory.P;
import ink.fdq.snowy.core.model.table._MappingKit;

public class ActiveRecordPluginKit {
    public static final ActiveRecordPlugin createActiveRecordPlugin(DruidPlugin druidPlugin){
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        arp.setDevMode(P.DEV_MODE);
        arp.setShowSql(P.DEV_MODE);
        _MappingKit.mapping(arp);

        return arp;
    }
}
