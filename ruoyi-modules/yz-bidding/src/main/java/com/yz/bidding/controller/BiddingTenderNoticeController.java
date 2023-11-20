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
import com.yz.bidding.domain.BiddingTenderNotice;
import com.yz.bidding.service.IBiddingTenderNoticeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 招标公告Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/tender_notice")
public class BiddingTenderNoticeController extends BaseController
{
    @Autowired
    private IBiddingTenderNoticeService biddingTenderNoticeService;

    /**
     * 查询招标公告列表
     */
    @RequiresPermissions("pms/bidding:tender_notice:list")
    @GetMapping("/list")
    public TableDataInfo list(BiddingTenderNotice biddingTenderNotice)
    {
        startPage();
        List<BiddingTenderNotice> list = biddingTenderNoticeService.selectBiddingTenderNoticeList(biddingTenderNotice);
        return getDataTable(list);
    }

    /**
     * 导出招标公告列表
     */
    @RequiresPermissions("pms/bidding:tender_notice:export")
    @Log(title = "招标公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BiddingTenderNotice biddingTenderNotice)
    {
        List<BiddingTenderNotice> list = biddingTenderNoticeService.selectBiddingTenderNoticeList(biddingTenderNotice);
        ExcelUtil<BiddingTenderNotice> util = new ExcelUtil<BiddingTenderNotice>(BiddingTenderNotice.class);
        util.exportExcel(response, list, "招标公告数据");
    }

    /**
     * 获取招标公告详细信息
     */
    @RequiresPermissions("pms/bidding:tender_notice:query")
    @GetMapping(value = "/{tenderNoticeId}")
    public AjaxResult getInfo(@PathVariable("tenderNoticeId") Long tenderNoticeId)
    {
        return success(biddingTenderNoticeService.selectBiddingTenderNoticeByTenderNoticeId(tenderNoticeId));
    }

    /**
     * 新增招标公告
     */
    @RequiresPermissions("pms/bidding:tender_notice:add")
    @Log(title = "招标公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BiddingTenderNotice biddingTenderNotice)
    {
        return toAjax(biddingTenderNoticeService.insertBiddingTenderNotice(biddingTenderNotice));
    }

    /**
     * 修改招标公告
     */
    @RequiresPermissions("pms/bidding:tender_notice:edit")
    @Log(title = "招标公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BiddingTenderNotice biddingTenderNotice)
    {
        return toAjax(biddingTenderNoticeService.updateBiddingTenderNotice(biddingTenderNotice));
    }

    /**
     * 删除招标公告
     */
    @RequiresPermissions("pms/bidding:tender_notice:remove")
    @Log(title = "招标公告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tenderNoticeIds}")
    public AjaxResult remove(@PathVariable Long[] tenderNoticeIds)
    {
        return toAjax(biddingTenderNoticeService.deleteBiddingTenderNoticeByTenderNoticeIds(tenderNoticeIds));
    }
}
