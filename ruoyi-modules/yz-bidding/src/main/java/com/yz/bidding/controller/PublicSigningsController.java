package com.yz.bidding.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONUtil;
import com.ruoyi.system.api.domain.PublicSignings;
import com.ruoyi.system.api.domain.PublicSuppliedMaterials;
import com.ruoyi.system.api.domain.PublicSupply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.yz.bidding.service.IPublicSigningsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 签署执行状态表Controller
 *
 * @author zhangye
 * @date 2023-12-04
 */
@RestController
@RequestMapping("/signings")
public class PublicSigningsController extends BaseController {
    @Autowired
    private IPublicSigningsService publicSigningsService;

    /**
     * 查询签署执行状态表列表
     */
    @RequiresPermissions("pms.public:signings:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicSignings publicSignings) {
        startPage();
        List<PublicSignings> list = publicSigningsService.selectPublicSigningsList(publicSignings);
        return getDataTable(list);
    }

    /**
     * 导出签署执行状态表列表
     */
    @RequiresPermissions("pms.public:signings:export")
    @Log(title = "签署执行状态表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicSignings publicSignings) {
        List<PublicSignings> list = publicSigningsService.selectPublicSigningsList(publicSignings);
        ExcelUtil<PublicSignings> util = new ExcelUtil<PublicSignings>(PublicSignings.class);
        util.exportExcel(response, list, "签署执行状态表数据");
    }

    /**
     * 获取签署执行状态表详细信息
     */
    @RequiresPermissions("pms.public:signings:query")
    @GetMapping(value = "/{signingStatusId}")
    public AjaxResult getInfo(@PathVariable("signingStatusId") Long signingStatusId) {
        return success(publicSigningsService.selectPublicSigningsBySigningStatusId(signingStatusId));
    }

    /**
     * 新增签署执行状态表
     */
    @RequiresPermissions("pms.public:signings:add")
    @Log(title = "签署执行状态表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicSignings publicSignings) {
        return toAjax(publicSigningsService.insertPublicSignings(publicSignings));
    }

    /**
     * 修改签署执行状态表
     */
    @RequiresPermissions("pms.public:signings:edit")
    @Log(title = "签署执行状态表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicSignings publicSignings) {
        return toAjax(publicSigningsService.updatePublicSignings(publicSignings));
    }

    /**
     * 删除签署执行状态表
     */
    @RequiresPermissions("pms.public:signings:remove")
    @Log(title = "签署执行状态表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{signingStatusIds}")
    public AjaxResult remove(@PathVariable Long[] signingStatusIds) {
        return toAjax(publicSigningsService.deletePublicSigningsBySigningStatusIds(signingStatusIds));
    }
}
