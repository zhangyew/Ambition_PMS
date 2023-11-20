package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingTenderNoticeMapper;
import com.yz.bidding.domain.BiddingTenderNotice;
import com.yz.bidding.service.IBiddingTenderNoticeService;

/**
 * 招标公告Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class BiddingTenderNoticeServiceImpl implements IBiddingTenderNoticeService 
{
    @Autowired
    private BiddingTenderNoticeMapper biddingTenderNoticeMapper;

    /**
     * 查询招标公告
     * 
     * @param tenderNoticeId 招标公告主键
     * @return 招标公告
     */
    @Override
    public BiddingTenderNotice selectBiddingTenderNoticeByTenderNoticeId(Long tenderNoticeId)
    {
        return biddingTenderNoticeMapper.selectBiddingTenderNoticeByTenderNoticeId(tenderNoticeId);
    }

    /**
     * 查询招标公告列表
     * 
     * @param biddingTenderNotice 招标公告
     * @return 招标公告
     */
    @Override
    public List<BiddingTenderNotice> selectBiddingTenderNoticeList(BiddingTenderNotice biddingTenderNotice)
    {
        return biddingTenderNoticeMapper.selectBiddingTenderNoticeList(biddingTenderNotice);
    }

    /**
     * 新增招标公告
     * 
     * @param biddingTenderNotice 招标公告
     * @return 结果
     */
    @Override
    public int insertBiddingTenderNotice(BiddingTenderNotice biddingTenderNotice)
    {
        return biddingTenderNoticeMapper.insertBiddingTenderNotice(biddingTenderNotice);
    }

    /**
     * 修改招标公告
     * 
     * @param biddingTenderNotice 招标公告
     * @return 结果
     */
    @Override
    public int updateBiddingTenderNotice(BiddingTenderNotice biddingTenderNotice)
    {
        return biddingTenderNoticeMapper.updateBiddingTenderNotice(biddingTenderNotice);
    }

    /**
     * 批量删除招标公告
     * 
     * @param tenderNoticeIds 需要删除的招标公告主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderNoticeByTenderNoticeIds(Long[] tenderNoticeIds)
    {
        return biddingTenderNoticeMapper.deleteBiddingTenderNoticeByTenderNoticeIds(tenderNoticeIds);
    }

    /**
     * 删除招标公告信息
     * 
     * @param tenderNoticeId 招标公告主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderNoticeByTenderNoticeId(Long tenderNoticeId)
    {
        return biddingTenderNoticeMapper.deleteBiddingTenderNoticeByTenderNoticeId(tenderNoticeId);
    }
}
