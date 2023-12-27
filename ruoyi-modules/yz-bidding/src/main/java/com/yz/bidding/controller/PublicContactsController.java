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
import com.ruoyi.system.api.domain.PublicContacts;
import com.yz.bidding.service.IPublicContactsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 供应商联系人Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/contacts")
public class PublicContactsController extends BaseController {
    @Autowired
    private IPublicContactsService publicContactsService;

    /**
     * 查找供应商所有联系人
     *
     * @param vid
     * @return
     */
    @PostMapping("/findVendorContactById")
    public List<PublicContacts> findVendorContactById(String vid) {
        return publicContactsService.findVendorContactById(vid);
    }

    /**
     * 查询供应商联系人列表
     */
    @RequiresPermissions("pms.public:contacts:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicContacts publicContacts) {
        startPage();
        List<PublicContacts> list = publicContactsService.selectPublicContactsList(publicContacts);
        return getDataTable(list);
    }

    /**
     * 导出供应商联系人列表
     */
    @RequiresPermissions("pms.public:contacts:export")
    @Log(title = "供应商联系人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicContacts publicContacts) {
        List<PublicContacts> list = publicContactsService.selectPublicContactsList(publicContacts);
        ExcelUtil<PublicContacts> util = new ExcelUtil<PublicContacts>(PublicContacts.class);
        util.exportExcel(response, list, "供应商联系人数据");
    }

    /**
     * 获取供应商联系人详细信息
     */
    @RequiresPermissions("pms.public:contacts:query")
    @GetMapping(value = "/{contactsId}")
    public AjaxResult getInfo(@PathVariable("contactsId") Long contactsId) {
        return success(publicContactsService.selectPublicContactsByContactsId(contactsId));
    }

    /**
     * 新增供应商联系人
     */
    @RequiresPermissions("pms.public:contacts:add")
    @Log(title = "供应商联系人", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicContacts publicContacts) {
        return toAjax(publicContactsService.insertPublicContacts(publicContacts));
    }

    /**
     * 修改供应商联系人
     */
    @RequiresPermissions("pms.public:contacts:edit")
    @Log(title = "供应商联系人", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicContacts publicContacts) {
        return toAjax(publicContactsService.updatePublicContacts(publicContacts));
    }

    /**
     * 删除供应商联系人
     */
    @RequiresPermissions("pms.public:contacts:remove")
    @Log(title = "供应商联系人", businessType = BusinessType.DELETE)
    @DeleteMapping("/{contactsIds}")
    public AjaxResult remove(@PathVariable Long[] contactsIds) {
        return toAjax(publicContactsService.deletePublicContactsByContactsIds(contactsIds));
    }
}
