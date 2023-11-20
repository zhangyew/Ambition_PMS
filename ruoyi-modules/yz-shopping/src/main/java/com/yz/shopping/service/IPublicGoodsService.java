package com.yz.shopping.service;

import java.util.List;
import com.ruoyi.system.api.domain.PublicGoods;

/**
 * 物料Service接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface IPublicGoodsService 
{
    /**
     * 查询物料
     * 
     * @param goodsId 物料主键
     * @return 物料
     */
    public PublicGoods selectPublicGoodsByGoodsId(Long goodsId);

    /**
     * 查询物料列表
     * 
     * @param publicGoods 物料
     * @return 物料集合
     */
    public List<PublicGoods> selectPublicGoodsList(PublicGoods publicGoods);

    /**
     * 新增物料
     * 
     * @param publicGoods 物料
     * @return 结果
     */
    public int insertPublicGoods(PublicGoods publicGoods);

    /**
     * 修改物料
     * 
     * @param publicGoods 物料
     * @return 结果
     */
    public int updatePublicGoods(PublicGoods publicGoods);

    /**
     * 批量删除物料
     * 
     * @param goodsIds 需要删除的物料主键集合
     * @return 结果
     */
    public int deletePublicGoodsByGoodsIds(Long[] goodsIds);

    /**
     * 删除物料信息
     * 
     * @param goodsId 物料主键
     * @return 结果
     */
    public int deletePublicGoodsByGoodsId(Long goodsId);
}
