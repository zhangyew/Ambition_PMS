package com.yz.bidding.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.system.api.domain.PublicVendor;
import com.yz.bidding.service.IPublicVendorService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 供应商Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/vendor")
public class PublicVendorController extends BaseController {
    @Autowired
    private IPublicVendorService publicVendorService;

    /**
     * 查询供应商列表
     */
    @RequiresPermissions("bidding/public:vendor:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicVendor publicVendor) {

        SnowflakeGetId sid = new SnowflakeGetId();
        String id = sid.getSnowflakesId("GYS",2003,15);
        System.out.println(id);

//        startPage();
        return null;
//        List<PublicVendor> list = publicVendorService.selectPublicVendorList(publicVendor);
//        return getDataTable(list);
    }

    /**
     * 导出供应商列表
     */
    @RequiresPermissions("bidding/public:vendor:export")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicVendor publicVendor) {
        List<PublicVendor> list = publicVendorService.selectPublicVendorList(publicVendor);
        ExcelUtil<PublicVendor> util = new ExcelUtil<PublicVendor>(PublicVendor.class);
        util.exportExcel(response, list, "供应商数据");
    }

    /**
     * 获取供应商详细信息
     */
    @RequiresPermissions("bidding/public:vendor:query")
    @GetMapping(value = "/{vendorId}")
    public AjaxResult getInfo(@PathVariable("vendorId") Long vendorId) {
        return success(publicVendorService.selectPublicVendorByVendorId(vendorId));
    }

    /**
     * 新增供应商
     */
    @RequiresPermissions("bidding/public:vendor:add")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicVendor publicVendor) {
        System.out.println(publicVendor.toString());
        return toAjax(publicVendorService.insertPublicVendor(publicVendor));
    }

    /**
     * 修改供应商
     */
    @RequiresPermissions("bidding/public:vendor:edit")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicVendor publicVendor) {
        return toAjax(publicVendorService.updatePublicVendor(publicVendor));
    }

    /**
     * 删除供应商
     */
    @RequiresPermissions("bidding/public:vendor:remove")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
    @DeleteMapping("/{vendorIds}")
    public AjaxResult remove(@PathVariable Long[] vendorIds) {
        return toAjax(publicVendorService.deletePublicVendorByVendorIds(vendorIds));
    }
}
