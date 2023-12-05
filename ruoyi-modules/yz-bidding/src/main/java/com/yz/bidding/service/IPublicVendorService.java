package com.yz.bidding.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.ruoyi.system.api.domain.PublicVendor;
import org.apache.ibatis.annotations.Param;

/**
 * 供应商Service接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface IPublicVendorService 
{

    /**
     * 供应商注册
     * @param map
     * @return
     */
    public int insertVendor(Map<String, String> map) ;

    /**
     * 查询供应商详细信息
     * @param vid
     * @return
     */
    public PublicVendor findVendorDetailed(int vid);

    /**
     * 查询供应商
     * 
     * @param vendorId 供应商主键
     * @return 供应商
     */
    public PublicVendor selectPublicVendorByVendorId(Long vendorId);

    /**
     * 查询供应商列表
     * 
     * @param publicVendor 供应商
     * @return 供应商集合
     */
    public List<PublicVendor> selectPublicVendorList(PublicVendor publicVendor);

    /**
     * 显示所有的供应商(合同管理下拉框)
     * @param
     */
    public List<PublicVendor> showsPublicVendorList(Long vendor_id);
    /**
     * 新增供应商
     * 
     * @param publicVendor 供应商
     * @return 结果
     */
    public int insertPublicVendor(PublicVendor publicVendor);

    /**
     * 修改供应商
     * 
     * @param publicVendor 供应商
     * @return 结果
     */
    public int updatePublicVendor(PublicVendor publicVendor);

    /**
     * 批量删除供应商
     * 
     * @param vendorIds 需要删除的供应商主键集合
     * @return 结果
     */
    public int deletePublicVendorByVendorIds(Long[] vendorIds);

    /**
     * 删除供应商信息
     * 
     * @param vendorId 供应商主键
     * @return 结果
     */
    public int deletePublicVendorByVendorId(Long vendorId);
}
