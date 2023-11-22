package com.ruoyi.system.api.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 收货单对象 public_receipt
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicReceipt extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 收货单ID
     */
    private Long receiptId;

    /**
     * 收货单号
     */
    @Excel(name = "收货单号")
    private String receiptClod;

    /**
     * 收货日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiptTime;

    /**
     * 收货人
     */
    @Excel(name = "收货人")
    private String receiptBy;

    /**
     * 收货总数量
     */
    @Excel(name = "收货总数量")
    private Long receiptNumber;

    /**
     * 金额
     */
    @Excel(name = "金额")
    private Long receiptMoney;

    /**
     * 供应商ID（外键）
     */
    @Excel(name = "供应商ID", readConverterExp = "外=键")
    private Long receiptVendorId;

    /**
     * 联系人
     */
    @Excel(name = "联系人")
    private String contact;

    /**
     * 移动电话
     */
    @Excel(name = "移动电话")
    private String receiptPhone;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long state;

    /**
     * 删除
     */
    @Excel(name = "删除")
    private Long isDelete;

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptClod(String receiptClod) {
        this.receiptClod = receiptClod;
    }

    public String getReceiptClod() {
        return receiptClod;
    }

    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }

    public Date getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptBy(String receiptBy) {
        this.receiptBy = receiptBy;
    }

    public String getReceiptBy() {
        return receiptBy;
    }

    public void setReceiptNumber(Long receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public Long getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptMoney(Long receiptMoney) {
        this.receiptMoney = receiptMoney;
    }

    public Long getReceiptMoney() {
        return receiptMoney;
    }

    public void setReceiptVendorId(Long receiptVendorId) {
        this.receiptVendorId = receiptVendorId;
    }

    public Long getReceiptVendorId() {
        return receiptVendorId;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setReceiptPhone(String receiptPhone) {
        this.receiptPhone = receiptPhone;
    }

    public String getReceiptPhone() {
        return receiptPhone;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getState() {
        return state;
    }

    public void setIsDelete(Long isDelete) {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("receiptId", getReceiptId())
                .append("receiptClod", getReceiptClod())
                .append("receiptTime", getReceiptTime())
                .append("receiptBy", getReceiptBy())
                .append("receiptNumber", getReceiptNumber())
                .append("receiptMoney", getReceiptMoney())
                .append("remark", getRemark())
                .append("receiptVendorId", getReceiptVendorId())
                .append("contact", getContact())
                .append("receiptPhone", getReceiptPhone())
                .append("state", getState())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}