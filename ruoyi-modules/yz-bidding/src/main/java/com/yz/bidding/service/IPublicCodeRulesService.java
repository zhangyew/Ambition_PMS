package com.yz.bidding.service;

import java.util.List;
import com.ruoyi.system.api.domain.PublicCodeRules;

/**
 * 编码规则Service接口
 * 
 * @author zhangye
 * @date 2023-11-22
 */
public interface IPublicCodeRulesService 
{
    /**
     * 查询编码规则
     * 
     * @param codeRulesId 编码规则主键
     * @return 编码规则
     */
    public PublicCodeRules selectPublicCodeRulesByCodeRulesId(Long codeRulesId);

    /**
     * 查询编码规则列表
     * 
     * @param publicCodeRules 编码规则
     * @return 编码规则集合
     */
    public List<PublicCodeRules> selectPublicCodeRulesList(PublicCodeRules publicCodeRules);

    /**
     * 新增编码规则
     * 
     * @param publicCodeRules 编码规则
     * @return 结果
     */
    public int insertPublicCodeRules(PublicCodeRules publicCodeRules);

    /**
     * 修改编码规则
     * 
     * @param publicCodeRules 编码规则
     * @return 结果
     */
    public int updatePublicCodeRules(PublicCodeRules publicCodeRules);

    /**
     * 批量删除编码规则
     * 
     * @param codeRulesIds 需要删除的编码规则主键集合
     * @return 结果
     */
    public int deletePublicCodeRulesByCodeRulesIds(Long[] codeRulesIds);

    /**
     * 删除编码规则信息
     * 
     * @param codeRulesId 编码规则主键
     * @return 结果
     */
    public int deletePublicCodeRulesByCodeRulesId(Long codeRulesId);
}
