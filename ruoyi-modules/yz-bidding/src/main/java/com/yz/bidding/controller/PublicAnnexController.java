package com.yz.bidding.controller;

import java.util.List;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;


import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.system.api.RemoteFileService;
import com.ruoyi.system.api.domain.SysFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.system.api.domain.PublicAnnex;
import com.yz.bidding.service.IPublicAnnexService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公告附件Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/annex")
public class PublicAnnexController extends BaseController {
    @Autowired
    private IPublicAnnexService publicAnnexService;
    @Autowired
    private RemoteFileService remoteFileService;


    /**
     * 根据招标项目查找附件集合
     *
     * @param pid
     * @return
     */
    @PostMapping("/findAnnexByTenderProjectsId")
    public TableDataInfo findAnnexByTenderProjectsId(String pid) {
        startPage();
        List<Map<String, Object>> list = publicAnnexService.findAnnexByTenderProjectsId(pid);
        return getDataTable(list);
    }

    /**
     * 订单id查询所有附件
     *
     * @param oid
     * @return
     */
    @GetMapping("/findAnnexByOrder")
    public List<PublicAnnex> findAnnexByOrder(Long oid) {
        List<PublicAnnex> list = publicAnnexService.findAnnexByOrder(oid);
        return list;
    }

    /**
     * 查询公告附件列表
     */
    @RequiresPermissions("pms.public:annex:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicAnnex publicAnnex) {
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
    public void export(HttpServletResponse response, PublicAnnex publicAnnex) {
        List<PublicAnnex> list = publicAnnexService.selectPublicAnnexList(publicAnnex);
        ExcelUtil<PublicAnnex> util = new ExcelUtil<PublicAnnex>(PublicAnnex.class);
        util.exportExcel(response, list, "公告附件数据");
    }

    /**
     * 获取公告附件详细信息
     */
    @RequiresPermissions("pms.public:annex:query")
    @GetMapping(value = "/{annexId}")
    public AjaxResult getInfo(@PathVariable("annexId") Long annexId) {
        return success(publicAnnexService.selectPublicAnnexByAnnexId(annexId));
    }

    /**
     * 新增公告附件
     */
    @RequiresPermissions("pms.public:annex:add")
    @Log(title = "公告附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicAnnex publicAnnex) {
        return toAjax(publicAnnexService.insertPublicAnnex(publicAnnex));
    }

//    /**
//     * 缩略图上传
//     */
//    @Log(title = "预览缩略图", businessType = BusinessType.UPDATE)
//    @PostMapping("/articleImg")
//    public AjaxResult uploadFile(MultipartFile file) throws IOException
//    {
//        if (!file.isEmpty())
//        {
//            R<SysFile> articleImg = remoteFileService.upload(file);
//            if (!StringUtils.isEmpty(articleImg.toString()))
//            {
//                AjaxResult ajax = AjaxResult.success();
//                ajax.put("url", articleImg);
//                return ajax;
//            }
//        }
//        return AjaxResult.error("上传图片异常，请联系管理员");
//    }

    /**
     * 只有文件上传
     */
    @PostMapping("/articleImg")
    public R<SysFile> uploadFile(MultipartFile file) {
        System.out.println(file);
        return remoteFileService.upload(file);
    }

    /**
     * 修改公告附件
     */
    @RequiresPermissions("pms.public:annex:edit")
    @Log(title = "公告附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicAnnex publicAnnex) {
        return toAjax(publicAnnexService.updatePublicAnnex(publicAnnex));
    }

    /**
     * 删除公告附件
     */
    @Log(title = "公告附件", businessType = BusinessType.DELETE)
    @DeleteMapping("/{annexIds}")
    public AjaxResult remove(@PathVariable Long[] annexIds) {
        return toAjax(publicAnnexService.deletePublicAnnexByAnnexIds(annexIds));
    }

}
