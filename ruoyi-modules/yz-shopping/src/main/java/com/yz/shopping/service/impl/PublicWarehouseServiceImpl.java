package com.yz.shopping.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.PublicWarehouseMapper;
import com.ruoyi.system.api.domain.PublicWarehouse;
import com.yz.shopping.service.IPublicWarehouseService;

/**
 * 仓库Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicWarehouseServiceImpl implements IPublicWarehouseService 
{
    @Autowired
    private PublicWarehouseMapper publicWarehouseMapper;

    /**
     * 查询仓库
     * 
     * @param warehouseId 仓库主键
     * @return 仓库
     */
    @Override
    public PublicWarehouse selectPublicWarehouseByWarehouseId(Long warehouseId)
    {
        return publicWarehouseMapper.selectPublicWarehouseByWarehouseId(warehouseId);
    }

    /**
     * 查询仓库列表
     * 
     * @param publicWarehouse 仓库
     * @return 仓库
     */
    @Override
    public List<PublicWarehouse> selectPublicWarehouseList(PublicWarehouse publicWarehouse)
    {
        return publicWarehouseMapper.selectPublicWarehouseList(publicWarehouse);
    }

    /**
     * 新增仓库
     * 
     * @param publicWarehouse 仓库
     * @return 结果
     */
    @Override
    public int insertPublicWarehouse(PublicWarehouse publicWarehouse)
    {
        return publicWarehouseMapper.insertPublicWarehouse(publicWarehouse);
    }

    /**
     * 修改仓库
     * 
     * @param publicWarehouse 仓库
     * @return 结果
     */
    @Override
    public int updatePublicWarehouse(PublicWarehouse publicWarehouse)
    {
        return publicWarehouseMapper.updatePublicWarehouse(publicWarehouse);
    }

    /**
     * 批量删除仓库
     * 
     * @param warehouseIds 需要删除的仓库主键
     * @return 结果
     */
    @Override
    public int deletePublicWarehouseByWarehouseIds(Long[] warehouseIds)
    {
        return publicWarehouseMapper.deletePublicWarehouseByWarehouseIds(warehouseIds);
    }

    /**
     * 删除仓库信息
     * 
     * @param warehouseId 仓库主键
     * @return 结果
     */
    @Override
    public int deletePublicWarehouseByWarehouseId(Long warehouseId)
    {
        return publicWarehouseMapper.deletePublicWarehouseByWarehouseId(warehouseId);
    }
}
