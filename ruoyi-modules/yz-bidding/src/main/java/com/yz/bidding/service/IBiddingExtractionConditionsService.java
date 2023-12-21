package com.yz.bidding.service;

import java.util.List;
import com.yz.bidding.domain.BiddingExtractionConditions;

/**
 * 抽取条件表Service接口
 * 
 * @author zhangye
 * @date 2023-12-21
 */
public interface IBiddingExtractionConditionsService 
{
    /**
     * 查询抽取条件表
     * 
     * @param extractionConditionsId 抽取条件表主键
     * @return 抽取条件表
     */
    public BiddingExtractionConditions selectBiddingExtractionConditionsByExtractionConditionsId(Long extractionConditionsId);

    /**
     * 查询抽取条件表列表
     * 
     * @param biddingExtractionConditions 抽取条件表
     * @return 抽取条件表集合
     */
    public List<BiddingExtractionConditions> selectBiddingExtractionConditionsList(BiddingExtractionConditions biddingExtractionConditions);

    /**
     * 新增抽取条件表
     * 
     * @param biddingExtractionConditions 抽取条件表
     * @return 结果
     */
    public int insertBiddingExtractionConditions(BiddingExtractionConditions biddingExtractionConditions);

    /**
     * 修改抽取条件表
     * 
     * @param biddingExtractionConditions 抽取条件表
     * @return 结果
     */
    public int updateBiddingExtractionConditions(BiddingExtractionConditions biddingExtractionConditions);

    /**
     * 批量删除抽取条件表
     * 
     * @param extractionConditionsIds 需要删除的抽取条件表主键集合
     * @return 结果
     */
    public int deleteBiddingExtractionConditionsByExtractionConditionsIds(Long[] extractionConditionsIds);

    /**
     * 删除抽取条件表信息
     * 
     * @param extractionConditionsId 抽取条件表主键
     * @return 结果
     */
    public int deleteBiddingExtractionConditionsByExtractionConditionsId(Long extractionConditionsId);
}
