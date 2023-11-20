package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingNoticeTextMapper;
import com.yz.bidding.domain.BiddingNoticeText;
import com.yz.bidding.service.IBiddingNoticeTextService;

/**
 * 招标公告正文Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class BiddingNoticeTextServiceImpl implements IBiddingNoticeTextService 
{
    @Autowired
    private BiddingNoticeTextMapper biddingNoticeTextMapper;

    /**
     * 查询招标公告正文
     * 
     * @param noticeTextId 招标公告正文主键
     * @return 招标公告正文
     */
    @Override
    public BiddingNoticeText selectBiddingNoticeTextByNoticeTextId(Long noticeTextId)
    {
        return biddingNoticeTextMapper.selectBiddingNoticeTextByNoticeTextId(noticeTextId);
    }

    /**
     * 查询招标公告正文列表
     * 
     * @param biddingNoticeText 招标公告正文
     * @return 招标公告正文
     */
    @Override
    public List<BiddingNoticeText> selectBiddingNoticeTextList(BiddingNoticeText biddingNoticeText)
    {
        return biddingNoticeTextMapper.selectBiddingNoticeTextList(biddingNoticeText);
    }

    /**
     * 新增招标公告正文
     * 
     * @param biddingNoticeText 招标公告正文
     * @return 结果
     */
    @Override
    public int insertBiddingNoticeText(BiddingNoticeText biddingNoticeText)
    {
        return biddingNoticeTextMapper.insertBiddingNoticeText(biddingNoticeText);
    }

    /**
     * 修改招标公告正文
     * 
     * @param biddingNoticeText 招标公告正文
     * @return 结果
     */
    @Override
    public int updateBiddingNoticeText(BiddingNoticeText biddingNoticeText)
    {
        return biddingNoticeTextMapper.updateBiddingNoticeText(biddingNoticeText);
    }

    /**
     * 批量删除招标公告正文
     * 
     * @param noticeTextIds 需要删除的招标公告正文主键
     * @return 结果
     */
    @Override
    public int deleteBiddingNoticeTextByNoticeTextIds(Long[] noticeTextIds)
    {
        return biddingNoticeTextMapper.deleteBiddingNoticeTextByNoticeTextIds(noticeTextIds);
    }

    /**
     * 删除招标公告正文信息
     * 
     * @param noticeTextId 招标公告正文主键
     * @return 结果
     */
    @Override
    public int deleteBiddingNoticeTextByNoticeTextId(Long noticeTextId)
    {
        return biddingNoticeTextMapper.deleteBiddingNoticeTextByNoticeTextId(noticeTextId);
    }
}
