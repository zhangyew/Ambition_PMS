package com.yz.bidding.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 标书下载记录表对象 bidding_download_logs
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public class BiddingDownloadLogs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long downloadLogsId;

    /** 公告主键 */
    @Excel(name = "公告主键")
    private Long noticeTextId;

    /** 投标人名称 */
    @Excel(name = "投标人名称")
    private String tenderName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contact;

    /** 移动电话 */
    @Excel(name = "移动电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 下载时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下载时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date downloadTime;

    /** 删除 */
    @Excel(name = "删除")
    private Long isDelete;

    public void setDownloadLogsId(Long downloadLogsId) 
    {
        this.downloadLogsId = downloadLogsId;
    }

    public Long getDownloadLogsId() 
    {
        return downloadLogsId;
    }
    public void setNoticeTextId(Long noticeTextId) 
    {
        this.noticeTextId = noticeTextId;
    }

    public Long getNoticeTextId() 
    {
        return noticeTextId;
    }
    public void setTenderName(String tenderName) 
    {
        this.tenderName = tenderName;
    }

    public String getTenderName() 
    {
        return tenderName;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setDownloadTime(Date downloadTime) 
    {
        this.downloadTime = downloadTime;
    }

    public Date getDownloadTime() 
    {
        return downloadTime;
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
            .append("downloadLogsId", getDownloadLogsId())
            .append("noticeTextId", getNoticeTextId())
            .append("tenderName", getTenderName())
            .append("contact", getContact())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("downloadTime", getDownloadTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
