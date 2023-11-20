package com.ruoyi.system.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 供应商供货表对象 public_supply
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicSupply extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 供货ID（主键）
     */
    private Long supplyId;

    /**
     * 供应商主键
     */
    @Excel(name = "供应商主键")
    private Long supplyVendorId;

    /**
     * 供应商编码
     */
    @Excel(name = "供应商编码")
    private String supplierCode;

    /**
     * 供应商名称
     */
    @Excel(name = "供应商名称")
    private String supplierName;

    /**
     * 删除
     */
    @Excel(name = "删除")
    private Long isDelete;

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setSupplyVendorId(Long supplyVendorId) {
        this.supplyVendorId = supplyVendorId;
    }

    public Long getSupplyVendorId() {
        return supplyVendorId;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
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
                .append("supplyId", getSupplyId())
                .append("supplyVendorId", getSupplyVendorId())
                .append("supplierCode", getSupplierCode())
                .append("supplierName", getSupplierName())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
