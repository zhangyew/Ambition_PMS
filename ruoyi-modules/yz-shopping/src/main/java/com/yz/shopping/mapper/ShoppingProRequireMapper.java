package com.yz.shopping.mapper;

import java.util.List;

import com.yz.shopping.domain.ShoppingBuyPlan;
import com.yz.shopping.domain.ShoppingProRequire;

/**
 * 采购需求表Mapper接口
 *
 * @author zhangye
 * @date 2023-11-20
 */
public interface ShoppingProRequireMapper {
    /**
     * 查询采购需求表
     *
     * @param requireId 采购需求表主键
     * @return 采购需求表
     */
    public ShoppingProRequire selectShoppingProRequireByRequireId(Long requireId);

    /**
     * 查询采购需求表列表
     *
     * @param shoppingProRequire 采购需求表
     * @return 采购需求表集合
     */
    public List<ShoppingProRequire> selectShoppingProRequireList(ShoppingProRequire shoppingProRequire);

    /**
     * 新增采购需求表
     *
     * @param shoppingProRequire 采购需求表
     * @return 结果
     */
    public int insertShoppingProRequire(ShoppingProRequire shoppingProRequire);

    /**
     * 修改采购需求表
     *
     * @param shoppingProRequire 采购需求表
     * @return 结果
     */
    public int updateShoppingProRequire(ShoppingProRequire shoppingProRequire);

    public int updateExamine(ShoppingProRequire shoppingProRequire);

    /**
     * 删除采购需求表
     *
     * @param requireId 采购需求表主键
     * @return 结果
     */
    public int deleteShoppingProRequireByRequireId(Long requireId);

    /**
     * 批量删除采购需求表
     *
     * @param requireIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShoppingProRequireByRequireIds(Long[] requireIds);
}
