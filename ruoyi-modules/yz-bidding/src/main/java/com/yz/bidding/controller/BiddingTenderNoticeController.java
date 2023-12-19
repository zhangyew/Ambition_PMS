package com.yz.bidding.controller;

import java.util.List;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONUtil;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.RemoteFileService;
import com.ruoyi.system.api.domain.PublicAnnex;
import com.ruoyi.system.api.domain.SysFile;
import com.yz.bidding.domain.BiddingNotice;
import com.yz.bidding.service.IBiddingNoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.yz.bidding.domain.BiddingTenderNotice;
import com.yz.bidding.service.IBiddingTenderNoticeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 招标公告Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/tender_notice")
public class BiddingTenderNoticeController extends BaseController {
    @Autowired
    private IBiddingTenderNoticeService biddingTenderNoticeService;
    @Autowired
    private IBiddingNoticeService biddingNoticeService;

    @Resource
    private RemoteFileService remoteFileService;

    @PostMapping(value = "/addTenderNotice")
    public int addTenderNotice(String tenderNotice, String fileUrl) {
        BiddingTenderNotice bt = JSONUtil.toBean(tenderNotice, BiddingTenderNotice.class);
        List<PublicAnnex> list = JSONUtil.toList(fileUrl, PublicAnnex.class);
        System.out.println(bt);
        System.out.println(list);
        return biddingTenderNoticeService.addTenderNotice(bt,list);
    }


    @PostMapping("/uploadFiles")
    public R<SysFile> uploadFiles(MultipartFile file) {
        System.out.println(file);
        return remoteFileService.upload(file);
    }


    @PostMapping("/findNoticeById")
    public AjaxResult findNoticeById(String pid, String tid) {
        return success(biddingTenderNoticeService.findNoticeById(pid, tid));
    }

    /**
     * 修改公告状态
     *
     * @param id
     * @param zt
     * @return
     */
    @PostMapping("/updateStates")
    public int updateStates(String id, String zt) {
        return biddingTenderNoticeService.updateState(id, zt);
    }

    /**
     * 查询招标公告列表
     */
    @RequiresPermissions("pms/bidding:tender_notice:list")
    @GetMapping("/list")
    public TableDataInfo list(BiddingTenderNotice biddingTenderNotice) {
        startPage();
        List<BiddingTenderNotice> list = biddingTenderNoticeService.selectBiddingTenderNoticeList(biddingTenderNotice);
        return getDataTable(list);
    }

    /**
     * 供应商首页（招投标信息显示）
     */
    @RequiresPermissions("bidding/public:tender_notice:ShowsTenderNoticeList")
    @GetMapping("/ShowsTenderNoticeList")
    public TableDataInfo ShowsTenderNoticeList() {
        List<BiddingTenderNotice> list = biddingTenderNoticeService.ShowsTenderNoticeList();
        return getDataTable(list);
    }

    @RequiresPermissions("bidding/public:tender_notice:showsNoticeList")
    @GetMapping("/showsNoticeList")
    public TableDataInfo showsNoticeList() {
        List<BiddingNotice> list = biddingNoticeService.showsNoticeList();
        return getDataTable(list);
    }

    /**
     * 供应商首页（通知公告）
     */
    @RequiresPermissions("bidding/public:tender_notice:displayTenderNoticeList")
    @GetMapping("/displayTenderNoticeList")
    public TableDataInfo displayTenderNoticeList() {
        List<BiddingTenderNotice> list = biddingTenderNoticeService.displayTenderNoticeList();
        return getDataTable(list);
    }



    /**
     * 导出招标公告列表
     */
    @RequiresPermissions("pms/bidding:tender_notice:export")
    @Log(title = "招标公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BiddingTenderNotice biddingTenderNotice) {
        List<BiddingTenderNotice> list = biddingTenderNoticeService.selectBiddingTenderNoticeList(biddingTenderNotice);
        ExcelUtil<BiddingTenderNotice> util = new ExcelUtil<BiddingTenderNotice>(BiddingTenderNotice.class);
        util.exportExcel(response, list, "招标公告数据");
    }

    /**
     * 获取招标公告详细信息
     */
    @RequiresPermissions("pms/bidding:tender_notice:query")
    @GetMapping(value = "/{tenderNoticeId}")
    public AjaxResult getInfo(@PathVariable("tenderNoticeId") Long tenderNoticeId) {
        return success(biddingTenderNoticeService.selectBiddingTenderNoticeByTenderNoticeId(tenderNoticeId));
    }

    /**
     * 新增招标公告
     */
    @RequiresPermissions("pms/bidding:tender_notice:add")
    @Log(title = "招标公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BiddingTenderNotice biddingTenderNotice) {
        return toAjax(biddingTenderNoticeService.insertBiddingTenderNotice(biddingTenderNotice));
    }

    /**
     * 修改招标公告
     */
    @RequiresPermissions("pms/bidding:tender_notice:edit")
    @Log(title = "招标公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BiddingTenderNotice biddingTenderNotice) {
        return toAjax(biddingTenderNoticeService.updateBiddingTenderNotice(biddingTenderNotice));
    }

    /**
     * 删除招标公告
     */
    @RequiresPermissions("pms/bidding:tender_notice:remove")
    @Log(title = "招标公告", businessType = BusinessType.DELETE)
    @DeleteMapping("/{tenderNoticeIds}")
    public AjaxResult remove(@PathVariable Long[] tenderNoticeIds) {
        return toAjax(biddingTenderNoticeService.deleteBiddingTenderNoticeByTenderNoticeIds(tenderNoticeIds));
    }
}
