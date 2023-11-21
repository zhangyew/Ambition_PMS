package com.ruoyi.system.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 仓库对象 public_warehouse
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicWarehouse extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 仓库ID
     */
    private Long warehouseId;

    /**
     * 仓库地址
     */
    @Excel(name = "仓库地址")
    private String warehouseAddress;

    /**
     * 仓库编码
     */
    @Excel(name = "仓库编码")
    private String warehouseNumber;

    /**
     * 仓库名称
     */
    @Excel(name = "仓库名称")
    private String warehouseName;

    @Excel(name = "仓库名称")
    private String warehouseName;


    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseNumber(String warehouseNumber) {
        this.warehouseNumber = warehouseNumber;
    }

    public String getWarehouseNumber() {
        return warehouseNumber;
    }
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public PublicWarehouse setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("warehouseId", getWarehouseId())
                .append("warehouseAddress", getWarehouseAddress())
                .append("warehouseNumber", getWarehouseNumber())
                .append("warehouseName", getWarehouseName())
                .toString();
    }
}
