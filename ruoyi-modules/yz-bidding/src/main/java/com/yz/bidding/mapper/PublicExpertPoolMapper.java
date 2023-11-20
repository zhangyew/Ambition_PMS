package com.yz.bidding.mapper;

import java.util.List;
import com.ruoyi.system.api.domain.PublicExpertPool;

/**
 * 专家库Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicExpertPoolMapper 
{
    /**
     * 查询专家库
     * 
     * @param expertPoolId 专家库主键
     * @return 专家库
     */
    public PublicExpertPool selectPublicExpertPoolByExpertPoolId(Long expertPoolId);

    /**
     * 查询专家库列表
     * 
     * @param publicExpertPool 专家库
     * @return 专家库集合
     */
    public List<PublicExpertPool> selectPublicExpertPoolList(PublicExpertPool publicExpertPool);

    /**
     * 新增专家库
     * 
     * @param publicExpertPool 专家库
     * @return 结果
     */
    public int insertPublicExpertPool(PublicExpertPool publicExpertPool);

    /**
     * 修改专家库
     * 
     * @param publicExpertPool 专家库
     * @return 结果
     */
    public int updatePublicExpertPool(PublicExpertPool publicExpertPool);

    /**
     * 删除专家库
     * 
     * @param expertPoolId 专家库主键
     * @return 结果
     */
    public int deletePublicExpertPoolByExpertPoolId(Long expertPoolId);

    /**
     * 批量删除专家库
     * 
     * @param expertPoolIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicExpertPoolByExpertPoolIds(Long[] expertPoolIds);
}
