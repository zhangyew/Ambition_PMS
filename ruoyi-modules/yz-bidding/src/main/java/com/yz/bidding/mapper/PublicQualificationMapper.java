package com.yz.bidding.mapper;

import java.util.List;
import com.ruoyi.system.api.domain.PublicQualification;

/**
 * 供应商资质Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicQualificationMapper 
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
     * 删除供应商资质
     * 
     * @param qualificationId 供应商资质主键
     * @return 结果
     */
    public int deletePublicQualificationByQualificationId(Long qualificationId);

    public int deleteVendorId(String vid);
    /**
     * 批量删除供应商资质
     * 
     * @param qualificationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicQualificationByQualificationIds(Long[] qualificationIds);
}
