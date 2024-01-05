package com.yz.shopping.service;

import java.util.List;
import com.ruoyi.system.api.domain.PublicCategory;
import org.apache.ibatis.annotations.Param;

/**
 * 物料类别Service接口
 * 
 * @author zhangye
 * @date 2023-11-21
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
     * 查询物料分类的父级id
     *
     */
    public List<PublicCategory> selectPublicParentCategoryList(Long parentCategory);


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

    /**
     * 查询所有的一级菜单
     * @return
     */
    public PublicCategory selectOne();
    /**
     * 根据一级分类查询对应的二级的分类菜单
     * @return
     */
    public List<PublicCategory> selectTwoByOne();
}
