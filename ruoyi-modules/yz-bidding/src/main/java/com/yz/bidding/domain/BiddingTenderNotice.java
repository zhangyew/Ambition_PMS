package com.yz.bidding.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 招标公告对象 bidding_tender_notice
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public class BiddingTenderNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 招标公告ID */
    private Long tenderNoticeId;

    /** 关联项目（外键） */
    @Excel(name = "关联项目", readConverterExp = "外=键")
    private Long tenderNoticeProjectsId;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String tenderTitle;

    /** 项目资金 */
    @Excel(name = "项目资金")
    private Long tenderNoticeMonery;

    /** 投标开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "投标开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bidStart;

    /** 投标结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "投标结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bidEnd;

    /** 开标开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开标开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date kaibiaoStart;

    /** 开标结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开标结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date kaibiaoEnd;

    /** 流程开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "流程开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date processStart;

    /** 流程结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "流程结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date processEnd;

    /** 正文 */
    @Excel(name = "正文")
    private String context;

    /** 标书 */
    @Excel(name = "标书")
    private String tenders;

    /** 状态 */
    @Excel(name = "状态")
    private Long state;

    /** 删除 */
    @Excel(name = "删除")
    private Long isDelete;

    public void setTenderNoticeId(Long tenderNoticeId) 
    {
        this.tenderNoticeId = tenderNoticeId;
    }

    public Long getTenderNoticeId() 
    {
        return tenderNoticeId;
    }
    public void setTenderNoticeProjectsId(Long tenderNoticeProjectsId) 
    {
        this.tenderNoticeProjectsId = tenderNoticeProjectsId;
    }

    public Long getTenderNoticeProjectsId() 
    {
        return tenderNoticeProjectsId;
    }
    public void setTenderTitle(String tenderTitle) 
    {
        this.tenderTitle = tenderTitle;
    }

    public String getTenderTitle() 
    {
        return tenderTitle;
    }
    public void setTenderNoticeMonery(Long tenderNoticeMonery) 
    {
        this.tenderNoticeMonery = tenderNoticeMonery;
    }

    public Long getTenderNoticeMonery() 
    {
        return tenderNoticeMonery;
    }
    public void setBidStart(Date bidStart) 
    {
        this.bidStart = bidStart;
    }

    public Date getBidStart() 
    {
        return bidStart;
    }
    public void setBidEnd(Date bidEnd) 
    {
        this.bidEnd = bidEnd;
    }

    public Date getBidEnd() 
    {
        return bidEnd;
    }
    public void setKaibiaoStart(Date kaibiaoStart) 
    {
        this.kaibiaoStart = kaibiaoStart;
    }

    public Date getKaibiaoStart() 
    {
        return kaibiaoStart;
    }
    public void setKaibiaoEnd(Date kaibiaoEnd) 
    {
        this.kaibiaoEnd = kaibiaoEnd;
    }

    public Date getKaibiaoEnd() 
    {
        return kaibiaoEnd;
    }
    public void setProcessStart(Date processStart) 
    {
        this.processStart = processStart;
    }

    public Date getProcessStart() 
    {
        return processStart;
    }
    public void setProcessEnd(Date processEnd) 
    {
        this.processEnd = processEnd;
    }

    public Date getProcessEnd() 
    {
        return processEnd;
    }
    public void setContext(String context) 
    {
        this.context = context;
    }

    public String getContext() 
    {
        return context;
    }
    public void setTenders(String tenders) 
    {
        this.tenders = tenders;
    }

    public String getTenders() 
    {
        return tenders;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tenderNoticeId", getTenderNoticeId())
            .append("tenderNoticeProjectsId", getTenderNoticeProjectsId())
            .append("tenderTitle", getTenderTitle())
            .append("tenderNoticeMonery", getTenderNoticeMonery())
            .append("bidStart", getBidStart())
            .append("bidEnd", getBidEnd())
            .append("kaibiaoStart", getKaibiaoStart())
            .append("kaibiaoEnd", getKaibiaoEnd())
            .append("processStart", getProcessStart())
            .append("processEnd", getProcessEnd())
            .append("remark", getRemark())
            .append("context", getContext())
            .append("tenders", getTenders())
            .append("state", getState())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
