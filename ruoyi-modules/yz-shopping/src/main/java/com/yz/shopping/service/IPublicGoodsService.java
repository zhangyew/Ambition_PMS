package com.yz.shopping.service;

import java.util.List;

import com.ruoyi.system.api.domain.PublicGoods;
import org.apache.ibatis.annotations.Param;

/**
 * 物料Service接口
 *
 * @author zhangye
 * @date 2023-11-21
 */
public interface IPublicGoodsService {

    /**
     * 物料组件查询列表
     *
     * @param mc  物料名称
     * @param fl  物料分类
     * @param gys 供应商名称
     * @return 物料集合
     */
    public List<PublicGoods> findGoodsList(String mc, String fl, String gys);

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
    public int deletePublicGoodsByGoodsId1(Long goodsId);

    public int deletePublicGoodsByGoodsId2(Long goodsId);
}
