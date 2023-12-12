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
/**
 * 合同明细对象 public_contractdetails
 *
 * @author zhangye
 * @date 2023-11-23
 */
public class PublicContractdetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同明细ID */
    private Long contractdetailsId;

    /** 合同申请id（外键） */
    @Excel(name = "合同申请id", readConverterExp = "外=键")
    private Long contractId;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractdetailsNumber;

    /** 外键合同付款ID */
    @Excel(name = "外键合同付款ID")
    private Long contractdetailsPaymentId;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String contractdetailsName;

    /** 合同类型 */
    @Excel(name = "合同类型")
    private Long contractdetailsType;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date openTime;

    /** 合同总金额 */
    @Excel(name = "合同总金额")
    private Long contractdetailsAmount;

    /** 密级（0：密级 1：非密） */
    @Excel(name = "密级", readConverterExp = "0=：密级,1=：非密")
    private Long contractdetailsLevel;

    /** 合同情况说明 */
    @Excel(name = "合同情况说明")
    private String illustrate;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bidEnd;

    /** 供应商外键 */
    @Excel(name = "供应商外键")
    private Long vendorContractId;

    /** 合同状态（数据字典） */
    @Excel(name = "合同状态", readConverterExp = "数=据字典")
    private Long contractdetailsState;

    /** 采购方式（1：招标 2：采购计划） */
    @Excel(name = "采购方式", readConverterExp = "1=：招标,2=：采购计划")
    private Long procurementMethod;

//    /** 招标项目ID（外键） */
//    @Excel(name = "招标项目ID", readConverterExp = "外=键")
//    private Long contractdetailsTenderProjectsId;

    /** 采购订单ID（外键） */
    @Excel(name = "采购订单ID", readConverterExp = "外=键")
    private Long purchaseListId;

    /**
     * 新增字段
     */
    @Excel(name = "项目名称")
    private String tenderProjectsName;
    public void setTenderProjectsName(String tenderProjectsName) {this.tenderProjectsName = tenderProjectsName;}
    public String getTenderProjectsName() {return tenderProjectsName;}
    @Excel(name = "供应商名称")
    private String abbreviated;
    public void setAbbreviated(String abbreviated) { this.abbreviated = abbreviated;}
    public String getAbbreviated() {return abbreviated;}
    @Excel(name = "申请人")
    private String applicant;
    public void setApplicant(String applicant) {this.applicant = applicant;}
    public String getApplicant() {return applicant;}



    public void setContractdetailsId(Long contractdetailsId){this.contractdetailsId = contractdetailsId;}
    public Long getContractdetailsId() {return contractdetailsId;}
    public void setContractId(Long contractId)
    {
        this.contractId = contractId;
    }

    public Long getContractId()
    {
        return contractId;
    }

    public void setContractdetailsNumber(String contractdetailsNumber)
    {
        this.contractdetailsNumber = contractdetailsNumber;
    }

    public String getContractdetailsNumber()
    {
        return contractdetailsNumber;
    }
    public void setContractdetailsPaymentId(Long contractdetailsPaymentId)
    {
        this.contractdetailsPaymentId = contractdetailsPaymentId;
    }

    public Long getContractdetailsPaymentId()
    {
        return contractdetailsPaymentId;
    }
    public void setContractdetailsName(String contractdetailsName)
    {
        this.contractdetailsName = contractdetailsName;
    }

    public String getContractdetailsName()
    {
        return contractdetailsName;
    }
    public void setContractdetailsType(Long contractdetailsType)
    {
        this.contractdetailsType = contractdetailsType;
    }

    public Long getContractdetailsType()
    {
        return contractdetailsType;
    }
    public void setOpenTime(Date openTime)
    {
        this.openTime = openTime;
    }

    public Date getOpenTime()
    {
        return openTime;
    }
    public void setContractdetailsAmount(Long contractdetailsAmount)
    {
        this.contractdetailsAmount = contractdetailsAmount;
    }

    public Long getContractdetailsAmount()
    {
        return contractdetailsAmount;
    }
    public void setContractdetailsLevel(Long contractdetailsLevel)
    {
        this.contractdetailsLevel = contractdetailsLevel;
    }

    public Long getContractdetailsLevel()
    {
        return contractdetailsLevel;
    }
    public void setIllustrate(String illustrate)
    {
        this.illustrate = illustrate;
    }

    public String getIllustrate()
    {
        return illustrate;
    }
    public void setBidEnd(Date bidEnd)
    {
        this.bidEnd = bidEnd;
    }

    public Date getBidEnd()
    {
        return bidEnd;
    }
    public void setVendorContractId(Long vendorContractId)
    {
        this.vendorContractId = vendorContractId;
    }

    public Long getVendorContractId()
    {
        return vendorContractId;
    }
    public void setContractdetailsState(Long contractdetailsState)
    {
        this.contractdetailsState = contractdetailsState;
    }

    public Long getContractdetailsState()
    {
        return contractdetailsState;
    }
    public void setProcurementMethod(Long procurementMethod)
    {
        this.procurementMethod = procurementMethod;
    }

    public Long getProcurementMethod()
    {
        return procurementMethod;
    }
//    public void setContractdetailsTenderProjectsId(Long contractdetailsTenderProjectsId)
//    {
//        this.contractdetailsTenderProjectsId = contractdetailsTenderProjectsId;
//    }
//
//    public Long getContractdetailsTenderProjectsId()
//    {
//        return contractdetailsTenderProjectsId;
//    }
    public void setPurchaseListId(Long purchaseListId)
    {
        this.purchaseListId = purchaseListId;
    }

    public Long getPurchaseListId()
    {
        return purchaseListId;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("contractdetailsId", getContractdetailsId())
                .append("contractId", getContractId())
                .append("contractdetailsNumber", getContractdetailsNumber())
                .append("contractdetailsPaymentId", getContractdetailsPaymentId())
                .append("contractdetailsName", getContractdetailsName())
                .append("contractdetailsType", getContractdetailsType())
                .append("openTime", getOpenTime())
                .append("contractdetailsAmount", getContractdetailsAmount())
                .append("contractdetailsLevel", getContractdetailsLevel())
                .append("illustrate", getIllustrate())
                .append("bidEnd", getBidEnd())
                .append("vendorContractId", getVendorContractId())
                .append("contractdetailsState", getContractdetailsState())
                .append("procurementMethod", getProcurementMethod())
//                .append("contractdetailsTenderProjectsId", getContractdetailsTenderProjectsId())
                .append("purchaseListId", getPurchaseListId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("tenderProjectsName",getTenderProjectsName())
                .append("abbreviated",getAbbreviated())
                .append("applicant",getApplicant())
                .toString();
    }
}
