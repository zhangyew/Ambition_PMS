package com.yz.bidding.mapper;

import java.util.List;
import com.yz.bidding.domain.BiddingTenderNotice;

/**
 * 招标公告Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface BiddingTenderNoticeMapper 
{
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
     * 删除招标公告
     * 
     * @param tenderNoticeId 招标公告主键
     * @return 结果
     */
    public int deleteBiddingTenderNoticeByTenderNoticeId(Long tenderNoticeId);

    /**
     * 批量删除招标公告
     * 
     * @param tenderNoticeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBiddingTenderNoticeByTenderNoticeIds(Long[] tenderNoticeIds);
}
