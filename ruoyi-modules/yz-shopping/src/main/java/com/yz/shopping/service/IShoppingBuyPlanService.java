package com.yz.shopping.service;

import java.util.List;
import com.yz.shopping.domain.ShoppingBuyPlan;

/**
 * 采购计划表Service接口
 * 
 * @author zhangye
 * @date 2023-11-20
 */
public interface IShoppingBuyPlanService 
{
    /**
     * 查询采购计划表
     * 
     * @param buyPlanId 采购计划表主键
     * @return 采购计划表
     */
    public ShoppingBuyPlan selectShoppingBuyPlanByBuyPlanId(Long buyPlanId);

    /**
     * 查询采购计划表列表
     * 
     * @param shoppingBuyPlan 采购计划表
     * @return 采购计划表集合
     */
    public List<ShoppingBuyPlan> selectShoppingBuyPlanList(ShoppingBuyPlan shoppingBuyPlan);

    /**
     * 新增采购计划表
     * 
     * @param shoppingBuyPlan 采购计划表
     * @return 结果
     */
    public int insertShoppingBuyPlan(ShoppingBuyPlan shoppingBuyPlan);

    /**
     * 修改采购计划表
     * 
     * @param shoppingBuyPlan 采购计划表
     * @return 结果
     */
    public int updateShoppingBuyPlan(ShoppingBuyPlan shoppingBuyPlan);

    /**
     * 批量删除采购计划表
     * 
     * @param buyPlanIds 需要删除的采购计划表主键集合
     * @return 结果
     */
    public int deleteShoppingBuyPlanByBuyPlanIds(Long[] buyPlanIds);

    /**
     * 删除采购计划表信息
     * 
     * @param buyPlanId 采购计划表主键
     * @return 结果
     */
    public int deleteShoppingBuyPlanByBuyPlanId(Long buyPlanId);
}
