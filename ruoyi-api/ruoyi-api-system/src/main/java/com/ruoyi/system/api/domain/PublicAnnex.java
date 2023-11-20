package com.ruoyi.system.api.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 公告附件对象 public_annex
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicAnnex extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 附件id
     */
    private Long annexId;

    /**
     * 主键编号
     */
    @Excel(name = "主键编号")
    private Long supplyId;

    /**
     * 附件类型
     */
    @Excel(name = "附件类型")
    private Long annexTypeId;

    /**
     * 附件正文
     */
    @Excel(name = "附件正文")
    private String annexText;

    /**
     * 附件url
     */
    @Excel(name = "附件url")
    private String annexUrl;

    /**
     * 上传时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date upTime;

    /**
     * 附件标题
     */
    @Excel(name = "附件标题")
    private String annexTitle;

    public void setAnnexId(Long annexId) {
        this.annexId = annexId;
    }

    public Long getAnnexId() {
        return annexId;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setAnnexTypeId(Long annexTypeId) {
        this.annexTypeId = annexTypeId;
    }

    public Long getAnnexTypeId() {
        return annexTypeId;
    }

    public void setAnnexText(String annexText) {
        this.annexText = annexText;
    }

    public String getAnnexText() {
        return annexText;
    }

    public void setAnnexUrl(String annexUrl) {
        this.annexUrl = annexUrl;
    }

    public String getAnnexUrl() {
        return annexUrl;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setAnnexTitle(String annexTitle) {
        this.annexTitle = annexTitle;
    }

    public String getAnnexTitle() {
        return annexTitle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("annexId", getAnnexId())
                .append("supplyId", getSupplyId())
                .append("annexTypeId", getAnnexTypeId())
                .append("annexText", getAnnexText())
                .append("annexUrl", getAnnexUrl())
                .append("upTime", getUpTime())
                .append("annexTitle", getAnnexTitle())
                .toString();
    }
}
