package com.yz.shopping.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.system.api.domain.PublicVendor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.util.Date;


import java.util.List;

/**
 * 采购订单表对象 shopping_orders
 * 
 * @author zhangye
 * @date 2023-11-20
 */
public class ShoppingOrders extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单号 */
    private Long orderId;

    /** 需求表id */
    @Excel(name = "需求表id")
    private Long requireId;

    /** 采购计划主键 */
    @Excel(name = "采购计划主键")
    private Long buyPlanId;

    /** 订单标题 */
    @Excel(name = "订单标题")
    private String orderTitle;

    /** 订单来源 */
    @Excel(name = "订单来源")
    private Long orderSource;

    public Long getVendorContacts() {
        return vendorContacts;
    }

    public void setVendorContacts(Long vendorContacts) {
        this.vendorContacts = vendorContacts;
    }

    @Excel(name = "供应商联系人")
    private Long vendorContacts;
    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNumber;

    /** 采购人 */
    @Excel(name = "采购人")
    private String orderPurchaser;

    /** 总金额 */
    @Excel(name = "总金额")
    private Long totalMoney;

    /** 0:自提,1:配送 */
    @Excel(name = "0:自提,1:配送")
    private Long isZt;

    /** 自提车牌号 */
    @Excel(name = "自提车牌号")
    private String carNumber;

    /** 司机联系方式 */
    @Excel(name = "司机联系方式")
    private String driverPhone;

    /** 合同id */
    @Excel(name = "合同id")
    private Long ordeContractId;

    /** 订单说明 */
    @Excel(name = "订单说明")
    private String orderContext;

    /** 合同总金额 */
    @Excel(name = "合同总金额")
    private Long contractdetailsAmount;

    /** 供应商 */
    @Excel(name = "供应商")
    private Long orderSupplierId;

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public String toString() {
        return "ShoppingOrders{" +
                "orderId=" + orderId +
                ", requireId=" + requireId +
                ", buyPlanId=" + buyPlanId +
                ", orderTitle='" + orderTitle + '\'' +
                ", orderSource=" + orderSource +
                ", vendorContacts=" + vendorContacts +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderPurchaser='" + orderPurchaser + '\'' +
                ", totalMoney=" + totalMoney +
                ", isZt=" + isZt +
                ", carNumber='" + carNumber + '\'' +
                ", driverPhone='" + driverPhone + '\'' +
                ", ordeContractId=" + ordeContractId +
                ", orderContext='" + orderContext + '\'' +
                ", contractdetailsAmount=" + contractdetailsAmount +
                ", orderSupplierId=" + orderSupplierId +
                ", vendorName='" + vendorName + '\'' +
                ", orderMaterialId='" + orderMaterialId + '\'' +
                ", shoppingDemands=" + shoppingDemands +
                ", typeOrderState=" + typeOrderState +
                ", isDelete=" + isDelete +
                '}';
    }

    @Excel(name = "供应商名称")
    private String vendorName;

    /** 订单物料信息 */
    @Excel(name = "订单物料信息")
    private String orderMaterialId;

    /**
     * 物料集合
     * @return
     */
    public List<ShoppingDemand> getShoppingDemands() {
        return shoppingDemands;
    }

    public void setShoppingDemands(List<ShoppingDemand> shoppingDemands) {
        this.shoppingDemands = shoppingDemands;
    }

    private List<ShoppingDemand> shoppingDemands;
    /** 字典类型外键 */
    @Excel(name = "字典类型外键")
    private Long typeOrderState;

    /** 删除 */
    @Excel(name = "删除")
    private Long isDelete;

    @Excel(name = "供应商资质")
    private PublicVendor publicVendor;

    /** 发货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datePlusThreeDays;
    public Date getDatePlusThreeDays() {return datePlusThreeDays;}
    public void setDatePlusThreeDays(Date datePlusThreeDays) {this.datePlusThreeDays = datePlusThreeDays;}

    public PublicVendor getPublicVendor() {
        return publicVendor;
    }

    public void setPublicVendor(PublicVendor publicVendor) {
        this.publicVendor = publicVendor;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setRequireId(Long requireId) 
    {
        this.requireId = requireId;
    }

    public Long getRequireId() 
    {
        return requireId;
    }
    public void setBuyPlanId(Long buyPlanId) 
    {
        this.buyPlanId = buyPlanId;
    }

    public Long getBuyPlanId() 
    {
        return buyPlanId;
    }
    public void setOrderTitle(String orderTitle) 
    {
        this.orderTitle = orderTitle;
    }

    public String getOrderTitle() 
    {
        return orderTitle;
    }
    public void setOrderSource(Long orderSource) 
    {
        this.orderSource = orderSource;
    }

    public Long getOrderSource() 
    {
        return orderSource;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setOrderPurchaser(String orderPurchaser) 
    {
        this.orderPurchaser = orderPurchaser;
    }

    public String getOrderPurchaser() 
    {
        return orderPurchaser;
    }
    public void setTotalMoney(Long totalMoney) 
    {
        this.totalMoney = totalMoney;
    }

    public Long getTotalMoney() 
    {
        return totalMoney;
    }
    public void setIsZt(Long isZt) 
    {
        this.isZt = isZt;
    }

    public Long getIsZt() 
    {
        return isZt;
    }
    public void setCarNumber(String carNumber) 
    {
        this.carNumber = carNumber;
    }

    public String getCarNumber() 
    {
        return carNumber;
    }
    public void setDriverPhone(String driverPhone) 
    {
        this.driverPhone = driverPhone;
    }

    public String getDriverPhone() 
    {
        return driverPhone;
    }

    public void setOrderContext(String orderContext) 
    {
        this.orderContext = orderContext;
    }

    public Long getOrdeContractId() {
        return ordeContractId;
    }

    public void setOrdeContractId(Long ordeContractId) {
        this.ordeContractId = ordeContractId;
    }

    public String getOrderContext()
    {
        return orderContext;
    }
    public void setContractdetailsAmount(Long contractdetailsAmount) 
    {
        this.contractdetailsAmount = contractdetailsAmount;
    }

    public Long getContractdetailsAmount() 
    {
        return contractdetailsAmount;
    }
    public void setOrderSupplierId(Long orderSupplierId) 
    {
        this.orderSupplierId = orderSupplierId;
    }

    public Long getOrderSupplierId() 
    {
        return orderSupplierId;
    }
    public void setOrderMaterialId(String orderMaterialId)
    {
        this.orderMaterialId = orderMaterialId;
    }

    public String getOrderMaterialId()
    {
        return orderMaterialId;
    }
    public void setTypeOrderState(Long typeOrderState) 
    {
        this.typeOrderState = typeOrderState;
    }

    public Long getTypeOrderState() 
    {
        return typeOrderState;
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
