package com.yz.bidding.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 中标公告对象 bidding_notice
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public class BiddingNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告id */
    private Long noticeId;

    /** 招标公告ID */
    @Excel(name = "招标公告ID")
    private Long tenderNoticeId;

    /** 公告日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "公告日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date noticeDate;

    /**  默认,远志集团有限公司 */
    @Excel(name = " 默认,远志集团有限公司")
    private String buyer;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String noticeTitle;

    /** 公告内容 */
    @Excel(name = "公告内容")
    private String noticeContext;

    /** 中标金额 */
    @Excel(name = "中标金额")
    private Long bidMoney;

    /** 外键 */
    @Excel(name = "外键")
    private Long noticeSupplierId;

    public void setNoticeId(Long noticeId) 
    {
        this.noticeId = noticeId;
    }

    public Long getNoticeId() 
    {
        return noticeId;
    }
    public void setTenderNoticeId(Long tenderNoticeId) 
    {
        this.tenderNoticeId = tenderNoticeId;
    }

    public Long getTenderNoticeId() 
    {
        return tenderNoticeId;
    }
    public void setNoticeDate(Date noticeDate) 
    {
        this.noticeDate = noticeDate;
    }

    public Date getNoticeDate() 
    {
        return noticeDate;
    }
    public void setBuyer(String buyer) 
    {
        this.buyer = buyer;
    }

    public String getBuyer() 
    {
        return buyer;
    }
    public void setNoticeTitle(String noticeTitle) 
    {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeTitle() 
    {
        return noticeTitle;
    }
    public void setNoticeContext(String noticeContext) 
    {
        this.noticeContext = noticeContext;
    }

    public String getNoticeContext() 
    {
        return noticeContext;
    }
    public void setBidMoney(Long bidMoney) 
    {
        this.bidMoney = bidMoney;
    }

    public Long getBidMoney() 
    {
        return bidMoney;
    }
    public void setNoticeSupplierId(Long noticeSupplierId) 
    {
        this.noticeSupplierId = noticeSupplierId;
    }

    public Long getNoticeSupplierId() 
    {
        return noticeSupplierId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("noticeId", getNoticeId())
            .append("tenderNoticeId", getTenderNoticeId())
            .append("noticeDate", getNoticeDate())
            .append("buyer", getBuyer())
            .append("noticeTitle", getNoticeTitle())
            .append("noticeContext", getNoticeContext())
            .append("bidMoney", getBidMoney())
            .append("noticeSupplierId", getNoticeSupplierId())
            .toString();
    }
}
