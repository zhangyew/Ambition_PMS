package com.yz.bidding.service.impl;

import java.util.List;

import com.ruoyi.system.api.domain.PublicCodeRules;
import com.ruoyi.system.api.util.SnowflakeGetId;
import com.yz.bidding.domain.BiddingTenderManifest;
import com.yz.bidding.mapper.BiddingTenderManifestMapper;
import com.yz.bidding.mapper.PublicCodeRulesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingTenderProjectsMapper;
import com.yz.bidding.domain.BiddingTenderProjects;
import com.yz.bidding.service.IBiddingTenderProjectsService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 招标项目Service业务层处理
 *
 * @author zhangye
 * @date 2023-11-21
 */
@Service
@Transactional
public class BiddingTenderProjectsServiceImpl implements IBiddingTenderProjectsService {
    @Resource
    private BiddingTenderProjectsMapper biddingTenderProjectsMapper;
    @Resource
    private BiddingTenderManifestMapper manifestMapper;
    @Resource
    private PublicCodeRulesMapper publicCodeRulesMapper;

    @Override
    public int updateStates(String id, String zt) {
        return biddingTenderProjectsMapper.updateStates(id, zt);
    }

    @Override
    public BiddingTenderProjects findProjectById(String pid) {
        return biddingTenderProjectsMapper.findProjectById(pid);
    }

    @Override
    public int insertProjects(BiddingTenderProjects projects, List<BiddingTenderManifest> list) {
        int x = 0;
        BiddingTenderProjects projects1 = projects;
        PublicCodeRules rules = publicCodeRulesMapper.selectPublicCodeRulesByCodeRulesId(12L);
        SnowflakeGetId snowflakeGetId = new SnowflakeGetId(1, 1);
        projects1.setTenderProjectsNumber(snowflakeGetId.getCode(rules));

        if (projects1.getTenderProjectsId() == null) {
            x = biddingTenderProjectsMapper.insertBiddingTenderProjects(projects1);
        } else {
            x = biddingTenderProjectsMapper.updateBiddingTenderProjects(projects1);
            x = manifestMapper.deleteByProjectId(projects1.getTenderProjectsId());
        }
        for (BiddingTenderManifest b : list) {
            b.setManifestProjectsId(projects1.getTenderProjectsId());
            x = manifestMapper.insertBiddingTenderManifest(b);
        }
        return x;
    }

    /**
     * 查询招标项目
     * 
     * @param tenderProjectsId 招标项目主键
     * @return 招标项目
     */
    @Override
    public BiddingTenderProjects selectBiddingTenderProjectsByTenderProjectsId(Long tenderProjectsId)
    {
        return biddingTenderProjectsMapper.selectBiddingTenderProjectsByTenderProjectsId(tenderProjectsId);
    }

    /**
     * 查询招标项目列表
     * 
     * @param biddingTenderProjects 招标项目
     * @return 招标项目
     */
    @Override
    public List<BiddingTenderProjects> selectBiddingTenderProjectsList(BiddingTenderProjects biddingTenderProjects)
    {
        return biddingTenderProjectsMapper.selectBiddingTenderProjectsList(biddingTenderProjects);
    }

    /**
     * 项目显示（合同签订）
     * @param tenderProjectsId
     * @return
     */
    @Override
    public List<BiddingTenderProjects> agreementTenderProjects(Long tenderProjectsId) {
        return biddingTenderProjectsMapper.agreementTenderProjects(tenderProjectsId);
    }

    /**
     * 新增招标项目
     * 
     * @param biddingTenderProjects 招标项目
     * @return 结果
     */
    @Override
    public int insertBiddingTenderProjects(BiddingTenderProjects biddingTenderProjects)
    {
        return biddingTenderProjectsMapper.insertBiddingTenderProjects(biddingTenderProjects);
    }

    /**
     * 修改招标项目
     * 
     * @param biddingTenderProjects 招标项目
     * @return 结果
     */
    @Override
    public int updateBiddingTenderProjects(BiddingTenderProjects biddingTenderProjects)
    {
        return biddingTenderProjectsMapper.updateBiddingTenderProjects(biddingTenderProjects);
    }

    /**
     * 批量删除招标项目
     * 
     * @param tenderProjectsIds 需要删除的招标项目主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderProjectsByTenderProjectsIds(Long[] tenderProjectsIds)
    {
        return biddingTenderProjectsMapper.deleteBiddingTenderProjectsByTenderProjectsIds(tenderProjectsIds);
    }

    /**
     * 删除招标项目信息
     * 
     * @param tenderProjectsId 招标项目主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderProjectsByTenderProjectsId(Long tenderProjectsId)
    {
        return biddingTenderProjectsMapper.deleteBiddingTenderProjectsByTenderProjectsId(tenderProjectsId);
    }
}
