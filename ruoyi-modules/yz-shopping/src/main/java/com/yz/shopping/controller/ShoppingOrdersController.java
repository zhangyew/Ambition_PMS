package com.yz.shopping.controller;

import java.util.List;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.system.api.RemoteCodeRulesService;
import com.ruoyi.system.api.RemoteFileService;
import com.ruoyi.system.api.domain.PublicAnnex;
import com.ruoyi.system.api.domain.PublicCodeRules;
import com.ruoyi.system.api.domain.SysFile;
import com.ruoyi.system.api.model.LoginUser;
import com.ruoyi.system.api.util.SnowflakeGetId;
import com.yz.bidding.domain.BiddingTenderNotice;
import com.yz.shopping.domain.ShoppingBuyPlan;
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
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private RemoteFileService remoteFileService;

    /**
     * 查询采购订单表列表
     */
    @RequiresPermissions("shopping/public:orders:list")
    @GetMapping("/list")
    public TableDataInfo list(ShoppingOrders shoppingOrders) {
        startPage();
        List<ShoppingOrders> list = shoppingOrdersService.selectShoppingOrdersList(shoppingOrders);
        return getDataTable(list);
    }

    /**
     * 供应商首页（我的订单）
     */
    @RequiresPermissions("shopping/public:orders:showOrderSupplierId")
    @GetMapping("/showOrderSupplierId")
    public TableDataInfo showOrderSupplierId(Long oSupplierId) {
        oSupplierId = 2L;
        List<ShoppingOrders> list = shoppingOrdersService.showOrderSupplierId(oSupplierId);
        return getDataTable(list);
    }

    /**
     * 导出采购订单表列表
     */
    @RequiresPermissions("shopping/public:orders:export")
    @Log(title = "采购订单表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShoppingOrders shoppingOrders) {
        List<ShoppingOrders> list = shoppingOrdersService.selectShoppingOrdersList(shoppingOrders);
        ExcelUtil<ShoppingOrders> util = new ExcelUtil<ShoppingOrders>(ShoppingOrders.class);
        util.exportExcel(response, list, "采购订单表数据");
    }

    /**
     * 获取采购订单表详细信息
     */
    @RequiresPermissions("shopping/public:orders:query")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId) {
        return success(shoppingOrdersService.selectShoppingOrdersByOrderId(orderId));
    }

    /**
     * 只有文件上传
     */
    @PostMapping("/uploadFiles")
    public R<SysFile> uploadFiles(MultipartFile file) {
        System.out.println(file);
        return remoteFileService.upload(file);
    }

    /**
     * 收货单（详情显示）
     */
    @RequiresPermissions("shopping/public:orders:query")
    @GetMapping(value = "showsDetailsReceipt/{orderId}")
    public AjaxResult showsDetailsReceipt(@PathVariable("orderId") Long orderId)
    {
        return success(shoppingOrdersService.showsDetailsReceipt(orderId));
    }

    /**
     * 新增采购订单表
     */
    @RequiresPermissions("shopping/public:orders:add")
    @Log(title = "采购订单表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShoppingOrders shoppingOrders) {
        AjaxResult ajaxResult = remoteCodeRulesService.getInfo(3L);
        Object obj = ajaxResult.get("data");
        String str = JSON.toJSONString(obj);
        PublicCodeRules p = JSONObject.parseObject(str, PublicCodeRules.class);
        shoppingOrders.setOrderNumber(SnowflakeGetId.getCode(p));
        shoppingOrders.setCreateBy("yyn");
        shoppingOrders.setIsDelete(0L);
//        shoppingOrders.setTypeOrderState(0L);
        return toAjax(shoppingOrdersService.insertShoppingOrders(shoppingOrders));
    }

    @PostMapping(value = "/addOrders")
    public int addOrders(@RequestBody ShoppingOrders shoppingOrders, String fileUrl) {
        List<PublicAnnex> list = JSONUtil.toList(fileUrl, PublicAnnex.class);
        System.out.println(list);
        AjaxResult ajaxResult = remoteCodeRulesService.getInfo(3L);
        Object obj = ajaxResult.get("data");
        String str = JSON.toJSONString(obj);
        PublicCodeRules p = JSONObject.parseObject(str, PublicCodeRules.class);
        shoppingOrders.setOrderNumber(SnowflakeGetId.getCode(p));
        shoppingOrders.setCreateBy("yyn");
        shoppingOrders.setIsDelete(0L);
        return shoppingOrdersService.addOrders(shoppingOrders,list);
    }
    /**
     * 修改采购订单表
     */
    @RequiresPermissions("shopping/public:orders:edit")
    @Log(title = "采购订单表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShoppingOrders shoppingOrders) {
        return toAjax(shoppingOrdersService.updateShoppingOrders(shoppingOrders));
    }
    /**
     * 审批修改状态
     */
    @RequiresPermissions("shopping/public:orders:edit")
    @Log(title = "采购订单表", businessType = BusinessType.UPDATE)
    @PostMapping("/updateExamine")
    public AjaxResult updateExamine(@RequestBody ShoppingOrders shoppingOrders) {
        return toAjax(shoppingOrdersService.updateExamine(shoppingOrders));
    }
    /**
     * 修改待收货状态
     */
    @RequiresPermissions("shopping/public:orders:edit")
    @Log(title = "采购订单表", businessType = BusinessType.UPDATE)
    @PutMapping("updateOrderState/{orderId}")
    public AjaxResult updateOrderState(@PathVariable("orderId") Long orderId) {
        return toAjax(shoppingOrdersService.updateOrderState(orderId));
    }



    /**
     * 删除采购订单表
     */
    @RequiresPermissions("shopping/public:orders:remove")
    @Log(title = "采购订单表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds) {
        return toAjax(shoppingOrdersService.deleteShoppingOrdersByOrderIds(orderIds));
    }
}
