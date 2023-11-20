package com.yz.shopping.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 采购需求表对象 shopping_pro_require
 * 
 * @author zhangye
 * @date 2023-11-20
 */
public class ShoppingProRequire extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 需求表id */
    private Long requireId;

    /** 需求物料id（外键） */
    @Excel(name = "需求物料id", readConverterExp = "外=键")
    private Long requireDemandId;

    /** 需求编号 */
    @Excel(name = "需求编号")
    private String requireNumber;

    /** 需求人 */
    @Excel(name = "需求人")
    private String requirePerson;

    /** 需求部门 */
    @Excel(name = "需求部门")
    private String requireDept;

    /** 需求类型（字典外键） */
    @Excel(name = "需求类型", readConverterExp = "字=典外键")
    private Long requireType;

    /** 总金额 */
    @Excel(name = "总金额")
    private Long totalMoney;

    /** 收货联系人 */
    @Excel(name = "收货联系人")
    private String requireContact;

    /** 主要用途及说明 */
    @Excel(name = "主要用途及说明")
    private String mainPurpose;

    /** 活动地址 */
    @Excel(name = "活动地址")
    private String requireAddress;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String requirePhone;

    /** 状态 */
    @Excel(name = "状态")
    private Long requireState;

    /** 删除 */
    @Excel(name = "删除")
    private Long isDelete;

    public void setRequireId(Long requireId) 
    {
        this.requireId = requireId;
    }

    public Long getRequireId() 
    {
        return requireId;
    }
    public void setRequireDemandId(Long requireDemandId) 
    {
        this.requireDemandId = requireDemandId;
    }

    public Long getRequireDemandId() 
    {
        return requireDemandId;
    }
    public void setRequireNumber(String requireNumber) 
    {
        this.requireNumber = requireNumber;
    }

    public String getRequireNumber() 
    {
        return requireNumber;
    }
    public void setRequirePerson(String requirePerson) 
    {
        this.requirePerson = requirePerson;
    }

    public String getRequirePerson() 
    {
        return requirePerson;
    }
    public void setRequireDept(String requireDept) 
    {
        this.requireDept = requireDept;
    }

    public String getRequireDept() 
    {
        return requireDept;
    }
    public void setRequireType(Long requireType) 
    {
        this.requireType = requireType;
    }

    public Long getRequireType() 
    {
        return requireType;
    }
    public void setTotalMoney(Long totalMoney) 
    {
        this.totalMoney = totalMoney;
    }

    public Long getTotalMoney() 
    {
        return totalMoney;
    }
    public void setRequireContact(String requireContact) 
    {
        this.requireContact = requireContact;
    }

    public String getRequireContact() 
    {
        return requireContact;
    }
    public void setMainPurpose(String mainPurpose) 
    {
        this.mainPurpose = mainPurpose;
    }

    public String getMainPurpose() 
    {
        return mainPurpose;
    }
    public void setRequireAddress(String requireAddress) 
    {
        this.requireAddress = requireAddress;
    }

    public String getRequireAddress() 
    {
        return requireAddress;
    }
    public void setRequirePhone(String requirePhone) 
    {
        this.requirePhone = requirePhone;
    }

    public String getRequirePhone() 
    {
        return requirePhone;
    }
    public void setRequireState(Long requireState) 
    {
        this.requireState = requireState;
    }

    public Long getRequireState() 
    {
        return requireState;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("requireId", getRequireId())
            .append("requireDemandId", getRequireDemandId())
            .append("requireNumber", getRequireNumber())
            .append("requirePerson", getRequirePerson())
            .append("requireDept", getRequireDept())
            .append("requireType", getRequireType())
            .append("totalMoney", getTotalMoney())
            .append("requireContact", getRequireContact())
            .append("mainPurpose", getMainPurpose())
            .append("requireAddress", getRequireAddress())
            .append("requirePhone", getRequirePhone())
            .append("requireState", getRequireState())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
