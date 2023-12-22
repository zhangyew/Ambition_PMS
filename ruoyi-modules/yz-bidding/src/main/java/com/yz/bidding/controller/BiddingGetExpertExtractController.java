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
import com.yz.bidding.domain.BiddingGetExpertExtract;
import com.yz.bidding.service.IBiddingGetExpertExtractService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 专家被抽取表Controller
 * 
 * @author zhangye
 * @date 2023-12-21
 */
@RestController
@RequestMapping("/extract")
public class BiddingGetExpertExtractController extends BaseController
{
    @Autowired
    private IBiddingGetExpertExtractService biddingGetExpertExtractService;

    /**
     * 查询专家被抽取表列表
     */
    @RequiresPermissions("bidding:extract:list")
    @GetMapping("/list")
    public TableDataInfo list(BiddingGetExpertExtract biddingGetExpertExtract)
    {
        startPage();
        List<BiddingGetExpertExtract> list = biddingGetExpertExtractService.selectBiddingGetExpertExtractList(biddingGetExpertExtract);
        return getDataTable(list);
    }

    /**
     * 导出专家被抽取表列表
     */
    @RequiresPermissions("bidding:extract:export")
    @Log(title = "专家被抽取表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BiddingGetExpertExtract biddingGetExpertExtract)
    {
        List<BiddingGetExpertExtract> list = biddingGetExpertExtractService.selectBiddingGetExpertExtractList(biddingGetExpertExtract);
        ExcelUtil<BiddingGetExpertExtract> util = new ExcelUtil<BiddingGetExpertExtract>(BiddingGetExpertExtract.class);
        util.exportExcel(response, list, "专家被抽取表数据");
    }

    /**
     * 获取专家被抽取表详细信息
     */
    @RequiresPermissions("bidding:extract:query")
    @GetMapping(value = "/{getExpertExtractId}")
    public AjaxResult getInfo(@PathVariable("getExpertExtractId") Long getExpertExtractId)
    {
        return success(biddingGetExpertExtractService.selectBiddingGetExpertExtractByGetExpertExtractId(getExpertExtractId));
    }

    /**
     * 新增专家被抽取表
     */
    @RequiresPermissions("bidding:extract:add")
    @Log(title = "专家被抽取表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BiddingGetExpertExtract biddingGetExpertExtract)
    {
        return toAjax(biddingGetExpertExtractService.insertBiddingGetExpertExtract(biddingGetExpertExtract));
    }

    /**
     * 修改专家被抽取表
     */
    @RequiresPermissions("bidding:extract:edit")
    @Log(title = "专家被抽取表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BiddingGetExpertExtract biddingGetExpertExtract)
    {
        return toAjax(biddingGetExpertExtractService.updateBiddingGetExpertExtract(biddingGetExpertExtract));
    }

    /**
     * 删除专家被抽取表
     */
    @RequiresPermissions("bidding:extract:remove")
    @Log(title = "专家被抽取表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{getExpertExtractIds}")
    public AjaxResult remove(@PathVariable Long[] getExpertExtractIds)
    {
        return toAjax(biddingGetExpertExtractService.deleteBiddingGetExpertExtractByGetExpertExtractIds(getExpertExtractIds));
    }
}
