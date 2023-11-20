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
import com.ruoyi.system.api.domain.PublicExpertPool;
import com.yz.bidding.service.IPublicExpertPoolService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 专家库Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/expert_pool")
public class PublicExpertPoolController extends BaseController
{
    @Autowired
    private IPublicExpertPoolService publicExpertPoolService;

    /**
     * 查询专家库列表
     */
    @RequiresPermissions("pms.public:expert_pool:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicExpertPool publicExpertPool)
    {
        startPage();
        List<PublicExpertPool> list = publicExpertPoolService.selectPublicExpertPoolList(publicExpertPool);
        return getDataTable(list);
    }

    /**
     * 导出专家库列表
     */
    @RequiresPermissions("pms.public:expert_pool:export")
    @Log(title = "专家库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicExpertPool publicExpertPool)
    {
        List<PublicExpertPool> list = publicExpertPoolService.selectPublicExpertPoolList(publicExpertPool);
        ExcelUtil<PublicExpertPool> util = new ExcelUtil<PublicExpertPool>(PublicExpertPool.class);
        util.exportExcel(response, list, "专家库数据");
    }

    /**
     * 获取专家库详细信息
     */
    @RequiresPermissions("pms.public:expert_pool:query")
    @GetMapping(value = "/{expertPoolId}")
    public AjaxResult getInfo(@PathVariable("expertPoolId") Long expertPoolId)
    {
        return success(publicExpertPoolService.selectPublicExpertPoolByExpertPoolId(expertPoolId));
    }

    /**
     * 新增专家库
     */
    @RequiresPermissions("pms.public:expert_pool:add")
    @Log(title = "专家库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicExpertPool publicExpertPool)
    {
        return toAjax(publicExpertPoolService.insertPublicExpertPool(publicExpertPool));
    }

    /**
     * 修改专家库
     */
    @RequiresPermissions("pms.public:expert_pool:edit")
    @Log(title = "专家库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicExpertPool publicExpertPool)
    {
        return toAjax(publicExpertPoolService.updatePublicExpertPool(publicExpertPool));
    }

    /**
     * 删除专家库
     */
    @RequiresPermissions("pms.public:expert_pool:remove")
    @Log(title = "专家库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{expertPoolIds}")
    public AjaxResult remove(@PathVariable Long[] expertPoolIds)
    {
        return toAjax(publicExpertPoolService.deletePublicExpertPoolByExpertPoolIds(expertPoolIds));
    }
}
