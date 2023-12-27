package com.yz.shopping.service;

import java.util.List;

import com.ruoyi.system.api.domain.PublicAnnex;
import com.yz.shopping.domain.ShoppingOrders;
import org.apache.ibatis.annotations.Param;

/**
 * 采购订单表Service接口
 * 
 * @author zhangye
 * @date 2023-11-20
 */
public interface IShoppingOrdersService 
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
     * 供应商首页（我的订单）
     * @param oSupplierId
     * @return
     */
    public List<ShoppingOrders> showOrderSupplierId(Long oSupplierId);

    public int addOrders(ShoppingOrders shoppingOrders,List<PublicAnnex> annexList);

    /**
     * 收货单（详情显示）
     * @param orderId
     * @return
     */
    public  ShoppingOrders showsDetailsReceipt( Long orderId);

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
     * 修改待收货状态
     *
     * @param orderId 采购订单表
     * @return 结果
     */
    public int updateOrderState(Long orderId);

    /**
     * 批量删除采购订单表
     * 
     * @param orderIds 需要删除的采购订单表主键集合
     * @return 结果
     */
    public int deleteShoppingOrdersByOrderIds(Long[] orderIds);

    /**
     * 删除采购订单表信息
     * 
     * @param orderId 采购订单表主键
     * @return 结果
     */
    public int deleteShoppingOrdersByOrderId(Long orderId);

    int updateExamine(ShoppingOrders shoppingOrders);

    List<ShoppingOrders> showOO();

    int updateExamine1(ShoppingOrders shoppingOrders);
}
