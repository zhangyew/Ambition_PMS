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
import com.yz.bidding.domain.BiddingExtractionConditions;
import com.yz.bidding.service.IBiddingExtractionConditionsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 抽取条件表Controller
 * 
 * @author zhangye
 * @date 2023-12-21
 */
@RestController
@RequestMapping("/conditions")
public class BiddingExtractionConditionsController extends BaseController
{
    @Autowired
    private IBiddingExtractionConditionsService biddingExtractionConditionsService;

    /**
     * 查询抽取条件表列表
     */
    @RequiresPermissions("bidding:conditions:list")
    @GetMapping("/list")
    public TableDataInfo list(BiddingExtractionConditions biddingExtractionConditions)
    {
        startPage();
        List<BiddingExtractionConditions> list = biddingExtractionConditionsService.selectBiddingExtractionConditionsList(biddingExtractionConditions);
        return getDataTable(list);
    }

    /**
     * 导出抽取条件表列表
     */
    @RequiresPermissions("bidding:conditions:export")
    @Log(title = "抽取条件表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BiddingExtractionConditions biddingExtractionConditions)
    {
        List<BiddingExtractionConditions> list = biddingExtractionConditionsService.selectBiddingExtractionConditionsList(biddingExtractionConditions);
        ExcelUtil<BiddingExtractionConditions> util = new ExcelUtil<BiddingExtractionConditions>(BiddingExtractionConditions.class);
        util.exportExcel(response, list, "抽取条件表数据");
    }

    /**
     * 获取抽取条件表详细信息
     */
    @RequiresPermissions("bidding:conditions:query")
    @GetMapping(value = "/{extractionConditionsId}")
    public AjaxResult getInfo(@PathVariable("extractionConditionsId") Long extractionConditionsId)
    {
        return success(biddingExtractionConditionsService.selectBiddingExtractionConditionsByExtractionConditionsId(extractionConditionsId));
    }

    /**
     * 新增抽取条件表
     */
    @RequiresPermissions("bidding:conditions:add")
    @Log(title = "抽取条件表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BiddingExtractionConditions biddingExtractionConditions)
    {
        return toAjax(biddingExtractionConditionsService.insertBiddingExtractionConditions(biddingExtractionConditions));
    }

    /**
     * 修改抽取条件表
     */
    @RequiresPermissions("bidding:conditions:edit")
    @Log(title = "抽取条件表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BiddingExtractionConditions biddingExtractionConditions)
    {
        return toAjax(biddingExtractionConditionsService.updateBiddingExtractionConditions(biddingExtractionConditions));
    }

    /**
     * 删除抽取条件表
     */
    @RequiresPermissions("bidding:conditions:remove")
    @Log(title = "抽取条件表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{extractionConditionsIds}")
    public AjaxResult remove(@PathVariable Long[] extractionConditionsIds)
    {
        return toAjax(biddingExtractionConditionsService.deleteBiddingExtractionConditionsByExtractionConditionsIds(extractionConditionsIds));
    }
}
