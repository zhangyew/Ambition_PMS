package com.yz.bidding.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 招标公告正文对象 bidding_notice_text
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public class BiddingNoticeText extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告正文主键 */
    private Long noticeTextId;

    /** 招标公告ID */
    @Excel(name = "招标公告ID")
    private Long tenderNoticeId;

    /** 附件地址 */
    @Excel(name = "附件地址")
    private String noticeAddress;

    /** 上传当前时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传当前时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uploadTime;

    /** 上传人 */
    @Excel(name = "上传人")
    private Long uploadBy;

    public void setNoticeTextId(Long noticeTextId) 
    {
        this.noticeTextId = noticeTextId;
    }

    public Long getNoticeTextId() 
    {
        return noticeTextId;
    }
    public void setTenderNoticeId(Long tenderNoticeId) 
    {
        this.tenderNoticeId = tenderNoticeId;
    }

    public Long getTenderNoticeId() 
    {
        return tenderNoticeId;
    }
    public void setNoticeAddress(String noticeAddress) 
    {
        this.noticeAddress = noticeAddress;
    }

    public String getNoticeAddress() 
    {
        return noticeAddress;
    }
    public void setUploadTime(Date uploadTime) 
    {
        this.uploadTime = uploadTime;
    }

    public Date getUploadTime() 
    {
        return uploadTime;
    }
    public void setUploadBy(Long uploadBy) 
    {
        this.uploadBy = uploadBy;
    }

    public Long getUploadBy() 
    {
        return uploadBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("noticeTextId", getNoticeTextId())
            .append("tenderNoticeId", getTenderNoticeId())
            .append("noticeAddress", getNoticeAddress())
            .append("uploadTime", getUploadTime())
            .append("uploadBy", getUploadBy())
            .toString();
    }
}
