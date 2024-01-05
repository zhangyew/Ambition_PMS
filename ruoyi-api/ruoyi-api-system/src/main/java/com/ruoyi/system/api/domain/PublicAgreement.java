package com.ruoyi.system.api.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 合同申请表对象 public_agreement
 *
 * @author zhangye
 * @date 2023-11-23
 */
public class PublicAgreement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同ID */
    private Long contractId;

    /** 申请人 */
    @Excel(name = "申请人")
    private String applicant;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicantTime;

    /** 申请部门 */
    @Excel(name = "申请部门")
    private String contractSector;

    /** 申请公司 */
    @Excel(name = "申请公司")
    private String firm;

    /** 项目相关合同（1：不相关 2：相关） */
    @Excel(name = "项目相关合同", readConverterExp = "1=：不相关,2=：相关")
    private Long contractProjectRelated;

    /** 相关招标的编号 */
    @Excel(name = "相关招标的编号")
    private Long contractProjectsId;

    /** 是否为主子合同（1：否 2：是） */
    @Excel(name = "是否为主子合同", readConverterExp = "1=：否,2=：是")
    private Long contractMaster;

    /** 关联主合同 */
    @Excel(name = "关联主合同")
    private Long contractPrimeId;

    /** 项目总预算 */
    @Excel(name = "项目总预算")
    private BigDecimal contractTotalBudget;

    /** 主合同 */
    @Excel(name = "主合同")
    private Long contractParent;

    /** 合同明细信息 */
    private List<PublicContractdetails> publicContractdetailsList;

    /**
     * 新增字段
     */
    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractdetailsNumber;
    /** 合同名称 */
    @Excel(name = "合同名称")
    private String contractdetailsName;
    public String getContractdetailsNumber() {return contractdetailsNumber;}
    public void setContractdetailsNumber(String contractdetailsNumber) {this.contractdetailsNumber = contractdetailsNumber;}
    public void setContractdetailsName(String contractdetailsName) {this.contractdetailsName = contractdetailsName;}
    public String getContractdetailsName() {return contractdetailsName;}


    public void setContractId(Long contractId)
    {
        this.contractId = contractId;
    }

    public Long getContractId()
    {
        return contractId;
    }
    public void setApplicant(String applicant)
    {
        this.applicant = applicant;
    }

    public String getApplicant()
    {
        return applicant;
    }
    public void setApplicantTime(Date applicantTime)
    {
        this.applicantTime = applicantTime;
    }

    public Date getApplicantTime()
    {
        return applicantTime;
    }
    public void setContractSector(String contractSector)
    {
        this.contractSector = contractSector;
    }

    public String getContractSector()
    {
        return contractSector;
    }
    public void setFirm(String firm)
    {
        this.firm = firm;
    }

    public String getFirm()
    {
        return firm;
    }
    public void setContractProjectRelated(Long contractProjectRelated)
    {
        this.contractProjectRelated = contractProjectRelated;
    }

    public Long getContractProjectRelated()
    {
        return contractProjectRelated;
    }
    public void setContractProjectsId(Long contractProjectsId)
    {
        this.contractProjectsId = contractProjectsId;
    }

    public Long getContractProjectsId()
    {
        return contractProjectsId;
    }
    public void setContractMaster(Long contractMaster)
    {
        this.contractMaster = contractMaster;
    }

    public Long getContractMaster()
    {
        return contractMaster;
    }
    public void setContractPrimeId(Long contractPrimeId)
    {
        this.contractPrimeId = contractPrimeId;
    }

    public Long getContractPrimeId()
    {
        return contractPrimeId;
    }
    public void setContractTotalBudget(BigDecimal contractTotalBudget)
    {
        this.contractTotalBudget = contractTotalBudget;
    }

    public BigDecimal getContractTotalBudget()
    {
        return contractTotalBudget;
    }
    public void setContractParent(Long contractParent)
    {
        this.contractParent = contractParent;
    }

    public Long getContractParent()
    {
        return contractParent;
    }

    public List<PublicContractdetails> getPublicContractdetailsList()
    {
        return publicContractdetailsList;
    }

    public void setPublicContractdetailsList(List<PublicContractdetails> publicContractdetailsList)
    {
        this.publicContractdetailsList = publicContractdetailsList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("contractId", getContractId())
                .append("applicant", getApplicant())
                .append("applicantTime", getApplicantTime())
                .append("contractSector", getContractSector())
                .append("firm", getFirm())
                .append("contractProjectRelated", getContractProjectRelated())
                .append("contractProjectsId", getContractProjectsId())
                .append("contractMaster", getContractMaster())
                .append("contractPrimeId", getContractPrimeId())
                .append("contractTotalBudget", getContractTotalBudget())
                .append("contractParent", getContractParent())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("publicContractdetailsList", getPublicContractdetailsList())
                .append("contractdetailsNumber",getContractdetailsNumber())
                .append("contractdetailsName",getContractdetailsName())
                .toString();
    }
}
