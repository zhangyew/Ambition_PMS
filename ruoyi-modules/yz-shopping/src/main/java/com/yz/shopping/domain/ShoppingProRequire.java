package com.yz.shopping.domain;

import com.ruoyi.system.api.domain.PublicGoods;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.util.List;

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
    private String requireDemandId;

    @Excel(name = "需求物料id", readConverterExp = "外=键")
    private List<String> publicGoodsList;

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

    @Excel(name = "是否转成招标项目")
    private Long isTender;

    @Override
    public String toString() {
        return "ShoppingProRequire{" +
                "requireId=" + requireId +
                ", requireDemandId='" + requireDemandId + '\'' +
                ", publicGoodsList=" + publicGoodsList +
                ", requireNumber='" + requireNumber + '\'' +
                ", requirePerson='" + requirePerson + '\'' +
                ", requireDept='" + requireDept + '\'' +
                ", requireType=" + requireType +
                ", isTender=" + isTender +
                ", requireVendor=" + requireVendor +
                ", vendorName='" + vendorName + '\'' +
                ", totalMoney=" + totalMoney +
                ", requireContact='" + requireContact + '\'' +
                ", mainPurpose='" + mainPurpose + '\'' +
                ", requireAddress='" + requireAddress + '\'' +
                ", requirePhone='" + requirePhone + '\'' +
                ", requireState=" + requireState +
                ", isDelete=" + isDelete +
                ", shoppingDemands=" + shoppingDemands +
                ", bcglXiangXiList=" + bcglXiangXiList +
                '}';
    }

    public Long getIsTender() {
        return isTender;
    }

    public void setIsTender(Long isTender) {
        this.isTender = isTender;
    }

    @Excel(name = "供应商")
    /**
     * 需求供应商
     */
    private Long requireVendor;
    private String vendorName;

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Long getRequireVendor() {
        return requireVendor;
    }

    public void setRequireVendor(Long requireVendor) {
        this.requireVendor = requireVendor;
    }

    /** 总金额 */
    @Excel(name = "总金额")
    private Double totalMoney;

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

    /**
     * 采购需求物料
     */
    private List<ShoppingDemand> shoppingDemands;

    public List<ShoppingDemand> getShoppingDemands() {
        return shoppingDemands;
    }

    public void setShoppingDemands(List<ShoppingDemand> shoppingDemands) {
        this.shoppingDemands = shoppingDemands;
    }

    /**
     * 物料集合
     * @return
     */
    public List<ShoppingDemand> getBcglXiangXiList() {
        return bcglXiangXiList;
    }

    public void setBcglXiangXiList(List<ShoppingDemand> bcglXiangXiList) {
        this.bcglXiangXiList = bcglXiangXiList;
    }

    private List<ShoppingDemand> bcglXiangXiList;

    public List<String> getPublicGoodsList() {
        return publicGoodsList;
    }

    public void setPublicGoodsList(List<String> publicGoodsList) {
        this.publicGoodsList = publicGoodsList;
    }

    public void setRequireId(Long requireId)
    {
        this.requireId = requireId;
    }

    public Long getRequireId() 
    {
        return requireId;
    }
    public void setRequireDemandId(String requireDemandId)
    {
        this.requireDemandId = requireDemandId;
    }

    public String getRequireDemandId()
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
    public void setTotalMoney(Double totalMoney)
    {
        this.totalMoney = totalMoney;
    }

    public Double getTotalMoney()
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

}
