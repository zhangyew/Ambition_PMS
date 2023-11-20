package com.yz.bidding.service;

import java.util.List;
import com.ruoyi.system.api.domain.PublicSupply;

/**
 * 供应商供货表Service接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface IPublicSupplyService 
{
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
     * 批量删除供应商供货表
     * 
     * @param supplyIds 需要删除的供应商供货表主键集合
     * @return 结果
     */
    public int deletePublicSupplyBySupplyIds(Long[] supplyIds);

    /**
     * 删除供应商供货表信息
     * 
     * @param supplyId 供应商供货表主键
     * @return 结果
     */
    public int deletePublicSupplyBySupplyId(Long supplyId);
}
