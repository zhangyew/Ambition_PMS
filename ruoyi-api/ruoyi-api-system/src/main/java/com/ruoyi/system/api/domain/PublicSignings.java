package com.ruoyi.system.api.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 签署执行状态表对象 public_signings
 * 
 * @author zhangye
 * @date 2023-12-04
 */
public class PublicSignings extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 签署状态ID */
    private Long signingStatusId;

    /** 合同基本信息ID（外键） */
    @Excel(name = "合同基本信息ID", readConverterExp = "外=键")
    private Long signingContractdetailsId;

    /** 签署方数（1：双方签署 2：三方签署） */
    @Excel(name = "签署方数", readConverterExp = "1=：双方签署,2=：三方签署")
    private Long signatoriesNumber;

    /** 我方主体 */
    @Excel(name = "我方主体")
    private String signingSubject;

    /** 乙方供应商ID（外键） */
    @Excel(name = "乙方供应商ID", readConverterExp = "外=键")
    private Long signingVendorId;

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

    public void setSigningStatusId(Long signingStatusId) 
    {
        this.signingStatusId = signingStatusId;
    }

    public Long getSigningStatusId() 
    {
        return signingStatusId;
    }
    public void setSigningContractdetailsId(Long signingContractdetailsId) 
    {
        this.signingContractdetailsId = signingContractdetailsId;
    }

    public Long getSigningContractdetailsId() 
    {
        return signingContractdetailsId;
    }
    public void setSignatoriesNumber(Long signatoriesNumber) 
    {
        this.signatoriesNumber = signatoriesNumber;
    }

    public Long getSignatoriesNumber() 
    {
        return signatoriesNumber;
    }
    public void setSigningSubject(String signingSubject) 
    {
        this.signingSubject = signingSubject;
    }

    public String getSigningSubject() 
    {
        return signingSubject;
    }
    public void setSigningVendorId(Long signingVendorId) 
    {
        this.signingVendorId = signingVendorId;
    }

    public Long getSigningVendorId() 
    {
        return signingVendorId;
    }
    public void setSigningAddress(String signingAddress) 
    {
        this.signingAddress = signingAddress;
    }

    public String getSigningAddress() 
    {
        return signingAddress;
    }
    public void setSigningContact(String signingContact) 
    {
        this.signingContact = signingContact;
    }

    public String getSigningContact() 
    {
        return signingContact;
    }
    public void setSigningContactMode(String signingContactMode) 
    {
        this.signingContactMode = signingContactMode;
    }

    public String getSigningContactMode() 
    {
        return signingContactMode;
    }
    public void setSigningBank(String signingBank) 
    {
        this.signingBank = signingBank;
    }

    public String getSigningBank() 
    {
        return signingBank;
    }
    public void setSigningBankAccount(String signingBankAccount) 
    {
        this.signingBankAccount = signingBankAccount;
    }

    public String getSigningBankAccount() 
    {
        return signingBankAccount;
    }
    public void setSigingAmount(BigDecimal sigingAmount) 
    {
        this.sigingAmount = sigingAmount;
    }

    public BigDecimal getSigingAmount() 
    {
        return sigingAmount;
    }
    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("signingStatusId", getSigningStatusId())
            .append("signingContractdetailsId", getSigningContractdetailsId())
            .append("signatoriesNumber", getSignatoriesNumber())
            .append("signingSubject", getSigningSubject())
            .append("signingVendorId", getSigningVendorId())
            .append("signingAddress", getSigningAddress())
            .append("signingContact", getSigningContact())
            .append("signingContactMode", getSigningContactMode())
            .append("signingBank", getSigningBank())
            .append("signingBankAccount", getSigningBankAccount())
            .append("sigingAmount", getSigingAmount())
            .append("currency", getCurrency())
            .toString();
    }
}
