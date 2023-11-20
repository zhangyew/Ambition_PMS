package com.yz.bidding.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicVendorMapper;
import com.ruoyi.system.api.domain.PublicVendor;
import com.yz.bidding.service.IPublicVendorService;

/**
 * 供应商Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicVendorServiceImpl implements IPublicVendorService 
{
    @Autowired
    private PublicVendorMapper publicVendorMapper;

    /**
     * 查询供应商
     * 
     * @param vendorId 供应商主键
     * @return 供应商
     */
    @Override
    public PublicVendor selectPublicVendorByVendorId(Long vendorId)
    {
        return publicVendorMapper.selectPublicVendorByVendorId(vendorId);
    }

    /**
     * 查询供应商列表
     * 
     * @param publicVendor 供应商
     * @return 供应商
     */
    @Override
    public List<PublicVendor> selectPublicVendorList(PublicVendor publicVendor)
    {
        return publicVendorMapper.selectPublicVendorList(publicVendor);
    }

    /**
     * 新增供应商
     * 
     * @param publicVendor 供应商
     * @return 结果
     */
    @Override
    public int insertPublicVendor(PublicVendor publicVendor)
    {
        publicVendor.setCreateTime(DateUtils.getNowDate());
        return publicVendorMapper.insertPublicVendor(publicVendor);
    }

    /**
     * 修改供应商
     * 
     * @param publicVendor 供应商
     * @return 结果
     */
    @Override
    public int updatePublicVendor(PublicVendor publicVendor)
    {
        publicVendor.setUpdateTime(DateUtils.getNowDate());
        return publicVendorMapper.updatePublicVendor(publicVendor);
    }

    /**
     * 批量删除供应商
     * 
     * @param vendorIds 需要删除的供应商主键
     * @return 结果
     */
    @Override
    public int deletePublicVendorByVendorIds(Long[] vendorIds)
    {
        return publicVendorMapper.deletePublicVendorByVendorIds(vendorIds);
    }

    /**
     * 删除供应商信息
     * 
     * @param vendorId 供应商主键
     * @return 结果
     */
    @Override
    public int deletePublicVendorByVendorId(Long vendorId)
    {
        return publicVendorMapper.deletePublicVendorByVendorId(vendorId);
    }
}
