package com.damai.system.entity;

import java.util.Date;

/**
 * 角色
 * @author ChenFei
 *
 */
public class SysRole {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 角色名称
     */
    private String rolename;

    /**
     * 备注
     */
    private String remark;

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
     * 角色名称
     * @return RoleName 角色名称
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * 角色名称
     * @param rolename 角色名称
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     * 备注
     * @return Remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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