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
import com.ruoyi.system.api.domain.PublicPayment;
import com.yz.shopping.service.IPublicPaymentService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 合同付款Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/payment")
public class PublicPaymentController extends BaseController
{
    @Autowired
    private IPublicPaymentService publicPaymentService;

    /**
     * 查询合同付款列表
     */
    @RequiresPermissions("pms.public:payment:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicPayment publicPayment)
    {
        startPage();
        List<PublicPayment> list = publicPaymentService.selectPublicPaymentList(publicPayment);
        return getDataTable(list);
    }

    /**
     * 导出合同付款列表
     */
    @RequiresPermissions("pms.public:payment:export")
    @Log(title = "合同付款", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicPayment publicPayment)
    {
        List<PublicPayment> list = publicPaymentService.selectPublicPaymentList(publicPayment);
        ExcelUtil<PublicPayment> util = new ExcelUtil<PublicPayment>(PublicPayment.class);
        util.exportExcel(response, list, "合同付款数据");
    }

    /**
     * 获取合同付款详细信息
     */
    @RequiresPermissions("pms.public:payment:query")
    @GetMapping(value = "/{paymentId}")
    public AjaxResult getInfo(@PathVariable("paymentId") Long paymentId)
    {
        return success(publicPaymentService.selectPublicPaymentByPaymentId(paymentId));
    }

    /**
     * 新增合同付款
     */
    @RequiresPermissions("pms.public:payment:add")
    @Log(title = "合同付款", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicPayment publicPayment)
    {
        return toAjax(publicPaymentService.insertPublicPayment(publicPayment));
    }

    /**
     * 修改合同付款
     */
    @RequiresPermissions("pms.public:payment:edit")
    @Log(title = "合同付款", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicPayment publicPayment)
    {
        return toAjax(publicPaymentService.updatePublicPayment(publicPayment));
    }

    /**
     * 删除合同付款
     */
    @RequiresPermissions("pms.public:payment:remove")
    @Log(title = "合同付款", businessType = BusinessType.DELETE)
	@DeleteMapping("/{paymentIds}")
    public AjaxResult remove(@PathVariable Long[] paymentIds)
    {
        return toAjax(publicPaymentService.deletePublicPaymentByPaymentIds(paymentIds));
    }
}
