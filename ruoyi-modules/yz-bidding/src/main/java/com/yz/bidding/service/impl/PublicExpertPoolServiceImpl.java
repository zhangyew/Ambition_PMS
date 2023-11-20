package com.yz.bidding.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicExpertPoolMapper;
import com.ruoyi.system.api.domain.PublicExpertPool;
import com.yz.bidding.service.IPublicExpertPoolService;

/**
 * 专家库Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicExpertPoolServiceImpl implements IPublicExpertPoolService 
{
    @Autowired
    private PublicExpertPoolMapper publicExpertPoolMapper;

    /**
     * 查询专家库
     * 
     * @param expertPoolId 专家库主键
     * @return 专家库
     */
    @Override
    public PublicExpertPool selectPublicExpertPoolByExpertPoolId(Long expertPoolId)
    {
        return publicExpertPoolMapper.selectPublicExpertPoolByExpertPoolId(expertPoolId);
    }

    /**
     * 查询专家库列表
     * 
     * @param publicExpertPool 专家库
     * @return 专家库
     */
    @Override
    public List<PublicExpertPool> selectPublicExpertPoolList(PublicExpertPool publicExpertPool)
    {
        return publicExpertPoolMapper.selectPublicExpertPoolList(publicExpertPool);
    }

    /**
     * 新增专家库
     * 
     * @param publicExpertPool 专家库
     * @return 结果
     */
    @Override
    public int insertPublicExpertPool(PublicExpertPool publicExpertPool)
    {
        publicExpertPool.setCreateTime(DateUtils.getNowDate());
        return publicExpertPoolMapper.insertPublicExpertPool(publicExpertPool);
    }

    /**
     * 修改专家库
     * 
     * @param publicExpertPool 专家库
     * @return 结果
     */
    @Override
    public int updatePublicExpertPool(PublicExpertPool publicExpertPool)
    {
        publicExpertPool.setUpdateTime(DateUtils.getNowDate());
        return publicExpertPoolMapper.updatePublicExpertPool(publicExpertPool);
    }

    /**
     * 批量删除专家库
     * 
     * @param expertPoolIds 需要删除的专家库主键
     * @return 结果
     */
    @Override
    public int deletePublicExpertPoolByExpertPoolIds(Long[] expertPoolIds)
    {
        return publicExpertPoolMapper.deletePublicExpertPoolByExpertPoolIds(expertPoolIds);
    }

    /**
     * 删除专家库信息
     * 
     * @param expertPoolId 专家库主键
     * @return 结果
     */
    @Override
    public int deletePublicExpertPoolByExpertPoolId(Long expertPoolId)
    {
        return publicExpertPoolMapper.deletePublicExpertPoolByExpertPoolId(expertPoolId);
    }
}
