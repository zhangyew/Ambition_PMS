package com.yz.bidding.service;

import java.util.List;
import com.yz.bidding.domain.BiddingTenderProjects;

/**
 * 招标项目Service接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface IBiddingTenderProjectsService 
{
    /**
     * 查询招标项目
     * 
     * @param tenderProjectsId 招标项目主键
     * @return 招标项目
     */
    public BiddingTenderProjects selectBiddingTenderProjectsByTenderProjectsId(Long tenderProjectsId);

    /**
     * 查询招标项目列表
     * 
     * @param biddingTenderProjects 招标项目
     * @return 招标项目集合
     */
    public List<BiddingTenderProjects> selectBiddingTenderProjectsList(BiddingTenderProjects biddingTenderProjects);

    /**
     * 新增招标项目
     * 
     * @param biddingTenderProjects 招标项目
     * @return 结果
     */
    public int insertBiddingTenderProjects(BiddingTenderProjects biddingTenderProjects);

    /**
     * 修改招标项目
     * 
     * @param biddingTenderProjects 招标项目
     * @return 结果
     */
    public int updateBiddingTenderProjects(BiddingTenderProjects biddingTenderProjects);

    /**
     * 批量删除招标项目
     * 
     * @param tenderProjectsIds 需要删除的招标项目主键集合
     * @return 结果
     */
    public int deleteBiddingTenderProjectsByTenderProjectsIds(Long[] tenderProjectsIds);

    /**
     * 删除招标项目信息
     * 
     * @param tenderProjectsId 招标项目主键
     * @return 结果
     */
    public int deleteBiddingTenderProjectsByTenderProjectsId(Long tenderProjectsId);
}
