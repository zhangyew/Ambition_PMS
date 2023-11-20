package com.yz.bidding.controller;

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
import com.ruoyi.system.api.domain.PublicContract;
import com.yz.bidding.service.IPublicContractService;
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
@RequestMapping("/contract")
public class PublicContractController extends BaseController
{
    @Autowired
    private IPublicContractService publicContractService;

    /**
     * 查询合同列表
     */
    @RequiresPermissions("pms.public:contract:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicContract publicContract)
    {
        startPage();
        List<PublicContract> list = publicContractService.selectPublicContractList(publicContract);
        return getDataTable(list);
    }

    /**
     * 导出合同列表
     */
    @RequiresPermissions("pms.public:contract:export")
    @Log(title = "合同", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicContract publicContract)
    {
        List<PublicContract> list = publicContractService.selectPublicContractList(publicContract);
        ExcelUtil<PublicContract> util = new ExcelUtil<PublicContract>(PublicContract.class);
        util.exportExcel(response, list, "合同数据");
    }

    /**
     * 获取合同详细信息
     */
    @RequiresPermissions("pms.public:contract:query")
    @GetMapping(value = "/{contractId}")
    public AjaxResult getInfo(@PathVariable("contractId") Long contractId)
    {
        return success(publicContractService.selectPublicContractByContractId(contractId));
    }

    /**
     * 新增合同
     */
    @RequiresPermissions("pms.public:contract:add")
    @Log(title = "合同", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicContract publicContract)
    {
        return toAjax(publicContractService.insertPublicContract(publicContract));
    }

    /**
     * 修改合同
     */
    @RequiresPermissions("pms.public:contract:edit")
    @Log(title = "合同", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicContract publicContract)
    {
        return toAjax(publicContractService.updatePublicContract(publicContract));
    }

    /**
     * 删除合同
     */
    @RequiresPermissions("pms.public:contract:remove")
    @Log(title = "合同", businessType = BusinessType.DELETE)
	@DeleteMapping("/{contractIds}")
    public AjaxResult remove(@PathVariable Long[] contractIds)
    {
        return toAjax(publicContractService.deletePublicContractByContractIds(contractIds));
    }
}
