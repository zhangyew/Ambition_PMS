package com.yz.bidding.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONUtil;
import com.ruoyi.system.api.domain.*;
import org.apache.ibatis.annotations.Param;
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
public class BiddingTenderController extends BaseController {
    @Autowired
    private IBiddingTenderService biddingTenderService;

    @PostMapping("/updateStateByTenderId")
    public int updateStateByTenderId(BiddingTender biddingTender) {
        return biddingTenderService.updateStateByTenderId(biddingTender);
    }
    @GetMapping("/TenderSum")
    public Integer TenderSum()
    {
        return biddingTenderService.TenderSum();
    }
    /**
     * 评标操作
     *
     * @param tender
     * @param ax
     * @return
     */
    @PostMapping("/bidEvaluation")
    public int bidEvaluation(String tender, String ax) {
        List<BiddingTender> tender1 = JSONUtil.toList(tender, BiddingTender.class);
        List<PublicAnnex> list = null;
        if (ax != null) {
            list = JSONUtil.toList(ax, PublicAnnex.class);
        }
        return biddingTenderService.bidEvaluation(tender1, list);
    }


    /**
     * 查找该项目下状态为初审通过的投标信息
     *
     * @param id
     * @return
     */
    @PostMapping("/findTendersStateByProjectsId")
    public TableDataInfo findTendersStateByProjectsId(String id) {
        startPage();
        List<BiddingTender> list = biddingTenderService.findTendersStateByProjectsId(id);
        System.out.println(list);
        return getDataTable(list);
    }


    /**
     * 根据项目Id和状态查询投标信息
     *
     * @param pid
     * @param zt
     * @return
     */
    @PostMapping("/findTendersByProjectsId")
    public TableDataInfo findTendersByProjectsId(String pid, String zt, String sid) {
        startPage();
        List<BiddingTender> list = biddingTenderService.findTendersByProjectsId(pid, zt, sid);
        System.out.println(list);
        return getDataTable(list);
    }

    /**
     * 查询投标列表
     */
//    @RequiresPermissions("pms/bidding:tender:list")
    @GetMapping("/list")
    public TableDataInfo list(BiddingTender biddingTender) {
        startPage();
        List<BiddingTender> list = biddingTenderService.selectBiddingTenderList(biddingTender);
        return getDataTable(list);
    }
    @GetMapping("/selBidCount")
    public Integer selBidCount(Long tnId,Long tsId) {
        return biddingTenderService.selBidCount(tnId,tsId);
    }

    /**
     * 导出投标列表
     */
//    @RequiresPermissions("pms/bidding:tender:export")
    @Log(title = "投标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BiddingTender biddingTender) {
        List<BiddingTender> list = biddingTenderService.selectBiddingTenderList(biddingTender);
        ExcelUtil<BiddingTender> util = new ExcelUtil<BiddingTender>(BiddingTender.class);
        util.exportExcel(response, list, "投标数据");
    }

    /**
     * 获取投标详细信息
     */
//    @RequiresPermissions("pms/bidding:tender:query")
    @GetMapping(value = "/{tenderId}")
    public AjaxResult getInfo(@PathVariable("tenderId") Long tenderId) {
        return success(biddingTenderService.selectBiddingTenderByTenderId(tenderId));
    }

    /**
     * 新增投标
     */
//    @RequiresPermissions("bidding/public:tender:add")
//    @Log(title = "投标", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody BiddingTender biddingTender) {
//        return toAjax(biddingTenderService.insertBiddingTender(biddingTender));
//    }
//    @RequiresPermissions("bidding/public:tender:add")
    @Log(title = "投标", businessType = BusinessType.INSERT)
    @PostMapping("/addTenders")
    public int addAgreements(BiddingTender biddingTender,String json5){

        List<PublicAnnex> publicAnnex=JSONUtil.toList(json5,PublicAnnex.class);

        return biddingTenderService.insertBiddingTender(biddingTender,publicAnnex);
    }

    /**
     * 修改投标
     */
//    @RequiresPermissions("pms/bidding:tender:edit")
    @Log(title = "投标", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BiddingTender biddingTender) {
        return toAjax(biddingTenderService.updateBiddingTender(biddingTender));
    }

    /**
     * 删除投标
     */
//    @RequiresPermissions("pms/bidding:tender:remove")
    @Log(title = "投标", businessType = BusinessType.DELETE)
    @DeleteMapping("/{tenderIds}")
    public AjaxResult remove(@PathVariable Long[] tenderIds) {
        return toAjax(biddingTenderService.deleteBiddingTenderByTenderIds(tenderIds));
    }
}
