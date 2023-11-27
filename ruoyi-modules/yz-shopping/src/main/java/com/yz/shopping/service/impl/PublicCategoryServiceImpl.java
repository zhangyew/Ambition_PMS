package com.yz.shopping.service.impl;

import java.util.List;

import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.PublicCategoryMapper;
import com.ruoyi.system.api.domain.PublicCategory;
import com.yz.shopping.service.IPublicCategoryService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 物料类别Service业务层处理
 *
 * @author zhangye
 * @date 2023-11-21
 */
@Service
@Transactional
public class PublicCategoryServiceImpl implements IPublicCategoryService
{
    @Resource
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
     * 查询物料分类的父级id
     *
     */
    @Override
    public List<PublicCategory> selectPublicParentCategoryList(Long parentCategory) {
        return publicCategoryMapper.selectPublicParentCategoryList(parentCategory);
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
        int res=0;
        if (publicCategoryMapper.selectCounts(categoryIds)<=0) {
            res= publicCategoryMapper.deletePublicCategoryByCategoryIds(categoryIds);
        }
        return res;
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

    /**
     * 查询所有的一级菜单
     *
     * @return
     */
    public PublicCategory selectOne() {
        return publicCategoryMapper.selectOne(null);
    }

    /**
     * 根据一级分类查询对应的二级的分类菜单
     *
     * @return
     */
    public List<PublicCategory> selectTwoByOne() {
        List<PublicCategory> list1 = publicCategoryMapper.selectTwoByOne(null);
        for (PublicCategory publicCategory : list1) {
            List<PublicCategory> list2 = publicCategoryMapper.selectTwoByOne(publicCategory.getCategoryNumber());
            publicCategory.setList(list2);
        }
        return list1;
    }
}
