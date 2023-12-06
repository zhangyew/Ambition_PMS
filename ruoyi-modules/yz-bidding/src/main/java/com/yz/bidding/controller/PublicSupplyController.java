package com.yz.bidding.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONUtil;
import com.ruoyi.system.api.domain.PublicSuppliedMaterials;
import io.swagger.models.auth.In;
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
import com.ruoyi.system.api.domain.PublicSupply;
import com.yz.bidding.service.IPublicSupplyService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 供应商供货表Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/supply")
public class PublicSupplyController extends BaseController {
    @Autowired
    private IPublicSupplyService publicSupplyService;


    @PostMapping(value = "/insertSupping")
    public int insertSupping(String publicSupply, String publicSuppliedMaterials) {
        PublicSupply publicSupply1 = JSONUtil.toBean(publicSupply, PublicSupply.class);
        List<PublicSuppliedMaterials> list = JSONUtil.toList(publicSuppliedMaterials, PublicSuppliedMaterials.class);
        return publicSupplyService.insertSupping(publicSupply1, list);
    }

    @PostMapping("/findSupplyById")
    public AjaxResult findSupplyById(Integer id) {
        return success(publicSupplyService.findSupplyById(id.toString()));
    }

    /**
     * 查询供应商供货表列表
     */
    @RequiresPermissions("pms.public:supply:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicSupply publicSupply) {
        startPage();
        List<PublicSupply> list = publicSupplyService.selectPublicSupplyList(publicSupply);
        return getDataTable(list);
    }

    /**
     * 导出供应商供货表列表
     */
    @RequiresPermissions("pms.public:supply:export")
    @Log(title = "供应商供货表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicSupply publicSupply) {
        List<PublicSupply> list = publicSupplyService.selectPublicSupplyList(publicSupply);
        ExcelUtil<PublicSupply> util = new ExcelUtil<PublicSupply>(PublicSupply.class);
        util.exportExcel(response, list, "供应商供货表数据");
    }

    /**
     * 获取供应商供货表详细信息
     */
    @RequiresPermissions("pms.public:supply:query")
    @GetMapping(value = "/{supplyId}")
    public AjaxResult getInfo(@PathVariable("supplyId") Long supplyId) {
        return success(publicSupplyService.selectPublicSupplyBySupplyId(supplyId));
    }

    /**
     * 新增供应商供货表
     */
    @RequiresPermissions("pms.public:supply:add")
    @Log(title = "供应商供货表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicSupply publicSupply) {
        return toAjax(publicSupplyService.insertPublicSupply(publicSupply));
    }

    /**
     * 修改供应商供货表
     */
    @RequiresPermissions("pms.public:supply:edit")
    @Log(title = "供应商供货表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicSupply publicSupply) {
        return toAjax(publicSupplyService.updatePublicSupply(publicSupply));
    }

    /**
     * 删除供应商供货表
     */
    @RequiresPermissions("pms.public:supply:remove")
    @Log(title = "供应商供货表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{supplyIds}")
    public AjaxResult remove(@PathVariable Long[] supplyIds) {
        return toAjax(publicSupplyService.deletePublicSupplyBySupplyIds(supplyIds));
    }
}
