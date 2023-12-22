package com.yz.bidding.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONUtil;
import com.ruoyi.system.api.domain.PublicExpert;
import com.yz.bidding.domain.BiddingExtractionConditions;
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
import com.yz.bidding.domain.BiddingDrawExperts;
import com.yz.bidding.service.IBiddingDrawExpertsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 抽取专家Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/draw_experts")
public class BiddingDrawExpertsController extends BaseController {
    @Autowired
    private IBiddingDrawExpertsService biddingDrawExpertsService;


    /**
     * 抽取专家操作
     * @param data
     * @param tj
     * @param zj
     * @return
     */
    @PostMapping("/addDrawExperts")
    public int addDrawExperts(String data, String tj, String zj) {
        BiddingDrawExperts drawExperts = JSONUtil.toBean(data, BiddingDrawExperts.class);
        List<BiddingExtractionConditions> conditions = JSONUtil.toList(tj, BiddingExtractionConditions.class);
        List<PublicExpert> experts = JSONUtil.toList(zj, PublicExpert.class);

        return biddingDrawExpertsService.addDrawExperts(drawExperts,conditions,experts);
    }


    /**
     * 查询抽取专家列表
     */
    @RequiresPermissions("pms/bidding:draw_experts:list")
    @GetMapping("/list")
    public TableDataInfo list(BiddingDrawExperts biddingDrawExperts) {
        startPage();
        List<BiddingDrawExperts> list = biddingDrawExpertsService.selectBiddingDrawExpertsList(biddingDrawExperts);
        return getDataTable(list);
    }

    /**
     * 导出抽取专家列表
     */
    @RequiresPermissions("pms/bidding:draw_experts:export")
    @Log(title = "抽取专家", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BiddingDrawExperts biddingDrawExperts) {
        List<BiddingDrawExperts> list = biddingDrawExpertsService.selectBiddingDrawExpertsList(biddingDrawExperts);
        ExcelUtil<BiddingDrawExperts> util = new ExcelUtil<BiddingDrawExperts>(BiddingDrawExperts.class);
        util.exportExcel(response, list, "抽取专家数据");
    }

    /**
     * 获取抽取专家详细信息
     */
    @RequiresPermissions("pms/bidding:draw_experts:query")
    @GetMapping(value = "/{drawExpertsId}")
    public AjaxResult getInfo(@PathVariable("drawExpertsId") Long drawExpertsId) {
        return success(biddingDrawExpertsService.selectBiddingDrawExpertsByDrawExpertsId(drawExpertsId));
    }

    /**
     * 新增抽取专家
     */
    @RequiresPermissions("pms/bidding:draw_experts:add")
    @Log(title = "抽取专家", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BiddingDrawExperts biddingDrawExperts) {
        return toAjax(biddingDrawExpertsService.insertBiddingDrawExperts(biddingDrawExperts));
    }

    /**
     * 修改抽取专家
     */
    @RequiresPermissions("pms/bidding:draw_experts:edit")
    @Log(title = "抽取专家", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BiddingDrawExperts biddingDrawExperts) {
        return toAjax(biddingDrawExpertsService.updateBiddingDrawExperts(biddingDrawExperts));
    }

    /**
     * 删除抽取专家
     */
    @RequiresPermissions("pms/bidding:draw_experts:remove")
    @Log(title = "抽取专家", businessType = BusinessType.DELETE)
    @DeleteMapping("/{drawExpertsIds}")
    public AjaxResult remove(@PathVariable Long[] drawExpertsIds) {
        return toAjax(biddingDrawExpertsService.deleteBiddingDrawExpertsByDrawExpertsIds(drawExpertsIds));
    }
}
