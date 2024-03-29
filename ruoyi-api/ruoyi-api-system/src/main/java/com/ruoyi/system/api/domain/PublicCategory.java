package com.ruoyi.system.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.util.List;

/**
 * 物料类别对象 public_category
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicCategory extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 类别ID
     */
    private Long categoryId;

    /**
     * 类别编码，用户自定义
     */
    @Excel(name = "类别编码，用户自定义")
    private String categoryNumber;


    /** 类别名称 */
    @Excel(name = "类别名称")
    private String categoryName;

    /**
     * 上级品类
     */
    @Excel(name = "上级品类")
    private Long parentCategory;

    /**
     * 删除
     */
    @Excel(name = "删除")
    private Long isDelete;

    /**
     * 二级分类
     */
    private List<PublicCategory> list;

    public List<PublicCategory> getList() {
        return list;
    }

    public void setList(List<PublicCategory> list) {
        this.list = list;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryNumber(String categoryNumber) {
        this.categoryNumber = categoryNumber;
    }

    public String getCategoryNumber() {
        return categoryNumber;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setParentCategory(Long parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Long getParentCategory() {
        return parentCategory;
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
                .append("categoryId", getCategoryId())
                .append("categoryNumber", getCategoryNumber())
                .append("categoryNumber", getCategoryName())
                .append("parentCategory", getParentCategory())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
