package com.yz.bidding.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.yz.bidding.service.IPublicAgreementService;
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
import com.ruoyi.system.api.domain.PublicAgreement;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 合同Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("agreement")
public class PublicAgreementController extends BaseController
{
    @Autowired
    private IPublicAgreementService publicAgreementService;

    /**
     * 查询合同申请表列表
     */
    @RequiresPermissions("bidding/public:agreement:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicAgreement publicAgreement)
    {
        startPage();
        List<PublicAgreement> list = publicAgreementService.selectPublicAgreementList(publicAgreement);
        return getDataTable(list);
    }

    /**
     * 导出合同申请表列表
     */
    @RequiresPermissions("bidding/public:agreement:export")
    @Log(title = "合同申请表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicAgreement publicAgreement)
    {
        List<PublicAgreement> list = publicAgreementService.selectPublicAgreementList(publicAgreement);
        ExcelUtil<PublicAgreement> util = new ExcelUtil<PublicAgreement>(PublicAgreement.class);
        util.exportExcel(response, list, "合同申请表数据");
    }

    /**
     * 获取合同申请表详细信息
     */
    @RequiresPermissions("bidding/public:agreement:query")
    @GetMapping(value = "/{contractId}")
    public AjaxResult getInfo(@PathVariable("contractId") Long contractId)
    {
        return success(publicAgreementService.selectPublicAgreementByContractId(contractId));
    }

    /**
     * 新增合同申请表
     */
    @RequiresPermissions("bidding/public:agreement:add")
    @Log(title = "合同申请表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicAgreement publicAgreement)
    {
        return toAjax(publicAgreementService.insertPublicAgreement(publicAgreement));
    }

    /**
     * 修改合同申请表
     */
    @RequiresPermissions("bidding/public:agreement:edit")
    @Log(title = "合同申请表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicAgreement publicAgreement)
    {
        return toAjax(publicAgreementService.updatePublicAgreement(publicAgreement));
    }

    /**
     * 删除合同申请表
     */
    @RequiresPermissions("bidding/public:agreement:remove")
    @Log(title = "合同申请表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{contractIds}")
    public AjaxResult remove(@PathVariable Long[] contractIds)
    {
        return toAjax(publicAgreementService.deletePublicAgreementByContractIds(contractIds));
    }
}
