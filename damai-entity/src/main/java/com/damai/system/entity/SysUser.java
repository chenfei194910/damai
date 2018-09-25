package com.damai.system.entity;

import java.util.Date;

/**
 * 用户实体类
 * @author ChenFei
 *
 */
public class SysUser {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 真实姓名
     */
    private String relName;

    /**
     * 用户登陆状态标记
     */
    private Integer state;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 最后登陆时间
     */
    private Date lastSignTime;

    /**
     * 登陆时间
     */
    private Date loginTime;

    /**
     * 登录次数
     */
    private Long count;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 操作人
     */
    private String operatingUser;

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
     * 用户名称
     * @return UserName 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名称
     * @param username 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 用户密码
     * @return UserPwd 用户密码
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 用户密码
     * @param userpwd 用户密码
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * 真实姓名
     * @return RelName 真实姓名
     */
    public String getRelName() {
        return relName;
    }

    /**
     * 真实姓名
     * @param relname 真实姓名
     */
    public void setRelName(String relName) {
        this.relName = relName == null ? null : relName.trim();
    }

    /**
     * 用户登陆状态标记
     * @return State 用户登陆状态标记
     */
    public Integer getState() {
        return state;
    }

    /**
     * 用户登陆状态标记
     * @param state 用户登陆状态标记
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 手机号
     * @return Mobile 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 电子邮箱
     * @return Email 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 电子邮箱
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 盐值
     * @return Salt 盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐值
     * @param salt 盐值
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 最后登陆时间
     * @return LastSignTime 最后登陆时间
     */
    public Date getLastSignTime() {
        return lastSignTime;
    }

    /**
     * 最后登陆时间
     * @param lastsigntime 最后登陆时间
     */
    public void setLastSignTime(Date lastSignTime) {
        this.lastSignTime = lastSignTime;
    }

    /**
     * 登陆时间
     * @return LoginTime 登陆时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 登陆时间
     * @param logintime 登陆时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 登录次数
     * @return Count 登录次数
     */
    public Long getCount() {
        return count;
    }

    /**
     * 登录次数
     * @param count 登录次数
     */
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * 创建时间
     * @return createTime 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return updateTime 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 操作人
     * @return operatingUser 操作人
     */
    public String getOperatingUser() {
        return operatingUser;
    }

    /**
     * 操作人
     * @param operatingUser 操作人
     */
    public void setOperatingUser(String operatingUser) {
        this.operatingUser = operatingUser == null ? null : operatingUser.trim();
    }
}