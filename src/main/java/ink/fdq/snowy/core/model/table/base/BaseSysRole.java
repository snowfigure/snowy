package ink.fdq.snowy.core.model.table.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by snowy, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseSysRole<M extends BaseSysRole<M>> extends Model<M> implements IBean {

    /**
     * 表名
     */
    public final static String TABLE_NAME = "snowy_sys_role";

    /**
     * 主键
     */
    public final static String PK_NAME = "role_id";

	public M setRoleId(java.lang.Integer roleId) {
		set("role_id", roleId);
		return (M)this;
	}
	
	public java.lang.Integer getRoleId() {
		return getInt("role_id");
	}

	public M setRoleName(java.lang.String roleName) {
		set("role_name", roleName);
		return (M)this;
	}
	
	public java.lang.String getRoleName() {
		return getStr("role_name");
	}

	public M setRoleType(java.lang.String roleType) {
		set("role_type", roleType);
		return (M)this;
	}
	
	public java.lang.String getRoleType() {
		return getStr("role_type");
	}

	public M setRoleRemark(java.lang.String roleRemark) {
		set("role_remark", roleRemark);
		return (M)this;
	}
	
	public java.lang.String getRoleRemark() {
		return getStr("role_remark");
	}

	public M setRoleSort(java.lang.Integer roleSort) {
		set("role_sort", roleSort);
		return (M)this;
	}
	
	public java.lang.Integer getRoleSort() {
		return getInt("role_sort");
	}

	public M setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
		return (M)this;
	}
	
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public M setEnableStatue(java.lang.String enableStatue) {
		set("enable_statue", enableStatue);
		return (M)this;
	}
	
	public java.lang.String getEnableStatue() {
		return getStr("enable_statue");
	}

}