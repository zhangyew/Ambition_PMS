package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicSuppliedMaterialsMapper;
import com.ruoyi.system.api.domain.PublicSuppliedMaterials;
import com.yz.bidding.service.IPublicSuppliedMaterialsService;

/**
 * 供应商供货物料表Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicSuppliedMaterialsServiceImpl implements IPublicSuppliedMaterialsService 
{
    @Autowired
    private PublicSuppliedMaterialsMapper publicSuppliedMaterialsMapper;

    /**
     * 查询供应商供货物料表
     * 
     * @param suppliedMaterialsId 供应商供货物料表主键
     * @return 供应商供货物料表
     */
    @Override
    public PublicSuppliedMaterials selectPublicSuppliedMaterialsBySuppliedMaterialsId(Long suppliedMaterialsId)
    {
        return publicSuppliedMaterialsMapper.selectPublicSuppliedMaterialsBySuppliedMaterialsId(suppliedMaterialsId);
    }

    /**
     * 查询供应商供货物料表列表
     * 
     * @param publicSuppliedMaterials 供应商供货物料表
     * @return 供应商供货物料表
     */
    @Override
    public List<PublicSuppliedMaterials> selectPublicSuppliedMaterialsList(PublicSuppliedMaterials publicSuppliedMaterials)
    {
        return publicSuppliedMaterialsMapper.selectPublicSuppliedMaterialsList(publicSuppliedMaterials);
    }

    /**
     * 新增供应商供货物料表
     * 
     * @param publicSuppliedMaterials 供应商供货物料表
     * @return 结果
     */
    @Override
    public int insertPublicSuppliedMaterials(PublicSuppliedMaterials publicSuppliedMaterials)
    {
        return publicSuppliedMaterialsMapper.insertPublicSuppliedMaterials(publicSuppliedMaterials);
    }

    /**
     * 修改供应商供货物料表
     * 
     * @param publicSuppliedMaterials 供应商供货物料表
     * @return 结果
     */
    @Override
    public int updatePublicSuppliedMaterials(PublicSuppliedMaterials publicSuppliedMaterials)
    {
        return publicSuppliedMaterialsMapper.updatePublicSuppliedMaterials(publicSuppliedMaterials);
    }

    /**
     * 批量删除供应商供货物料表
     * 
     * @param suppliedMaterialsIds 需要删除的供应商供货物料表主键
     * @return 结果
     */
    @Override
    public int deletePublicSuppliedMaterialsBySuppliedMaterialsIds(Long[] suppliedMaterialsIds)
    {
        return publicSuppliedMaterialsMapper.deletePublicSuppliedMaterialsBySuppliedMaterialsIds(suppliedMaterialsIds);
    }

    /**
     * 删除供应商供货物料表信息
     * 
     * @param suppliedMaterialsId 供应商供货物料表主键
     * @return 结果
     */
    @Override
    public int deletePublicSuppliedMaterialsBySuppliedMaterialsId(Long suppliedMaterialsId)
    {
        return publicSuppliedMaterialsMapper.deletePublicSuppliedMaterialsBySuppliedMaterialsId(suppliedMaterialsId);
    }
}
