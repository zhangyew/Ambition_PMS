package com.yz.shopping.controller;

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
import com.yz.shopping.domain.ShoppingProRequire;
import com.yz.shopping.service.IShoppingProRequireService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 采购需求表Controller
 * 
 * @author zhangye
 * @date 2023-11-20
 */
@RestController
@RequestMapping("/pro_require")
public class ShoppingProRequireController extends BaseController
{
    @Autowired
    private IShoppingProRequireService shoppingProRequireService;

    /**
     * 查询采购需求表列表
     */
    @RequiresPermissions("shopping/public:pro_require:list")
    @GetMapping("/list")
    public TableDataInfo list(ShoppingProRequire shoppingProRequire)
    {
        startPage();
        List<ShoppingProRequire> list = shoppingProRequireService.selectShoppingProRequireList(shoppingProRequire);
        return getDataTable(list);
    }

    /**
     * 导出采购需求表列表
     */
    @RequiresPermissions("shopping/public:pro_require:export")
    @Log(title = "采购需求表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShoppingProRequire shoppingProRequire)
    {
        List<ShoppingProRequire> list = shoppingProRequireService.selectShoppingProRequireList(shoppingProRequire);
        ExcelUtil<ShoppingProRequire> util = new ExcelUtil<ShoppingProRequire>(ShoppingProRequire.class);
        util.exportExcel(response, list, "采购需求表数据");
    }

    /**
     * 获取采购需求表详细信息
     */
    @RequiresPermissions("shopping/public:pro_require:query")
    @GetMapping(value = "/{requireId}")
    public AjaxResult getInfo(@PathVariable("requireId") Long requireId)
    {
        return success(shoppingProRequireService.selectShoppingProRequireByRequireId(requireId));
    }

    /**
     * 新增采购需求表
     */
    @RequiresPermissions("shopping/public:pro_require:add")
    @Log(title = "采购需求表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShoppingProRequire shoppingProRequire)
    {
        return toAjax(shoppingProRequireService.insertShoppingProRequire(shoppingProRequire));
    }

    /**
     * 修改采购需求表
     */
    @RequiresPermissions("shopping/public:pro_require:edit")
    @Log(title = "采购需求表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShoppingProRequire shoppingProRequire)
    {
        return toAjax(shoppingProRequireService.updateShoppingProRequire(shoppingProRequire));
    }

    /**
     * 删除采购需求表
     */
    @RequiresPermissions("shopping/public:pro_require:remove")
    @Log(title = "采购需求表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{requireIds}")
    public AjaxResult remove(@PathVariable Long[] requireIds)
    {
        return toAjax(shoppingProRequireService.deleteShoppingProRequireByRequireIds(requireIds));
    }
}
