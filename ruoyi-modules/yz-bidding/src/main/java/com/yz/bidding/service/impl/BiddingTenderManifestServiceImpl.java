package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingTenderManifestMapper;
import com.yz.bidding.domain.BiddingTenderManifest;
import com.yz.bidding.service.IBiddingTenderManifestService;

/**
 * 招标项目详情Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class BiddingTenderManifestServiceImpl implements IBiddingTenderManifestService 
{
    @Autowired
    private BiddingTenderManifestMapper biddingTenderManifestMapper;

    /**
     * 查询招标项目详情
     * 
     * @param tenderManifestId 招标项目详情主键
     * @return 招标项目详情
     */
    @Override
    public BiddingTenderManifest selectBiddingTenderManifestByTenderManifestId(Long tenderManifestId)
    {
        return biddingTenderManifestMapper.selectBiddingTenderManifestByTenderManifestId(tenderManifestId);
    }

    /**
     * 查询招标项目详情列表
     * 
     * @param biddingTenderManifest 招标项目详情
     * @return 招标项目详情
     */
    @Override
    public List<BiddingTenderManifest> selectBiddingTenderManifestList(BiddingTenderManifest biddingTenderManifest)
    {
        return biddingTenderManifestMapper.selectBiddingTenderManifestList(biddingTenderManifest);
    }

    /**
     * 新增招标项目详情
     * 
     * @param biddingTenderManifest 招标项目详情
     * @return 结果
     */
    @Override
    public int insertBiddingTenderManifest(BiddingTenderManifest biddingTenderManifest)
    {
        return biddingTenderManifestMapper.insertBiddingTenderManifest(biddingTenderManifest);
    }

    /**
     * 修改招标项目详情
     * 
     * @param biddingTenderManifest 招标项目详情
     * @return 结果
     */
    @Override
    public int updateBiddingTenderManifest(BiddingTenderManifest biddingTenderManifest)
    {
        return biddingTenderManifestMapper.updateBiddingTenderManifest(biddingTenderManifest);
    }

    /**
     * 批量删除招标项目详情
     * 
     * @param tenderManifestIds 需要删除的招标项目详情主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderManifestByTenderManifestIds(Long[] tenderManifestIds)
    {
        return biddingTenderManifestMapper.deleteBiddingTenderManifestByTenderManifestIds(tenderManifestIds);
    }

    /**
     * 删除招标项目详情信息
     * 
     * @param tenderManifestId 招标项目详情主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderManifestByTenderManifestId(Long tenderManifestId)
    {
        return biddingTenderManifestMapper.deleteBiddingTenderManifestByTenderManifestId(tenderManifestId);
    }
}
