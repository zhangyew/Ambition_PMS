package com.yz.shopping.controller;

import java.util.List;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.system.api.RemoteCodeRulesService;
import com.ruoyi.system.api.domain.PublicCodeRules;
import com.ruoyi.system.api.util.SnowflakeGetId;
import com.yz.bidding.service.IPublicCodeRulesService;
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
import com.ruoyi.system.api.domain.PublicWarehouse;
import com.yz.shopping.service.IPublicWarehouseService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 仓库Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/warehouse")
public class PublicWarehouseController extends BaseController {
    @Autowired
    private IPublicWarehouseService publicWarehouseService;

    @Autowired
    private RemoteCodeRulesService remoteCodeRulesService;
//    @Resource
//    private SnowflakeGetId snowflakeGetId;
    /**
     * 查询仓库列表
     */
    @GetMapping("/list")
    public TableDataInfo list(PublicWarehouse publicWarehouse) {
        startPage();
        List<PublicWarehouse> list = publicWarehouseService.selectPublicWarehouseList(publicWarehouse);
        return getDataTable(list);
    }



    /**
     * 导出仓库列表
     */
    @Log(title = "仓库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicWarehouse publicWarehouse) {
        List<PublicWarehouse> list = publicWarehouseService.selectPublicWarehouseList(publicWarehouse);
        ExcelUtil<PublicWarehouse> util = new ExcelUtil<PublicWarehouse>(PublicWarehouse.class);
        util.exportExcel(response, list, "仓库数据");
    }

    /**
     * 获取仓库详细信息
     */
    @GetMapping(value = "/{warehouseId}")
    public AjaxResult getInfo(@PathVariable("warehouseId") Long warehouseId) {
        return success(publicWarehouseService.selectPublicWarehouseByWarehouseId(warehouseId));
    }

    /**
     * 新增仓库
     */
    @RequiresPermissions("shoping/public:warehouse:add")
    @Log(title = "仓库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicWarehouse publicWarehouse) throws IOException {
        AjaxResult ajaxResult = remoteCodeRulesService.getInfo(7L);
        Object obj = ajaxResult.get("data");
        String str = JSON.toJSONString(obj);
        PublicCodeRules p = JSONObject.parseObject(str,PublicCodeRules.class);
//        String id = SnowflakeGetId.getCode(p);
        publicWarehouse.setWarehouseNumber(SnowflakeGetId.getCode(p));
        return toAjax(publicWarehouseService.insertPublicWarehouse(publicWarehouse));
    }

    /**
     * 修改仓库
     */
    @RequiresPermissions("shopping/public:warehouse:edit")
    @Log(title = "仓库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicWarehouse publicWarehouse) {
        return toAjax(publicWarehouseService.updatePublicWarehouse(publicWarehouse));
    }

    /**
     * 删除仓库
     */
    @RequiresPermissions("shopping/public:warehouse:remove")
    @Log(title = "仓库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{warehouseIds}")
    public AjaxResult remove(@PathVariable Long[] warehouseIds) {
        return toAjax(publicWarehouseService.deletePublicWarehouseByWarehouseIds(warehouseIds));
    }
}
