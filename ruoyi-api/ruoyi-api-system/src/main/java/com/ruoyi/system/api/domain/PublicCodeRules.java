package com.ruoyi.system.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 编码规则对象 public_code_rules
 * 
 * @author zhangye
 * @date 2023-11-22
 */
public class PublicCodeRules extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号规则主键 */
    @Excel(name = "编号规则主键")
    private Long codeRulesId;

    /** 目标表单 */
    @Excel(name = "目标表单")
    private String targets;

    /** 编号前缀 */
    @Excel(name = "编号前缀")
    private String prefixs;

    /** 时间规则 */
    @Excel(name = "时间规则")
    private String timeRules;

    /** 编码规则(UUID/Snowflakes) */
    @Excel(name = "编码规则(UUID/Snowflakes)")
    private Long codingRules;

    /** 流水号/总长度 */
    @Excel(name = "流水号/总长度")
    private Long lengths;

    public void setCodeRulesId(Long codeRulesId) 
    {
        this.codeRulesId = codeRulesId;
    }

    public Long getCodeRulesId() 
    {
        return codeRulesId;
    }
    public void setTargets(String targets) 
    {
        this.targets = targets;
    }

    public String getTargets() 
    {
        return targets;
    }
    public void setPrefixs(String prefixs) 
    {
        this.prefixs = prefixs;
    }

    public String getPrefixs() 
    {
        return prefixs;
    }
    public void setTimeRules(String timeRules) 
    {
        this.timeRules = timeRules;
    }

    public String getTimeRules() 
    {
        return timeRules;
    }
    public void setCodingRules(Long codingRules) 
    {
        this.codingRules = codingRules;
    }

    public Long getCodingRules() 
    {
        return codingRules;
    }
    public void setLengths(Long lengths) 
    {
        this.lengths = lengths;
    }

    public Long getLengths() 
    {
        return lengths;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("codeRulesId", getCodeRulesId())
            .append("targets", getTargets())
            .append("prefixs", getPrefixs())
            .append("timeRules", getTimeRules())
            .append("codingRules", getCodingRules())
            .append("lengths", getLengths())
            .toString();
    }
}
