package com.yz.shopping.controller;

import java.util.List;
import java.io.IOException;
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
import com.yz.shopping.domain.ShoppingOrders;
import com.yz.shopping.service.IShoppingOrdersService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 采购订单表Controller
 * 
 * @author zhangye
 * @date 2023-11-20
 */
@RestController
@RequestMapping("/orders")
public class ShoppingOrdersController extends BaseController
{
    @Autowired
    private IShoppingOrdersService shoppingOrdersService;

    @Autowired
    private RemoteCodeRulesService remoteCodeRulesService;
    /**
     * 查询采购订单表列表
     */
    @RequiresPermissions("shopping/public:orders:list")
    @GetMapping("/list")
    public TableDataInfo list(ShoppingOrders shoppingOrders)
    {
        startPage();
        List<ShoppingOrders> list = shoppingOrdersService.selectShoppingOrdersList(shoppingOrders);
        return getDataTable(list);
    }

    /**
     * 导出采购订单表列表
     */
    @RequiresPermissions("shopping/public:orders:export")
    @Log(title = "采购订单表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShoppingOrders shoppingOrders)
    {
        List<ShoppingOrders> list = shoppingOrdersService.selectShoppingOrdersList(shoppingOrders);
        ExcelUtil<ShoppingOrders> util = new ExcelUtil<ShoppingOrders>(ShoppingOrders.class);
        util.exportExcel(response, list, "采购订单表数据");
    }

    /**
     * 获取采购订单表详细信息
     */
    @RequiresPermissions("shopping/public:orders:query")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return success(shoppingOrdersService.selectShoppingOrdersByOrderId(orderId));
    }

    /**
     * 新增采购订单表
     */
    @RequiresPermissions("shopping/public:orders:add")
    @Log(title = "采购订单表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShoppingOrders shoppingOrders)
    {
        AjaxResult ajaxResult = remoteCodeRulesService.getInfo(3L);
        Object obj = ajaxResult.get("data");
        String str = JSON.toJSONString(obj);
        PublicCodeRules p = JSONObject.parseObject(str,PublicCodeRules.class);
        SnowflakeGetId snowflakeGetId = new SnowflakeGetId(3, 1);
        String id = snowflakeGetId.getCode(p);
        shoppingOrders.setOrderNumber(id);
        shoppingOrders.setCreateBy("yyn");
        shoppingOrders.setIsDelete(0L);
        return toAjax(shoppingOrdersService.insertShoppingOrders(shoppingOrders));
    }

    /**
     * 修改采购订单表
     */
    @RequiresPermissions("shopping/public:orders:edit")
    @Log(title = "采购订单表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShoppingOrders shoppingOrders)
    {
        return toAjax(shoppingOrdersService.updateShoppingOrders(shoppingOrders));
    }

    /**
     * 删除采购订单表
     */
    @RequiresPermissions("shopping/public:orders:remove")
    @Log(title = "采购订单表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(shoppingOrdersService.deleteShoppingOrdersByOrderIds(orderIds));
    }
}
