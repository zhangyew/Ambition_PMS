package com.yz.bidding.mapper;

import java.util.List;
import com.yz.bidding.domain.BiddingDrawExperts;

/**
 * 抽取专家Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface BiddingDrawExpertsMapper 
{
    /**
     * 查询抽取专家
     * 
     * @param drawExpertsId 抽取专家主键
     * @return 抽取专家
     */
    public BiddingDrawExperts selectBiddingDrawExpertsByDrawExpertsId(Long drawExpertsId);

    /**
     * 查询抽取专家列表
     * 
     * @param biddingDrawExperts 抽取专家
     * @return 抽取专家集合
     */
    public List<BiddingDrawExperts> selectBiddingDrawExpertsList(BiddingDrawExperts biddingDrawExperts);

    /**
     * 新增抽取专家
     * 
     * @param biddingDrawExperts 抽取专家
     * @return 结果
     */
    public int insertBiddingDrawExperts(BiddingDrawExperts biddingDrawExperts);

    /**
     * 修改抽取专家
     * 
     * @param biddingDrawExperts 抽取专家
     * @return 结果
     */
    public int updateBiddingDrawExperts(BiddingDrawExperts biddingDrawExperts);

    /**
     * 删除抽取专家
     * 
     * @param drawExpertsId 抽取专家主键
     * @return 结果
     */
    public int deleteBiddingDrawExpertsByDrawExpertsId(Long drawExpertsId);

    /**
     * 批量删除抽取专家
     * 
     * @param drawExpertsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBiddingDrawExpertsByDrawExpertsIds(Long[] drawExpertsIds);
}
