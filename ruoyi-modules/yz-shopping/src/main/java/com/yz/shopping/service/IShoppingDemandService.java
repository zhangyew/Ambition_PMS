package com.yz.shopping.service;

import java.util.List;
import com.yz.shopping.domain.ShoppingDemand;

/**
 * 采购需求物料表Service接口
 * 
 * @author zhangye
 * @date 2023-11-20
 */
public interface IShoppingDemandService 
{
    /**
     * 查询采购需求物料表
     * 
     * @param demandId 采购需求物料表主键
     * @return 采购需求物料表
     */
    public ShoppingDemand selectShoppingDemandByDemandId(Long demandId);

    /**
     * 查询采购需求物料表列表
     * 
     * @param shoppingDemand 采购需求物料表
     * @return 采购需求物料表集合
     */
    public List<ShoppingDemand> selectShoppingDemandList(ShoppingDemand shoppingDemand);

    /**
     * 新增采购需求物料表
     * 
     * @param shoppingDemand 采购需求物料表
     * @return 结果
     */
    public int insertShoppingDemand(ShoppingDemand shoppingDemand);

    /**
     * 修改采购需求物料表
     * 
     * @param shoppingDemand 采购需求物料表
     * @return 结果
     */
    public int updateShoppingDemand(ShoppingDemand shoppingDemand);

    /**
     * 批量删除采购需求物料表
     * 
     * @param demandIds 需要删除的采购需求物料表主键集合
     * @return 结果
     */
    public int deleteShoppingDemandByDemandIds(Long[] demandIds);

    /**
     * 删除采购需求物料表信息
     * 
     * @param demandId 采购需求物料表主键
     * @return 结果
     */
    public int deleteShoppingDemandByDemandId(Long demandId);
}
