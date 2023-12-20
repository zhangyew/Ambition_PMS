package com.yz.bidding.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 抽取专家对象 bidding_draw_experts
 *
 * @author zhangye
 * @date 2023-11-21
 */
public class BiddingDrawExperts extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long drawExpertsId;

    /**
     * 申请编号
     */
    @Excel(name = "申请编号")
    private String number;

    /**
     * 专家主键
     */
    @Excel(name = "专家主键")
    private Long drawExpertId;

    /**
     * 项目主键
     */
    @Excel(name = "项目主键")
    private Long drawProjectsId;

    /**
     * 资格审查方式
     */
    @Excel(name = "资格审查方式")
    private Integer must;

    /**
     * 抽取方式
     */
    @Excel(name = "抽取方式")
    private Long manner;

    /**
     * 抽取条件
     */
    @Excel(name = "抽取条件")
    private String conditions;

    /**
     * 回避专家
     */
    @Excel(name = "回避专家")
    private String evadeExperts;

    /**
     * 专家人数
     */
    @Excel(name = "专家人数")
    private Long expertsNumber;

    /**
     * 采购人数
     */
    @Excel(name = "采购人数")
    private Long buyNumber;

    /**
     * 评标地点
     */
    @Excel(name = "评标地点")
    private String address;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long state;

    /**
     * 删除
     */
    @Excel(name = "删除")
    private Long isDelete;

    public void setDrawExpertsId(Long drawExpertsId) {
        this.drawExpertsId = drawExpertsId;
    }

    public Long getDrawExpertsId() {
        return drawExpertsId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setDrawExpertId(Long drawExpertId) {
        this.drawExpertId = drawExpertId;
    }

    public Long getDrawExpertId() {
        return drawExpertId;
    }

    public void setDrawProjectsId(Long drawProjectsId) {
        this.drawProjectsId = drawProjectsId;
    }

    public Long getDrawProjectsId() {
        return drawProjectsId;
    }

    public void setMust(Integer must) {
        this.must = must;
    }

    public Integer getMust() {
        return must;
    }

    public void setManner(Long manner) {
        this.manner = manner;
    }

    public Long getManner() {
        return manner;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getConditions() {
        return conditions;
    }

    public void setEvadeExperts(String evadeExperts) {
        this.evadeExperts = evadeExperts;
    }

    public String getEvadeExperts() {
        return evadeExperts;
    }

    public void setExpertsNumber(Long expertsNumber) {
        this.expertsNumber = expertsNumber;
    }

    public Long getExpertsNumber() {
        return expertsNumber;
    }

    public void setBuyNumber(Long buyNumber) {
        this.buyNumber = buyNumber;
    }

    public Long getBuyNumber() {
        return buyNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getState() {
        return state;
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
                .append("drawExpertsId", getDrawExpertsId())
                .append("number", getNumber())
                .append("drawExpertId", getDrawExpertId())
                .append("drawProjectsId", getDrawProjectsId())
                .append("must", getMust())
                .append("manner", getManner())
                .append("conditions", getConditions())
                .append("evadeExperts", getEvadeExperts())
                .append("expertsNumber", getExpertsNumber())
                .append("buyNumber", getBuyNumber())
                .append("address", getAddress())
                .append("state", getState())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
