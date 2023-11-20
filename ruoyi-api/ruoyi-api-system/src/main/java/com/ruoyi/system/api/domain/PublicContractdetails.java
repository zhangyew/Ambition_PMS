package com.ruoyi.system.api.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 合同明细对象 public_contractdetails
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicContractdetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 合同明细ID
     */
    private Long contractdetailsId;

    /**
     * 合同ID
     */
    @Excel(name = "合同ID")
    private Long conContractId;

    /**
     * 外键合同付款ID
     */
    @Excel(name = "外键合同付款ID")
    private Long contractdetailsPaymentId;

    /**
     * 仓库名称
     */
    @Excel(name = "仓库名称")
    private String contractdetailsName;

    /**
     * 字典外键
     */
    @Excel(name = "字典外键")
    private Long contractdetailsType;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date openTime;

    /**
     * 合同总金额
     */
    @Excel(name = "合同总金额")
    private Long contractdetailsAmount;

    /**
     * 合同情况说明
     */
    @Excel(name = "合同情况说明")
    private String illustrate;

    /**
     * 投标结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "投标结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bidEnd;

    public void setContractdetailsId(Long contractdetailsId) {
        this.contractdetailsId = contractdetailsId;
    }

    public Long getContractdetailsId() {
        return contractdetailsId;
    }

    public void setConContractId(Long conContractId) {
        this.conContractId = conContractId;
    }

    public Long getConContractId() {
        return conContractId;
    }

    public void setContractdetailsPaymentId(Long contractdetailsPaymentId) {
        this.contractdetailsPaymentId = contractdetailsPaymentId;
    }

    public Long getContractdetailsPaymentId() {
        return contractdetailsPaymentId;
    }

    public void setContractdetailsName(String contractdetailsName) {
        this.contractdetailsName = contractdetailsName;
    }

    public String getContractdetailsName() {
        return contractdetailsName;
    }

    public void setContractdetailsType(Long contractdetailsType) {
        this.contractdetailsType = contractdetailsType;
    }

    public Long getContractdetailsType() {
        return contractdetailsType;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setContractdetailsAmount(Long contractdetailsAmount) {
        this.contractdetailsAmount = contractdetailsAmount;
    }

    public Long getContractdetailsAmount() {
        return contractdetailsAmount;
    }

    public void setIllustrate(String illustrate) {
        this.illustrate = illustrate;
    }

    public String getIllustrate() {
        return illustrate;
    }

    public void setBidEnd(Date bidEnd) {
        this.bidEnd = bidEnd;
    }

    public Date getBidEnd() {
        return bidEnd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("contractdetailsId", getContractdetailsId())
                .append("conContractId", getConContractId())
                .append("contractdetailsPaymentId", getContractdetailsPaymentId())
                .append("contractdetailsName", getContractdetailsName())
                .append("contractdetailsType", getContractdetailsType())
                .append("openTime", getOpenTime())
                .append("contractdetailsAmount", getContractdetailsAmount())
                .append("illustrate", getIllustrate())
                .append("bidEnd", getBidEnd())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
