package com.yz.bidding.mapper;

import java.util.List;
import com.ruoyi.system.api.domain.PublicSuppliedMaterials;

/**
 * 供应商供货物料表Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicSuppliedMaterialsMapper 
{
    /**
     * 查询供应商供货物料表
     * 
     * @param suppliedMaterialsId 供应商供货物料表主键
     * @return 供应商供货物料表
     */
    public PublicSuppliedMaterials selectPublicSuppliedMaterialsBySuppliedMaterialsId(Long suppliedMaterialsId);

    /**
     * 查询供应商供货物料表列表
     * 
     * @param publicSuppliedMaterials 供应商供货物料表
     * @return 供应商供货物料表集合
     */
    public List<PublicSuppliedMaterials> selectPublicSuppliedMaterialsList(PublicSuppliedMaterials publicSuppliedMaterials);

    /**
     * 新增供应商供货物料表
     * 
     * @param publicSuppliedMaterials 供应商供货物料表
     * @return 结果
     */
    public int insertPublicSuppliedMaterials(PublicSuppliedMaterials publicSuppliedMaterials);

    /**
     * 修改供应商供货物料表
     * 
     * @param publicSuppliedMaterials 供应商供货物料表
     * @return 结果
     */
    public int updatePublicSuppliedMaterials(PublicSuppliedMaterials publicSuppliedMaterials);

    /**
     * 删除供应商供货物料表
     * 
     * @param suppliedMaterialsId 供应商供货物料表主键
     * @return 结果
     */
    public int deletePublicSuppliedMaterialsBySuppliedMaterialsId(Long suppliedMaterialsId);

    /**
     * 批量删除供应商供货物料表
     * 
     * @param suppliedMaterialsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicSuppliedMaterialsBySuppliedMaterialsIds(Long[] suppliedMaterialsIds);
}
