package com.yz.bidding.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 抽取条件表对象 bidding_extraction_conditions
 * 
 * @author zhangye
 * @date 2023-12-21
 */
public class BiddingExtractionConditions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 抽取专家表主键 */
    private Long extractionConditionsId;

    /** 抽取表主键 */
    @Excel(name = "抽取表主键")
    private Long extractionExpertId;

    /** 评标专业 */
    @Excel(name = "评标专业")
    private Long specialized;

    /** 抽取人数 */
    @Excel(name = "抽取人数")
    private Long number;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationTime;

    public void setExtractionConditionsId(Long extractionConditionsId) 
    {
        this.extractionConditionsId = extractionConditionsId;
    }

    public Long getExtractionConditionsId() 
    {
        return extractionConditionsId;
    }
    public void setExtractionExpertId(Long extractionExpertId) 
    {
        this.extractionExpertId = extractionExpertId;
    }

    public Long getExtractionExpertId() 
    {
        return extractionExpertId;
    }
    public void setSpecialized(Long specialized) 
    {
        this.specialized = specialized;
    }

    public Long getSpecialized() 
    {
        return specialized;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
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
            .append("extractionConditionsId", getExtractionConditionsId())
            .append("extractionExpertId", getExtractionExpertId())
            .append("specialized", getSpecialized())
            .append("number", getNumber())
            .append("creationTime", getCreationTime())
            .toString();
    }
}
