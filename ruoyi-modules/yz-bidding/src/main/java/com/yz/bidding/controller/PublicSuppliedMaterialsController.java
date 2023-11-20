package com.yz.bidding.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.api.domain.PublicSuppliedMaterials;
import com.yz.bidding.service.IPublicSuppliedMaterialsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 供应商供货物料表Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/supplied_materials")
public class PublicSuppliedMaterialsController extends BaseController
{
    @Autowired
    private IPublicSuppliedMaterialsService publicSuppliedMaterialsService;

    /**
     * 查询供应商供货物料表列表
     */
    @RequiresPermissions("pms.public:supplied_materials:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicSuppliedMaterials publicSuppliedMaterials)
    {
        startPage();
        List<PublicSuppliedMaterials> list = publicSuppliedMaterialsService.selectPublicSuppliedMaterialsList(publicSuppliedMaterials);
        return getDataTable(list);
    }

    /**
     * 导出供应商供货物料表列表
     */
    @RequiresPermissions("pms.public:supplied_materials:export")
    @Log(title = "供应商供货物料表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicSuppliedMaterials publicSuppliedMaterials)
    {
        List<PublicSuppliedMaterials> list = publicSuppliedMaterialsService.selectPublicSuppliedMaterialsList(publicSuppliedMaterials);
        ExcelUtil<PublicSuppliedMaterials> util = new ExcelUtil<PublicSuppliedMaterials>(PublicSuppliedMaterials.class);
        util.exportExcel(response, list, "供应商供货物料表数据");
    }

    /**
     * 获取供应商供货物料表详细信息
     */
    @RequiresPermissions("pms.public:supplied_materials:query")
    @GetMapping(value = "/{suppliedMaterialsId}")
    public AjaxResult getInfo(@PathVariable("suppliedMaterialsId") Long suppliedMaterialsId)
    {
        return success(publicSuppliedMaterialsService.selectPublicSuppliedMaterialsBySuppliedMaterialsId(suppliedMaterialsId));
    }

    /**
     * 新增供应商供货物料表
     */
    @RequiresPermissions("pms.public:supplied_materials:add")
    @Log(title = "供应商供货物料表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicSuppliedMaterials publicSuppliedMaterials)
    {
        return toAjax(publicSuppliedMaterialsService.insertPublicSuppliedMaterials(publicSuppliedMaterials));
    }

    /**
     * 修改供应商供货物料表
     */
    @RequiresPermissions("pms.public:supplied_materials:edit")
    @Log(title = "供应商供货物料表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicSuppliedMaterials publicSuppliedMaterials)
    {
        return toAjax(publicSuppliedMaterialsService.updatePublicSuppliedMaterials(publicSuppliedMaterials));
    }

    /**
     * 删除供应商供货物料表
     */
    @RequiresPermissions("pms.public:supplied_materials:remove")
    @Log(title = "供应商供货物料表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{suppliedMaterialsIds}")
    public AjaxResult remove(@PathVariable Long[] suppliedMaterialsIds)
    {
        return toAjax(publicSuppliedMaterialsService.deletePublicSuppliedMaterialsBySuppliedMaterialsIds(suppliedMaterialsIds));
    }
}
