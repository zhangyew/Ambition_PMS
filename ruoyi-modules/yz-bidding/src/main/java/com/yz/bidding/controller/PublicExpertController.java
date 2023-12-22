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
import com.ruoyi.system.api.domain.PublicExpert;
import com.yz.bidding.service.IPublicExpertService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 专家Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/expert")
public class PublicExpertController extends BaseController {
    @Autowired
    private IPublicExpertService publicExpertService;


    @PostMapping("/findExpertList")
    public TableDataInfo findExpertList(String name, String poolId) {
        startPage();
        List<PublicExpert> list = publicExpertService.findExpertList(name, poolId);
        return getDataTable(list);
    }

    /**
     * 查询专家列表
     */
    @RequiresPermissions("pms.public:expert:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicExpert publicExpert) {
        startPage();
        List<PublicExpert> list = publicExpertService.selectPublicExpertList(publicExpert);
        return getDataTable(list);
    }

    /**
     * 导出专家列表
     */
    @RequiresPermissions("pms.public:expert:export")
    @Log(title = "专家", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicExpert publicExpert) {
        List<PublicExpert> list = publicExpertService.selectPublicExpertList(publicExpert);
        ExcelUtil<PublicExpert> util = new ExcelUtil<PublicExpert>(PublicExpert.class);
        util.exportExcel(response, list, "专家数据");
    }

    /**
     * 获取专家详细信息
     */
    @RequiresPermissions("pms.public:expert:query")
    @GetMapping(value = "/{expertId}")
    public AjaxResult getInfo(@PathVariable("expertId") Long expertId) {
        return success(publicExpertService.selectPublicExpertByExpertId(expertId));
    }

    /**
     * 新增专家
     */
    @RequiresPermissions("pms.public:expert:add")
    @Log(title = "专家", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicExpert publicExpert) {
        return toAjax(publicExpertService.insertPublicExpert(publicExpert));
    }

    /**
     * 修改专家
     */
    @RequiresPermissions("pms.public:expert:edit")
    @Log(title = "专家", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicExpert publicExpert) {
        return toAjax(publicExpertService.updatePublicExpert(publicExpert));
    }

    /**
     * 删除专家
     */
    @RequiresPermissions("pms.public:expert:remove")
    @Log(title = "专家", businessType = BusinessType.DELETE)
    @DeleteMapping("/{expertIds}")
    public AjaxResult remove(@PathVariable Long[] expertIds) {
        return toAjax(publicExpertService.deletePublicExpertByExpertIds(expertIds));
    }
}
