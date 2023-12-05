package com.yz.bidding.mapper;

import java.util.List;
import com.ruoyi.system.api.domain.PublicVendor;

/**
 * 供应商Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicVendorMapper 
{
    /**
     * 查询供应商
     * 
     * @param vendorId 供应商主键
     * @return 供应商
     */
    public PublicVendor selectPublicVendorByVendorId(Long vendorId);

    /**
     * 查询供应商详细信息
     * @param vid
     * @return
     */
    public PublicVendor findVendorDetailed(int vid);

    /**
     * 查询供应商列表
     * 
     * @param publicVendor 供应商
     * @return 供应商集合
     */
    public List<PublicVendor> selectPublicVendorList(PublicVendor publicVendor);

    /**
     * 新增供应商
     * 
     * @param publicVendor 供应商
     * @return 结果
     */
    public int insertPublicVendor(PublicVendor publicVendor);

    /**
     * 注册供应商
     *
     * @param publicVendor 供应商
     * @return 结果
     */
    public PublicVendor insertVendor(PublicVendor publicVendor);

    /**
     * 修改供应商
     * 
     * @param publicVendor 供应商
     * @return 结果
     */
    public int updatePublicVendor(PublicVendor publicVendor);

    /**
     * 删除供应商
     * 
     * @param vendorId 供应商主键
     * @return 结果
     */
    public int deletePublicVendorByVendorId(Long vendorId);

    /**
     * 批量删除供应商
     * 
     * @param vendorIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicVendorByVendorIds(Long[] vendorIds);
}
