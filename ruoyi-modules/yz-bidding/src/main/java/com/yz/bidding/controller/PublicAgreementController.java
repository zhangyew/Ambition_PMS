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
     * 新增合同申请表
     */
    @RequiresPermissions("pms.public:agreement:add")
    @Log(title = "合同申请表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicAgreement publicAgreement)
    {
        return toAjax(publicAgreementService.insertPublicAgreement(publicAgreement));
    }

    /**
     * 修改合同申请表
     */
    @RequiresPermissions("pms.public:agreement:edit")
    @Log(title = "合同申请表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicAgreement publicAgreement)
    {
        return toAjax(publicAgreementService.updatePublicAgreement(publicAgreement));
    }

    /**
     * 删除合同申请表
     */
    @RequiresPermissions("pms.public:agreement:remove")
    @Log(title = "合同申请表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{contractIds}")
    public AjaxResult remove(@PathVariable Long[] contractIds)
    {
        return toAjax(publicAgreementService.deletePublicAgreementByContractIds(contractIds));
    }
}
