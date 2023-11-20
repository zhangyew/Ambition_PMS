package com.yz.bidding.mapper;

import java.util.List;
import com.ruoyi.system.api.domain.PublicExpert;

/**
 * 专家Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicExpertMapper 
{
    /**
     * 查询专家
     * 
     * @param expertId 专家主键
     * @return 专家
     */
    public PublicExpert selectPublicExpertByExpertId(Long expertId);

    /**
     * 查询专家列表
     * 
     * @param publicExpert 专家
     * @return 专家集合
     */
    public List<PublicExpert> selectPublicExpertList(PublicExpert publicExpert);

    /**
     * 新增专家
     * 
     * @param publicExpert 专家
     * @return 结果
     */
    public int insertPublicExpert(PublicExpert publicExpert);

    /**
     * 修改专家
     * 
     * @param publicExpert 专家
     * @return 结果
     */
    public int updatePublicExpert(PublicExpert publicExpert);

    /**
     * 删除专家
     * 
     * @param expertId 专家主键
     * @return 结果
     */
    public int deletePublicExpertByExpertId(Long expertId);

    /**
     * 批量删除专家
     * 
     * @param expertIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicExpertByExpertIds(Long[] expertIds);
}
