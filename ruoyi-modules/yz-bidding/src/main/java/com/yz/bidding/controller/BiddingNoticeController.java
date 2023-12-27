package com.yz.bidding.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONUtil;
import com.ruoyi.system.api.domain.PublicAnnex;
import com.yz.bidding.domain.BiddingTender;
import com.yz.bidding.service.IPublicAnnexService;
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
import com.yz.bidding.domain.BiddingNotice;
import com.yz.bidding.service.IBiddingNoticeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 中标公告Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/notice")
public class BiddingNoticeController extends BaseController {
    @Autowired
    private IBiddingNoticeService biddingNoticeService;
    @Autowired
    private IPublicAnnexService publicAnnexService;


    /**
     * 查询供应商公告信息
     *
     * @param id
     * @return
     */
    @PostMapping("/findNotice")
    public List<Map<String, Object>> findNotice(String vid) {
        return biddingNoticeService.findNotice(vid);
    }

    /**
     * 查找项目下需要发送招标通知的集合
     *
     * @param id
     * @return
     */
    @PostMapping("/findNoticeTenderById")
    public List<Map<String, Object>> findNoticeTenderById(String id) {
        return biddingNoticeService.findNoticeTenderById(id);
    }

    /**
     * 查询项目下的中标结果公示
     *
     * @param id
     * @return
     */
    @PostMapping("/findNoticeAllById")
    public List<BiddingNotice> findNoticeAllById(String id) {
        return biddingNoticeService.findNoticeAllById(id);
    }

    /**
     * 添加中标公告
     *
     * @param notice
     * @return
     */
    @PostMapping("/updateNotice")
    public int updateNotice(String notice) {
        List<BiddingNotice> biddingNotice = JSONUtil.toList(notice, BiddingNotice.class);
        return biddingNoticeService.updateNotice(biddingNotice);
    }

    /**
     * 添加中标公告
     *
     * @param notice
     * @return
     */
    @PostMapping("/addNotice")
    public int addNotice(String notice) {
        List<BiddingTender> biddingNotice = JSONUtil.toList(notice, BiddingTender.class);
        return biddingNoticeService.addNotice(biddingNotice);
    }

    /**
     * 查询中标公告列表
     */
    @RequiresPermissions("pms2/bidding:notice:list")
    @GetMapping("/list")
    public TableDataInfo list(BiddingNotice biddingNotice) {
        List<PublicAnnex> l = publicAnnexService.selectPublicAnnexList(null);
        System.out.println(l.size());
        startPage();
        List<BiddingNotice> list = biddingNoticeService.selectBiddingNoticeList(biddingNotice);
        return getDataTable(list);
    }

    @RequiresPermissions("pms2/bidding:notice:list")
    @GetMapping("/selAll")
    public TableDataInfo selAll() {
        List<BiddingNotice> list = biddingNoticeService.selAll();
        return getDataTable(list);
    }

    /**
     * 导出中标公告列表
     */
    @RequiresPermissions("pms2/bidding:notice:export")
    @Log(title = "中标公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BiddingNotice biddingNotice) {
        List<BiddingNotice> list = biddingNoticeService.selectBiddingNoticeList(biddingNotice);
        ExcelUtil<BiddingNotice> util = new ExcelUtil<BiddingNotice>(BiddingNotice.class);
        util.exportExcel(response, list, "中标公告数据");
    }

    /**
     * 获取中标公告详细信息
     */
    @RequiresPermissions("pms2/bidding:notice:query")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable("noticeId") Long noticeId) {
        return success(biddingNoticeService.selectBiddingNoticeByNoticeId(noticeId));
    }

    /**
     * 新增中标公告
     */
    @RequiresPermissions("pms2/bidding:notice:add")
    @Log(title = "中标公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BiddingNotice biddingNotice) {
        return toAjax(biddingNoticeService.insertBiddingNotice(biddingNotice));
    }

    /**
     * 修改中标公告
     */
    @RequiresPermissions("pms2/bidding:notice:edit")
    @Log(title = "中标公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BiddingNotice biddingNotice) {
        return toAjax(biddingNoticeService.updateBiddingNotice(biddingNotice));
    }

    /**
     * 删除中标公告
     */
    @RequiresPermissions("pms2/bidding:notice:remove")
    @Log(title = "中标公告", businessType = BusinessType.DELETE)
    @DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds) {
        return toAjax(biddingNoticeService.deleteBiddingNoticeByNoticeIds(noticeIds));
    }
}
