package com.yz.bidding.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.system.api.domain.PublicAnnex;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 投标对象 bidding_tender
 *
 * @author zhangye
 * @date 2023-11-21
 */
public class BiddingTender extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long tenderId;

    /**
     * 招标公告ID
     */
    @Excel(name = "招标公告ID")
    private Long tenderNoticeId;

    /**
     * 供应商（外键）
     */
    @Excel(name = "供应商", readConverterExp = "外=键")
    private Long tenderSupplierId;

    /**
     * 供应商名称
     */
    @Excel(name = "供应商名称")
    private String tenderSupplierName;

    /**
     * 投标人名称
     */
    @Excel(name = "投标人名称")
    private String tenderName;

    /**
     * 联系人
     */
    @Excel(name = "联系人")
    private String contact;

    /**
     * 移动电话
     */
    @Excel(name = "移动电话")
    private String phone;

    /**
     * 投标时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "投标时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tenderTime;

    /**
     * IP地址
     */
    @Excel(name = "IP地址")
    private String ipAddress;

    /**
     * 总价
     */
    @Excel(name = "总价")
    private Long prices;

    /**
     * 评分表地址
     */
    @Excel(name = "评分表地址")
    private String score;

    /**
     * 是否推荐
     */
    @Excel(name = "是否推荐")
    private Long recommend;

    /**
     * 排名
     */
    @Excel(name = "排名")
    private Long ranking;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long state;

    /**
     * 标书文件地址外键
     */
    @Excel(name = "标书文件地址外键")
    private String tenderAnnexId;

    private PublicAnnex publicAnnex;

    public String getTenderAnnexId() {
        return tenderAnnexId;
    }

    public BiddingTender setTenderAnnexId(String tenderAnnexId) {
        this.tenderAnnexId = tenderAnnexId;
        return this;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public PublicAnnex getPublicAnnex() {
        return publicAnnex;
    }

    public BiddingTender setPublicAnnex(PublicAnnex publicAnnex) {
        this.publicAnnex = publicAnnex;
        return this;
    }

    public void setTenderId(Long tenderId) {
        this.tenderId = tenderId;
    }

    public Long getTenderId() {
        return tenderId;
    }

    public void setTenderNoticeId(Long tenderNoticeId) {
        this.tenderNoticeId = tenderNoticeId;
    }

    public Long getTenderNoticeId() {
        return tenderNoticeId;
    }

    public void setTenderSupplierId(Long tenderSupplierId) {
        this.tenderSupplierId = tenderSupplierId;
    }

    public Long getTenderSupplierId() {
        return tenderSupplierId;
    }

    public void setTenderSupplierName(String tenderSupplierName) {
        this.tenderSupplierName = tenderSupplierName;
    }

    public String getTenderSupplierName() {
        return tenderSupplierName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setTenderTime(Date tenderTime) {
        this.tenderTime = tenderTime;
    }

    public Date getTenderTime() {
        return tenderTime;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setPrices(Long prices) {
        this.prices = prices;
    }

    public Long getPrices() {
        return prices;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setRecommend(Long recommend) {
        this.recommend = recommend;
    }

    public Long getRecommend() {
        return recommend;
    }

    public void setRanking(Long ranking) {
        this.ranking = ranking;
    }

    public Long getRanking() {
        return ranking;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getState() {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("tenderId", getTenderId())
                .append("tenderNoticeId", getTenderNoticeId())
                .append("tenderSupplierId", getTenderSupplierId())
                .append("tenderSupplierName", getTenderSupplierName())
                .append("tenderName", getTenderName())
                .append("contact", getContact())
                .append("phone", getPhone())
                .append("tenderTime", getTenderTime())
                .append("ipAddress", getIpAddress())
                .append("prices", getPrices())
                .append("score", getScore())
                .append("recommend", getRecommend())
                .append("ranking", getRanking())
                .append("state", getState())
                .append("tenderAnnexId", getTenderAnnexId())
                .toString();
    }
}
