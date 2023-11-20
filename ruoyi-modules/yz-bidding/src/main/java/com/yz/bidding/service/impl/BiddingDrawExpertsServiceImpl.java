package com.yz.bidding.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingDrawExpertsMapper;
import com.yz.bidding.domain.BiddingDrawExperts;
import com.yz.bidding.service.IBiddingDrawExpertsService;

/**
 * 抽取专家Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class BiddingDrawExpertsServiceImpl implements IBiddingDrawExpertsService 
{
    @Autowired
    private BiddingDrawExpertsMapper biddingDrawExpertsMapper;

    /**
     * 查询抽取专家
     * 
     * @param drawExpertsId 抽取专家主键
     * @return 抽取专家
     */
    @Override
    public BiddingDrawExperts selectBiddingDrawExpertsByDrawExpertsId(Long drawExpertsId)
    {
        return biddingDrawExpertsMapper.selectBiddingDrawExpertsByDrawExpertsId(drawExpertsId);
    }

    /**
     * 查询抽取专家列表
     * 
     * @param biddingDrawExperts 抽取专家
     * @return 抽取专家
     */
    @Override
    public List<BiddingDrawExperts> selectBiddingDrawExpertsList(BiddingDrawExperts biddingDrawExperts)
    {
        return biddingDrawExpertsMapper.selectBiddingDrawExpertsList(biddingDrawExperts);
    }

    /**
     * 新增抽取专家
     * 
     * @param biddingDrawExperts 抽取专家
     * @return 结果
     */
    @Override
    public int insertBiddingDrawExperts(BiddingDrawExperts biddingDrawExperts)
    {
        biddingDrawExperts.setCreateTime(DateUtils.getNowDate());
        return biddingDrawExpertsMapper.insertBiddingDrawExperts(biddingDrawExperts);
    }

    /**
     * 修改抽取专家
     * 
     * @param biddingDrawExperts 抽取专家
     * @return 结果
     */
    @Override
    public int updateBiddingDrawExperts(BiddingDrawExperts biddingDrawExperts)
    {
        biddingDrawExperts.setUpdateTime(DateUtils.getNowDate());
        return biddingDrawExpertsMapper.updateBiddingDrawExperts(biddingDrawExperts);
    }

    /**
     * 批量删除抽取专家
     * 
     * @param drawExpertsIds 需要删除的抽取专家主键
     * @return 结果
     */
    @Override
    public int deleteBiddingDrawExpertsByDrawExpertsIds(Long[] drawExpertsIds)
    {
        return biddingDrawExpertsMapper.deleteBiddingDrawExpertsByDrawExpertsIds(drawExpertsIds);
    }

    /**
     * 删除抽取专家信息
     * 
     * @param drawExpertsId 抽取专家主键
     * @return 结果
     */
    @Override
    public int deleteBiddingDrawExpertsByDrawExpertsId(Long drawExpertsId)
    {
        return biddingDrawExpertsMapper.deleteBiddingDrawExpertsByDrawExpertsId(drawExpertsId);
    }
}
