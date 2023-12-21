package com.yz.bidding.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 专家被抽取表对象 bidding_get_expert_extract
 * 
 * @author zhangye
 * @date 2023-12-21
 */
public class BiddingGetExpertExtract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专家被抽取表主键 */
    private Long getExpertExtractId;

    /** 项目公告表主键 */
    @Excel(name = "项目公告表主键")
    private Long getTenderId;

    /** 抽取表主键 */
    @Excel(name = "抽取表主键")
    private Long getExpertId;

    /** 专家表主键 */
    @Excel(name = "专家表主键")
    private Long getPoolId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationTime;

    public void setGetExpertExtractId(Long getExpertExtractId) 
    {
        this.getExpertExtractId = getExpertExtractId;
    }

    public Long getGetExpertExtractId() 
    {
        return getExpertExtractId;
    }
    public void setGetTenderId(Long getTenderId) 
    {
        this.getTenderId = getTenderId;
    }

    public Long getGetTenderId() 
    {
        return getTenderId;
    }
    public void setGetExpertId(Long getExpertId) 
    {
        this.getExpertId = getExpertId;
    }

    public Long getGetExpertId() 
    {
        return getExpertId;
    }
    public void setGetPoolId(Long getPoolId) 
    {
        this.getPoolId = getPoolId;
    }

    public Long getGetPoolId() 
    {
        return getPoolId;
    }
    public void setCreationTime(Date creationTime) 
    {
        this.creationTime = creationTime;
    }

    public Date getCreationTime() 
    {
        return creationTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("getExpertExtractId", getGetExpertExtractId())
            .append("getTenderId", getGetTenderId())
            .append("getExpertId", getGetExpertId())
            .append("getPoolId", getGetPoolId())
            .append("creationTime", getCreationTime())
            .toString();
    }
}
