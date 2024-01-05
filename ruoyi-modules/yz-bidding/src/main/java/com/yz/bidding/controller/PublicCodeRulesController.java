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
import com.ruoyi.system.api.domain.PublicCodeRules;
import com.yz.bidding.service.IPublicCodeRulesService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 编码规则Controller
 * 
 * @author zhangye
 * @date 2023-11-22
 */
@RestController
@RequestMapping("/rules")
public class PublicCodeRulesController extends BaseController
{
    @Autowired
    private IPublicCodeRulesService publicCodeRulesService;

    /**
     * 查询编码规则列表
     */
    @RequiresPermissions("bidding/rules:rules:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicCodeRules publicCodeRules)
    {
        startPage();
        List<PublicCodeRules> list = publicCodeRulesService.selectPublicCodeRulesList(publicCodeRules);
        return getDataTable(list);
    }

    /**
     * 导出编码规则列表
     */
    @RequiresPermissions("bidding/rules:rules:export")
    @Log(title = "编码规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicCodeRules publicCodeRules)
    {
        List<PublicCodeRules> list = publicCodeRulesService.selectPublicCodeRulesList(publicCodeRules);
        ExcelUtil<PublicCodeRules> util = new ExcelUtil<PublicCodeRules>(PublicCodeRules.class);
        util.exportExcel(response, list, "编码规则数据");
    }

    /**
     * 获取编码规则详细信息
     */
    @RequiresPermissions("bidding/rules:rules:query")
    @GetMapping(value = "/{codeRulesId}")
    public AjaxResult getInfo(@PathVariable("codeRulesId") Long codeRulesId)
    {
        return success(publicCodeRulesService.selectPublicCodeRulesByCodeRulesId(codeRulesId));
    }

    /**
     * 新增编码规则
     */
    @RequiresPermissions("bidding/rules:rules:add")
    @Log(title = "编码规则", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicCodeRules publicCodeRules)
    {
        return toAjax(publicCodeRulesService.insertPublicCodeRules(publicCodeRules));
    }

    /**
     * 修改编码规则
     */
    @RequiresPermissions("bidding/rules:rules:edit")
    @Log(title = "编码规则", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicCodeRules publicCodeRules)
    {
        return toAjax(publicCodeRulesService.updatePublicCodeRules(publicCodeRules));
    }

    /**
     * 删除编码规则
     */
    @RequiresPermissions("bidding/rules:rules:remove")
    @Log(title = "编码规则", businessType = BusinessType.DELETE)
	@DeleteMapping("/{codeRulesIds}")
    public AjaxResult remove(@PathVariable Long[] codeRulesIds)
    {
        return toAjax(publicCodeRulesService.deletePublicCodeRulesByCodeRulesIds(codeRulesIds));
    }
}
