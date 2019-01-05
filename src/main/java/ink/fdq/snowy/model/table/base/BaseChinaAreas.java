package ink.fdq.snowy.model.table.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by snowy, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseChinaAreas<M extends BaseChinaAreas<M>> extends Model<M> implements IBean {

    /**
     * 表名
     */
    public final static String TABLE_NAME = "snowy_china_areas";

    /**
     * 主键
     */
    public final static String PK_NAME = "id";

	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	public void setPId(java.lang.Long pId) {
		set("p_id", pId);
	}
	
	public java.lang.Long getPId() {
		return getLong("p_id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}

	public void setZipCode(java.lang.String zipCode) {
		set("zip_code", zipCode);
	}
	
	public java.lang.String getZipCode() {
		return getStr("zip_code");
	}

}