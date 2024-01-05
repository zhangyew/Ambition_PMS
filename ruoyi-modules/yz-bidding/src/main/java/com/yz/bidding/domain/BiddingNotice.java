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

    /** 公示编号 */
    @Excel(name = "公示编号")
    private String noticeClod;

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

    @Excel(name = "招标项目外键")
    private Long noticeProjectId;

    public Long getNoticeProjectId() {
        return noticeProjectId;
    }

    public void setNoticeProjectId(Long noticeProjectId) {
        this.noticeProjectId = noticeProjectId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNoticeClod() {
        return noticeClod;
    }

    public BiddingNotice setNoticeClod(String noticeClod) {
        this.noticeClod = noticeClod;
        return this;
    }

    @Override
    public String toString() {
        return "BiddingNotice{" +
                "noticeId=" + noticeId +
                ", tenderNoticeId=" + tenderNoticeId +
                ", noticeDate=" + noticeDate +
                ", noticeClod=" + noticeClod +
                ", buyer='" + buyer + '\'' +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContext='" + noticeContext + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", bidMoney=" + bidMoney +
                ", noticeProjectId=" + noticeProjectId +
                ", noticeSupplierId=" + noticeSupplierId +
                '}';
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Excel(name = "供应商")
    private String vendorName;

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

}
