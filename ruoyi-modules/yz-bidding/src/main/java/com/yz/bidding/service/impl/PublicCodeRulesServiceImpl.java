package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicCodeRulesMapper;
import com.ruoyi.system.api.domain.PublicCodeRules;
import com.yz.bidding.service.IPublicCodeRulesService;

/**
 * 编码规则Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-22
 */
@Service
public class PublicCodeRulesServiceImpl implements IPublicCodeRulesService 
{
    @Autowired
    private PublicCodeRulesMapper publicCodeRulesMapper;

    /**
     * 查询编码规则
     * 
     * @param codeRulesId 编码规则主键
     * @return 编码规则
     */
    @Override
    public PublicCodeRules selectPublicCodeRulesByCodeRulesId(Long codeRulesId)
    {
        return publicCodeRulesMapper.selectPublicCodeRulesByCodeRulesId(codeRulesId);
    }

    /**
     * 查询编码规则列表
     * 
     * @param publicCodeRules 编码规则
     * @return 编码规则
     */
    @Override
    public List<PublicCodeRules> selectPublicCodeRulesList(PublicCodeRules publicCodeRules)
    {
        return publicCodeRulesMapper.selectPublicCodeRulesList(publicCodeRules);
    }

    /**
     * 新增编码规则
     * 
     * @param publicCodeRules 编码规则
     * @return 结果
     */
    @Override
    public int insertPublicCodeRules(PublicCodeRules publicCodeRules)
    {
        return publicCodeRulesMapper.insertPublicCodeRules(publicCodeRules);
    }

    /**
     * 修改编码规则
     * 
     * @param publicCodeRules 编码规则
     * @return 结果
     */
    @Override
    public int updatePublicCodeRules(PublicCodeRules publicCodeRules)
    {
        return publicCodeRulesMapper.updatePublicCodeRules(publicCodeRules);
    }

    /**
     * 批量删除编码规则
     * 
     * @param codeRulesIds 需要删除的编码规则主键
     * @return 结果
     */
    @Override
    public int deletePublicCodeRulesByCodeRulesIds(Long[] codeRulesIds)
    {
        return publicCodeRulesMapper.deletePublicCodeRulesByCodeRulesIds(codeRulesIds);
    }

    /**
     * 删除编码规则信息
     * 
     * @param codeRulesId 编码规则主键
     * @return 结果
     */
    @Override
    public int deletePublicCodeRulesByCodeRulesId(Long codeRulesId)
    {
        return publicCodeRulesMapper.deletePublicCodeRulesByCodeRulesId(codeRulesId);
    }
}
