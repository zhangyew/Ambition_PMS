package com.yz.bidding.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购合同管理详情视图
 */
public class PurchaseContractsVo extends BaseEntity{
    private static final long serialVersionUID = 1L;
    /** 合同明细ID */
    private Long contractdetailsId;

    @Override
    public String toString() {
        return "PurchaseContractsVo{" +
                "contractdetailsId=" + contractdetailsId +
                ", tenderProjectsId=" + tenderProjectsId +
                ", contractdetailsNumber='" + contractdetailsNumber + '\'' +
                ", contractdetailsName='" + contractdetailsName + '\'' +
                ", contractdetailsType=" + contractdetailsType +
                ", openTime=" + openTime +
                ", contractdetailsAmount=" + contractdetailsAmount +
                ", contractdetailsLevel=" + contractdetailsLevel +
                ", illustrate='" + illustrate + '\'' +
                ", bidEnd=" + bidEnd +
                ", contractdetailsState=" + contractdetailsState +
                ", vendorId=" + vendorId +
                ", procurementMethod=" + procurementMethod +
                ", purchaseListId=" + purchaseListId +
                ", tenderProjectsName='" + tenderProjectsName + '\'' +
                ", abbreviated='" + abbreviated + '\'' +
                ", applicant='" + applicant + '\'' +
                ", applicantTime=" + applicantTime +
                ", contractSector='" + contractSector + '\'' +
                ", firm='" + firm + '\'' +
                ", contractProjectRelated=" + contractProjectRelated +
                ", contractProjectsId=" + contractProjectsId +
                ", contractMaster=" + contractMaster +
                ", contractPrimeId=" + contractPrimeId +
                ", contractTotalBudget=" + contractTotalBudget +
                ", contractParent=" + contractParent +
                ", planName='" + planName + '\'' +
                ", signatoriesNumber=" + signatoriesNumber +
                ", signingSubject='" + signingSubject + '\'' +
                ", signingAddress='" + signingAddress + '\'' +
                ", signingContact='" + signingContact + '\'' +
                ", signingContactMode='" + signingContactMode + '\'' +
                ", signingBank='" + signingBank + '\'' +
                ", signingBankAccount='" + signingBankAccount + '\'' +
                ", sigingAmount=" + sigingAmount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Long getTenderProjectsId() {
        return tenderProjectsId;
    }

    public void setTenderProjectsId(Long tenderProjectsId) {
        this.tenderProjectsId = tenderProjectsId;
    }

    private Long tenderProjectsId;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractdetailsNumber;

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

    /** 合同状态（数据字典） */
    @Excel(name = "合同状态", readConverterExp = "数=据字典")
    private Long contractdetailsState;

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    private Long vendorId;

    /** 采购方式（1：招标 2：采购计划） */
    @Excel(name = "采购方式", readConverterExp = "1=：招标,2=：采购计划")
    private Long procurementMethod;

    /** 采购订单ID（外键） */
    @Excel(name = "采购订单ID", readConverterExp = "外=键")
    private Long purchaseListId;

    @Excel(name = "项目名称")
    private String tenderProjectsName;

    @Excel(name = "供应商名称")
    private String abbreviated;

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

    /**
     * 采购计划名称
     */
    @Excel(name = "采购计划名称")
    private String planName;


    /** 签署方数（1：双方签署 2：三方签署） */
    @Excel(name = "签署方数", readConverterExp = "1=：双方签署,2=：三方签署")
    private Long signatoriesNumber;

    /** 我方主体 */
    @Excel(name = "我方主体")
    private String signingSubject;

    /** 乙方供应商公司地址 */
    @Excel(name = "乙方供应商公司地址")
    private String signingAddress;

    /** 乙方联系人 */
    @Excel(name = "乙方联系人")
    private String signingContact;

    /** 乙方联系方式 */
    @Excel(name = "乙方联系方式")
    private String signingContactMode;

    /** 乙户开户行 */
    @Excel(name = "乙户开户行")
    private String signingBank;

    /** 开户账号 */
    @Excel(name = "开户账号")
    private String signingBankAccount;

    /** 合同方金额 */
    @Excel(name = "合同方金额")
    private BigDecimal sigingAmount;

    /** 币别 */
    @Excel(name = "币别")
    private String currency;


    public PurchaseContractsVo(Long contractdetailsId, String contractdetailsNumber, String contractdetailsName, Long contractdetailsType, Date openTime, Long contractdetailsAmount, Long contractdetailsLevel, String illustrate, Date bidEnd, Long contractdetailsState, Long procurementMethod, Long purchaseListId, String tenderProjectsName, String abbreviated, String applicant, Date applicantTime, String contractSector, String firm, Long contractProjectRelated, Long contractProjectsId, Long contractMaster, Long contractPrimeId, BigDecimal contractTotalBudget, Long contractParent, String planName, Long signatoriesNumber, String signingSubject, String signingAddress, String signingContact, String signingContactMode, String signingBank, String signingBankAccount, BigDecimal sigingAmount, String currency) {
        this.contractdetailsId = contractdetailsId;
        this.contractdetailsNumber = contractdetailsNumber;
        this.contractdetailsName = contractdetailsName;
        this.contractdetailsType = contractdetailsType;
        this.openTime = openTime;
        this.contractdetailsAmount = contractdetailsAmount;
        this.contractdetailsLevel = contractdetailsLevel;
        this.illustrate = illustrate;
        this.bidEnd = bidEnd;
        this.contractdetailsState = contractdetailsState;
        this.procurementMethod = procurementMethod;
        this.purchaseListId = purchaseListId;
        this.tenderProjectsName = tenderProjectsName;
        this.abbreviated = abbreviated;
        this.applicant = applicant;
        this.applicantTime = applicantTime;
        this.contractSector = contractSector;
        this.firm = firm;
        this.contractProjectRelated = contractProjectRelated;
        this.contractProjectsId = contractProjectsId;
        this.contractMaster = contractMaster;
        this.contractPrimeId = contractPrimeId;
        this.contractTotalBudget = contractTotalBudget;
        this.contractParent = contractParent;
        this.planName = planName;
        this.signatoriesNumber = signatoriesNumber;
        this.signingSubject = signingSubject;
        this.signingAddress = signingAddress;
        this.signingContact = signingContact;
        this.signingContactMode = signingContactMode;
        this.signingBank = signingBank;
        this.signingBankAccount = signingBankAccount;
        this.sigingAmount = sigingAmount;
        this.currency = currency;
    }

    public PurchaseContractsVo() {
    }

    public Long getContractdetailsId() {
        return contractdetailsId;
    }

    public void setContractdetailsId(Long contractdetailsId) {
        this.contractdetailsId = contractdetailsId;
    }

    public String getContractdetailsNumber() {
        return contractdetailsNumber;
    }

    public void setContractdetailsNumber(String contractdetailsNumber) {
        this.contractdetailsNumber = contractdetailsNumber;
    }

    public String getContractdetailsName() {
        return contractdetailsName;
    }

    public void setContractdetailsName(String contractdetailsName) {
        this.contractdetailsName = contractdetailsName;
    }

    public Long getContractdetailsType() {
        return contractdetailsType;
    }

    public void setContractdetailsType(Long contractdetailsType) {
        this.contractdetailsType = contractdetailsType;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Long getContractdetailsAmount() {
        return contractdetailsAmount;
    }

    public void setContractdetailsAmount(Long contractdetailsAmount) {
        this.contractdetailsAmount = contractdetailsAmount;
    }

    public Long getContractdetailsLevel() {
        return contractdetailsLevel;
    }

    public void setContractdetailsLevel(Long contractdetailsLevel) {
        this.contractdetailsLevel = contractdetailsLevel;
    }

    public String getIllustrate() {
        return illustrate;
    }

    public void setIllustrate(String illustrate) {
        this.illustrate = illustrate;
    }

    public Date getBidEnd() {
        return bidEnd;
    }

    public void setBidEnd(Date bidEnd) {
        this.bidEnd = bidEnd;
    }

    public Long getContractdetailsState() {
        return contractdetailsState;
    }

    public void setContractdetailsState(Long contractdetailsState) {
        this.contractdetailsState = contractdetailsState;
    }

    public Long getProcurementMethod() {
        return procurementMethod;
    }

    public void setProcurementMethod(Long procurementMethod) {
        this.procurementMethod = procurementMethod;
    }

    public Long getPurchaseListId() {
        return purchaseListId;
    }

    public void setPurchaseListId(Long purchaseListId) {
        this.purchaseListId = purchaseListId;
    }

    public String getTenderProjectsName() {
        return tenderProjectsName;
    }

    public void setTenderProjectsName(String tenderProjectsName) {
        this.tenderProjectsName = tenderProjectsName;
    }

    public String getAbbreviated() {
        return abbreviated;
    }

    public void setAbbreviated(String abbreviated) {
        this.abbreviated = abbreviated;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getApplicantTime() {
        return applicantTime;
    }

    public void setApplicantTime(Date applicantTime) {
        this.applicantTime = applicantTime;
    }

    public String getContractSector() {
        return contractSector;
    }

    public void setContractSector(String contractSector) {
        this.contractSector = contractSector;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public Long getContractProjectRelated() {
        return contractProjectRelated;
    }

    public void setContractProjectRelated(Long contractProjectRelated) {
        this.contractProjectRelated = contractProjectRelated;
    }

    public Long getContractProjectsId() {
        return contractProjectsId;
    }

    public void setContractProjectsId(Long contractProjectsId) {
        this.contractProjectsId = contractProjectsId;
    }

    public Long getContractMaster() {
        return contractMaster;
    }

    public void setContractMaster(Long contractMaster) {
        this.contractMaster = contractMaster;
    }

    public Long getContractPrimeId() {
        return contractPrimeId;
    }

    public void setContractPrimeId(Long contractPrimeId) {
        this.contractPrimeId = contractPrimeId;
    }

    public BigDecimal getContractTotalBudget() {
        return contractTotalBudget;
    }

    public void setContractTotalBudget(BigDecimal contractTotalBudget) {
        this.contractTotalBudget = contractTotalBudget;
    }

    public Long getContractParent() {
        return contractParent;
    }

    public void setContractParent(Long contractParent) {
        this.contractParent = contractParent;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Long getSignatoriesNumber() {
        return signatoriesNumber;
    }

    public void setSignatoriesNumber(Long signatoriesNumber) {
        this.signatoriesNumber = signatoriesNumber;
    }

    public String getSigningSubject() {
        return signingSubject;
    }

    public void setSigningSubject(String signingSubject) {
        this.signingSubject = signingSubject;
    }

    public String getSigningAddress() {
        return signingAddress;
    }

    public void setSigningAddress(String signingAddress) {
        this.signingAddress = signingAddress;
    }

    public String getSigningContact() {
        return signingContact;
    }

    public void setSigningContact(String signingContact) {
        this.signingContact = signingContact;
    }

    public String getSigningContactMode() {
        return signingContactMode;
    }

    public void setSigningContactMode(String signingContactMode) {
        this.signingContactMode = signingContactMode;
    }

    public String getSigningBank() {
        return signingBank;
    }

    public void setSigningBank(String signingBank) {
        this.signingBank = signingBank;
    }

    public String getSigningBankAccount() {
        return signingBankAccount;
    }

    public void setSigningBankAccount(String signingBankAccount) {
        this.signingBankAccount = signingBankAccount;
    }

    public BigDecimal getSigingAmount() {
        return sigingAmount;
    }

    public void setSigingAmount(BigDecimal sigingAmount) {
        this.sigingAmount = sigingAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
