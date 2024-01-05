package com.yz.shopping.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.system.api.domain.PublicGoods;
import com.yz.shopping.domain.ShoppingDemand;
import com.yz.shopping.mapper.ShoppingDemandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.ShoppingProRequireMapper;
import com.yz.shopping.domain.ShoppingProRequire;
import com.yz.shopping.service.IShoppingProRequireService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * 采购需求表Service业务层处理
 *
 * @author zhangye
 * @date 2023-11-20
 */
@Service
public class ShoppingProRequireServiceImpl implements IShoppingProRequireService {
    @Autowired
    private ShoppingProRequireMapper shoppingProRequireMapper;

    @Autowired
    private ShoppingDemandMapper shoppingDemandMapper;

    /**
     * 查询采购需求表
     *
     * @param requireId 采购需求表主键
     * @return 采购需求表
     */
    @Override
    public ShoppingProRequire selectShoppingProRequireByRequireId(Long requireId) {
        ShoppingProRequire shoppingProRequire = shoppingProRequireMapper.selectShoppingProRequireByRequireId(requireId);
        if (ObjectUtils.isEmpty(shoppingProRequire)) {
            return null;
        }
        if (!ObjectUtils.isEmpty(shoppingProRequire.getRequireDemandId())){
            String[] str = shoppingProRequire.getRequireDemandId().split(",");
            List<ShoppingDemand> shoppingDemands = new ArrayList<>();
            for (String s : str) {
                ShoppingDemand shoppingDemand = shoppingDemandMapper.selectShoppingDemandByDemandId(Long.parseLong(s));
                shoppingDemands.add(shoppingDemand);
            }
            shoppingProRequire.setShoppingDemands(shoppingDemands);
        }
        return shoppingProRequire;
    }

    /**
     * 查询采购需求表列表
     *
     * @param shoppingProRequire 采购需求表
     * @return 采购需求表
     */
    @Override
    public List<ShoppingProRequire> selectShoppingProRequireList(ShoppingProRequire shoppingProRequire) {
        return shoppingProRequireMapper.selectShoppingProRequireList(shoppingProRequire);
    }

    /**
     * 新增采购需求表
     *
     * @param shoppingProRequire 采购需求表
     * @return 结果
     */
    @Override
    @Transactional
    public int insertShoppingProRequire(ShoppingProRequire shoppingProRequire) {
        shoppingProRequire.setCreateTime(DateUtils.getNowDate());
        shoppingProRequire.setRequireVendor(shoppingProRequire.getRequireVendor());
        String id = "";
        for (ShoppingDemand sd : shoppingProRequire.getShoppingDemands()) {
            int row = shoppingDemandMapper.insertShoppingDemand(sd);
            if (row <= 0) {
                throw new RuntimeException("采购需求详情添加失败");
            }
            id += sd.getDemandId() + ",";
        }
        id = id.substring(0, id.lastIndexOf(","));
        shoppingProRequire.setRequireDemandId(id);
        int row = shoppingProRequireMapper.insertShoppingProRequire(shoppingProRequire);
        if (row <= 0) {
            throw new RuntimeException("采购需求添加失败");
        }
        return row;
    }

    /**
     * 修改采购需求表
     *
     * @param shoppingProRequire 采购需求表
     * @return 结果
     */
    @Override
    @Transactional
    public int updateShoppingProRequire(ShoppingProRequire shoppingProRequire) {
        shoppingProRequire.setUpdateTime(DateUtils.getNowDate());
        shoppingProRequire.setRequireVendor(shoppingProRequire.getRequireVendor());
        ShoppingProRequire spr = shoppingProRequireMapper.selectShoppingProRequireByRequireId(shoppingProRequire.getRequireId());
        if (!ObjectUtils.isEmpty(spr.getRequireDemandId())){
            String[] strings = spr.getRequireDemandId().contains(",") ? spr.getRequireDemandId().split(",") : new String[]{spr.getRequireDemandId()};
            Long[] longs = new Long[strings.length];
            for (int i = 0; i < strings.length; i++) {
                longs[i] = Long.parseLong(strings[i]);
            }
            int row = shoppingDemandMapper.deleteShoppingDemandByDemandIds(longs);
            if (row <= 0) {
                throw new RuntimeException("修改失败");
            }
        }
        if (!ObjectUtils.isEmpty(shoppingProRequire.getShoppingDemands())) {
            String id = "";
            for (ShoppingDemand sd : shoppingProRequire.getShoppingDemands()) {
                int row = shoppingDemandMapper.insertShoppingDemand(sd);
                if (row <= 0) {
                    throw new RuntimeException("采购需求详情添加失败");
                }
                id += sd.getDemandId() + ",";
            }
            id = id.substring(0, id.lastIndexOf(","));
            shoppingProRequire.setRequireDemandId(id);
        } else {
            shoppingProRequire.setRequireDemandId("");
        }
        shoppingProRequire.setRequireState(0L);
        return shoppingProRequireMapper.updateShoppingProRequire(shoppingProRequire);
    }

    @Override
    public int updateExamine(ShoppingProRequire shoppingProRequire) {
        return shoppingProRequireMapper.updateExamine(shoppingProRequire);
    }

    /**
     * 批量删除采购需求表
     *
     * @param requireIds 需要删除的采购需求表主键
     * @return 结果
     */
    @Override
    public int deleteShoppingProRequireByRequireIds(Long[] requireIds) {
        return shoppingProRequireMapper.deleteShoppingProRequireByRequireIds(requireIds);
    }

    /**
     * 删除采购需求表信息
     *
     * @param requireId 采购需求表主键
     * @return 结果
     */
    @Override
    public int deleteShoppingProRequireByRequireId(Long requireId) {
        return shoppingProRequireMapper.deleteShoppingProRequireByRequireId(requireId);
    }

    @Override
    public int upReState(Long rid) {
        return shoppingProRequireMapper.upReState(rid);
    }
}
