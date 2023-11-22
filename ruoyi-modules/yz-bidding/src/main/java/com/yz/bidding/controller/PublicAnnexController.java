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
import com.ruoyi.system.api.domain.PublicAnnex;
import com.yz.bidding.service.IPublicAnnexService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 公告附件Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/annex")
public class PublicAnnexController extends BaseController
{
    @Autowired
    private IPublicAnnexService publicAnnexService;

    /**
     * 查询公告附件列表
     */
    @RequiresPermissions("pms.public:annex:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicAnnex publicAnnex)
    {
        startPage();
        List<PublicAnnex> list = publicAnnexService.selectPublicAnnexList(publicAnnex);
        return getDataTable(list);
    }

    /**
     * 导出公告附件列表
     */
    @RequiresPermissions("pms.public:annex:export")
    @Log(title = "公告附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicAnnex publicAnnex)
    {
        List<PublicAnnex> list = publicAnnexService.selectPublicAnnexList(publicAnnex);
        ExcelUtil<PublicAnnex> util = new ExcelUtil<PublicAnnex>(PublicAnnex.class);
        util.exportExcel(response, list, "公告附件数据");
    }

    /**
     * 获取公告附件详细信息
     */
    @RequiresPermissions("pms.public:annex:query")
    @GetMapping(value = "/{annexId}")
    public AjaxResult getInfo(@PathVariable("annexId") Long annexId)
    {
        return success(publicAnnexService.selectPublicAnnexByAnnexId(annexId));
    }

    /**
     * 新增公告附件
     */
    @RequiresPermissions("pms.public:annex:add")
    @Log(title = "公告附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicAnnex publicAnnex)
    {
        return toAjax(publicAnnexService.insertPublicAnnex(publicAnnex));
    }

    /**
     * 修改公告附件
     */
    @RequiresPermissions("pms.public:annex:edit")
    @Log(title = "公告附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicAnnex publicAnnex)
    {
        return toAjax(publicAnnexService.updatePublicAnnex(publicAnnex));
    }

    /**
     * 删除公告附件
     */
    @RequiresPermissions("pms.public:annex:remove")
    @Log(title = "公告附件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{annexIds}")
    public AjaxResult remove(@PathVariable Long[] annexIds)
    {
        return toAjax(publicAnnexService.deletePublicAnnexByAnnexIds(annexIds));
    }
}