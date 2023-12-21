package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingGetExpertExtractMapper;
import com.yz.bidding.domain.BiddingGetExpertExtract;
import com.yz.bidding.service.IBiddingGetExpertExtractService;

/**
 * 专家被抽取表Service业务层处理
 * 
 * @author zhangye
 * @date 2023-12-21
 */
@Service
public class BiddingGetExpertExtractServiceImpl implements IBiddingGetExpertExtractService 
{
    @Autowired
    private BiddingGetExpertExtractMapper biddingGetExpertExtractMapper;

    /**
     * 查询专家被抽取表
     * 
     * @param getExpertExtractId 专家被抽取表主键
     * @return 专家被抽取表
     */
    @Override
    public BiddingGetExpertExtract selectBiddingGetExpertExtractByGetExpertExtractId(Long getExpertExtractId)
    {
        return biddingGetExpertExtractMapper.selectBiddingGetExpertExtractByGetExpertExtractId(getExpertExtractId);
    }

    /**
     * 查询专家被抽取表列表
     * 
     * @param biddingGetExpertExtract 专家被抽取表
     * @return 专家被抽取表
     */
    @Override
    public List<BiddingGetExpertExtract> selectBiddingGetExpertExtractList(BiddingGetExpertExtract biddingGetExpertExtract)
    {
        return biddingGetExpertExtractMapper.selectBiddingGetExpertExtractList(biddingGetExpertExtract);
    }

    /**
     * 新增专家被抽取表
     * 
     * @param biddingGetExpertExtract 专家被抽取表
     * @return 结果
     */
    @Override
    public int insertBiddingGetExpertExtract(BiddingGetExpertExtract biddingGetExpertExtract)
    {
        return biddingGetExpertExtractMapper.insertBiddingGetExpertExtract(biddingGetExpertExtract);
    }

    /**
     * 修改专家被抽取表
     * 
     * @param biddingGetExpertExtract 专家被抽取表
     * @return 结果
     */
    @Override
    public int updateBiddingGetExpertExtract(BiddingGetExpertExtract biddingGetExpertExtract)
    {
        return biddingGetExpertExtractMapper.updateBiddingGetExpertExtract(biddingGetExpertExtract);
    }

    /**
     * 批量删除专家被抽取表
     * 
     * @param getExpertExtractIds 需要删除的专家被抽取表主键
     * @return 结果
     */
    @Override
    public int deleteBiddingGetExpertExtractByGetExpertExtractIds(Long[] getExpertExtractIds)
    {
        return biddingGetExpertExtractMapper.deleteBiddingGetExpertExtractByGetExpertExtractIds(getExpertExtractIds);
    }

    /**
     * 删除专家被抽取表信息
     * 
     * @param getExpertExtractId 专家被抽取表主键
     * @return 结果
     */
    @Override
    public int deleteBiddingGetExpertExtractByGetExpertExtractId(Long getExpertExtractId)
    {
        return biddingGetExpertExtractMapper.deleteBiddingGetExpertExtractByGetExpertExtractId(getExpertExtractId);
    }
}
