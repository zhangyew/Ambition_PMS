package com.yz.shopping.controller;

import java.util.List;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.security.annotation.InnerAuth;
import com.ruoyi.system.api.RemoteCodeRulesService;
import com.ruoyi.system.api.domain.PublicCategory;
import com.ruoyi.system.api.domain.PublicCodeRules;
import com.ruoyi.system.api.util.SnowflakeGetId;
import com.yz.shopping.domain.ShoppingProRequire;
import com.yz.shopping.service.IPublicCategoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private RemoteCodeRulesService remoteCodeRulesService;

//    @Resource
//    private SnowflakeGetId snowflakeGetId;

    /**
     * 查询采购计划表列表
     */
    @RequiresPermissions("shopping/buy_plan:list")
    @GetMapping("/list")
    public TableDataInfo list(ShoppingBuyPlan shoppingBuyPlan) {
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
    public void export(HttpServletResponse response, ShoppingBuyPlan shoppingBuyPlan) {
        List<ShoppingBuyPlan> list = shoppingBuyPlanService.selectShoppingBuyPlanList(shoppingBuyPlan);
        ExcelUtil<ShoppingBuyPlan> util = new ExcelUtil<ShoppingBuyPlan>(ShoppingBuyPlan.class);
        util.exportExcel(response, list, "采购计划表数据");
    }

    /**
     * 采购计划（合同签订）
     *
     * @param buyPlanId 采购计划表
     * @return 采购计划表集合
     */
    @RequiresPermissions("shopping/buy_plan:showBuyPlan")
    @GetMapping("/showBuyPlan")
    public TableDataInfo showBuyPlan(Long buyPlanId) {
        startPage();
        List<ShoppingBuyPlan> list = shoppingBuyPlanService.showBuyPlan(buyPlanId);
        System.out.println("显示所有采购计划：" + list.toString());
        return getDataTable(list);
    }

    /**
     * 获取采购计划表详细信息
     */
    @RequiresPermissions("shopping/buy_plan:query")
    @GetMapping(value = "/{buyPlanId}")
    public AjaxResult getInfo(@PathVariable("buyPlanId") Long buyPlanId) {
        return success(shoppingBuyPlanService.selectShoppingBuyPlanByBuyPlanId(buyPlanId));
    }

    /**
     * 新增采购计划表
     */
    @RequiresPermissions("shopping/buy_plan:add")
    @Log(title = "采购计划表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShoppingBuyPlan shoppingBuyPlan) {
        AjaxResult ajaxResult = remoteCodeRulesService.getInfo(11L);
        Object obj = ajaxResult.get("data");
        String str = JSON.toJSONString(obj);
        PublicCodeRules p = JSONObject.parseObject(str, PublicCodeRules.class);
//        String id = SnowflakeGetId.getCode(p);
        shoppingBuyPlan.setPlanClod(SnowflakeGetId.getCode(p));
        shoppingBuyPlan.setCreateBy("fm");
        shoppingBuyPlan.setPlanState(0L);
        shoppingBuyPlan.setIsDelete(0L);
        return toAjax(shoppingBuyPlanService.insertShoppingBuyPlan(shoppingBuyPlan));
    }

    /**
     * 修改采购计划表
     */
    @RequiresPermissions("shopping/buy_plan:edit")
    @Log(title = "采购计划表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShoppingBuyPlan shoppingBuyPlan) {
        shoppingBuyPlan.setPlanState(0L);
        return toAjax(shoppingBuyPlanService.updateShoppingBuyPlan(shoppingBuyPlan));
    }

    /**
     * 审批修改状态
     */
    @RequiresPermissions("shopping/public:buy_plan:edit")
    @Log(title = "采购计划表", businessType = BusinessType.UPDATE)
    @PostMapping("/updateExamine")
    public AjaxResult updateExamine(@RequestBody ShoppingBuyPlan shoppingBuyPlan) {
        return toAjax(shoppingBuyPlanService.updateExamine(shoppingBuyPlan));
    }

    //修改状态
    @GetMapping("/upState/{bid}")
    public AjaxResult upState(@PathVariable Long bid) {
        return toAjax(shoppingBuyPlanService.upState(bid));
    }

    /**
     * 删除采购计划表
     */
    @RequiresPermissions("shopping/buy_plan:remove")
    @Log(title = "采购计划表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{buyPlanIds}")
    public AjaxResult remove(@PathVariable Long[] buyPlanIds) {
        return toAjax(shoppingBuyPlanService.deleteShoppingBuyPlanByBuyPlanIds(buyPlanIds));
    }
}
