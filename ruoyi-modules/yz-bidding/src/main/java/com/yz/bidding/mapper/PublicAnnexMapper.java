package com.yz.bidding.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.api.domain.PublicAnnex;

/**
 * 公告附件Mapper接口
 *
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicAnnexMapper {


    /**
     * 查找评标附件
     * @param id
     * @return
     */
    public List<PublicAnnex> findAnnexByPbId(String id);

    /**
     * 根据招标项目查找附件集合
     *
     * @param pid
     * @return
     */
    public List<Map<String, Object>> findAnnexByTenderProjectsId(String pid);

    /**
     * 按招标公告id删除附件表记录
     *
     * @param nid 招标公告id
     * @return
     */
    public int deleteAnnexTextByNoticeId(String nid);
    List<PublicAnnex> findAnnexByOrder(Long oid);
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
     * 删除公告附件
     *
     * @param annexId 公告附件主键
     * @return 结果
     */
    public int deletePublicAnnexByAnnexId(Long annexId);

    /**
     * 批量删除公告附件
     *
     * @param annexIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicAnnexByAnnexIds(Long[] annexIds);
}
