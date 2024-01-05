package com.yz.bidding.mapper;

import java.util.List;
import com.ruoyi.system.api.domain.PublicContacts;

/**
 * 供应商联系人Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicContactsMapper 
{
    /**
     * 查找供应商所有联系人
     * @param vid
     * @return
     */
    public List<PublicContacts> findVendorContactById(String vid);

    /**
     * 查询供应商联系人
     * 
     * @param contactsId 供应商联系人主键
     * @return 供应商联系人
     */
    public PublicContacts selectPublicContactsByContactsId(Long contactsId);

    /**
     * 查询供应商联系人列表
     * 
     * @param publicContacts 供应商联系人
     * @return 供应商联系人集合
     */
    public List<PublicContacts> selectPublicContactsList(PublicContacts publicContacts);

    /**
     * 新增供应商联系人
     * 
     * @param publicContacts 供应商联系人
     * @return 结果
     */
    public int insertPublicContacts(PublicContacts publicContacts);

    /**
     * 修改供应商联系人
     * 
     * @param publicContacts 供应商联系人
     * @return 结果
     */
    public int updatePublicContacts(PublicContacts publicContacts);

    /**
     * 删除供应商联系人
     * 
     * @param contactsId 供应商联系人主键
     * @return 结果
     */
    public int deletePublicContactsByContactsId(Long contactsId);

    /**
     * 批量删除供应商联系人
     * 
     * @param contactsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicContactsByContactsIds(Long[] contactsIds);
}
