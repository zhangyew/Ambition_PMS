package com.yz.bidding.service.impl;

import java.util.List;

import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicExpertMapper;
import com.ruoyi.system.api.domain.PublicExpert;
import com.yz.bidding.service.IPublicExpertService;

/**
 * 专家Service业务层处理
 *
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicExpertServiceImpl implements IPublicExpertService {
    @Autowired
    private PublicExpertMapper publicExpertMapper;

    @Override
    public List<PublicExpert> findExpertList(String name, String poolId) {
        PublicExpert publicExpert = new PublicExpert();
        if (!poolId.equals("") && !poolId.equals("null"))
            publicExpert.setPoolId(Long.parseLong(poolId));
        publicExpert.setIsExtract(0L);
        publicExpert.setName(name);
        return publicExpertMapper.selectPublicExpertList(publicExpert);
    }

    /**
     * 查询专家
     *
     * @param expertId 专家主键
     * @return 专家
     */
    @Override
    public PublicExpert selectPublicExpertByExpertId(Long expertId) {
        return publicExpertMapper.selectPublicExpertByExpertId(expertId);
    }

    /**
     * 查询专家列表
     *
     * @param publicExpert 专家
     * @return 专家
     */
    @Override
    public List<PublicExpert> selectPublicExpertList(PublicExpert publicExpert) {
        return publicExpertMapper.selectPublicExpertList(publicExpert);
    }

    /**
     * 新增专家
     *
     * @param publicExpert 专家
     * @return 结果
     */
    @Override
    public int insertPublicExpert(PublicExpert publicExpert) {
        publicExpert.setCreateTime(DateUtils.getNowDate());
        return publicExpertMapper.insertPublicExpert(publicExpert);
    }

    /**
     * 修改专家
     *
     * @param publicExpert 专家
     * @return 结果
     */
    @Override
    public int updatePublicExpert(PublicExpert publicExpert) {
        publicExpert.setUpdateTime(DateUtils.getNowDate());
        return publicExpertMapper.updatePublicExpert(publicExpert);
    }

    /**
     * 批量删除专家
     *
     * @param expertIds 需要删除的专家主键
     * @return 结果
     */
    @Override
    public int deletePublicExpertByExpertIds(Long[] expertIds) {
        return publicExpertMapper.deletePublicExpertByExpertIds(expertIds);
    }

    /**
     * 删除专家信息
     *
     * @param expertId 专家主键
     * @return 结果
     */
    @Override
    public int deletePublicExpertByExpertId(Long expertId) {
        return publicExpertMapper.deletePublicExpertByExpertId(expertId);
    }
}
