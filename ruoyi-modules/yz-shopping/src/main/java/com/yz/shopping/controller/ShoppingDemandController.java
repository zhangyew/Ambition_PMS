package com.yz.shopping.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ruoyi.system.api.domain.PublicReceipt;
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
import com.yz.shopping.domain.ShoppingDemand;
import com.yz.shopping.service.IShoppingDemandService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 采购需求物料表Controller
 * 
 * @author zhangye
 * @date 2023-11-20
 */
@RestController
@RequestMapping("/demand")
public class ShoppingDemandController extends BaseController
{
    @Autowired
    private IShoppingDemandService shoppingDemandService;

    /**
     * 查询采购需求物料表列表
     */
    @RequiresPermissions("pms/shopping:demand:list")
    @GetMapping("/list")
    public TableDataInfo list(ShoppingDemand shoppingDemand)
    {
        startPage();
        List<ShoppingDemand> list = shoppingDemandService.selectShoppingDemandList(shoppingDemand);
        return getDataTable(list);
    }

    /**
     * 导出采购需求物料表列表
     */
    @RequiresPermissions("pms/shopping:demand:export")
    @Log(title = "采购需求物料表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShoppingDemand shoppingDemand)
    {
        List<ShoppingDemand> list = shoppingDemandService.selectShoppingDemandList(shoppingDemand);
        ExcelUtil<ShoppingDemand> util = new ExcelUtil<ShoppingDemand>(ShoppingDemand.class);
        util.exportExcel(response, list, "采购需求物料表数据");
    }

    /**
     * 获取采购需求物料表详细信息
     */
    @GetMapping(value = "/{demandId}")
    public AjaxResult getInfo(@PathVariable("demandId") Long demandId)
    {
        return success(shoppingDemandService.selectShoppingDemandByDemandId(demandId));
    }


    /**
     * 收货单物料信息
     */
//    @RequiresPermissions("shopping/public:demand:query")
    @GetMapping(value = "/showDemand/{demandId}")
    public AjaxResult showDemand(@PathVariable("demandId")Long demandId)
    {
        System.out.println("收货单物料信息："+demandId);
        return success(shoppingDemandService.showDemand(demandId));
    }

    /**
     * 新增采购需求物料表
     */
    @PostMapping
    public AjaxResult add(@RequestBody ShoppingDemand shoppingDemand)
    {
        return toAjax(shoppingDemandService.insertShoppingDemand(shoppingDemand));
    }

    /**
     * 修改采购需求物料表
     */
    @Log(title = "采购需求物料表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShoppingDemand shoppingDemand)
    {
        return toAjax(shoppingDemandService.updateShoppingDemand(shoppingDemand));
    }

    /**
     * 删除采购需求物料表
     */
    @RequiresPermissions("pms/shopping:demand:remove")
    @Log(title = "采购需求物料表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{demandIds}")
    public AjaxResult remove(@PathVariable Long[] demandIds)
    {
        return toAjax(shoppingDemandService.deleteShoppingDemandByDemandIds(demandIds));
    }
}
