package com.yz.bidding.controller;

import java.util.List;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.api.RemoteCodeRulesService;
import com.ruoyi.system.api.domain.*;
import com.ruoyi.system.api.util.SnowflakeGetId;
import com.yz.bidding.service.IPublicSigningsService;
import com.yz.bidding.service.IPublicVendorService;
import com.yz.bidding.vo.PurchaseContractsVo;
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
import com.yz.bidding.service.IPublicContractdetailsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 合同明细Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/contractdetails")
public class PublicContractdetailsController extends BaseController
{
    @Autowired
    private IPublicContractdetailsService publicContractdetailsService;
    @Autowired
    private IPublicVendorService publicVendorService;
    @Autowired
    private RemoteCodeRulesService remoteCodeRulesService;
    @Autowired
    private IPublicSigningsService publicSigningsService;


    /**
     * 查询合同所有列表
     */
    @GetMapping("/list")
    public TableDataInfo list(PublicContractdetails publicContractdetails)
    {
        startPage();
        List<PublicContractdetails> list = publicContractdetailsService.selectPublicContractdetailsList(publicContractdetails);
        return getDataTable(list);
    }

    /**
     * 供应商合同所有列表
     */
    @RequiresPermissions("bidding/public:contractdetails:list")
    @GetMapping("/selectVendorList")
    public TableDataInfo selectVendorList(Long vendorId)
    {
        startPage();
        List<PublicContractdetails> list = publicContractdetailsService.selectVendorList(vendorId);
        return getDataTable(list);
    }

    /**
     * 显示所有供应商
     * @param
     * @return
     */
    @GetMapping("/showsPublicVendorList")
    public TableDataInfo ShowsPublicVendorList(Long vendor_id)
    {
        startPage();
        List<PublicVendor> list = publicVendorService.showsPublicVendorList(vendor_id);
        return getDataTable(list);
    }

    /**
     * 导出合同明细列表
     */
    @RequiresPermissions("bidding/public:contractdetails:export")
    @Log(title = "合同明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicContractdetails publicContractdetails)
    {
        List<PublicContractdetails> list = publicContractdetailsService.selectPublicContractdetailsList(publicContractdetails);
        ExcelUtil<PublicContractdetails> util = new ExcelUtil<PublicContractdetails>(PublicContractdetails.class);
        util.exportExcel(response, list, "合同明细数据");
    }

    /**
     * 供应商首页（我的合同）
     */
//    @RequiresPermissions("bidding/public:contractdetails:VendorContractId")
    @GetMapping("/VendorContractId")
    public TableDataInfo VendorContractId(Long vendorId)
    {
        List<PublicContractdetails> list = publicContractdetailsService.VendorContractId(vendorId);
        return getDataTable(list);
    }


    /**
     * 采购合同详情信息
     */
    @GetMapping(value = "/{contractdetailsId}")
    public AjaxResult getInfo(@PathVariable("contractdetailsId") Long contractdetailsId)
    {
        return success(publicContractdetailsService.selectContractDetailsId(contractdetailsId));
    }

    //修改状态
    @GetMapping("/upConState/{conId}")
    public AjaxResult upConState(@PathVariable Long conId) {
        return toAjax(publicContractdetailsService.upConState(conId));
    }

    //状态5已完成
    @GetMapping("/upCon/{conId}")
    public AjaxResult upCon(@PathVariable Long conId){
        return toAjax(publicContractdetailsService.upCon(conId));
    }
    /**
     * 获取合同明细详细信息
     */
    @RequiresPermissions("pms.public:contractdetails:query")
    @GetMapping(value = "Shows/{contractdetailsId}")
    public AjaxResult Shows(@PathVariable("contractdetailsId") Long contractdetailsId)
    {
        return success(publicContractdetailsService.selectPublicContractdetailsByContractdetailsId(contractdetailsId));
    }

    /**
     * 新增合同明细
     */
    @RequiresPermissions("bidding/public:contractdetails:add")
    @Log(title = "合同明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody PublicContractdetails publicContractdetails)
    {
        AjaxResult ajaxResult = remoteCodeRulesService.getInfo(10L);
        Object obj = ajaxResult.get("data");
        String str = JSON.toJSONString(obj);
        PublicCodeRules p = JSONObject.parseObject(str,PublicCodeRules.class);
        String id = SnowflakeGetId.getCode(p);
        publicContractdetails.setContractdetailsNumber(id);
        return toAjax(publicContractdetailsService.insertPublicContractdetails(publicContractdetails));
    }
    /**
     * 新增签署执行状态表
     */
    @RequiresPermissions("bidding/public:contractdetails:signingAdd")
    @Log(title = "签署执行状态表", businessType = BusinessType.INSERT)
    @PostMapping("/signingAdd")
    public AjaxResult signingAdd(@RequestBody PublicSignings publicSignings)
    {
        return toAjax(publicSigningsService.insertPublicSignings(publicSignings));
    }

    /**
     * 合同总金额
     * @return
     */
//    @RequiresPermissions("bidding/public:contractdetails:ContractCount")
    @GetMapping("/ContractCount")
    public Integer ContractCount()
    {
        return  publicContractdetailsService.ContractCount();
    }

    /**
     * 合同总金额
     * @return
     */
//    @RequiresPermissions("bidding/public:contractdetails:ContractSum")
    @GetMapping("/ContractSum")
    public Double ContractSum()
    {
        return publicContractdetailsService.ContractSum();
    }
    /**
     * 合同总金额
     * @return
     */
//    @RequiresPermissions("bidding/public:contractdetails:ContractCounts")
    @GetMapping("/ContractCounts")
    public Integer ContractCounts(Long vendorId)
    {
        return  publicContractdetailsService.ContractCounts(vendorId);
    }
    /**
     * 合同总金额
     * @return
     */
//    @RequiresPermissions("bidding/public:contractdetails:ContractSums")
    @GetMapping("/ContractSums")
    public Double ContractSums(Long vendorId)
    {
        return publicContractdetailsService.ContractSums(vendorId);
    }


    /**
     * 修改合同明细
     */
//    @RequiresPermissions("bidding/public:contractdetails:edit")
    @Log(title = "合同明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicContractdetails publicContractdetails)
    {
        return toAjax(publicContractdetailsService.updatePublicContractdetails(publicContractdetails));
    }

    /**
     * 删除合同明细
     */
    @RequiresPermissions("bidding/public:contractdetails:remove")
    @Log(title = "合同明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{contractdetailsIds}")
    public AjaxResult remove(@PathVariable Long[] contractdetailsIds)
    {
        return toAjax(publicContractdetailsService.deletePublicContractdetailsByContractdetailsIds(contractdetailsIds));
    }
}
