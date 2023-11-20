package com.yz.pms.publics.service;

import java.util.List;
import com.ruoyi.system.api.domain.PublicCategory;

/**
 * 物料类别Service接口
 * 
 * @author zhangye
 * @date 2023-11-20
 */
public interface IPublicCategoryService 
{
    /**
     * 查询物料类别
     * 
     * @param categoryId 物料类别主键
     * @return 物料类别
     */
    public PublicCategory selectPublicCategoryByCategoryId(Long categoryId);

    /**
     * 查询物料类别列表
     * 
     * @param publicCategory 物料类别
     * @return 物料类别集合
     */
    public List<PublicCategory> selectPublicCategoryList(PublicCategory publicCategory);

    /**
     * 新增物料类别
     * 
     * @param publicCategory 物料类别
     * @return 结果
     */
    public int insertPublicCategory(PublicCategory publicCategory);

    /**
     * 修改物料类别
     * 
     * @param publicCategory 物料类别
     * @return 结果
     */
    public int updatePublicCategory(PublicCategory publicCategory);

    /**
     * 批量删除物料类别
     * 
     * @param categoryIds 需要删除的物料类别主键集合
     * @return 结果
     */
    public int deletePublicCategoryByCategoryIds(Long[] categoryIds);

    /**
     * 删除物料类别信息
     * 
     * @param categoryId 物料类别主键
     * @return 结果
     */
    public int deletePublicCategoryByCategoryId(Long categoryId);
}
