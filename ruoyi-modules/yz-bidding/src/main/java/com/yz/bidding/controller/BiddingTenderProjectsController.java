package com.yz.bidding.controller;

import java.util.List;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONUtil;
import com.yz.bidding.domain.BiddingTenderManifest;
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
import com.yz.bidding.domain.BiddingTenderProjects;
import com.yz.bidding.service.IBiddingTenderProjectsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 招标项目Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/tender_projects")
public class BiddingTenderProjectsController extends BaseController {
    @Autowired
    private IBiddingTenderProjectsService biddingTenderProjectsService;

    @PostMapping("/updateStates")
    public int updateStates(String id, String zt) {
        return biddingTenderProjectsService.updateStates(id, zt);
    }

    @PostMapping("/findProjectById")
    public AjaxResult findProjectById(String id) {
        return success(biddingTenderProjectsService.findProjectById(id));
    }

    @PostMapping("/insertProjects")
    public int insertProjects(String projects, String manifest) {
        BiddingTenderProjects tenderProjects = JSONUtil.toBean(projects, BiddingTenderProjects.class);
        List<BiddingTenderManifest> list = JSONUtil.toList(manifest, BiddingTenderManifest.class);
        return biddingTenderProjectsService.insertProjects(tenderProjects, list);
    }

    /**
     * 查询招标项目列表
     */
    @RequiresPermissions("bidding/tender_projects:list")
    @GetMapping("/list")
    public TableDataInfo list(BiddingTenderProjects biddingTenderProjects) {
        startPage();
        List<BiddingTenderProjects> list = biddingTenderProjectsService.selectBiddingTenderProjectsList(biddingTenderProjects);
        return getDataTable(list);
    }

    /**
     * 导出招标项目列表
     */
    @RequiresPermissions("bidding/tender_projects:export")
    @Log(title = "招标项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BiddingTenderProjects biddingTenderProjects) {
        List<BiddingTenderProjects> list = biddingTenderProjectsService.selectBiddingTenderProjectsList(biddingTenderProjects);
        ExcelUtil<BiddingTenderProjects> util = new ExcelUtil<BiddingTenderProjects>(BiddingTenderProjects.class);
        util.exportExcel(response, list, "招标项目数据");
    }

    /**
     * 获取招标项目详细信息
     */
    @RequiresPermissions("bidding/tender_projects:query")
    @GetMapping(value = "/{tenderProjectsId}")
    public AjaxResult getInfo(@PathVariable("tenderProjectsId") Long tenderProjectsId) {
        return success(biddingTenderProjectsService.selectBiddingTenderProjectsByTenderProjectsId(tenderProjectsId));
    }

    /**
     * 合同签订物料信息
     */
//    @RequiresPermissions("bidding/public:contractdetails:query")
    @GetMapping("/SHowsProjectRelatedItems")
    public TableDataInfo SHowsProjectRelatedItems(Long tenderProjectsId, Long noticeSupplierId) {
        List<BiddingTenderProjects> list = biddingTenderProjectsService.SHowsProjectRelatedItems(tenderProjectsId, noticeSupplierId);
        return getDataTable(list);
    }
    @GetMapping("/ProSum")
    public Integer ProSum()
    {
        return biddingTenderProjectsService.ProSum();
    }

    /**
     * 投标单物料信息
     */
//    @RequiresPermissions("bidding/tender_projects:list")
    @GetMapping("/deskShows")
    public TableDataInfo deskShows(Long tenderNoticeId ,Long tenderProjectsId, Long vendorId) {
        System.out.println("显示："+tenderNoticeId+tenderProjectsId+vendorId);
        List<BiddingTenderProjects> list = biddingTenderProjectsService.deskShows(tenderNoticeId,tenderProjectsId, vendorId);
        return getDataTable(list);
    }
    /**
     * 合同签订根据项目显示供应商选择供应商
     */
    @RequiresPermissions("bidding/public:tender:query")
    @GetMapping("/htShowVendorId")
    public TableDataInfo htShowVendorId(Long tenderProjectsId) {
        List<Map<String,Object>> list = biddingTenderProjectsService.htShowVendorId(tenderProjectsId);
        return getDataTable(list);
    }

    /**
     * 新增招标项目
     */
    @RequiresPermissions("bidding/tender_projects:add")
    @Log(title = "招标项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BiddingTenderProjects biddingTenderProjects) {
        return toAjax(biddingTenderProjectsService.insertBiddingTenderProjects(biddingTenderProjects));
    }

    /**
     * 修改招标项目
     */
    @RequiresPermissions("bidding/tender_projects:edit")
    @Log(title = "招标项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BiddingTenderProjects biddingTenderProjects) {
        return toAjax(biddingTenderProjectsService.updateBiddingTenderProjects(biddingTenderProjects));
    }

    /**
     * 删除招标项目
     */
    @RequiresPermissions("bidding/tender_projects:remove")
    @Log(title = "招标项目", businessType = BusinessType.DELETE)
    @DeleteMapping("/{tenderProjectsIds}")
    public AjaxResult remove(@PathVariable Long[] tenderProjectsIds) {
        return toAjax(biddingTenderProjectsService.deleteBiddingTenderProjectsByTenderProjectsIds(tenderProjectsIds));
    }
}
