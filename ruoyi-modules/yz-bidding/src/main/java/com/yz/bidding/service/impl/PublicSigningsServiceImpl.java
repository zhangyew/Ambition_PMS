package com.yz.bidding.service.impl;

import java.util.List;

import com.ruoyi.system.api.domain.PublicSignings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicSigningsMapper;
import com.yz.bidding.service.IPublicSigningsService;

import javax.annotation.Resource;

/**
 * 签署执行状态表Service业务层处理
 * 
 * @author zhangye
 * @date 2023-12-04
 */
@Service
public class PublicSigningsServiceImpl implements IPublicSigningsService 
{
    @Resource
    private PublicSigningsMapper publicSigningsMapper;

    /**
     * 查询签署执行状态表
     * 
     * @param signingStatusId 签署执行状态表主键
     * @return 签署执行状态表
     */
    @Override
    public PublicSignings selectPublicSigningsBySigningStatusId(Long signingStatusId)
    {
        return publicSigningsMapper.selectPublicSigningsBySigningStatusId(signingStatusId);
    }

    /**
     * 查询签署执行状态表列表
     * 
     * @param publicSignings 签署执行状态表
     * @return 签署执行状态表
     */
    @Override
    public List<PublicSignings> selectPublicSigningsList(PublicSignings publicSignings)
    {
        return publicSigningsMapper.selectPublicSigningsList(publicSignings);
    }

    /**
     * 新增签署执行状态表
     * 
     * @param publicSignings 签署执行状态表
     * @return 结果
     */
    @Override
    public int insertPublicSignings(PublicSignings publicSignings)
    {
        return publicSigningsMapper.insertPublicSignings(publicSignings);
    }

    /**
     * 修改签署执行状态表
     * 
     * @param publicSignings 签署执行状态表
     * @return 结果
     */
    @Override
    public int updatePublicSignings(PublicSignings publicSignings)
    {
        return publicSigningsMapper.updatePublicSignings(publicSignings);
    }

    /**
     * 批量删除签署执行状态表
     * 
     * @param signingStatusIds 需要删除的签署执行状态表主键
     * @return 结果
     */
    @Override
    public int deletePublicSigningsBySigningStatusIds(Long[] signingStatusIds)
    {
        return publicSigningsMapper.deletePublicSigningsBySigningStatusIds(signingStatusIds);
    }

    /**
     * 删除签署执行状态表信息
     * 
     * @param signingStatusId 签署执行状态表主键
     * @return 结果
     */
    @Override
    public int deletePublicSigningsBySigningStatusId(Long signingStatusId)
    {
        return publicSigningsMapper.deletePublicSigningsBySigningStatusId(signingStatusId);
    }
}
