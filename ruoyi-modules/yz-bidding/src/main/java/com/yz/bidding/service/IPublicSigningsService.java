package com.yz.bidding.service;

import java.util.List;

import com.ruoyi.system.api.domain.PublicSignings;

/**
 * 签署执行状态表Service接口
 * 
 * @author zhangye
 * @date 2023-12-04
 */
public interface IPublicSigningsService 
{
    /**
     * 查询签署执行状态表
     * 
     * @param signingStatusId 签署执行状态表主键
     * @return 签署执行状态表
     */
    public PublicSignings selectPublicSigningsBySigningStatusId(Long signingStatusId);

    /**
     * 查询签署执行状态表列表
     * 
     * @param publicSignings 签署执行状态表
     * @return 签署执行状态表集合
     */
    public List<PublicSignings> selectPublicSigningsList(PublicSignings publicSignings);

    /**
     * 新增签署执行状态表
     * 
     * @param publicSignings 签署执行状态表
     * @return 结果
     */
    public int insertPublicSignings(PublicSignings publicSignings);

    /**
     * 修改签署执行状态表
     * 
     * @param publicSignings 签署执行状态表
     * @return 结果
     */
    public int updatePublicSignings(PublicSignings publicSignings);

    /**
     * 批量删除签署执行状态表
     * 
     * @param signingStatusIds 需要删除的签署执行状态表主键集合
     * @return 结果
     */
    public int deletePublicSigningsBySigningStatusIds(Long[] signingStatusIds);

    /**
     * 删除签署执行状态表信息
     * 
     * @param signingStatusId 签署执行状态表主键
     * @return 结果
     */
    public int deletePublicSigningsBySigningStatusId(Long signingStatusId);
}
