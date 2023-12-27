package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicContactsMapper;
import com.ruoyi.system.api.domain.PublicContacts;
import com.yz.bidding.service.IPublicContactsService;

/**
 * 供应商联系人Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicContactsServiceImpl implements IPublicContactsService 
{
    @Autowired
    private PublicContactsMapper publicContactsMapper;

    @Override
    public List<PublicContacts> findVendorContactById(String vid) {
        return publicContactsMapper.findVendorContactById(vid);
    }

    /**
     * 查询供应商联系人
     * 
     * @param contactsId 供应商联系人主键
     * @return 供应商联系人
     */
    @Override
    public PublicContacts selectPublicContactsByContactsId(Long contactsId)
    {
        return publicContactsMapper.selectPublicContactsByContactsId(contactsId);
    }

    /**
     * 查询供应商联系人列表
     * 
     * @param publicContacts 供应商联系人
     * @return 供应商联系人
     */
    @Override
    public List<PublicContacts> selectPublicContactsList(PublicContacts publicContacts)
    {
        return publicContactsMapper.selectPublicContactsList(publicContacts);
    }

    /**
     * 新增供应商联系人
     * 
     * @param publicContacts 供应商联系人
     * @return 结果
     */
    @Override
    public int insertPublicContacts(PublicContacts publicContacts)
    {
        return publicContactsMapper.insertPublicContacts(publicContacts);
    }

    /**
     * 修改供应商联系人
     * 
     * @param publicContacts 供应商联系人
     * @return 结果
     */
    @Override
    public int updatePublicContacts(PublicContacts publicContacts)
    {
        return publicContactsMapper.updatePublicContacts(publicContacts);
    }

    /**
     * 批量删除供应商联系人
     * 
     * @param contactsIds 需要删除的供应商联系人主键
     * @return 结果
     */
    @Override
    public int deletePublicContactsByContactsIds(Long[] contactsIds)
    {
        return publicContactsMapper.deletePublicContactsByContactsIds(contactsIds);
    }

    /**
     * 删除供应商联系人信息
     * 
     * @param contactsId 供应商联系人主键
     * @return 结果
     */
    @Override
    public int deletePublicContactsByContactsId(Long contactsId)
    {
        return publicContactsMapper.deletePublicContactsByContactsId(contactsId);
    }
}
