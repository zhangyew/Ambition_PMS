package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingExtractionConditionsMapper;
import com.yz.bidding.domain.BiddingExtractionConditions;
import com.yz.bidding.service.IBiddingExtractionConditionsService;

/**
 * 抽取条件表Service业务层处理
 * 
 * @author zhangye
 * @date 2023-12-21
 */
@Service
public class BiddingExtractionConditionsServiceImpl implements IBiddingExtractionConditionsService 
{
    @Autowired
    private BiddingExtractionConditionsMapper biddingExtractionConditionsMapper;

    /**
     * 查询抽取条件表
     * 
     * @param extractionConditionsId 抽取条件表主键
     * @return 抽取条件表
     */
    @Override
    public BiddingExtractionConditions selectBiddingExtractionConditionsByExtractionConditionsId(Long extractionConditionsId)
    {
        return biddingExtractionConditionsMapper.selectBiddingExtractionConditionsByExtractionConditionsId(extractionConditionsId);
    }

    /**
     * 查询抽取条件表列表
     * 
     * @param biddingExtractionConditions 抽取条件表
     * @return 抽取条件表
     */
    @Override
    public List<BiddingExtractionConditions> selectBiddingExtractionConditionsList(BiddingExtractionConditions biddingExtractionConditions)
    {
        return biddingExtractionConditionsMapper.selectBiddingExtractionConditionsList(biddingExtractionConditions);
    }

    /**
     * 新增抽取条件表
     * 
     * @param biddingExtractionConditions 抽取条件表
     * @return 结果
     */
    @Override
    public int insertBiddingExtractionConditions(BiddingExtractionConditions biddingExtractionConditions)
    {
        return biddingExtractionConditionsMapper.insertBiddingExtractionConditions(biddingExtractionConditions);
    }

    /**
     * 修改抽取条件表
     * 
     * @param biddingExtractionConditions 抽取条件表
     * @return 结果
     */
    @Override
    public int updateBiddingExtractionConditions(BiddingExtractionConditions biddingExtractionConditions)
    {
        return biddingExtractionConditionsMapper.updateBiddingExtractionConditions(biddingExtractionConditions);
    }

    /**
     * 批量删除抽取条件表
     * 
     * @param extractionConditionsIds 需要删除的抽取条件表主键
     * @return 结果
     */
    @Override
    public int deleteBiddingExtractionConditionsByExtractionConditionsIds(Long[] extractionConditionsIds)
    {
        return biddingExtractionConditionsMapper.deleteBiddingExtractionConditionsByExtractionConditionsIds(extractionConditionsIds);
    }

    /**
     * 删除抽取条件表信息
     * 
     * @param extractionConditionsId 抽取条件表主键
     * @return 结果
     */
    @Override
    public int deleteBiddingExtractionConditionsByExtractionConditionsId(Long extractionConditionsId)
    {
        return biddingExtractionConditionsMapper.deleteBiddingExtractionConditionsByExtractionConditionsId(extractionConditionsId);
    }
}
