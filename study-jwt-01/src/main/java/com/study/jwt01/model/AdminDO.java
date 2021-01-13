package com.study.jwt01.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_admin")
public class AdminDO {
    /**
     * 管理员id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 管理员姓名
     */
    @Column(name = "admin_name")
    private String adminName;

    /**
     * 管理员电话/账号
     */
    @Column(name = "admin_phone")
    private String adminPhone;

    /**
     * 管理员登录密码
     */
    @Column(name = "admin_password")
    private String adminPassword;

    /**
     * 管理员邮箱
     */
    @Column(name = "admin_email")
    private String adminEmail;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取管理员id
     *
     * @return id - 管理员id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置管理员id
     *
     * @param id 管理员id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取管理员姓名
     *
     * @return admin_name - 管理员姓名
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置管理员姓名
     *
     * @param adminName 管理员姓名
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    /**
     * 获取管理员电话/账号
     *
     * @return admin_phone - 管理员电话/账号
     */
    public String getAdminPhone() {
        return adminPhone;
    }

    /**
     * 设置管理员电话/账号
     *
     * @param adminPhone 管理员电话/账号
     */
    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone == null ? null : adminPhone.trim();
    }

    /**
     * 获取管理员登录密码
     *
     * @return admin_password - 管理员登录密码
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * 设置管理员登录密码
     *
     * @param adminPassword 管理员登录密码
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    /**
     * 获取管理员邮箱
     *
     * @return admin_email - 管理员邮箱
     */
    public String getAdminEmail() {
        return adminEmail;
    }

    /**
     * 设置管理员邮箱
     *
     * @param adminEmail 管理员邮箱
     */
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail == null ? null : adminEmail.trim();
    }

    /**
     * 获取注册时间
     *
     * @return create_time - 注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置注册时间
     *
     * @param createTime 注册时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}