package com.yz.bidding.service.impl;

import java.util.*;

import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.system.api.domain.PublicCodeRules;
import com.ruoyi.system.api.domain.PublicExpert;
import com.ruoyi.system.api.util.SnowflakeGetId;
import com.yz.bidding.domain.BiddingExtractionConditions;
import com.yz.bidding.domain.BiddingGetExpertExtract;
import com.yz.bidding.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.domain.BiddingDrawExperts;
import com.yz.bidding.service.IBiddingDrawExpertsService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 抽取专家Service业务层处理
 *
 * @author zhangye
 * @date 2023-11-21
 */
@Transactional
@Service
public class BiddingDrawExpertsServiceImpl implements IBiddingDrawExpertsService {
    @Resource
    private BiddingDrawExpertsMapper biddingDrawExpertsMapper;
    @Resource
    private PublicExpertMapper expertMapper;
    @Resource
    private BiddingExtractionConditionsMapper ecm;
    @Resource
    private BiddingGetExpertExtractMapper gem;
    @Resource
    private PublicCodeRulesMapper code;

    @Override
    public List<Map<String, Object>> findExpertsByProjectsId(String pid) {
        return biddingDrawExpertsMapper.findExpertsByProjectsId(pid);
    }

    @Override
    public int addDrawExperts(BiddingDrawExperts drawExperts
            , List<BiddingExtractionConditions> conditions, List<PublicExpert> experts) {
        int x = 0;
        BiddingDrawExperts draw = drawExperts;
        System.out.println(draw);
        draw.setCreateTime(new Date());
        PublicCodeRules rules = code.selectPublicCodeRulesByCodeRulesId(14L);
        draw.setNumber(SnowflakeGetId.getCode(rules));
        if (drawExperts.getManner() == 1) { // 直接指定专家
            // 插入抽取表、更改专家状态、插入专家抽取表
            x = biddingDrawExpertsMapper.insertBiddingDrawExperts(draw);

            for (PublicExpert e : experts) {
                PublicExpert y = new PublicExpert();
                BiddingGetExpertExtract gee = new BiddingGetExpertExtract();
                y.setExpertId(e.getExpertId());
                y.setIsExtract(1L);
                gee.setGetTenderId(draw.getDrawProjectsId());
                gee.setGetExpertId(draw.getDrawExpertsId());
                gee.setGetPoolId(e.getExpertId());
                gee.setCreationTime(new Date());
                x = expertMapper.updatePublicExpert(y);
                x = gem.insertBiddingGetExpertExtract(gee);
            }

        } else { // 根据条件随机抽取专家
            // 拿到所有回避专家id、根据抽取条件查询出每个条件下除去回避专家的所有专家
            // 根据抽取人数对专家集合进行随机取出专家id
            // 然后拿到所有专家id。
            // 插入抽取表、条件表、专家被抽取表、专家状态修改
            List<Long> zj = new ArrayList<>();
            for (PublicExpert p : experts) {
                zj.add(p.getExpertId());
            }
            StringBuffer sb = new StringBuffer();
            for (Long l : zj) {
                sb.append(l).append(",");
            }
            draw.setEvadeExperts(sb.toString());
            x = biddingDrawExpertsMapper.insertBiddingDrawExperts(draw);
            for (BiddingExtractionConditions g : conditions) {
                g.setExtractionExpertId(draw.getDrawExpertsId());
                g.setCreationTime(new Date());
                x = ecm.insertBiddingExtractionConditions(g);
                g.getSpecialized();
                List<PublicExpert> ex = expertMapper
                        .findExpertByExtractionConditions(g.getSpecialized().toString(), zj);
                // 使用洗牌算法打乱列表中的元素
                Collections.shuffle(ex);
                int loopCount = (int) Math.min(ex.size(), g.getNumber());
                for (int i = 0; i < loopCount; i++) {
                    PublicExpert expert = ex.get(i);
                    BiddingGetExpertExtract gee = new BiddingGetExpertExtract();
                    gee.setGetTenderId(draw.getDrawProjectsId());
                    gee.setGetExpertId(draw.getDrawExpertsId());
                    gee.setGetPoolId(expert.getExpertId());
                    gee.setCreationTime(new Date());
                    PublicExpert y = new PublicExpert();
                    y.setExpertId(expert.getExpertId());
                    y.setIsExtract(1L);
                    x = expertMapper.updatePublicExpert(y);
                    x = gem.insertBiddingGetExpertExtract(gee);
                }
            }
        }
        return x;
    }

    /**
     * 查询抽取专家
     *
     * @param drawExpertsId 抽取专家主键
     * @return 抽取专家
     */
    @Override
    public BiddingDrawExperts selectBiddingDrawExpertsByDrawExpertsId(Long drawExpertsId) {
        return biddingDrawExpertsMapper.selectBiddingDrawExpertsByDrawExpertsId(drawExpertsId);
    }

    /**
     * 查询抽取专家列表
     *
     * @param biddingDrawExperts 抽取专家
     * @return 抽取专家
     */
    @Override
    public List<BiddingDrawExperts> selectBiddingDrawExpertsList(BiddingDrawExperts biddingDrawExperts) {
        return biddingDrawExpertsMapper.selectBiddingDrawExpertsList(biddingDrawExperts);
    }

    /**
     * 新增抽取专家
     *
     * @param biddingDrawExperts 抽取专家
     * @return 结果
     */
    @Override
    public int insertBiddingDrawExperts(BiddingDrawExperts biddingDrawExperts) {
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
    public int updateBiddingDrawExperts(BiddingDrawExperts biddingDrawExperts) {
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
    public int deleteBiddingDrawExpertsByDrawExpertsIds(Long[] drawExpertsIds) {
        return biddingDrawExpertsMapper.deleteBiddingDrawExpertsByDrawExpertsIds(drawExpertsIds);
    }

    /**
     * 删除抽取专家信息
     *
     * @param drawExpertsId 抽取专家主键
     * @return 结果
     */
    @Override
    public int deleteBiddingDrawExpertsByDrawExpertsId(Long drawExpertsId) {
        return biddingDrawExpertsMapper.deleteBiddingDrawExpertsByDrawExpertsId(drawExpertsId);
    }
}
