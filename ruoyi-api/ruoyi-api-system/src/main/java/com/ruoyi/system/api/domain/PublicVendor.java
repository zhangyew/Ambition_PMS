package com.ruoyi.system.api.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 供应商对象 public_vendor
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicVendor extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 供应商ID
     */
    private Long vendorId;

    /**
     * 供应商编号
     */
    @Excel(name = "供应商编号")
    private String vendorNumber;

    /**
     * 简称
     */
    @Excel(name = "简称")
    private String abbreviated;

    /**
     * 级别
     */
    @Excel(name = "级别")
    private Long level;

    /**
     * 字典类型（外键）
     */
    @Excel(name = "字典类型", readConverterExp = "外=键")
    private Long contractTypeTypeId;

    /**
     * 状态（字典类型外键）
     */
    @Excel(name = "状态", readConverterExp = "字=典类型外键")
    private Long vendorTypeStateId;

    /**
     * 是否进黑名单
     */
    @Excel(name = "是否进黑名单")
    private Long isBlacklist;

    /**
     * 服务范围
     */
    @Excel(name = "服务范围")
    private String ranges;

    /**
     * 原因
     */
    @Excel(name = "原因")
    private String causes;

    /**
     * 仓库地址
     */
    @Excel(name = "仓库地址")
    private String warehouseAddress;

    /**
     * 简介
     */
    @Excel(name = "简介")
    private String profile;

    /**
     * 法定代表
     */
    @Excel(name = "法定代表")
    private String delegates;

    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;

    /**
     * 传真
     */
    @Excel(name = "传真")
    private String fax;

    /**
     * 负责人
     */
    @Excel(name = "负责人")
    private String responsible;

    /**
     * 负责人手机
     */
    @Excel(name = "负责人手机")
    private String responsiblePhone;

    /**
     * 工商注册号
     */
    @Excel(name = "工商注册号")
    private String industrialCommercial;

    /**
     * 供应商信息是否存在
     */
    @Excel(name = "供应商信息是否存在")
    private Long isExist;

    /**
     * 删除
     */
    @Excel(name = "删除")
    private Long isDelete;

    @Excel(name = "供应商联系人")
    private PublicContacts publicContacts;

    @Excel(name = "供应商资质")
    private List<PublicQualification> publicQualificationList;


    public PublicContacts getPublicContacts() {
        return publicContacts;
    }

    public PublicVendor setPublicContacts(PublicContacts publicContacts) {
        this.publicContacts = publicContacts;
        return this;
    }

    public List<PublicQualification> getPublicQualificationList() {
        return publicQualificationList;
    }

    public PublicVendor setPublicQualificationList(List<PublicQualification> publicQualificationList) {
        this.publicQualificationList = publicQualificationList;
        return this;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorNumber(String vendorNumber) {
        this.vendorNumber = vendorNumber;
    }

    public String getVendorNumber() {
        return vendorNumber;
    }

    public void setAbbreviated(String abbreviated) {
        this.abbreviated = abbreviated;
    }

    public String getAbbreviated() {
        return abbreviated;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getLevel() {
        return level;
    }

    public void setContractTypeTypeId(Long contractTypeTypeId) {
        this.contractTypeTypeId = contractTypeTypeId;
    }

    public Long getContractTypeTypeId() {
        return contractTypeTypeId;
    }

    public void setVendorTypeStateId(Long vendorTypeStateId) {
        this.vendorTypeStateId = vendorTypeStateId;
    }

    public Long getVendorTypeStateId() {
        return vendorTypeStateId;
    }

    public void setIsBlacklist(Long isBlacklist) {
        this.isBlacklist = isBlacklist;
    }

    public Long getIsBlacklist() {
        return isBlacklist;
    }

    public void setRanges(String ranges) {
        this.ranges = ranges;
    }

    public String getRanges() {
        return ranges;
    }

    public void setCauses(String causes) {
        this.causes = causes;
    }

    public String getCauses() {
        return causes;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }

    public void setDelegates(String delegates) {
        this.delegates = delegates;
    }

    public String getDelegates() {
        return delegates;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() {
        return fax;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsiblePhone(String responsiblePhone) {
        this.responsiblePhone = responsiblePhone;
    }

    public String getResponsiblePhone() {
        return responsiblePhone;
    }

    public void setIndustrialCommercial(String industrialCommercial) {
        this.industrialCommercial = industrialCommercial;
    }

    public String getIndustrialCommercial() {
        return industrialCommercial;
    }

    public void setIsExist(Long isExist) {
        this.isExist = isExist;
    }

    public Long getIsExist() {
        return isExist;
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
                .append("vendorId", getVendorId())
                .append("vendorNumber", getVendorNumber())
                .append("abbreviated", getAbbreviated())
                .append("level", getLevel())
                .append("contractTypeTypeId", getContractTypeTypeId())
                .append("vendorTypeStateId", getVendorTypeStateId())
                .append("isBlacklist", getIsBlacklist())
                .append("ranges", getRanges())
                .append("causes", getCauses())
                .append("warehouseAddress", getWarehouseAddress())
                .append("profile", getProfile())
                .append("delegates", getDelegates())
                .append("addTime", getAddTime())
                .append("email", getEmail())
                .append("fax", getFax())
                .append("responsible", getResponsible())
                .append("responsiblePhone", getResponsiblePhone())
                .append("industrial Commercial", getIndustrialCommercial())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("isExist", getIsExist())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
