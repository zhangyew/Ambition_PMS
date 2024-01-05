package com.yz.bidding.mapper;

import java.util.List;

import com.ruoyi.system.api.domain.PublicSupply;

/**
 * 供应商供货表Mapper接口
 *
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicSupplyMapper {
    /**
     * 查询详细信息
     *
     * @param sid
     * @return
     */
    public PublicSupply findPublicSupplyById(String sid);



    /**
     * 查询供应商供货表
     *
     * @param supplyId 供应商供货表主键
     * @return 供应商供货表
     */
    public PublicSupply selectPublicSupplyBySupplyId(Long supplyId);

    /**
     * 查询供应商供货表列表
     *
     * @param publicSupply 供应商供货表
     * @return 供应商供货表集合
     */
    public List<PublicSupply> selectPublicSupplyList(PublicSupply publicSupply);

    /**
     * 新增供应商供货表
     *
     * @param publicSupply 供应商供货表
     * @return 结果
     */
    public int insertPublicSupply(PublicSupply publicSupply);

    /**
     * 修改供应商供货表
     *
     * @param publicSupply 供应商供货表
     * @return 结果
     */
    public int updatePublicSupply(PublicSupply publicSupply);

    /**
     * 删除供应商供货表
     *
     * @param supplyId 供应商供货表主键
     * @return 结果
     */
    public int deletePublicSupplyBySupplyId(Long supplyId);

    /**
     * 批量删除供应商供货表
     *
     * @param supplyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicSupplyBySupplyIds(Long[] supplyIds);
}
