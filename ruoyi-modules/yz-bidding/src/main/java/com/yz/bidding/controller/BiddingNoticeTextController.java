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
import com.yz.bidding.domain.BiddingNoticeText;
import com.yz.bidding.service.IBiddingNoticeTextService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 招标公告正文Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/notice_text")
public class BiddingNoticeTextController extends BaseController
{
    @Autowired
    private IBiddingNoticeTextService biddingNoticeTextService;

    /**
     * 查询招标公告正文列表
     */
    @RequiresPermissions("pms/bidding:notice_text:list")
    @GetMapping("/list")
    public TableDataInfo list(BiddingNoticeText biddingNoticeText)
    {
        startPage();
        List<BiddingNoticeText> list = biddingNoticeTextService.selectBiddingNoticeTextList(biddingNoticeText);
        return getDataTable(list);
    }

    /**
     * 导出招标公告正文列表
     */
    @RequiresPermissions("pms/bidding:notice_text:export")
    @Log(title = "招标公告正文", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BiddingNoticeText biddingNoticeText)
    {
        List<BiddingNoticeText> list = biddingNoticeTextService.selectBiddingNoticeTextList(biddingNoticeText);
        ExcelUtil<BiddingNoticeText> util = new ExcelUtil<BiddingNoticeText>(BiddingNoticeText.class);
        util.exportExcel(response, list, "招标公告正文数据");
    }

    /**
     * 获取招标公告正文详细信息
     */
    @RequiresPermissions("pms/bidding:notice_text:query")
    @GetMapping(value = "/{noticeTextId}")
    public AjaxResult getInfo(@PathVariable("noticeTextId") Long noticeTextId)
    {
        return success(biddingNoticeTextService.selectBiddingNoticeTextByNoticeTextId(noticeTextId));
    }

    /**
     * 新增招标公告正文
     */
    @RequiresPermissions("pms/bidding:notice_text:add")
    @Log(title = "招标公告正文", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BiddingNoticeText biddingNoticeText)
    {
        return toAjax(biddingNoticeTextService.insertBiddingNoticeText(biddingNoticeText));
    }

    /**
     * 修改招标公告正文
     */
    @RequiresPermissions("pms/bidding:notice_text:edit")
    @Log(title = "招标公告正文", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BiddingNoticeText biddingNoticeText)
    {
        return toAjax(biddingNoticeTextService.updateBiddingNoticeText(biddingNoticeText));
    }

    /**
     * 删除招标公告正文
     */
    @RequiresPermissions("pms/bidding:notice_text:remove")
    @Log(title = "招标公告正文", businessType = BusinessType.DELETE)
	@DeleteMapping("/{noticeTextIds}")
    public AjaxResult remove(@PathVariable Long[] noticeTextIds)
    {
        return toAjax(biddingNoticeTextService.deleteBiddingNoticeTextByNoticeTextIds(noticeTextIds));
    }
}
