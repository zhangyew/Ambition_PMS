package com.ruoyi.system.api.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 合同付款对象 public_payment
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicPayment extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 合同付款ID
     */
    private Long paymentId;

    /**
     * 款项内容
     */
    @Excel(name = "款项内容")
    private Long content;

    /**
     * 付款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "付款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /**
     * 付款单位
     */
    @Excel(name = "付款单位")
    private String unit;

    /**
     * 供应商ID（外键）
     */
    @Excel(name = "供应商ID", readConverterExp = "外=键")
    private Long paymentVendorId;

    /**
     * 付款条件
     */
    @Excel(name = "付款条件")
    private String terms;

    /**
     * 付款金额
     */
    @Excel(name = "付款金额")
    private Long sum;

    /**
     * 违约责任
     */
    @Excel(name = "违约责任")
    private String duty;

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setContent(Long content) {
        this.content = content;
    }

    public Long getContent() {
        return content;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setPaymentVendorId(Long paymentVendorId) {
        this.paymentVendorId = paymentVendorId;
    }

    public Long getPaymentVendorId() {
        return paymentVendorId;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getTerms() {
        return terms;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Long getSum() {
        return sum;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("paymentId", getPaymentId())
                .append("content", getContent())
                .append("payTime", getPayTime())
                .append("unit", getUnit())
                .append("paymentVendorId", getPaymentVendorId())
                .append("terms", getTerms())
                .append("sum", getSum())
                .append("duty", getDuty())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
