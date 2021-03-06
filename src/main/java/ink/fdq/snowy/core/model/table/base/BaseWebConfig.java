package ink.fdq.snowy.core.model.table.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by snowy, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseWebConfig<M extends BaseWebConfig<M>> extends Model<M> implements IBean {

    /**
     * 表名
     */
    public final static String TABLE_NAME = "snowy_web_config";

    /**
     * 主键
     */
    public final static String PK_NAME = "id";

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setKey(java.lang.String key) {
		set("key", key);
		return (M)this;
	}
	
	public java.lang.String getKey() {
		return getStr("key");
	}

	public M setValue(java.lang.String value) {
		set("value", value);
		return (M)this;
	}
	
	public java.lang.String getValue() {
		return getStr("value");
	}

	public M setDescription(java.lang.String description) {
		set("description", description);
		return (M)this;
	}
	
	public java.lang.String getDescription() {
		return getStr("description");
	}

	public M setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
		return (M)this;
	}
	
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public M setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
		return (M)this;
	}
	
	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

	public M setIsSystem(java.lang.String isSystem) {
		set("is_system", isSystem);
		return (M)this;
	}
	
	public java.lang.String getIsSystem() {
		return getStr("is_system");
	}

}
