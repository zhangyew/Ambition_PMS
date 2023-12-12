package com.yz.shopping.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import com.yz.shopping.domain.ShoppingDemand;
import com.yz.shopping.mapper.ShoppingDemandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.ShoppingBuyPlanMapper;
import com.yz.shopping.domain.ShoppingBuyPlan;
import com.yz.shopping.service.IShoppingBuyPlanService;

/**
 * 采购计划表Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-20
 */
@Service
public class ShoppingBuyPlanServiceImpl implements IShoppingBuyPlanService 
{
    @Autowired
    private ShoppingBuyPlanMapper shoppingBuyPlanMapper;
    @Autowired
    private ShoppingDemandMapper shoppingDemandMapper;
    /**
     * 查询采购计划表
     * 
     * @param buyPlanId 采购计划表主键
     * @return 采购计划表
     */
    @Override
    public ShoppingBuyPlan selectShoppingBuyPlanByBuyPlanId(Long buyPlanId)
    {
        return shoppingBuyPlanMapper.selectShoppingBuyPlanByBuyPlanId(buyPlanId);
    }

    /**
     * 查询采购计划表列表
     * 
     * @param shoppingBuyPlan 采购计划表
     * @return 采购计划表
     */
    @Override
    public List<ShoppingBuyPlan> selectShoppingBuyPlanList(ShoppingBuyPlan shoppingBuyPlan)
    {
        return shoppingBuyPlanMapper.selectShoppingBuyPlanList(shoppingBuyPlan);
    }

    /**
     * 新增采购计划表
     * 
     * @param shoppingBuyPlan 采购计划表
     * @return 结果
     */
    @Override
    public int insertShoppingBuyPlan(ShoppingBuyPlan shoppingBuyPlan) {
        shoppingBuyPlan.setCreateTime(DateUtils.getNowDate());
        String id = "";
        for (ShoppingDemand sd : shoppingBuyPlan.getShoppingDemands()) {
            int row = shoppingDemandMapper.insertShoppingDemand(sd);
            if (row <= 0) {
                throw new RuntimeException("采购计划详情添加失败");
            }
            id += sd.getDemandId() + ",";
        }
        id = id.substring(0, id.lastIndexOf(","));
        shoppingBuyPlan.setBuyPlanDemandId(id);
        int row = shoppingBuyPlanMapper.insertShoppingBuyPlan(shoppingBuyPlan);
        if (row <= 0) {
            throw new RuntimeException("采购计划添加失败");
        }
        return row;
    }
    /**
     * 修改采购计划表
     * 
     * @param shoppingBuyPlan 采购计划表
     * @return 结果
     */
    @Override
    public int updateShoppingBuyPlan(ShoppingBuyPlan shoppingBuyPlan)
    {
        shoppingBuyPlan.setUpdateTime(DateUtils.getNowDate());
        return shoppingBuyPlanMapper.updateShoppingBuyPlan(shoppingBuyPlan);
    }

    /**
     * 批量删除采购计划表
     * 
     * @param buyPlanIds 需要删除的采购计划表主键
     * @return 结果
     */
    @Override
    public int deleteShoppingBuyPlanByBuyPlanIds(Long[] buyPlanIds)
    {
        return shoppingBuyPlanMapper.deleteShoppingBuyPlanByBuyPlanIds(buyPlanIds);
    }

    /**
     * 删除采购计划表信息
     * 
     * @param buyPlanId 采购计划表主键
     * @return 结果
     */
    @Override
    public int deleteShoppingBuyPlanByBuyPlanId(Long buyPlanId)
    {
        return shoppingBuyPlanMapper.deleteShoppingBuyPlanByBuyPlanId(buyPlanId);
    }

    @Override
    public int updateExamine(ShoppingBuyPlan shoppingBuyPlan) {
        return shoppingBuyPlanMapper.updateExamine(shoppingBuyPlan);
    }
}
