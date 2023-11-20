package com.yz.shopping.service;

import java.util.List;
import com.ruoyi.system.api.domain.PublicWarehouse;

/**
 * 仓库Service接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface IPublicWarehouseService 
{
    /**
     * 查询仓库
     * 
     * @param warehouseId 仓库主键
     * @return 仓库
     */
    public PublicWarehouse selectPublicWarehouseByWarehouseId(Long warehouseId);

    /**
     * 查询仓库列表
     * 
     * @param publicWarehouse 仓库
     * @return 仓库集合
     */
    public List<PublicWarehouse> selectPublicWarehouseList(PublicWarehouse publicWarehouse);

    /**
     * 新增仓库
     * 
     * @param publicWarehouse 仓库
     * @return 结果
     */
    public int insertPublicWarehouse(PublicWarehouse publicWarehouse);

    /**
     * 修改仓库
     * 
     * @param publicWarehouse 仓库
     * @return 结果
     */
    public int updatePublicWarehouse(PublicWarehouse publicWarehouse);

    /**
     * 批量删除仓库
     * 
     * @param warehouseIds 需要删除的仓库主键集合
     * @return 结果
     */
    public int deletePublicWarehouseByWarehouseIds(Long[] warehouseIds);

    /**
     * 删除仓库信息
     * 
     * @param warehouseId 仓库主键
     * @return 结果
     */
    public int deletePublicWarehouseByWarehouseId(Long warehouseId);
}
