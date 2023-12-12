package com.yz.bidding.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 招标项目对象 bidding_tender_projects
 *
 * @author zhangye
 * @date 2023-11-21
 */
public class BiddingTenderProjects extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 项目ID
     */
    private Long tenderProjectsId;

    /**
     * 项目编号
     */
    @Excel(name = "项目编号")
    private String tenderProjectsNumber;

    /**
     * 项目名称
     */
    @Excel(name = "项目名称")
    private String tenderProjectsName;

    /**
     * 业务类型
     */
    @Excel(name = "业务类型")
    private Long projectsType;

    /**
     * 项目预算
     */
    @Excel(name = "项目预算")
    private Long tenderProjectsMoney;

    /**
     * 联系人
     */
    @Excel(name = "联系人")
    private String tenderProjectsContact;

    /**
     * 电话
     */
    @Excel(name = "电话")
    private String tenderProjectsPhone;

    /**
     * 地址
     */
    @Excel(name = "地址")
    private String tenderProjectsAddress;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String tenderProjectsEmail;

    /**
     * 招标方式
     */
    @Excel(name = "招标方式")
    private Long manner;

    /**
     * 审查表地址
     */
    @Excel(name = "审查表地址")
    private String censor;

    /**
     * 资格审查方式
     */
    @Excel(name = "资格审查方式")
    private Long must;

    /**
     * 审核状态
     */
    @Excel(name = "审核状态")
    private Long auditState;

    /**
     * 创建人
     */
    @Excel(name = "创建人")
    private String creatBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    /**
     * 删除
     */
    @Excel(name = "删除")
    private Long isDelete;

    private List<Map<String, Object>> list;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public BiddingTenderProjects setList(List<Map<String, Object>> list) {
        this.list = list;
        return this;
    }

    public void setTenderProjectsId(Long tenderProjectsId) {
        this.tenderProjectsId = tenderProjectsId;
    }

    public Long getTenderProjectsId() {
        return tenderProjectsId;
    }

    public void setTenderProjectsNumber(String tenderProjectsNumber) {
        this.tenderProjectsNumber = tenderProjectsNumber;
    }

    public String getTenderProjectsNumber() {
        return tenderProjectsNumber;
    }

    public void setTenderProjectsName(String tenderProjectsName) {
        this.tenderProjectsName = tenderProjectsName;
    }

    public String getTenderProjectsName() {
        return tenderProjectsName;
    }

    public void setProjectsType(Long projectsType) {
        this.projectsType = projectsType;
    }

    public Long getProjectsType() {
        return projectsType;
    }

    public void setTenderProjectsMoney(Long tenderProjectsMoney) {
        this.tenderProjectsMoney = tenderProjectsMoney;
    }

    public Long getTenderProjectsMoney() {
        return tenderProjectsMoney;
    }

    public void setTenderProjectsContact(String tenderProjectsContact) {
        this.tenderProjectsContact = tenderProjectsContact;
    }

    public String getTenderProjectsContact() {
        return tenderProjectsContact;
    }

    public void setTenderProjectsPhone(String tenderProjectsPhone) {
        this.tenderProjectsPhone = tenderProjectsPhone;
    }

    public String getTenderProjectsPhone() {
        return tenderProjectsPhone;
    }

    public void setTenderProjectsAddress(String tenderProjectsAddress) {
        this.tenderProjectsAddress = tenderProjectsAddress;
    }

    public String getTenderProjectsAddress() {
        return tenderProjectsAddress;
    }

    public void setTenderProjectsEmail(String tenderProjectsEmail) {
        this.tenderProjectsEmail = tenderProjectsEmail;
    }

    public String getTenderProjectsEmail() {
        return tenderProjectsEmail;
    }

    public void setManner(Long manner) {
        this.manner = manner;
    }

    public Long getManner() {
        return manner;
    }

    public void setCensor(String censor) {
        this.censor = censor;
    }

    public String getCensor() {
        return censor;
    }

    public void setMust(Long must) {
        this.must = must;
    }

    public Long getMust() {
        return must;
    }

    public void setAuditState(Long auditState) {
        this.auditState = auditState;
    }

    public Long getAuditState() {
        return auditState;
    }

    public void setCreatBy(String creatBy) {
        this.creatBy = creatBy;
    }

    public String getCreatBy() {
        return creatBy;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setIsDelete(Long isDelete) {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("tenderProjectsIds", getTenderProjectsId())
                .append("tenderProjectsNumber", getTenderProjectsNumber())
                .append("tenderProjectsName", getTenderProjectsName())
                .append("projectsType", getProjectsType())
                .append("tenderProjectsMoney", getTenderProjectsMoney())
                .append("tenderProjectsContact", getTenderProjectsContact())
                .append("tenderProjectsPhone", getTenderProjectsPhone())
                .append("tenderProjectsAddress", getTenderProjectsAddress())
                .append("tenderProjectsEmail", getTenderProjectsEmail())
                .append("remark", getRemark())
                .append("manner", getManner())
                .append("censor", getCensor())
                .append("must", getMust())
                .append("auditState", getAuditState())
                .append("creatBy", getCreatBy())
                .append("creatTime", getCreatTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
