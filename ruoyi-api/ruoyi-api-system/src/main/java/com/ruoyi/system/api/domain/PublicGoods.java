package com.ruoyi.system.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 物料对象 public_goods
 *
 * @author zhangye
 * @date 2023-11-20
 */
public class PublicGoods extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 物料ID
     */
    private Long goodsId;

    /**
     * 类别ID
     */
    @Excel(name = "类别ID")
    private Long categoryId;

    /**
     * 商品名称
     */
    @Excel(name = "商品名称")
    private String goodsName;

    /**
     * 字典外键
     */
    @Excel(name = "字典外键")
    private Long goodsType;

    /**
     * 规格
     */
    @Excel(name = "规格")
    private String specs;

    /**
     * 型号
     */
    @Excel(name = "型号")
    private String model;

    /**
     * 品牌
     */
    @Excel(name = "品牌")
    private String brand;

    /**
     * 重量单位
     */
    @Excel(name = "重量单位")
    private Long weight;

    /**
     * 商品数量
     */
    @Excel(name = "商品数量")
    private Long goodsNumber;

    /**
     * 体积单位
     */
    @Excel(name = "体积单位")
    private Long volume;

    /**
     * 默认,远志集团有限公司
     */
    @Excel(name = " 默认,远志集团有限公司")
    private String buyer;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long state;

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsType(Long goodsType) {
        this.goodsType = goodsType;
    }

    public Long getGoodsType() {
        return goodsType;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getSpecs() {
        return specs;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getWeight() {
        return weight;
    }

    public void setGoodsNumber(Long goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Long getGoodsNumber() {
        return goodsNumber;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Long getVolume() {
        return volume;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getState() {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("goodsId", getGoodsId())
                .append("categoryId", getCategoryId())
                .append("goodsName", getGoodsName())
                .append("goodsType", getGoodsType())
                .append("specs", getSpecs())
                .append("model", getModel())
                .append("brand", getBrand())
                .append("weight", getWeight())
                .append("goodsNumber", getGoodsNumber())
                .append("volume", getVolume())
                .append("buyer", getBuyer())
                .append("state", getState())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
