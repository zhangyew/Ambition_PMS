package com.yz.pms.publics.service;

import java.util.List;
import com.ruoyi.system.api.domain.PublicQualification;

/**
 * 供应商资质Service接口
 * 
 * @author zhangye
 * @date 2023-11-20
 */
public interface IPublicQualificationService 
{
    /**
     * 查询供应商资质
     * 
     * @param qualificationId 供应商资质主键
     * @return 供应商资质
     */
    public PublicQualification selectPublicQualificationByQualificationId(Long qualificationId);

    /**
     * 查询供应商资质列表
     * 
     * @param publicQualification 供应商资质
     * @return 供应商资质集合
     */
    public List<PublicQualification> selectPublicQualificationList(PublicQualification publicQualification);

    /**
     * 新增供应商资质
     * 
     * @param publicQualification 供应商资质
     * @return 结果
     */
    public int insertPublicQualification(PublicQualification publicQualification);

    /**
     * 修改供应商资质
     * 
     * @param publicQualification 供应商资质
     * @return 结果
     */
    public int updatePublicQualification(PublicQualification publicQualification);

    /**
     * 批量删除供应商资质
     * 
     * @param qualificationIds 需要删除的供应商资质主键集合
     * @return 结果
     */
    public int deletePublicQualificationByQualificationIds(Long[] qualificationIds);

    /**
     * 删除供应商资质信息
     * 
     * @param qualificationId 供应商资质主键
     * @return 结果
     */
    public int deletePublicQualificationByQualificationId(Long qualificationId);
}
