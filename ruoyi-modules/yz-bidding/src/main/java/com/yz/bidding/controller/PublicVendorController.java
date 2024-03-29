package com.yz.bidding.controller;

import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.api.domain.PublicContacts;
import com.ruoyi.system.api.util.MsgManager;
import com.ruoyi.system.api.util.SnowflakeGetId;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.system.api.domain.PublicVendor;
import com.yz.bidding.service.IPublicVendorService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 供应商Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/vendor")
public class PublicVendorController extends BaseController {
    @Autowired
    private IPublicVendorService publicVendorService;


    @PostMapping("/findVendorIdByUserId")
    public PublicVendor findVendorIdByUserId(String id){
        return publicVendorService.findVendorIdByUserId(id);
    }

    /**
     * 修改供应商注册状态
     *
     * @param id
     * @param zt
     * @return
     */
    @PostMapping("/updateStates")
    public int updateStates(String id, String zt) {
        return publicVendorService.updateStates(id, zt);
    }


    @PostMapping("/findVendorDetailed")
    public AjaxResult findVendorDetailed(String vid) {
        PublicVendor publicVendor = publicVendorService.findVendorDetailed(Integer.parseInt(vid));
        System.out.println(publicVendor);
        return success(publicVendor);
    }


    @PostMapping(value = "/insertVendor")
    public int insertVendor(@RequestPart("map") Map<String, String> map) {//, @RequestParam("files") MultipartFile[] files) {
        System.out.println("1111111111");
        System.out.println(map);
        //System.out.println(files);

        return publicVendorService.insertVendor(map);

    }

    /**
     * 根据id查询联系人列表
     *
     * @param vendorId
     * @return
     */
    @PostMapping(value = "/showContactsList")
    public TableDataInfo showContactsList(@RequestParam("vendorId") String vendorId) {
        List<PublicVendor> list = publicVendorService.showContactsList(Long.valueOf(vendorId));
        System.out.println(list);
        return getDataTable(list);
    }

    @GetMapping("/codeVa/{phone}")
    public String codeVa(@PathVariable String phone) {
        return MsgManager.getMsg(phone);
    }

    /**
     * 查询供应商列表
     */
    @RequiresPermissions("bidding/public:vendor:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicVendor publicVendor) {
        startPage();
        List<PublicVendor> list = publicVendorService.selectPublicVendorList(publicVendor);
        return getDataTable(list);
    }
    //供应商数量
    @GetMapping("/VendorSum")
    public Integer VendorSum()
    {
        return publicVendorService.VendorSum();
    }
    @GetMapping("/selCount/{vNumber}")
    public Integer selCount(@PathVariable String vNumber) {
        return publicVendorService.selCount(vNumber);
    }

    @GetMapping("/selRe")
    public Integer selRe(String vNumber, String phone) {

        return publicVendorService.selRe(vNumber, phone);
    }

    /**
     * 修改id
     *
     * @param vNumber
     * @return
     */
    @GetMapping(value = "/updateExist")
    public AjaxResult updateExist(Long uid, String vNumber) {
        System.out.println(uid);
        System.out.println(vNumber);

        return toAjax(publicVendorService.updateExist(uid, vNumber));
    }

    /**
     * 查询供应商列表
     */
    @GetMapping("/showAll")
    public TableDataInfo showAll() {
        List<PublicVendor> list = publicVendorService.showAll();
        return getDataTable(list);
    }

    /**
     * 导出供应商列表
     */
    @RequiresPermissions("bidding/public:vendor:export")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicVendor publicVendor) {
        List<PublicVendor> list = publicVendorService.selectPublicVendorList(publicVendor);
        ExcelUtil<PublicVendor> util = new ExcelUtil<PublicVendor>(PublicVendor.class);
        util.exportExcel(response, list, "供应商数据");
    }

    /**
     * 获取供应商详细信息
     */
    @RequiresPermissions("bidding/public:vendor:query")
    @GetMapping(value = "/{vendorId}")
    public AjaxResult getInfo(@PathVariable("vendorId") Long vendorId) {
        return success(publicVendorService.selectPublicVendorByVendorId(vendorId));
    }

    /**
     * 供应商uid
     * @param uid
     * @return
     */
    @GetMapping(value = "showUid/{uid}")
    public AjaxResult showUid(@PathVariable("uid") Long uid){
        return success(publicVendorService.showUid(uid));
    }

    /**
     * 新增供应商
     */
    @RequiresPermissions("bidding/public:vendor:add")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicVendor publicVendor) {
        System.out.println(publicVendor.toString());
        return toAjax(publicVendorService.insertPublicVendor(publicVendor));
    }

    /**
     * 修改供应商
     */
    @RequiresPermissions("bidding/public:vendor:edit")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicVendor publicVendor) {
        return toAjax(publicVendorService.updatePublicVendor(publicVendor));
    }

    /**
     * 删除供应商
     */
    @RequiresPermissions("bidding/public:vendor:remove")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
    @DeleteMapping("/{vendorIds}")
    public AjaxResult remove(@PathVariable Long[] vendorIds) {
        return toAjax(publicVendorService.deletePublicVendorByVendorIds(vendorIds));
    }
}
