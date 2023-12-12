package com.yz.bidding.service;

import java.util.List;
import com.yz.bidding.domain.BiddingNotice;

/**
 * 中标公告Service接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface IBiddingNoticeService 
{
    /**
     * 查询中标公告
     * 
     * @param noticeId 中标公告主键
     * @return 中标公告
     */
    public BiddingNotice selectBiddingNoticeByNoticeId(Long noticeId);

    /**
     * 查询中标公告列表
     * 
     * @param biddingNotice 中标公告
     * @return 中标公告集合
     */
    public List<BiddingNotice> selectBiddingNoticeList(BiddingNotice biddingNotice);

    /**
     * 供应商首页（通知公告）
     * @return 通知公告集合
     */
    public List<BiddingNotice> showsNoticeList();

    /**
     * 新增中标公告
     * 
     * @param biddingNotice 中标公告
     * @return 结果
     */
    public int insertBiddingNotice(BiddingNotice biddingNotice);

    /**
     * 修改中标公告
     * 
     * @param biddingNotice 中标公告
     * @return 结果
     */
    public int updateBiddingNotice(BiddingNotice biddingNotice);

    /**
     * 批量删除中标公告
     * 
     * @param noticeIds 需要删除的中标公告主键集合
     * @return 结果
     */
    public int deleteBiddingNoticeByNoticeIds(Long[] noticeIds);

    /**
     * 删除中标公告信息
     * 
     * @param noticeId 中标公告主键
     * @return 结果
     */
    public int deleteBiddingNoticeByNoticeId(Long noticeId);
}
