package com.yz.shopping.controller;

import java.util.List;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.api.RemoteCodeRulesService;
import com.ruoyi.system.api.domain.PublicCodeRules;
import com.ruoyi.system.api.util.SnowflakeGetId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.system.api.domain.PublicCategory;
import com.yz.shopping.service.IPublicCategoryService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 物料类别Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/category")
public class PublicCategoryController extends BaseController
{
    @Autowired
    private IPublicCategoryService publicCategoryService;
    @Autowired
    private RemoteCodeRulesService remoteCodeRulesService;
//    @Resource
//    private SnowflakeGetId snowflakeGetId;


    /**
     * 查询物料类别列表
     */
    @RequiresPermissions("shopping/public:category:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicCategory publicCategory)
    {
        startPage();
        List<PublicCategory> list = publicCategoryService.selectPublicCategoryList(publicCategory);
        return getDataTable(list);
    }

    /**
     * 查询物料类别列表
     */
    @GetMapping("/ParentCategoryList")
    public TableDataInfo ParentCategoryList(Long parentCategory)
    {
        startPage();
        List<PublicCategory> list = publicCategoryService.selectPublicParentCategoryList(parentCategory);
        System.out.println("222222222222");
        return getDataTable(list);
    }

    /**
     * 导出物料类别列表
     */
    @RequiresPermissions("shopping/public:category:export")
    @Log(title = "物料类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicCategory publicCategory)
    {
        List<PublicCategory> list = publicCategoryService.selectPublicCategoryList(publicCategory);
        ExcelUtil<PublicCategory> util = new ExcelUtil<PublicCategory>(PublicCategory.class);
        util.exportExcel(response, list, "物料类别数据");
    }

    /**
     * 获取物料类别详细信息
     */
    @RequiresPermissions("shopping/public:category:query")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId)
    {
        return success(publicCategoryService.selectPublicCategoryByCategoryId(categoryId));
    }

    /**
     * 新增物料类别
     */
    @RequiresPermissions("shopping/public:category:add")
    @Log(title = "物料类别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicCategory publicCategory)
    {
        AjaxResult ajaxResult = remoteCodeRulesService.getInfo(9L);
        Object obj = ajaxResult.get("data");
        String str = JSON.toJSONString(obj);
        PublicCodeRules p = JSONObject.parseObject(str,PublicCodeRules.class);
        String id = SnowflakeGetId.getCode(p);
        publicCategory.setCategoryNumber(id);
        publicCategory.setIsDelete(0L);
        return toAjax(publicCategoryService.insertPublicCategory(publicCategory));
    }

    /**
     * 修改物料类别
     */
    @RequiresPermissions("shopping/public:category:edit")
    @Log(title = "物料类别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicCategory publicCategory)
    {
        return toAjax(publicCategoryService.updatePublicCategory(publicCategory));
    }

    /**
     * 删除物料类别
     */
    @RequiresPermissions("shopping/public:category:remove")
    @Log(title = "物料类别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Long[] categoryIds)
    {
        return toAjax(publicCategoryService.deletePublicCategoryByCategoryIds(categoryIds));
    }
}
