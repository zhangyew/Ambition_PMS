package com.yz.shopping.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.ShoppingOrdersMapper;
import com.yz.shopping.domain.ShoppingOrders;
import com.yz.shopping.service.IShoppingOrdersService;

/**
 * 采购订单表Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-20
 */
@Service
public class ShoppingOrdersServiceImpl implements IShoppingOrdersService 
{
    @Autowired
    private ShoppingOrdersMapper shoppingOrdersMapper;

    /**
     * 查询采购订单表
     * 
     * @param orderId 采购订单表主键
     * @return 采购订单表
     */
    @Override
    public ShoppingOrders selectShoppingOrdersByOrderId(Long orderId)
    {
        return shoppingOrdersMapper.selectShoppingOrdersByOrderId(orderId);
    }

    /**
     * 查询采购订单表列表
     * 
     * @param shoppingOrders 采购订单表
     * @return 采购订单表
     */
    @Override
    public List<ShoppingOrders> selectShoppingOrdersList(ShoppingOrders shoppingOrders)
    {
        return shoppingOrdersMapper.selectShoppingOrdersList(shoppingOrders);
    }

    /**
     * 供应商首页（我的订单）
     * @param oSupplierId
     * @return
     */
    @Override
    public List<ShoppingOrders> showOrderSupplierId(Long oSupplierId) {
        return shoppingOrdersMapper.showOrderSupplierId(oSupplierId);
    }

    /**
     * 收货单（详情显示）
     * @param orderId
     * @return
     */
    @Override
    public ShoppingOrders showsDetailsReceipt(Long orderId) {
        return shoppingOrdersMapper.showsDetailsReceipt(orderId);
    }

    /**
     * 新增采购订单表
     * 
     * @param shoppingOrders 采购订单表
     * @return 结果
     */
    @Override
    public int insertShoppingOrders(ShoppingOrders shoppingOrders)
    {
        shoppingOrders.setCreateTime(DateUtils.getNowDate());
        return shoppingOrdersMapper.insertShoppingOrders(shoppingOrders);
    }

    /**
     * 修改采购订单表
     * 
     * @param shoppingOrders 采购订单表
     * @return 结果
     */
    @Override
    public int updateShoppingOrders(ShoppingOrders shoppingOrders)
    {
        shoppingOrders.setUpdateTime(DateUtils.getNowDate());
        return shoppingOrdersMapper.updateShoppingOrders(shoppingOrders);
    }

    /**
     * 修改待收货状态
     * @param orderId 采购订单表
     * @return
     */
    @Override
    public int updateOrderState(Long orderId) {
        return shoppingOrdersMapper.updateOrderState(orderId);
    }

    /**
     * 批量删除采购订单表
     * 
     * @param orderIds 需要删除的采购订单表主键
     * @return 结果
     */
    @Override
    public int deleteShoppingOrdersByOrderIds(Long[] orderIds)
    {
        return shoppingOrdersMapper.deleteShoppingOrdersByOrderIds(orderIds);
    }

    /**
     * 删除采购订单表信息
     * 
     * @param orderId 采购订单表主键
     * @return 结果
     */
    @Override
    public int deleteShoppingOrdersByOrderId(Long orderId)
    {
        return shoppingOrdersMapper.deleteShoppingOrdersByOrderId(orderId);
    }
}
