package com.yz.shopping.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.system.api.domain.PublicGoods;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 采购需求物料表对象 shopping_demand
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class ShoppingDemand extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采购需求物料id */
    private Long demandId;

    /** 物料id */
    @Excel(name = "物料id")
    private Long demandMaId;

    private PublicGoods publicGoods;

    public PublicGoods getPublicGoods() {
        return publicGoods;
    }

    public void setPublicGoods(PublicGoods publicGoods) {
        this.publicGoods = publicGoods;
    }

    /** 数量 */
    @Excel(name = "数量")
    private Long demandCount;

    /** 需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date demandTime;

    /** 预算金额 */
    @Excel(name = "预算金额")
    private Double budgetAmount;

    /** 已生成订单数量 */
    @Excel(name = "已生成订单数量")
    private Long orderCount;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Long warehousingCount;

    public void setDemandId(Long demandId)
    {
        this.demandId = demandId;
    }

    public Long getDemandId()
    {
        return demandId;
    }
    public void setDemandMaId(Long demandMaId)
    {
        this.demandMaId = demandMaId;
    }

    public Long getDemandMaId()
    {
        return demandMaId;
    }
    public void setDemandCount(Long demandCount)
    {
        this.demandCount = demandCount;
    }

    public Long getDemandCount()
    {
        return demandCount;
    }
    public void setDemandTime(Date demandTime)
    {
        this.demandTime = demandTime;
    }

    public Date getDemandTime()
    {
        return demandTime;
    }
    public void setBudgetAmount(Double budgetAmount)
    {
        this.budgetAmount = budgetAmount;
    }

    public Double getBudgetAmount()
    {
        return budgetAmount;
    }
    public void setOrderCount(Long orderCount)
    {
        this.orderCount = orderCount;
    }

    public Long getOrderCount()
    {
        return orderCount;
    }
    public void setWarehousingCount(Long warehousingCount)
    {
        this.warehousingCount = warehousingCount;
    }

    public Long getWarehousingCount()
    {
        return warehousingCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("demandId", getDemandId())
            .append("demandMaId", getDemandMaId())
            .append("demandCount", getDemandCount())
            .append("demandTime", getDemandTime())
            .append("remark", getRemark())
            .append("budgetAmount", getBudgetAmount())
            .append("orderCount", getOrderCount())
            .append("warehousingCount", getWarehousingCount())
            .toString();
    }
}
