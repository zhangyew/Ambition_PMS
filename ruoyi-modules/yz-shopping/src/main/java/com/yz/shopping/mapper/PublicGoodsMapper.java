package com.yz.shopping.mapper;

import java.util.List;

import com.ruoyi.system.api.domain.PublicGoods;
import org.apache.ibatis.annotations.Param;

/**
 * 物料Mapper接口
 *
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicGoodsMapper {
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
     * 物料组件查询列表
     * @param mc 物料名称
     * @param fl 物料分类
     * @param gys 供应商名称
     * @return 物料集合
     */
    public List<PublicGoods> findGoodsList(@Param("mc") String mc
            , @Param("fl") String fl, @Param("gys") String gys);

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
     * 下架物料
     *
     * @param goodsId 物料主键
     * @return 结果
     */
    public int deletePublicGoodsByGoodsId1(Long goodsId);

    /**
     * 上架物料
     *
     * @param goodsId 物料主键
     * @return 结果
     */
    public int deletePublicGoodsByGoodsId2(Long goodsId);

    /**
     * 批量删除物料
     *
     * @param goodsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicGoodsByGoodsIds(Long[] goodsIds);

}
