package com.yz.shopping.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.PublicGoodsMapper;
import com.ruoyi.system.api.domain.PublicGoods;
import com.yz.shopping.service.IPublicGoodsService;

/**
 * 物料Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicGoodsServiceImpl implements IPublicGoodsService 
{
    @Autowired
    private PublicGoodsMapper publicGoodsMapper;

    /**
     * 查询物料
     * 
     * @param goodsId 物料主键
     * @return 物料
     */
    @Override
    public PublicGoods selectPublicGoodsByGoodsId(Long goodsId)
    {
        return publicGoodsMapper.selectPublicGoodsByGoodsId(goodsId);
    }

    /**
     * 查询物料列表
     * 
     * @param publicGoods 物料
     * @return 物料
     */
    @Override
    public List<PublicGoods> selectPublicGoodsList(PublicGoods publicGoods)
    {
        return publicGoodsMapper.selectPublicGoodsList(publicGoods);
    }

    /**
     * 新增物料
     * 
     * @param publicGoods 物料
     * @return 结果
     */
    @Override
    public int insertPublicGoods(PublicGoods publicGoods)
    {
        publicGoods.setCreateTime(DateUtils.getNowDate());
        return publicGoodsMapper.insertPublicGoods(publicGoods);
    }

    /**
     * 修改物料
     * 
     * @param publicGoods 物料
     * @return 结果
     */
    @Override
    public int updatePublicGoods(PublicGoods publicGoods)
    {
        publicGoods.setUpdateTime(DateUtils.getNowDate());
        return publicGoodsMapper.updatePublicGoods(publicGoods);
    }

    /**
     * 批量删除物料
     * 
     * @param goodsIds 需要删除的物料主键
     * @return 结果
     */
    @Override
    public int deletePublicGoodsByGoodsIds(Long[] goodsIds)
    {
        return publicGoodsMapper.deletePublicGoodsByGoodsIds(goodsIds);
    }

    /**
     * 删除物料信息
     * 
     * @param goodsId 物料主键
     * @return 结果
     */
    @Override
    public int deletePublicGoodsByGoodsId(Long goodsId)
    {
        return publicGoodsMapper.deletePublicGoodsByGoodsId(goodsId);
    }
}
