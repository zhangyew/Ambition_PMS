package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingTenderProjectsMapper;
import com.yz.bidding.domain.BiddingTenderProjects;
import com.yz.bidding.service.IBiddingTenderProjectsService;

/**
 * 招标项目Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class BiddingTenderProjectsServiceImpl implements IBiddingTenderProjectsService 
{
    @Autowired
    private BiddingTenderProjectsMapper biddingTenderProjectsMapper;

    /**
     * 查询招标项目
     * 
     * @param tenderProjectsId 招标项目主键
     * @return 招标项目
     */
    @Override
    public BiddingTenderProjects selectBiddingTenderProjectsByTenderProjectsId(Long tenderProjectsId)
    {
        return biddingTenderProjectsMapper.selectBiddingTenderProjectsByTenderProjectsId(tenderProjectsId);
    }

    /**
     * 查询招标项目列表
     * 
     * @param biddingTenderProjects 招标项目
     * @return 招标项目
     */
    @Override
    public List<BiddingTenderProjects> selectBiddingTenderProjectsList(BiddingTenderProjects biddingTenderProjects)
    {
        return biddingTenderProjectsMapper.selectBiddingTenderProjectsList(biddingTenderProjects);
    }

    /**
     * 新增招标项目
     * 
     * @param biddingTenderProjects 招标项目
     * @return 结果
     */
    @Override
    public int insertBiddingTenderProjects(BiddingTenderProjects biddingTenderProjects)
    {
        return biddingTenderProjectsMapper.insertBiddingTenderProjects(biddingTenderProjects);
    }

    /**
     * 修改招标项目
     * 
     * @param biddingTenderProjects 招标项目
     * @return 结果
     */
    @Override
    public int updateBiddingTenderProjects(BiddingTenderProjects biddingTenderProjects)
    {
        return biddingTenderProjectsMapper.updateBiddingTenderProjects(biddingTenderProjects);
    }

    /**
     * 批量删除招标项目
     * 
     * @param tenderProjectsIds 需要删除的招标项目主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderProjectsByTenderProjectsIds(Long[] tenderProjectsIds)
    {
        return biddingTenderProjectsMapper.deleteBiddingTenderProjectsByTenderProjectsIds(tenderProjectsIds);
    }

    /**
     * 删除招标项目信息
     * 
     * @param tenderProjectsId 招标项目主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderProjectsByTenderProjectsId(Long tenderProjectsId)
    {
        return biddingTenderProjectsMapper.deleteBiddingTenderProjectsByTenderProjectsId(tenderProjectsId);
    }
}
