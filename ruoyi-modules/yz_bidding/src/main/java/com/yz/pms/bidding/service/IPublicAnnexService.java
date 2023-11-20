package com.yz.pms.publics.service;

import java.util.List;
import com.ruoyi.system.api.domain.PublicAnnex;

/**
 * 公告附件Service接口
 * 
 * @author zhangye
 * @date 2023-11-20
 */
public interface IPublicAnnexService 
{
    /**
     * 查询公告附件
     * 
     * @param annexId 公告附件主键
     * @return 公告附件
     */
    public PublicAnnex selectPublicAnnexByAnnexId(Long annexId);

    /**
     * 查询公告附件列表
     * 
     * @param publicAnnex 公告附件
     * @return 公告附件集合
     */
    public List<PublicAnnex> selectPublicAnnexList(PublicAnnex publicAnnex);

    /**
     * 新增公告附件
     * 
     * @param publicAnnex 公告附件
     * @return 结果
     */
    public int insertPublicAnnex(PublicAnnex publicAnnex);

    /**
     * 修改公告附件
     * 
     * @param publicAnnex 公告附件
     * @return 结果
     */
    public int updatePublicAnnex(PublicAnnex publicAnnex);

    /**
     * 批量删除公告附件
     * 
     * @param annexIds 需要删除的公告附件主键集合
     * @return 结果
     */
    public int deletePublicAnnexByAnnexIds(Long[] annexIds);

    /**
     * 删除公告附件信息
     * 
     * @param annexId 公告附件主键
     * @return 结果
     */
    public int deletePublicAnnexByAnnexId(Long annexId);
}
