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
import com.yz.bidding.domain.BiddingTenderManifest;
import com.yz.bidding.service.IBiddingTenderManifestService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 招标项目详情Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/tender_manifest")
public class BiddingTenderManifestController extends BaseController
{
    @Autowired
    private IBiddingTenderManifestService biddingTenderManifestService;

    /**
     * 查询招标项目详情列表
     */
    @RequiresPermissions("pms/bidding:tender_manifest:list")
    @GetMapping("/list")
    public TableDataInfo list(BiddingTenderManifest biddingTenderManifest)
    {
        startPage();
        List<BiddingTenderManifest> list = biddingTenderManifestService.selectBiddingTenderManifestList(biddingTenderManifest);
        return getDataTable(list);
    }

    /**
     * 导出招标项目详情列表
     */
    @RequiresPermissions("pms/bidding:tender_manifest:export")
    @Log(title = "招标项目详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BiddingTenderManifest biddingTenderManifest)
    {
        List<BiddingTenderManifest> list = biddingTenderManifestService.selectBiddingTenderManifestList(biddingTenderManifest);
        ExcelUtil<BiddingTenderManifest> util = new ExcelUtil<BiddingTenderManifest>(BiddingTenderManifest.class);
        util.exportExcel(response, list, "招标项目详情数据");
    }

    /**
     * 获取招标项目详情详细信息
     */
    @RequiresPermissions("pms/bidding:tender_manifest:query")
    @GetMapping(value = "/{tenderManifestId}")
    public AjaxResult getInfo(@PathVariable("tenderManifestId") Long tenderManifestId)
    {
        return success(biddingTenderManifestService.selectBiddingTenderManifestByTenderManifestId(tenderManifestId));
    }

    /**
     * 新增招标项目详情
     */
    @RequiresPermissions("pms/bidding:tender_manifest:add")
    @Log(title = "招标项目详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BiddingTenderManifest biddingTenderManifest)
    {
        return toAjax(biddingTenderManifestService.insertBiddingTenderManifest(biddingTenderManifest));
    }

    /**
     * 修改招标项目详情
     */
    @RequiresPermissions("pms/bidding:tender_manifest:edit")
    @Log(title = "招标项目详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BiddingTenderManifest biddingTenderManifest)
    {
        return toAjax(biddingTenderManifestService.updateBiddingTenderManifest(biddingTenderManifest));
    }

    /**
     * 删除招标项目详情
     */
    @RequiresPermissions("pms/bidding:tender_manifest:remove")
    @Log(title = "招标项目详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tenderManifestIds}")
    public AjaxResult remove(@PathVariable Long[] tenderManifestIds)
    {
        return toAjax(biddingTenderManifestService.deleteBiddingTenderManifestByTenderManifestIds(tenderManifestIds));
    }
}
