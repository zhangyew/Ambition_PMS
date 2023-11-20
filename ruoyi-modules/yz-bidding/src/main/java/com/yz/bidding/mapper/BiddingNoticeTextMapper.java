package com.yz.bidding.mapper;

import java.util.List;
import com.yz.bidding.domain.BiddingNoticeText;

/**
 * 招标公告正文Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface BiddingNoticeTextMapper 
{
    /**
     * 查询招标公告正文
     * 
     * @param noticeTextId 招标公告正文主键
     * @return 招标公告正文
     */
    public BiddingNoticeText selectBiddingNoticeTextByNoticeTextId(Long noticeTextId);

    /**
     * 查询招标公告正文列表
     * 
     * @param biddingNoticeText 招标公告正文
     * @return 招标公告正文集合
     */
    public List<BiddingNoticeText> selectBiddingNoticeTextList(BiddingNoticeText biddingNoticeText);

    /**
     * 新增招标公告正文
     * 
     * @param biddingNoticeText 招标公告正文
     * @return 结果
     */
    public int insertBiddingNoticeText(BiddingNoticeText biddingNoticeText);

    /**
     * 修改招标公告正文
     * 
     * @param biddingNoticeText 招标公告正文
     * @return 结果
     */
    public int updateBiddingNoticeText(BiddingNoticeText biddingNoticeText);

    /**
     * 删除招标公告正文
     * 
     * @param noticeTextId 招标公告正文主键
     * @return 结果
     */
    public int deleteBiddingNoticeTextByNoticeTextId(Long noticeTextId);

    /**
     * 批量删除招标公告正文
     * 
     * @param noticeTextIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBiddingNoticeTextByNoticeTextIds(Long[] noticeTextIds);
}
