package com.ruoyi.system.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 供应商联系人对象 public_contacts
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicContacts extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 供应商联系人ID
     */
    private Long contactsId;

    /**
     * 供应商ID
     */
    @Excel(name = "供应商ID")
    private Long contactsVendorId;

    /**
     * 称呼
     */
    @Excel(name = "称呼")
    private String calls;

    /**
     * 岗位
     */
    @Excel(name = "岗位")
    private String job;

    /**
     * 部门
     */
    @Excel(name = "部门")
    private String division;

    /**
     * 移动电话
     */
    @Excel(name = "移动电话")
    private String phone;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String mailbox;

    public void setContactsId(Long contactsId) {
        this.contactsId = contactsId;
    }

    public Long getContactsId() {
        return contactsId;
    }

    public void setContactsVendorId(Long contactsVendorId) {
        this.contactsVendorId = contactsVendorId;
    }

    public Long getContactsVendorId() {
        return contactsVendorId;
    }

    public void setCall(String call) {
        this.calls = call;
    }

    public String getCall() {
        return calls;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDivision() {
        return division;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getMailbox() {
        return mailbox;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("contactsId", getContactsId())
                .append("contactsVendorId", getContactsVendorId())
                .append("call", getCall())
                .append("job", getJob())
                .append("division", getDivision())
                .append("phone", getPhone())
                .append("mailbox", getMailbox())
                .toString();
    }
}
