package com.yz.bidding.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.api.domain.PublicExpert;
import com.yz.bidding.domain.BiddingDrawExperts;
import com.yz.bidding.domain.BiddingExtractionConditions;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 抽取专家Service接口
 *
 * @author zhangye
 * @date 2023-11-21
 */
public interface IBiddingDrawExpertsService {


    /**
     * 查找当前项目下被抽取的专家
     * @param pid
     * @return
     */
    public List<Map<String,Object>> findExpertsByProjectsId(String pid);

    /**
     * 抽取专家操作
     *
     * @param data
     * @param tj
     * @param zj
     * @return
     */
    public int addDrawExperts(BiddingDrawExperts data, List<BiddingExtractionConditions> tj,
                              List<PublicExpert> zj);

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
     * 批量删除抽取专家
     *
     * @param drawExpertsIds 需要删除的抽取专家主键集合
     * @return 结果
     */
    public int deleteBiddingDrawExpertsByDrawExpertsIds(Long[] drawExpertsIds);

    /**
     * 删除抽取专家信息
     *
     * @param drawExpertsId 抽取专家主键
     * @return 结果
     */
    public int deleteBiddingDrawExpertsByDrawExpertsId(Long drawExpertsId);
}
