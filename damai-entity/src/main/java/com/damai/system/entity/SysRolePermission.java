package com.damai.system.entity;

import java.util.Date;

/**
 * 角色权限
 * @author ChenFei
 *
 */
public class SysRolePermission {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 角色ID
     */
    private String roleid;

    /**
     * 权限ID
     */
    private String permissionid;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 修改时间
     */
    private Date updatetime;

    /**
     * 操作人
     */
    private String operatinguser;

    /**
     * 主键ID
     * @return ID 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 角色ID
     * @return RoleID 角色ID
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * 角色ID
     * @param roleid 角色ID
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    /**
     * 权限ID
     * @return PermissionID 权限ID
     */
    public String getPermissionid() {
        return permissionid;
    }

    /**
     * 权限ID
     * @param permissionid 权限ID
     */
    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid == null ? null : permissionid.trim();
    }

    /**
     * 创建时间
     * @return CreateTime 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 修改时间
     * @return UpdateTime 修改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 修改时间
     * @param updatetime 修改时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 操作人
     * @return OperatingUser 操作人
     */
    public String getOperatinguser() {
        return operatinguser;
    }

    /**
     * 操作人
     * @param operatinguser 操作人
     */
    public void setOperatinguser(String operatinguser) {
        this.operatinguser = operatinguser == null ? null : operatinguser.trim();
    }
}