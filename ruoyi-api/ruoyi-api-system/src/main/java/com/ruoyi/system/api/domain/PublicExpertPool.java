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
     * 库名
     */
    @Excel(name = "库名")
    private String expertPoolName;

    /**
     * 级别
     */
    @Excel(name = "级别")
    private Long level;

    /**
     * 类别
     */
    @Excel(name = "类别")
    private Long category;

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

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getLevel() {
        return level;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getCategory() {
        return category;
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
                .append("level", getLevel())
                .append("category", getCategory())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
