package com.yz.shopping.mapper;

import java.util.List;
import com.ruoyi.system.api.domain.PublicWarehouse;
import org.apache.ibatis.annotations.Param;

/**
 * 仓库Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicWarehouseMapper 
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
     * 删除仓库
     * 
     * @param warehouseId 仓库主键
     * @return 结果
     */
    public int deletePublicWarehouseByWarehouseId(Long warehouseId);

    /**
     * 批量删除仓库
     * 
     * @param warehouseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicWarehouseByWarehouseIds(Long[] warehouseIds);
}
