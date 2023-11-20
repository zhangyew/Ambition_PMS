package com.ruoyi.system.api.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 用户表对象 public_user
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 账号
     */
    @Excel(name = "账号")
    private String account;

    /**
     * 密码
     */
    @Excel(name = "密码")
    private String password;

    /**
     * 岗位
     */
    @Excel(name = "岗位")
    private String job;

    /**
     * 移动电话
     */
    @Excel(name = "移动电话")
    private String phone;

    /**
     * 最后登录日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后登录日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastLogintime;

    /**
     * 0:采购部,1:供应商
     */
    @Excel(name = "0:采购部,1:供应商")
    private Long identity;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setLastLogintime(Date lastLogintime) {
        this.lastLogintime = lastLogintime;
    }

    public Date getLastLogintime() {
        return lastLogintime;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public Long getIdentity() {
        return identity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("account", getAccount())
                .append("password", getPassword())
                .append("job", getJob())
                .append("phone", getPhone())
                .append("lastLogintime", getLastLogintime())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("identity", getIdentity())
                .toString();
    }
}
