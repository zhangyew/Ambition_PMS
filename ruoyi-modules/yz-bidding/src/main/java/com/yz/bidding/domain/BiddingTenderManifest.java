package com.yz.bidding.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 招标项目详情对象 bidding_tender_manifest
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public class BiddingTenderManifest extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键（招标详情表） */
    private Long tenderManifestId;

    /** 招标项目（外键） */
    @Excel(name = "招标项目", readConverterExp = "外=键")
    private Long manifestProjectsId;

    /** 物料（外键键） */
    @Excel(name = "物料", readConverterExp = "外=键键")
    private Long manifestGoodsId;

    /** 申请编号 */
    @Excel(name = "申请编号")
    private String number;

    /** 招标类型（数据字典外键） */
    @Excel(name = "招标类型", readConverterExp = "数=据字典外键")
    private Long manifestTypeId;

    /** 单价 */
    @Excel(name = "单价")
    private Long price;

    /** 总价 */
    @Excel(name = "总价")
    private Long prices;

    /** 需求 */
    @Excel(name = "需求")
    private String explains;

    /** 删除 */
    @Excel(name = "删除")
    private Long isDelete;

    public void setTenderManifestId(Long tenderManifestId) 
    {
        this.tenderManifestId = tenderManifestId;
    }

    public Long getTenderManifestId() 
    {
        return tenderManifestId;
    }
    public void setManifestProjectsId(Long manifestProjectsId) 
    {
        this.manifestProjectsId = manifestProjectsId;
    }

    public Long getManifestProjectsId() 
    {
        return manifestProjectsId;
    }
    public void setManifestGoodsId(Long manifestGoodsId) 
    {
        this.manifestGoodsId = manifestGoodsId;
    }

    public Long getManifestGoodsId() 
    {
        return manifestGoodsId;
    }
    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getNumber() 
    {
        return number;
    }
    public void setManifestTypeId(Long manifestTypeId) 
    {
        this.manifestTypeId = manifestTypeId;
    }

    public Long getManifestTypeId() 
    {
        return manifestTypeId;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setPrices(Long prices) 
    {
        this.prices = prices;
    }

    public Long getPrices() 
    {
        return prices;
    }
    public void setExplains(String explain)
    {
        this.explains = explain;
    }

    public String getExplains()
    {
        return explains;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tenderManifestId", getTenderManifestId())
            .append("manifestProjectsId", getManifestProjectsId())
            .append("manifestGoodsId", getManifestGoodsId())
            .append("number", getNumber())
            .append("manifestTypeId", getManifestTypeId())
            .append("price", getPrice())
            .append("prices", getPrices())
            .append("explain", getExplains())
            .append("remark", getRemark())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
