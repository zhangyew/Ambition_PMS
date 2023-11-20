package com.yz.shopping.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.ShoppingProRequireMapper;
import com.yz.shopping.domain.ShoppingProRequire;
import com.yz.shopping.service.IShoppingProRequireService;

/**
 * 采购需求表Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-20
 */
@Service
public class ShoppingProRequireServiceImpl implements IShoppingProRequireService 
{
    @Autowired
    private ShoppingProRequireMapper shoppingProRequireMapper;

    /**
     * 查询采购需求表
     * 
     * @param requireId 采购需求表主键
     * @return 采购需求表
     */
    @Override
    public ShoppingProRequire selectShoppingProRequireByRequireId(Long requireId)
    {
        return shoppingProRequireMapper.selectShoppingProRequireByRequireId(requireId);
    }

    /**
     * 查询采购需求表列表
     * 
     * @param shoppingProRequire 采购需求表
     * @return 采购需求表
     */
    @Override
    public List<ShoppingProRequire> selectShoppingProRequireList(ShoppingProRequire shoppingProRequire)
    {
        return shoppingProRequireMapper.selectShoppingProRequireList(shoppingProRequire);
    }

    /**
     * 新增采购需求表
     * 
     * @param shoppingProRequire 采购需求表
     * @return 结果
     */
    @Override
    public int insertShoppingProRequire(ShoppingProRequire shoppingProRequire)
    {
        shoppingProRequire.setCreateTime(DateUtils.getNowDate());
        return shoppingProRequireMapper.insertShoppingProRequire(shoppingProRequire);
    }

    /**
     * 修改采购需求表
     * 
     * @param shoppingProRequire 采购需求表
     * @return 结果
     */
    @Override
    public int updateShoppingProRequire(ShoppingProRequire shoppingProRequire)
    {
        shoppingProRequire.setUpdateTime(DateUtils.getNowDate());
        return shoppingProRequireMapper.updateShoppingProRequire(shoppingProRequire);
    }

    /**
     * 批量删除采购需求表
     * 
     * @param requireIds 需要删除的采购需求表主键
     * @return 结果
     */
    @Override
    public int deleteShoppingProRequireByRequireIds(Long[] requireIds)
    {
        return shoppingProRequireMapper.deleteShoppingProRequireByRequireIds(requireIds);
    }

    /**
     * 删除采购需求表信息
     * 
     * @param requireId 采购需求表主键
     * @return 结果
     */
    @Override
    public int deleteShoppingProRequireByRequireId(Long requireId)
    {
        return shoppingProRequireMapper.deleteShoppingProRequireByRequireId(requireId);
    }
}
