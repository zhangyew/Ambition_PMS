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
import com.ruoyi.system.api.domain.PublicContractdetails;
import com.yz.bidding.service.IPublicContractdetailsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 合同明细Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/contractdetails")
public class PublicContractdetailsController extends BaseController
{
    @Autowired
    private IPublicContractdetailsService publicContractdetailsService;

    /**
     * 查询合同明细列表
     */
    @RequiresPermissions("pms.public:contractdetails:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicContractdetails publicContractdetails)
    {
        startPage();
        List<PublicContractdetails> list = publicContractdetailsService.selectPublicContractdetailsList(publicContractdetails);
        return getDataTable(list);
    }

    /**
     * 导出合同明细列表
     */
    @RequiresPermissions("pms.public:contractdetails:export")
    @Log(title = "合同明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicContractdetails publicContractdetails)
    {
        List<PublicContractdetails> list = publicContractdetailsService.selectPublicContractdetailsList(publicContractdetails);
        ExcelUtil<PublicContractdetails> util = new ExcelUtil<PublicContractdetails>(PublicContractdetails.class);
        util.exportExcel(response, list, "合同明细数据");
    }

    /**
     * 获取合同明细详细信息
     */
    @RequiresPermissions("pms.public:contractdetails:query")
    @GetMapping(value = "/{contractdetailsId}")
    public AjaxResult getInfo(@PathVariable("contractdetailsId") Long contractdetailsId)
    {
        return success(publicContractdetailsService.selectPublicContractdetailsByContractdetailsId(contractdetailsId));
    }

    /**
     * 新增合同明细
     */
    @RequiresPermissions("pms.public:contractdetails:add")
    @Log(title = "合同明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicContractdetails publicContractdetails)
    {
        return toAjax(publicContractdetailsService.insertPublicContractdetails(publicContractdetails));
    }

    /**
     * 修改合同明细
     */
    @RequiresPermissions("pms.public:contractdetails:edit")
    @Log(title = "合同明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicContractdetails publicContractdetails)
    {
        return toAjax(publicContractdetailsService.updatePublicContractdetails(publicContractdetails));
    }

    /**
     * 删除合同明细
     */
    @RequiresPermissions("pms.public:contractdetails:remove")
    @Log(title = "合同明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{contractdetailsIds}")
    public AjaxResult remove(@PathVariable Long[] contractdetailsIds)
    {
        return toAjax(publicContractdetailsService.deletePublicContractdetailsByContractdetailsIds(contractdetailsIds));
    }
}
