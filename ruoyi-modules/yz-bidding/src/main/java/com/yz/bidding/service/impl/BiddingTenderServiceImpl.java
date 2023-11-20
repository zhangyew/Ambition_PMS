package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingTenderMapper;
import com.yz.bidding.domain.BiddingTender;
import com.yz.bidding.service.IBiddingTenderService;

/**
 * 投标Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class BiddingTenderServiceImpl implements IBiddingTenderService 
{
    @Autowired
    private BiddingTenderMapper biddingTenderMapper;

    /**
     * 查询投标
     * 
     * @param tenderId 投标主键
     * @return 投标
     */
    @Override
    public BiddingTender selectBiddingTenderByTenderId(Long tenderId)
    {
        return biddingTenderMapper.selectBiddingTenderByTenderId(tenderId);
    }

    /**
     * 查询投标列表
     * 
     * @param biddingTender 投标
     * @return 投标
     */
    @Override
    public List<BiddingTender> selectBiddingTenderList(BiddingTender biddingTender)
    {
        return biddingTenderMapper.selectBiddingTenderList(biddingTender);
    }

    /**
     * 新增投标
     * 
     * @param biddingTender 投标
     * @return 结果
     */
    @Override
    public int insertBiddingTender(BiddingTender biddingTender)
    {
        return biddingTenderMapper.insertBiddingTender(biddingTender);
    }

    /**
     * 修改投标
     * 
     * @param biddingTender 投标
     * @return 结果
     */
    @Override
    public int updateBiddingTender(BiddingTender biddingTender)
    {
        return biddingTenderMapper.updateBiddingTender(biddingTender);
    }

    /**
     * 批量删除投标
     * 
     * @param tenderIds 需要删除的投标主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderByTenderIds(Long[] tenderIds)
    {
        return biddingTenderMapper.deleteBiddingTenderByTenderIds(tenderIds);
    }

    /**
     * 删除投标信息
     * 
     * @param tenderId 投标主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderByTenderId(Long tenderId)
    {
        return biddingTenderMapper.deleteBiddingTenderByTenderId(tenderId);
    }
}
