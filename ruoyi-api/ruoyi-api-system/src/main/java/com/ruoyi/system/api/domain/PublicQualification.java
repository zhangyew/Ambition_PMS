package com.ruoyi.system.api.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 供应商资质对象 public_qualification
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicQualification extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 资质表ID
     */
    private Long qualificationId;

    /**
     * 供应商ID（外键）
     */
    @Excel(name = "供应商ID", readConverterExp = "外=键")
    private Long qualificationVendorId;

    /**
     * 资质名称
     */
    @Excel(name = "资质名称")
    private String qualificationName;

    /**
     * 有效期起
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效期起", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 有效期终
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效期终", width = 30, dateFormat = "yyyy-MM-dd")
    private Date stopTime;

    /**
     * 资质证件
     */
    @Excel(name = "资质证件")
    private String documents;

    /**
     * 删除
     */
    @Excel(name = "删除")
    private Long isDelete;

    public void setQualificationId(Long qualificationId) {
        this.qualificationId = qualificationId;
    }

    public Long getQualificationId() {
        return qualificationId;
    }

    public void setQualificationVendorId(Long qualificationVendorId) {
        this.qualificationVendorId = qualificationVendorId;
    }

    public Long getQualificationVendorId() {
        return qualificationVendorId;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getDocuments() {
        return documents;
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
                .append("qualificationId", getQualificationId())
                .append("qualificationVendorId", getQualificationVendorId())
                .append("qualificationName", getQualificationName())
                .append("startTime", getStartTime())
                .append("stopTime", getStopTime())
                .append("documents", getDocuments())
                .append("remark", getRemark())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
