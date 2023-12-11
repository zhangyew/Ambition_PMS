package com.yz.bidding.service;

import java.util.List;

import com.yz.bidding.domain.BiddingTenderNotice;
import com.yz.bidding.domain.BiddingTenderProjects;
import org.apache.ibatis.annotations.Param;

/**
 * 招标公告Service接口
 *
 * @author zhangye
 * @date 2023-11-21
 */
public interface IBiddingTenderNoticeService {
    /**
     * 修改招标公告状态
     *
     * @param id
     * @param zt
     * @return
     */
    public int updateState(String id, String zt);

    /**
     * 查询招标项目公告列表/公告详情
     *
     * @param pid
     * @param tid
     * @return
     */
    public BiddingTenderProjects findNoticeById(String pid, String tid);

    /**
     * 查询招标公告
     *
     * @param tenderNoticeId 招标公告主键
     * @return 招标公告
     */
    public BiddingTenderNotice selectBiddingTenderNoticeByTenderNoticeId(Long tenderNoticeId);

    /**
     * 查询招标公告列表
     *
     * @param biddingTenderNotice 招标公告
     * @return 招标公告集合
     */
    public List<BiddingTenderNotice> selectBiddingTenderNoticeList(BiddingTenderNotice biddingTenderNotice);

    /**
     * 新增招标公告
     *
     * @param biddingTenderNotice 招标公告
     * @return 结果
     */
    public int insertBiddingTenderNotice(BiddingTenderNotice biddingTenderNotice);

    /**
     * 修改招标公告
     *
     * @param biddingTenderNotice 招标公告
     * @return 结果
     */
    public int updateBiddingTenderNotice(BiddingTenderNotice biddingTenderNotice);

    /**
     * 批量删除招标公告
     *
     * @param tenderNoticeIds 需要删除的招标公告主键集合
     * @return 结果
     */
    public int deleteBiddingTenderNoticeByTenderNoticeIds(Long[] tenderNoticeIds);

    /**
     * 删除招标公告信息
     *
     * @param tenderNoticeId 招标公告主键
     * @return 结果
     */
    public int deleteBiddingTenderNoticeByTenderNoticeId(Long tenderNoticeId);
}
