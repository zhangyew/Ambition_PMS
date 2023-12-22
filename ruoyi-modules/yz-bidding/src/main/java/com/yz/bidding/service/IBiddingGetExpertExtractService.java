package com.yz.bidding.service;

import java.util.List;
import com.yz.bidding.domain.BiddingGetExpertExtract;

/**
 * 专家被抽取表Service接口
 * 
 * @author zhangye
 * @date 2023-12-21
 */
public interface IBiddingGetExpertExtractService 
{
    /**
     * 查询专家被抽取表
     * 
     * @param getExpertExtractId 专家被抽取表主键
     * @return 专家被抽取表
     */
    public BiddingGetExpertExtract selectBiddingGetExpertExtractByGetExpertExtractId(Long getExpertExtractId);

    /**
     * 查询专家被抽取表列表
     * 
     * @param biddingGetExpertExtract 专家被抽取表
     * @return 专家被抽取表集合
     */
    public List<BiddingGetExpertExtract> selectBiddingGetExpertExtractList(BiddingGetExpertExtract biddingGetExpertExtract);

    /**
     * 新增专家被抽取表
     * 
     * @param biddingGetExpertExtract 专家被抽取表
     * @return 结果
     */
    public int insertBiddingGetExpertExtract(BiddingGetExpertExtract biddingGetExpertExtract);

    /**
     * 修改专家被抽取表
     * 
     * @param biddingGetExpertExtract 专家被抽取表
     * @return 结果
     */
    public int updateBiddingGetExpertExtract(BiddingGetExpertExtract biddingGetExpertExtract);

    /**
     * 批量删除专家被抽取表
     * 
     * @param getExpertExtractIds 需要删除的专家被抽取表主键集合
     * @return 结果
     */
    public int deleteBiddingGetExpertExtractByGetExpertExtractIds(Long[] getExpertExtractIds);

    /**
     * 删除专家被抽取表信息
     * 
     * @param getExpertExtractId 专家被抽取表主键
     * @return 结果
     */
    public int deleteBiddingGetExpertExtractByGetExpertExtractId(Long getExpertExtractId);
}
