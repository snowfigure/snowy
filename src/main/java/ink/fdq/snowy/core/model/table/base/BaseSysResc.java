package ink.fdq.snowy.core.model.table.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by snowy, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseSysResc<M extends BaseSysResc<M>> extends Model<M> implements IBean {

    /**
     * 表名
     */
    public final static String TABLE_NAME = "snowy_sys_resc";

    /**
     * 主键
     */
    public final static String PK_NAME = "resc_id";

	public M setRescId(java.lang.Integer rescId) {
		set("resc_id", rescId);
		return (M)this;
	}
	
	public java.lang.Integer getRescId() {
		return getInt("resc_id");
	}

	public M setRescPid(java.lang.Integer rescPid) {
		set("resc_pid", rescPid);
		return (M)this;
	}
	
	public java.lang.Integer getRescPid() {
		return getInt("resc_pid");
	}

	public M setRescName(java.lang.String rescName) {
		set("resc_name", rescName);
		return (M)this;
	}
	
	public java.lang.String getRescName() {
		return getStr("resc_name");
	}

	public M setRescUrl(java.lang.String rescUrl) {
		set("resc_url", rescUrl);
		return (M)this;
	}
	
	public java.lang.String getRescUrl() {
		return getStr("resc_url");
	}

	public M setRescLevel(java.lang.Integer rescLevel) {
		set("resc_level", rescLevel);
		return (M)this;
	}
	
	public java.lang.Integer getRescLevel() {
		return getInt("resc_level");
	}

	public M setRescSort(java.lang.Integer rescSort) {
		set("resc_sort", rescSort);
		return (M)this;
	}
	
	public java.lang.Integer getRescSort() {
		return getInt("resc_sort");
	}

	public M setRescType(java.lang.String rescType) {
		set("resc_type", rescType);
		return (M)this;
	}
	
	public java.lang.String getRescType() {
		return getStr("resc_type");
	}

	public M setRescIconName(java.lang.String rescIconName) {
		set("resc_icon_name", rescIconName);
		return (M)this;
	}
	
	public java.lang.String getRescIconName() {
		return getStr("resc_icon_name");
	}

	public M setRescHtmlId(java.lang.String rescHtmlId) {
		set("resc_html_id", rescHtmlId);
		return (M)this;
	}
	
	public java.lang.String getRescHtmlId() {
		return getStr("resc_html_id");
	}

	public M setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
		return (M)this;
	}
	
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public M setEnableStatus(java.lang.String enableStatus) {
		set("enable_status", enableStatus);
		return (M)this;
	}
	
	public java.lang.String getEnableStatus() {
		return getStr("enable_status");
	}

	public M setRemark(java.lang.String remark) {
		set("remark", remark);
		return (M)this;
	}
	
	public java.lang.String getRemark() {
		return getStr("remark");
	}

}