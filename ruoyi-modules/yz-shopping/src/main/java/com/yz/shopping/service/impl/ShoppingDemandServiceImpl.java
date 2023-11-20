package com.yz.shopping.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.ShoppingDemandMapper;
import com.yz.shopping.domain.ShoppingDemand;
import com.yz.shopping.service.IShoppingDemandService;

/**
 * 采购需求物料表Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-20
 */
@Service
public class ShoppingDemandServiceImpl implements IShoppingDemandService 
{
    @Autowired
    private ShoppingDemandMapper shoppingDemandMapper;

    /**
     * 查询采购需求物料表
     * 
     * @param demandId 采购需求物料表主键
     * @return 采购需求物料表
     */
    @Override
    public ShoppingDemand selectShoppingDemandByDemandId(Long demandId)
    {
        return shoppingDemandMapper.selectShoppingDemandByDemandId(demandId);
    }

    /**
     * 查询采购需求物料表列表
     * 
     * @param shoppingDemand 采购需求物料表
     * @return 采购需求物料表
     */
    @Override
    public List<ShoppingDemand> selectShoppingDemandList(ShoppingDemand shoppingDemand)
    {
        return shoppingDemandMapper.selectShoppingDemandList(shoppingDemand);
    }

    /**
     * 新增采购需求物料表
     * 
     * @param shoppingDemand 采购需求物料表
     * @return 结果
     */
    @Override
    public int insertShoppingDemand(ShoppingDemand shoppingDemand)
    {
        return shoppingDemandMapper.insertShoppingDemand(shoppingDemand);
    }

    /**
     * 修改采购需求物料表
     * 
     * @param shoppingDemand 采购需求物料表
     * @return 结果
     */
    @Override
    public int updateShoppingDemand(ShoppingDemand shoppingDemand)
    {
        return shoppingDemandMapper.updateShoppingDemand(shoppingDemand);
    }

    /**
     * 批量删除采购需求物料表
     * 
     * @param demandIds 需要删除的采购需求物料表主键
     * @return 结果
     */
    @Override
    public int deleteShoppingDemandByDemandIds(Long[] demandIds)
    {
        return shoppingDemandMapper.deleteShoppingDemandByDemandIds(demandIds);
    }

    /**
     * 删除采购需求物料表信息
     * 
     * @param demandId 采购需求物料表主键
     * @return 结果
     */
    @Override
    public int deleteShoppingDemandByDemandId(Long demandId)
    {
        return shoppingDemandMapper.deleteShoppingDemandByDemandId(demandId);
    }
}
