package com.yz.bidding.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicQualificationMapper;
import com.ruoyi.system.api.domain.PublicQualification;
import com.yz.bidding.service.IPublicQualificationService;

/**
 * 供应商资质Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicQualificationServiceImpl implements IPublicQualificationService 
{
    @Autowired
    private PublicQualificationMapper publicQualificationMapper;

    @Override
    public List<Map<String, Object>> findQualificationAnnexByVendorId(String vid) {
        return publicQualificationMapper.findQualificationAnnexByVendorId(vid);
    }

    /**
     * 查询供应商资质
     * 
     * @param qualificationId 供应商资质主键
     * @return 供应商资质
     */
    @Override
    public PublicQualification selectPublicQualificationByQualificationId(Long qualificationId)
    {
        return publicQualificationMapper.selectPublicQualificationByQualificationId(qualificationId);
    }

    /**
     * 查询供应商资质列表
     * 
     * @param publicQualification 供应商资质
     * @return 供应商资质
     */
    @Override
    public List<PublicQualification> selectPublicQualificationList(PublicQualification publicQualification)
    {
        return publicQualificationMapper.selectPublicQualificationList(publicQualification);
    }

    /**
     * 新增供应商资质
     * 
     * @param publicQualification 供应商资质
     * @return 结果
     */
    @Override
    public int insertPublicQualification(PublicQualification publicQualification)
    {
        return publicQualificationMapper.insertPublicQualification(publicQualification);
    }

    /**
     * 修改供应商资质
     * 
     * @param publicQualification 供应商资质
     * @return 结果
     */
    @Override
    public int updatePublicQualification(PublicQualification publicQualification)
    {
        return publicQualificationMapper.updatePublicQualification(publicQualification);
    }

    /**
     * 批量删除供应商资质
     * 
     * @param qualificationIds 需要删除的供应商资质主键
     * @return 结果
     */
    @Override
    public int deletePublicQualificationByQualificationIds(Long[] qualificationIds)
    {
        return publicQualificationMapper.deletePublicQualificationByQualificationIds(qualificationIds);
    }

    /**
     * 删除供应商资质信息
     * 
     * @param qualificationId 供应商资质主键
     * @return 结果
     */
    @Override
    public int deletePublicQualificationByQualificationId(Long qualificationId)
    {
        return publicQualificationMapper.deletePublicQualificationByQualificationId(qualificationId);
    }
}
