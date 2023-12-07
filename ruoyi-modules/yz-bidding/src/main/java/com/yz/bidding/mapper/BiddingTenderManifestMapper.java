package com.yz.bidding.mapper;

import java.util.List;
import com.yz.bidding.domain.BiddingTenderManifest;

/**
 * 招标项目详情Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface BiddingTenderManifestMapper 
{

    /**
     * 根据项目ID删除详情表
     * @param pid
     * @return
     */
    public int deleteByProjectId(Long pid);

    /**
     * 查询招标项目详情
     * 
     * @param tenderManifestId 招标项目详情主键
     * @return 招标项目详情
     */
    public BiddingTenderManifest selectBiddingTenderManifestByTenderManifestId(Long tenderManifestId);

    /**
     * 查询招标项目详情列表
     * 
     * @param biddingTenderManifest 招标项目详情
     * @return 招标项目详情集合
     */
    public List<BiddingTenderManifest> selectBiddingTenderManifestList(BiddingTenderManifest biddingTenderManifest);

    /**
     * 新增招标项目详情
     * 
     * @param biddingTenderManifest 招标项目详情
     * @return 结果
     */
    public int insertBiddingTenderManifest(BiddingTenderManifest biddingTenderManifest);

    /**
     * 修改招标项目详情
     * 
     * @param biddingTenderManifest 招标项目详情
     * @return 结果
     */
    public int updateBiddingTenderManifest(BiddingTenderManifest biddingTenderManifest);

    /**
     * 删除招标项目详情
     * 
     * @param tenderManifestId 招标项目详情主键
     * @return 结果
     */
    public int deleteBiddingTenderManifestByTenderManifestId(Long tenderManifestId);

    /**
     * 批量删除招标项目详情
     * 
     * @param tenderManifestIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBiddingTenderManifestByTenderManifestIds(Long[] tenderManifestIds);
}
