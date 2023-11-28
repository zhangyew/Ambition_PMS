package com.yz.shopping.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.api.domain.PublicCategory;
import com.yz.shopping.service.IPublicCategoryService;
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
import com.yz.shopping.domain.ShoppingBuyPlan;
import com.yz.shopping.service.IShoppingBuyPlanService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 采购计划表Controller
 *
 * @author zhangye
 * @date 2023-11-20
 */
@RestController
@RequestMapping("/buy_plan")
public class ShoppingBuyPlanController extends BaseController {
    @Autowired
    private IShoppingBuyPlanService shoppingBuyPlanService;

    @Autowired
    private IPublicCategoryService publicCategoryService;

    /**
     * 查询采购计划表列表
     */
    @RequiresPermissions("shopping/buy_plan:list")
    @GetMapping("/list")
    public TableDataInfo list(ShoppingBuyPlan shoppingBuyPlan)
    {
        startPage();
        List<ShoppingBuyPlan> list = shoppingBuyPlanService.selectShoppingBuyPlanList(shoppingBuyPlan);
        return getDataTable(list);
    }

    /**
     * 导出采购计划表列表
     */
    @RequiresPermissions("shopping/buy_plan:export")
    @Log(title = "采购计划表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShoppingBuyPlan shoppingBuyPlan)
    {
        List<ShoppingBuyPlan> list = shoppingBuyPlanService.selectShoppingBuyPlanList(shoppingBuyPlan);
        ExcelUtil<ShoppingBuyPlan> util = new ExcelUtil<ShoppingBuyPlan>(ShoppingBuyPlan.class);
        util.exportExcel(response, list, "采购计划表数据");
    }

    /**
     * 获取采购计划表详细信息
     */
    @RequiresPermissions("shopping/buy_plan:query")
    @GetMapping(value = "/{buyPlanId}")
    public AjaxResult getInfo(@PathVariable("buyPlanId") Long buyPlanId)
    {
        return success(shoppingBuyPlanService.selectShoppingBuyPlanByBuyPlanId(buyPlanId));
    }

    /**
     * 新增采购计划表
     */
    @RequiresPermissions("shopping/buy_plan:add")
    @Log(title = "采购计划表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShoppingBuyPlan shoppingBuyPlan)
    {
        return toAjax(shoppingBuyPlanService.insertShoppingBuyPlan(shoppingBuyPlan));
    }

    /**
     * 修改采购计划表
     */
    @RequiresPermissions("shopping/buy_plan:edit")
    @Log(title = "采购计划表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShoppingBuyPlan shoppingBuyPlan)
    {
        return toAjax(shoppingBuyPlanService.updateShoppingBuyPlan(shoppingBuyPlan));
    }

    /**
     * 删除采购计划表
     */
    @RequiresPermissions("shopping/buy_plan:remove")
    @Log(title = "采购计划表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{buyPlanIds}")
    public AjaxResult remove(@PathVariable Long[] buyPlanIds)
    {
        return toAjax(shoppingBuyPlanService.deleteShoppingBuyPlanByBuyPlanIds(buyPlanIds));
    }
}
