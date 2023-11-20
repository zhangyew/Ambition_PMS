package com.ruoyi.system.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 专家库对象 public_expert_pool
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicExpertPool extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long expertPoolId;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String expertPoolName;

    /**
     * 性别
     */
    @Excel(name = "性别")
    private Long sex;

    /**
     * 级别
     */
    @Excel(name = "级别")
    private Long level;

    /**
     * 类型
     */
    @Excel(name = "类型")
    private Long type;

    /**
     * 类别
     */
    @Excel(name = "类别")
    private Long category;

    /**
     * 固定电话
     */
    @Excel(name = "固定电话")
    private String landline;

    /**
     * 移动电话
     */
    @Excel(name = "移动电话")
    private String phone;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;

    /**
     * 删除
     */
    @Excel(name = "删除")
    private Long isDelete;

    public void setExpertPoolId(Long expertPoolId) {
        this.expertPoolId = expertPoolId;
    }

    public Long getExpertPoolId() {
        return expertPoolId;
    }

    public void setExpertPoolName(String expertPoolName) {
        this.expertPoolName = expertPoolName;
    }

    public String getExpertPoolName() {
        return expertPoolName;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public Long getSex() {
        return sex;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getLevel() {
        return level;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getType() {
        return type;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getCategory() {
        return category;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getLandline() {
        return landline;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
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
                .append("expertPoolId", getExpertPoolId())
                .append("expertPoolName", getExpertPoolName())
                .append("sex", getSex())
                .append("level", getLevel())
                .append("type", getType())
                .append("category", getCategory())
                .append("landline", getLandline())
                .append("phone", getPhone())
                .append("email", getEmail())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
