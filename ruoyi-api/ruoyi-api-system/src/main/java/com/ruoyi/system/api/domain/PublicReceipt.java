package com.ruoyi.system.api.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 收货单对象 public_receipt
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicReceipt extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 收货单ID */
    private Long receiptId;

    /** 收货单号 */
    @Excel(name = "收货单号")
    private String receiptClod;

    /** 收货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiptTime;

    /** 收货人 */
    @Excel(name = "收货人")
    private String receiptBy;

    /** 收货总数量 */
    @Excel(name = "收货总数量")
    private Long receiptNumber;

    /** 金额 */
    @Excel(name = "金额")
    private Long receiptMoney;

    /** 供应商ID（外键） */
    @Excel(name = "供应商ID", readConverterExp = "外=键")
    private Long receiptVendorId;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contact;

    /** 移动电话 */
    @Excel(name = "移动电话")
    private String receiptPhone;

    /** 状态 */
    @Excel(name = "状态")
    private Long receiptState;

    /** 采购订单ID（外键） */
    @Excel(name = "采购订单ID", readConverterExp = "外=键")
    private Long receiptOrdersId;

    /** 仓库ID（外键） */
    @Excel(name = "仓库ID", readConverterExp = "外=键")
    private Long receiptWarehouseId;

    /** 删除 */
    @Excel(name = "删除")
    private Long isDelete;

    /**
     * 新增字段
     * @param receiptId
     */
    /** 订单号 */
    private Long orderId;
    public void setOrderId(Long orderId) {this.orderId = orderId;}
    public Long getOrderId()
    {
        return orderId;
    }
    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNumber;
    public void setOrderNumber(String orderNumber) {this.orderNumber = orderNumber;}
    public String getOrderNumber()
    {
        return orderNumber;
    }
    /** 订单标题 */
    @Excel(name = "订单标题")
    private String orderTitle;
    public void setOrderTitle(String orderTitle) {this.orderTitle = orderTitle;}
    public String getOrderTitle()
    {
        return orderTitle;
    }
    /** 简称 */
    @Excel(name = "简称")
    private String abbreviated;
    public void setAbbreviated(String abbreviated) {this.abbreviated = abbreviated;}
    public String getAbbreviated() {
        return abbreviated;
    }
    /** 数量 */
    @Excel(name = "数量")
    private Long demandCount;
    public void setDemandCount(Long demandCount) {this.demandCount = demandCount;}
    public Long getDemandCount()
    {
        return demandCount;
    }
    /** 总金额 */
    @Excel(name = "总金额")
    private Long totalMoney;
    public void setTotalMoney(Long totalMoney) {this.totalMoney = totalMoney;}
    public Long getTotalMoney()
    {
        return totalMoney;
    }
    /** 发货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datePlusThreeDays;
    public Date getDatePlusThreeDays() {return datePlusThreeDays;}
    public void setDatePlusThreeDays(Date datePlusThreeDays) {this.datePlusThreeDays = datePlusThreeDays;}
    /** 合同id */
    @Excel(name = "合同id")
    private Long ordeContractId;

    public Long getOrdeContractId() {
        return ordeContractId;
    }

    public void setOrdeContractId(Long ordeContractId) {
        this.ordeContractId = ordeContractId;
    }

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String warehouseName;
    public String getWarehouseName() {
        return warehouseName;
    }
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
    /** 物料id */
    private String orderMaterialId;
    public String getOrderMaterialId() {return orderMaterialId;}
    public void setOrderMaterialId(String orderMaterialId) {this.orderMaterialId = orderMaterialId;}

    public void setReceiptId(Long receiptId)
    {
        this.receiptId = receiptId;
    }

    private PublicVendor publicVendor;
    private PublicWarehouse publicWarehouse;

    public PublicVendor getPublicVendor() {return publicVendor;}
    public void setPublicVendor(PublicVendor publicVendor) {this.publicVendor = publicVendor;}
    public PublicWarehouse getPublicWarehouse() {return publicWarehouse;}
    public void setPublicWarehouse(PublicWarehouse publicWarehouse) {this.publicWarehouse = publicWarehouse;}


    public Long getReceiptId()
    {
        return receiptId;
    }
    public void setReceiptClod(String receiptClod)
    {
        this.receiptClod = receiptClod;
    }

    public String getReceiptClod()
    {
        return receiptClod;
    }
    public void setReceiptTime(Date receiptTime)
    {
        this.receiptTime = receiptTime;
    }

    public Date getReceiptTime()
    {
        return receiptTime;
    }
    public void setReceiptBy(String receiptBy)
    {
        this.receiptBy = receiptBy;
    }

    public String getReceiptBy()
    {
        return receiptBy;
    }
    public void setReceiptNumber(Long receiptNumber)
    {
        this.receiptNumber = receiptNumber;
    }

    public Long getReceiptNumber()
    {
        return receiptNumber;
    }
    public void setReceiptMoney(Long receiptMoney)
    {
        this.receiptMoney = receiptMoney;
    }

    public Long getReceiptMoney()
    {
        return receiptMoney;
    }
    public void setReceiptVendorId(Long receiptVendorId)
    {
        this.receiptVendorId = receiptVendorId;
    }

    public Long getReceiptVendorId()
    {
        return receiptVendorId;
    }
    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getContact()
    {
        return contact;
    }
    public void setReceiptPhone(String receiptPhone)
    {
        this.receiptPhone = receiptPhone;
    }

    public String getReceiptPhone()
    {
        return receiptPhone;
    }

    public Long getReceiptState() {
        return receiptState;
    }

    public void setReceiptState(Long receiptState) {
        this.receiptState = receiptState;
    }

    public void setReceiptOrdersId(Long receiptOrdersId)
    {
        this.receiptOrdersId = receiptOrdersId;
    }

    public Long getReceiptOrdersId()
    {
        return receiptOrdersId;
    }

    public void setReceiptWarehouseId(Long receiptWarehouseId)
    {
        this.receiptWarehouseId = receiptWarehouseId;
    }

    public Long getReceiptWarehouseId()
    {
        return receiptWarehouseId;
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
                .append("receiptId", getReceiptId())
                .append("receiptClod", getReceiptClod())
                .append("receiptTime", getReceiptTime())
                .append("receiptBy", getReceiptBy())
                .append("receiptNumber", getReceiptNumber())
                .append("receiptMoney", getReceiptMoney())
                .append("remark", getRemark())
                .append("receiptVendorId", getReceiptVendorId())
                .append("contact", getContact())
                .append("receiptPhone", getReceiptPhone())
                .append("receiptState", getReceiptState())
                .append("receiptOrdersId", getReceiptOrdersId())
                .append("receiptWarehouseId",getReceiptWarehouseId())
                .append("orderId",getOrderId())
                .append("orderNumber",getOrderNumber())
                .append("orderTitle",getOrderTitle())
                .append("abbreviated",getAbbreviated())
                .append("demandCount",getDemandCount())
                .append("totalMoney",getTotalMoney())
                .append("datePlusThreeDays",getDatePlusThreeDays())
                .append("warehouseName",getWarehouseName())
                .append("orderMaterialId",getOrderMaterialId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
