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
import com.yz.bidding.domain.BiddingTender;
import com.yz.bidding.service.IBiddingTenderService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 投标Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/tender")
public class BiddingTenderController extends BaseController
{
    @Autowired
    private IBiddingTenderService biddingTenderService;

    /**
     * 查询投标列表
     */
    @RequiresPermissions("pms/bidding:tender:list")
    @GetMapping("/list")
    public TableDataInfo list(BiddingTender biddingTender)
    {
        startPage();
        List<BiddingTender> list = biddingTenderService.selectBiddingTenderList(biddingTender);
        return getDataTable(list);
    }

    /**
     * 导出投标列表
     */
    @RequiresPermissions("pms/bidding:tender:export")
    @Log(title = "投标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BiddingTender biddingTender)
    {
        List<BiddingTender> list = biddingTenderService.selectBiddingTenderList(biddingTender);
        ExcelUtil<BiddingTender> util = new ExcelUtil<BiddingTender>(BiddingTender.class);
        util.exportExcel(response, list, "投标数据");
    }

    /**
     * 获取投标详细信息
     */
    @RequiresPermissions("pms/bidding:tender:query")
    @GetMapping(value = "/{tenderId}")
    public AjaxResult getInfo(@PathVariable("tenderId") Long tenderId)
    {
        return success(biddingTenderService.selectBiddingTenderByTenderId(tenderId));
    }

    /**
     * 新增投标
     */
    @RequiresPermissions("pms/bidding:tender:add")
    @Log(title = "投标", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BiddingTender biddingTender)
    {
        return toAjax(biddingTenderService.insertBiddingTender(biddingTender));
    }

    /**
     * 修改投标
     */
    @RequiresPermissions("pms/bidding:tender:edit")
    @Log(title = "投标", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BiddingTender biddingTender)
    {
        return toAjax(biddingTenderService.updateBiddingTender(biddingTender));
    }

    /**
     * 删除投标
     */
    @RequiresPermissions("pms/bidding:tender:remove")
    @Log(title = "投标", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tenderIds}")
    public AjaxResult remove(@PathVariable Long[] tenderIds)
    {
        return toAjax(biddingTenderService.deleteBiddingTenderByTenderIds(tenderIds));
    }
}
