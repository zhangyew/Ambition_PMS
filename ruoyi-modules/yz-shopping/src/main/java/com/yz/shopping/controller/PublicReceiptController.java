package com.yz.shopping.controller;

import java.util.Date;
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
import com.ruoyi.system.api.domain.PublicReceipt;
import com.yz.shopping.service.IPublicReceiptService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 收货单Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/receipt")
public class PublicReceiptController extends BaseController
{
    @Autowired
    private IPublicReceiptService publicReceiptService;
    @Autowired
    private RemoteCodeRulesService remoteCodeRulesService;

    /**
     * 查询待货单列表
     */
//    @RequiresPermissions("shopping/public:receipt:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicReceipt publicReceipt)
    {
        startPage();
        List<PublicReceipt> list = publicReceiptService.selectPublicReceiptList(publicReceipt);
        return getDataTable(list);
    }

    /**
     * 查询收货单列表
     */
//    @RequiresPermissions("shopping/public:receipt:list")
    @GetMapping("/ShowsPublicReceiptList")
    public TableDataInfo ShowsPublicReceiptList(PublicReceipt publicReceipt)
    {
        startPage();
        List<PublicReceipt> list = publicReceiptService.ShowsPublicReceiptList(publicReceipt);
        return getDataTable(list);
    }

    /**
     * 导出收货单列表
     */
    @RequiresPermissions("shopping/public:receipt:export")
    @Log(title = "收货单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicReceipt publicReceipt)
    {
        List<PublicReceipt> list = publicReceiptService.selectPublicReceiptList(publicReceipt);
        ExcelUtil<PublicReceipt> util = new ExcelUtil<PublicReceipt>(PublicReceipt.class);
        util.exportExcel(response, list, "收货单数据");
    }

    /**
     * 获取收货单详细信息
     */
//    @RequiresPermissions("shopping/public:receipt:query")
    @GetMapping(value = "/{receiptId}")
    public AjaxResult getInfo(@PathVariable("receiptId") Long receiptId)
    {
        return success(publicReceiptService.selectPublicReceiptByReceiptId(receiptId));
    }

    /**
     * 新增收货单
     */
//    @RequiresPermissions("shopping/public:receipt:add")
    @Log(title = "收货单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add( PublicReceipt publicReceipt)
    {
        AjaxResult ajaxResult = remoteCodeRulesService.getInfo(13L);
        Object obj = ajaxResult.get("data");
        String str = JSON.toJSONString(obj);
        PublicCodeRules p = JSONObject.parseObject(str,PublicCodeRules.class);
        String id = SnowflakeGetId.getCode(p);
        publicReceipt.setReceiptClod(id);
        publicReceipt.setReceiptState(1l);
        publicReceipt.setCreateBy(publicReceipt.getReceiptBy());
        publicReceipt.setCreateTime(new Date());
        publicReceipt.setIsDelete(0L);
        return toAjax(publicReceiptService.insertPublicReceipt(publicReceipt));
    }

    /**
     * 修改收货单
     */
//    @RequiresPermissions("shopping/public:receipt:edit")
    @Log(title = "收货单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicReceipt publicReceipt)
    {
        return toAjax(publicReceiptService.updatePublicReceipt(publicReceipt));
    }

    /**
     * 删除收货单
     */
//    @RequiresPermissions("shopping/public:receipt:remove")
    @Log(title = "收货单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{receiptIds}")
    public AjaxResult remove(@PathVariable Long[] receiptIds)
    {
        return toAjax(publicReceiptService.deletePublicReceiptByReceiptIds(receiptIds));
    }
}
