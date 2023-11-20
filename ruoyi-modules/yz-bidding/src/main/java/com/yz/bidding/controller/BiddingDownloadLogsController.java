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
import com.yz.bidding.domain.BiddingDownloadLogs;
import com.yz.bidding.service.IBiddingDownloadLogsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 标书下载记录表Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/download_logs")
public class BiddingDownloadLogsController extends BaseController
{
    @Autowired
    private IBiddingDownloadLogsService biddingDownloadLogsService;

    /**
     * 查询标书下载记录表列表
     */
    @RequiresPermissions("pms/bidding:download_logs:list")
    @GetMapping("/list")
    public TableDataInfo list(BiddingDownloadLogs biddingDownloadLogs)
    {
        startPage();
        List<BiddingDownloadLogs> list = biddingDownloadLogsService.selectBiddingDownloadLogsList(biddingDownloadLogs);
        return getDataTable(list);
    }

    /**
     * 导出标书下载记录表列表
     */
    @RequiresPermissions("pms/bidding:download_logs:export")
    @Log(title = "标书下载记录表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BiddingDownloadLogs biddingDownloadLogs)
    {
        List<BiddingDownloadLogs> list = biddingDownloadLogsService.selectBiddingDownloadLogsList(biddingDownloadLogs);
        ExcelUtil<BiddingDownloadLogs> util = new ExcelUtil<BiddingDownloadLogs>(BiddingDownloadLogs.class);
        util.exportExcel(response, list, "标书下载记录表数据");
    }

    /**
     * 获取标书下载记录表详细信息
     */
    @RequiresPermissions("pms/bidding:download_logs:query")
    @GetMapping(value = "/{downloadLogsId}")
    public AjaxResult getInfo(@PathVariable("downloadLogsId") Long downloadLogsId)
    {
        return success(biddingDownloadLogsService.selectBiddingDownloadLogsByDownloadLogsId(downloadLogsId));
    }

    /**
     * 新增标书下载记录表
     */
    @RequiresPermissions("pms/bidding:download_logs:add")
    @Log(title = "标书下载记录表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BiddingDownloadLogs biddingDownloadLogs)
    {
        return toAjax(biddingDownloadLogsService.insertBiddingDownloadLogs(biddingDownloadLogs));
    }

    /**
     * 修改标书下载记录表
     */
    @RequiresPermissions("pms/bidding:download_logs:edit")
    @Log(title = "标书下载记录表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BiddingDownloadLogs biddingDownloadLogs)
    {
        return toAjax(biddingDownloadLogsService.updateBiddingDownloadLogs(biddingDownloadLogs));
    }

    /**
     * 删除标书下载记录表
     */
    @RequiresPermissions("pms/bidding:download_logs:remove")
    @Log(title = "标书下载记录表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{downloadLogsIds}")
    public AjaxResult remove(@PathVariable Long[] downloadLogsIds)
    {
        return toAjax(biddingDownloadLogsService.deleteBiddingDownloadLogsByDownloadLogsIds(downloadLogsIds));
    }
}
