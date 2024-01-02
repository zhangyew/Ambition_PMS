package com.yz.bidding.mapper;

import java.util.List;

import com.ruoyi.system.api.domain.PublicCategory;
import com.ruoyi.system.api.domain.PublicContacts;
import com.ruoyi.system.api.domain.PublicVendor;
import org.apache.ibatis.annotations.Param;

/**
 * 供应商Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicVendorMapper 
{
    /**
     * 修改供应商注册状态
     * @param id
     * @param zt
     * @return
     */
    public int updateStates(@Param("id")String id, @Param("zt")String zt);

    /**
     * 查询供应商
     * 
     * @param vendorId 供应商主键
     * @return 供应商
     */
    public PublicVendor selectPublicVendorByVendorId(Long vendorId);

    /**
     * 供应商uid
     * @param uid
     * @return
     */
    public PublicVendor showUid(Long uid);

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
     * 显示所有的供应商(合同管理下拉框)
     * @param
     */
    public List<PublicVendor> showsPublicVendorList(@Param("vendor_id") Long vendor_id);
    int selCount(String vNumber);
    int selRe(@Param("vNumber")String vNumber, @Param("phone")String phone);
    public List<PublicVendor> showAll();
    /**|
     * 根据供应商id查询所有联系人
     * @param vendor_id
     * @return
     */
    public List<PublicVendor> showContactsList(@Param("vendor_id") Long vendor_id);
    /**
     * 新增供应商
     * 
     * @param publicVendor 供应商
     * @return 结果
     */
    public int insertPublicVendor(PublicVendor publicVendor);
    int updateExist(@Param("uid")Long uid,@Param("vNumber")String vNumber);
    /**
     * 注册供应商
     *
     * @param publicVendor 供应商
     * @return 结果
     */
    public PublicVendor insertVendor(PublicVendor publicVendor);
    Integer VendorSum();
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
