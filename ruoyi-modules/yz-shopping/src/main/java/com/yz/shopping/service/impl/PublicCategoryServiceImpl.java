package com.yz.shopping.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.PublicCategoryMapper;
import com.ruoyi.system.api.domain.PublicCategory;
import com.yz.shopping.service.IPublicCategoryService;

/**
 * 物料类别Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicCategoryServiceImpl implements IPublicCategoryService 
{
    @Autowired
    private PublicCategoryMapper publicCategoryMapper;

    /**
     * 查询物料类别
     * 
     * @param categoryId 物料类别主键
     * @return 物料类别
     */
    @Override
    public PublicCategory selectPublicCategoryByCategoryId(Long categoryId)
    {
        return publicCategoryMapper.selectPublicCategoryByCategoryId(categoryId);
    }

    /**
     * 查询物料类别列表
     * 
     * @param publicCategory 物料类别
     * @return 物料类别
     */
    @Override
    public List<PublicCategory> selectPublicCategoryList(PublicCategory publicCategory)
    {
        return publicCategoryMapper.selectPublicCategoryList(publicCategory);
    }

    /**
     * 新增物料类别
     * 
     * @param publicCategory 物料类别
     * @return 结果
     */
    @Override
    public int insertPublicCategory(PublicCategory publicCategory)
    {
        publicCategory.setCreateTime(DateUtils.getNowDate());
        return publicCategoryMapper.insertPublicCategory(publicCategory);
    }

    /**
     * 修改物料类别
     * 
     * @param publicCategory 物料类别
     * @return 结果
     */
    @Override
    public int updatePublicCategory(PublicCategory publicCategory)
    {
        publicCategory.setUpdateTime(DateUtils.getNowDate());
        return publicCategoryMapper.updatePublicCategory(publicCategory);
    }

    /**
     * 批量删除物料类别
     * 
     * @param categoryIds 需要删除的物料类别主键
     * @return 结果
     */
    @Override
    public int deletePublicCategoryByCategoryIds(Long[] categoryIds)
    {
        return publicCategoryMapper.deletePublicCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除物料类别信息
     * 
     * @param categoryId 物料类别主键
     * @return 结果
     */
    @Override
    public int deletePublicCategoryByCategoryId(Long categoryId)
    {
        return publicCategoryMapper.deletePublicCategoryByCategoryId(categoryId);
    }
}
