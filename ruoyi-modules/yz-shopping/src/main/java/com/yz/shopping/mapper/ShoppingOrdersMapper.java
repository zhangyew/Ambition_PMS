package com.yz.shopping.mapper;

import java.util.List;
import com.yz.shopping.domain.ShoppingOrders;

/**
 * 采购订单表Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-20
 */
public interface ShoppingOrdersMapper 
{
    /**
     * 查询采购订单表
     * 
     * @param orderId 采购订单表主键
     * @return 采购订单表
     */
    public ShoppingOrders selectShoppingOrdersByOrderId(Long orderId);

    /**
     * 查询采购订单表列表
     * 
     * @param shoppingOrders 采购订单表
     * @return 采购订单表集合
     */
    public List<ShoppingOrders> selectShoppingOrdersList(ShoppingOrders shoppingOrders);

    /**
     * 新增采购订单表
     * 
     * @param shoppingOrders 采购订单表
     * @return 结果
     */
    public int insertShoppingOrders(ShoppingOrders shoppingOrders);

    /**
     * 修改采购订单表
     * 
     * @param shoppingOrders 采购订单表
     * @return 结果
     */
    public int updateShoppingOrders(ShoppingOrders shoppingOrders);

    /**
     * 删除采购订单表
     * 
     * @param orderId 采购订单表主键
     * @return 结果
     */
    public int deleteShoppingOrdersByOrderId(Long orderId);

    /**
     * 批量删除采购订单表
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShoppingOrdersByOrderIds(Long[] orderIds);
}