package com.yz.shopping.controller;

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
import com.ruoyi.system.api.domain.PublicUser;
import com.yz.shopping.service.IPublicUserService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 用户表Controller
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/user")
public class PublicUserController extends BaseController
{
    @Autowired
    private IPublicUserService publicUserService;

    /**
     * 查询用户表列表
     */
    @RequiresPermissions("pms.public:user:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicUser publicUser)
    {
        startPage();
        List<PublicUser> list = publicUserService.selectPublicUserList(publicUser);
        return getDataTable(list);
    }

    /**
     * 导出用户表列表
     */
    @RequiresPermissions("pms.public:user:export")
    @Log(title = "用户表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicUser publicUser)
    {
        List<PublicUser> list = publicUserService.selectPublicUserList(publicUser);
        ExcelUtil<PublicUser> util = new ExcelUtil<PublicUser>(PublicUser.class);
        util.exportExcel(response, list, "用户表数据");
    }

    /**
     * 获取用户表详细信息
     */
    @RequiresPermissions("pms.public:user:query")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(publicUserService.selectPublicUserByUserId(userId));
    }

    /**
     * 新增用户表
     */
    @RequiresPermissions("pms.public:user:add")
    @Log(title = "用户表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicUser publicUser)
    {
        return toAjax(publicUserService.insertPublicUser(publicUser));
    }

    /**
     * 修改用户表
     */
    @RequiresPermissions("pms.public:user:edit")
    @Log(title = "用户表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicUser publicUser)
    {
        return toAjax(publicUserService.updatePublicUser(publicUser));
    }

    /**
     * 删除用户表
     */
    @RequiresPermissions("pms.public:user:remove")
    @Log(title = "用户表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(publicUserService.deletePublicUserByUserIds(userIds));
    }
}
