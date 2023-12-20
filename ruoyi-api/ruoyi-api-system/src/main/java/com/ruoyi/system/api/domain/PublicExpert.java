package com.ruoyi.system.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 专家对象 public_expert
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicExpert extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long expertId;

    /**
     * 专家库主键
     */
    @Excel(name = "专家库主键")
    private Long poolId;

    /**
     * 专家姓名
     */
    @Excel(name = "专家姓名")
    private String name;

    /**
     * 专家身份证
     */
    @Excel(name = "专家身份证")
    private String idCard;

    /**
     * 区域
     */
    @Excel(name = "区域")
    private String address;

    /**
     * 移动电话
     */
    @Excel(name = "移动电话")
    private String phone;

    /**
     * 删除
     */
    @Excel(name = "删除")
    private Long isDelete;

    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    public Long getExpertId() {
        return expertId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
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
                .append("expertId", getExpertId())
                .append("poolId", getPoolId())
                .append("name", getName())
                .append("idCard", getIdCard())
                .append("address", getAddress())
                .append("phone", getPhone())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
