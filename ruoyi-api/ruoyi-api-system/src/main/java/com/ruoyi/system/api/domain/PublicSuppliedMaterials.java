package com.ruoyi.system.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 供应商供货物料表对象 public_supplied_materials
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicSuppliedMaterials extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 供货物料表id
     */
    private Long suppliedMaterialsId;

    /**
     * 供货表编号（外键）
     */
    @Excel(name = "供货表编号", readConverterExp = "外=键")
    private Long supplyId;

    /**
     * 是否可供
     */
    @Excel(name = "是否可供")
    private Long available;

    /**
     * 物料id
     */
    @Excel(name = "物料id")
    private Long demandMaId;

    /**
     * 是否免检
     */
    @Excel(name = "是否免检")
    private Long exempt;

    /**
     * 供货能力等级
     */
    @Excel(name = "供货能力等级")
    private Long grade;

    public void setSuppliedMaterialsId(Long suppliedMaterialsId) {
        this.suppliedMaterialsId = suppliedMaterialsId;
    }

    public Long getSuppliedMaterialsId() {
        return suppliedMaterialsId;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public Long getAvailable() {
        return available;
    }

    public void setDemandMaId(Long demandMaId) {
        this.demandMaId = demandMaId;
    }

    public Long getDemandMaId() {
        return demandMaId;
    }

    public void setExempt(Long exempt) {
        this.exempt = exempt;
    }

    public Long getExempt() {
        return exempt;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public Long getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("suppliedMaterialsId", getSuppliedMaterialsId())
                .append("supplyId", getSupplyId())
                .append("available", getAvailable())
                .append("demandMaId", getDemandMaId())
                .append("exempt", getExempt())
                .append("grade", getGrade())
                .toString();
    }
}
