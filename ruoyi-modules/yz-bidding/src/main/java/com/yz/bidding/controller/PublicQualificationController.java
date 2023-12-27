package com.yz.bidding.controller;

import java.util.List;
import java.io.IOException;
import java.util.Map;
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
import com.ruoyi.system.api.domain.PublicQualification;
import com.yz.bidding.service.IPublicQualificationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 供应商资质Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/qualification")
public class PublicQualificationController extends BaseController {
    @Autowired
    private IPublicQualificationService publicQualificationService;


    /**
     * 查询供应商证件及文件
     *
     * @param vid
     * @return
     */
    @PostMapping("/findQualificationAnnexByVendorId")
    public List<Map<String, Object>> findQualificationAnnexByVendorId(String vid) {
        return publicQualificationService.findQualificationAnnexByVendorId(vid);
    }

    /**
     * 查询供应商资质列表
     */
    @RequiresPermissions("pms.public:qualification:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicQualification publicQualification) {
        startPage();
        List<PublicQualification> list = publicQualificationService.selectPublicQualificationList(publicQualification);
        return getDataTable(list);
    }

    /**
     * 导出供应商资质列表
     */
    @RequiresPermissions("pms.public:qualification:export")
    @Log(title = "供应商资质", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicQualification publicQualification) {
        List<PublicQualification> list = publicQualificationService.selectPublicQualificationList(publicQualification);
        ExcelUtil<PublicQualification> util = new ExcelUtil<PublicQualification>(PublicQualification.class);
        util.exportExcel(response, list, "供应商资质数据");
    }

    /**
     * 获取供应商资质详细信息
     */
    @RequiresPermissions("pms.public:qualification:query")
    @GetMapping(value = "/{qualificationId}")
    public AjaxResult getInfo(@PathVariable("qualificationId") Long qualificationId) {
        return success(publicQualificationService.selectPublicQualificationByQualificationId(qualificationId));
    }

    /**
     * 新增供应商资质
     */
    @RequiresPermissions("pms.public:qualification:add")
    @Log(title = "供应商资质", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicQualification publicQualification) {
        return toAjax(publicQualificationService.insertPublicQualification(publicQualification));
    }

    /**
     * 修改供应商资质
     */
    @RequiresPermissions("pms.public:qualification:edit")
    @Log(title = "供应商资质", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicQualification publicQualification) {
        return toAjax(publicQualificationService.updatePublicQualification(publicQualification));
    }

    /**
     * 删除供应商资质
     */
    @RequiresPermissions("pms.public:qualification:remove")
    @Log(title = "供应商资质", businessType = BusinessType.DELETE)
    @DeleteMapping("/{qualificationIds}")
    public AjaxResult remove(@PathVariable Long[] qualificationIds) {
        return toAjax(publicQualificationService.deletePublicQualificationByQualificationIds(qualificationIds));
    }
}
