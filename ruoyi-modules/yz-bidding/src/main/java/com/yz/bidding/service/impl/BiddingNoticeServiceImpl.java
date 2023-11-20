package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingNoticeMapper;
import com.yz.bidding.domain.BiddingNotice;
import com.yz.bidding.service.IBiddingNoticeService;

/**
 * 中标公告Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class BiddingNoticeServiceImpl implements IBiddingNoticeService 
{
    @Autowired
    private BiddingNoticeMapper biddingNoticeMapper;

    /**
     * 查询中标公告
     * 
     * @param noticeId 中标公告主键
     * @return 中标公告
     */
    @Override
    public BiddingNotice selectBiddingNoticeByNoticeId(Long noticeId)
    {
        return biddingNoticeMapper.selectBiddingNoticeByNoticeId(noticeId);
    }

    /**
     * 查询中标公告列表
     * 
     * @param biddingNotice 中标公告
     * @return 中标公告
     */
    @Override
    public List<BiddingNotice> selectBiddingNoticeList(BiddingNotice biddingNotice)
    {
        return biddingNoticeMapper.selectBiddingNoticeList(biddingNotice);
    }

    /**
     * 新增中标公告
     * 
     * @param biddingNotice 中标公告
     * @return 结果
     */
    @Override
    public int insertBiddingNotice(BiddingNotice biddingNotice)
    {
        return biddingNoticeMapper.insertBiddingNotice(biddingNotice);
    }

    /**
     * 修改中标公告
     * 
     * @param biddingNotice 中标公告
     * @return 结果
     */
    @Override
    public int updateBiddingNotice(BiddingNotice biddingNotice)
    {
        return biddingNoticeMapper.updateBiddingNotice(biddingNotice);
    }

    /**
     * 批量删除中标公告
     * 
     * @param noticeIds 需要删除的中标公告主键
     * @return 结果
     */
    @Override
    public int deleteBiddingNoticeByNoticeIds(Long[] noticeIds)
    {
        return biddingNoticeMapper.deleteBiddingNoticeByNoticeIds(noticeIds);
    }

    /**
     * 删除中标公告信息
     * 
     * @param noticeId 中标公告主键
     * @return 结果
     */
    @Override
    public int deleteBiddingNoticeByNoticeId(Long noticeId)
    {
        return biddingNoticeMapper.deleteBiddingNoticeByNoticeId(noticeId);
    }
}
