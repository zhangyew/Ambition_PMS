package com.yz.shopping.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 采购计划表对象 shopping_buy_plan
 * 
 * @author zhangye
 * @date 2023-11-20
 */
public class ShoppingBuyPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采购计划主键 */
    private Long buyPlanId;

    /** 采购计划编码（转订单编码，不需要修改） */
    @Excel(name = "采购计划编码", readConverterExp = "转=订单编码，不需要修改")
    private String planClod;

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * 采购计划名称
     */
    @Excel(name = "采购计划名称")
    private String planName;
    /** 供应商主键 */
    @Excel(name = "供应商主键")
    private Long buyPlanVendorId;

    /** 仓库主键 */
    @Excel(name = "仓库主键")
    private Long buyPlanWarehouseId;

    /** 采购类型 */
    @Excel(name = "采购类型")
    private Long buyTypeId;

    /** 状态 */
    @Excel(name = "状态")
    private Long state;

    /** 删除 */
    @Excel(name = "删除")
    private Long isDelete;

    public void setBuyPlanId(Long buyPlanId) 
    {
        this.buyPlanId = buyPlanId;
    }

    public Long getBuyPlanId() 
    {
        return buyPlanId;
    }
    public void setPlanClod(String planClod) 
    {
        this.planClod = planClod;
    }

    public String getPlanClod() 
    {
        return planClod;
    }
    public void setBuyPlanVendorId(Long buyPlanVendorId) 
    {
        this.buyPlanVendorId = buyPlanVendorId;
    }

    public Long getBuyPlanVendorId() 
    {
        return buyPlanVendorId;
    }
    public void setBuyPlanWarehouseId(Long buyPlanWarehouseId) 
    {
        this.buyPlanWarehouseId = buyPlanWarehouseId;
    }

    public Long getBuyPlanWarehouseId() 
    {
        return buyPlanWarehouseId;
    }
    public void setBuyTypeId(Long buyTypeId) 
    {
        this.buyTypeId = buyTypeId;
    }

    public Long getBuyTypeId() 
    {
        return buyTypeId;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
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
            .append("buyPlanId", getBuyPlanId())
            .append("planClod", getPlanClod())
            .append("buyPlanVendorId", getBuyPlanVendorId())
            .append("buyPlanWarehouseId", getBuyPlanWarehouseId())
            .append("buyTypeId", getBuyTypeId())
            .append("state", getState())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
