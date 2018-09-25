package com.damai.system.entity;

import java.util.Date;

/**
 * 权限
 * @author ChenFei
 *
 */
public class SysPermission {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 资源类型：menu,button
     */
    private String type;

    /**
     * 访问url地址
     */
    private String url;

    /**
     * 父结点id
     */
    private String parentid;

    /**
     * 权限代码字符串
     */
    private String percode;

    /**
     * 顺序
     */
    private Integer priority;

    /**
     * 使用状态
     */
    private Integer useflag;

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
     * 权限名称
     * @return Name 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 权限名称
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 资源类型：menu,button
     * @return Type 资源类型：menu,button
     */
    public String getType() {
        return type;
    }

    /**
     * 资源类型：menu,button
     * @param type 资源类型：menu,button
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 访问url地址
     * @return Url 访问url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 访问url地址
     * @param url 访问url地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 父结点id
     * @return ParentId 父结点id
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * 父结点id
     * @param parentid 父结点id
     */
    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    /**
     * 权限代码字符串
     * @return Percode 权限代码字符串
     */
    public String getPercode() {
        return percode;
    }

    /**
     * 权限代码字符串
     * @param percode 权限代码字符串
     */
    public void setPercode(String percode) {
        this.percode = percode == null ? null : percode.trim();
    }

    /**
     * 顺序
     * @return Priority 顺序
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 顺序
     * @param priority 顺序
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 使用状态
     * @return UseFlag 使用状态
     */
    public Integer getUseflag() {
        return useflag;
    }

    /**
     * 使用状态
     * @param useflag 使用状态
     */
    public void setUseflag(Integer useflag) {
        this.useflag = useflag;
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