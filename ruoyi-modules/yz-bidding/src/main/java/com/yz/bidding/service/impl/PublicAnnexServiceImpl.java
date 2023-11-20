package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicAnnexMapper;
import com.ruoyi.system.api.domain.PublicAnnex;
import com.yz.bidding.service.IPublicAnnexService;

/**
 * 公告附件Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicAnnexServiceImpl implements IPublicAnnexService 
{
    @Autowired
    private PublicAnnexMapper publicAnnexMapper;

    /**
     * 查询公告附件
     * 
     * @param annexId 公告附件主键
     * @return 公告附件
     */
    @Override
    public PublicAnnex selectPublicAnnexByAnnexId(Long annexId)
    {
        return publicAnnexMapper.selectPublicAnnexByAnnexId(annexId);
    }

    /**
     * 查询公告附件列表
     * 
     * @param publicAnnex 公告附件
     * @return 公告附件
     */
    @Override
    public List<PublicAnnex> selectPublicAnnexList(PublicAnnex publicAnnex)
    {
        return publicAnnexMapper.selectPublicAnnexList(publicAnnex);
    }

    /**
     * 新增公告附件
     * 
     * @param publicAnnex 公告附件
     * @return 结果
     */
    @Override
    public int insertPublicAnnex(PublicAnnex publicAnnex)
    {
        return publicAnnexMapper.insertPublicAnnex(publicAnnex);
    }

    /**
     * 修改公告附件
     * 
     * @param publicAnnex 公告附件
     * @return 结果
     */
    @Override
    public int updatePublicAnnex(PublicAnnex publicAnnex)
    {
        return publicAnnexMapper.updatePublicAnnex(publicAnnex);
    }

    /**
     * 批量删除公告附件
     * 
     * @param annexIds 需要删除的公告附件主键
     * @return 结果
     */
    @Override
    public int deletePublicAnnexByAnnexIds(Long[] annexIds)
    {
        return publicAnnexMapper.deletePublicAnnexByAnnexIds(annexIds);
    }

    /**
     * 删除公告附件信息
     * 
     * @param annexId 公告附件主键
     * @return 结果
     */
    @Override
    public int deletePublicAnnexByAnnexId(Long annexId)
    {
        return publicAnnexMapper.deletePublicAnnexByAnnexId(annexId);
    }
}
