package com.ruoyi.system.api.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 合同对象 public_contract
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicContract extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 合同ID
     */
    private Long contractId;

    /**
     * 申请人
     */
    @Excel(name = "申请人")
    private String applicant;

    /**
     * 申请日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicantTime;

    /**
     * 字典类型（外键）
     */
    @Excel(name = "字典类型", readConverterExp = "外=键")
    private Long contractTypeTypeId;

    /**
     * 申请公司
     */
    @Excel(name = "申请公司")
    private String firm;

    /**
     * 供应商外键
     */
    @Excel(name = "供应商外键")
    private Long vendorContractId;

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicantTime(Date applicantTime) {
        this.applicantTime = applicantTime;
    }

    public Date getApplicantTime() {
        return applicantTime;
    }

    public void setContractTypeTypeId(Long contractTypeTypeId) {
        this.contractTypeTypeId = contractTypeTypeId;
    }

    public Long getContractTypeTypeId() {
        return contractTypeTypeId;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getFirm() {
        return firm;
    }

    public void setVendorContractId(Long vendorContractId) {
        this.vendorContractId = vendorContractId;
    }

    public Long getVendorContractId() {
        return vendorContractId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("contractId", getContractId())
                .append("applicant", getApplicant())
                .append("applicantTime", getApplicantTime())
                .append("contractTypeTypeId", getContractTypeTypeId())
                .append("firm", getFirm())
                .append("vendorContractId", getVendorContractId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
