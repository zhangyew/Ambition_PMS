package com.yz.shopping.controller;

import java.util.List;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.api.RemoteCodeRulesService;
import com.ruoyi.system.api.domain.PublicCodeRules;
import com.ruoyi.system.api.util.SnowflakeGetId;
import com.yz.shopping.service.IPublicCategoryService;
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
import com.ruoyi.system.api.domain.PublicGoods;
import com.yz.shopping.service.IPublicGoodsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 物料Controller
 *
 * @author zhangye
 * @date 2023-11-21
 */
@RestController
@RequestMapping("/goods")
public class PublicGoodsController extends BaseController {
    @Autowired
    private IPublicGoodsService publicGoodsService;

    @Autowired
    private IPublicCategoryService publicCategoryService;

    @Autowired
    private RemoteCodeRulesService remoteCodeRulesService;

//    @Resource
//    private SnowflakeGetId snowflakeGetId;

    /**
     * 物料组件查询列表
     *
     * @param mc  物料名称
     * @param fl  物料分类
     * @param gys 供应商名称
     * @return 物料集合
     */
    @PostMapping("/findGoodsList")
    public TableDataInfo findGoodsList(String mc, String fl, String gys) {
        startPage();
        List<PublicGoods> list = publicGoodsService.findGoodsList(mc, fl, gys);
        return getDataTable(list);
    }

    /**
     * 查询物料列表
     */
    @RequiresPermissions("shopping/public:goods:list")
    @GetMapping("/list")
    public TableDataInfo list(PublicGoods publicGoods) {
        startPage();
        List<PublicGoods> list = publicGoodsService.selectPublicGoodsList(publicGoods);
        return getDataTable(list);
    }

    /**
     * 导出物料列表
     */
    @RequiresPermissions("shopping/public:goods:export")
    @Log(title = "物料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PublicGoods publicGoods) {
        List<PublicGoods> list = publicGoodsService.selectPublicGoodsList(publicGoods);
        ExcelUtil<PublicGoods> util = new ExcelUtil<PublicGoods>(PublicGoods.class);
        util.exportExcel(response, list, "物料数据");
    }

    /**
     * 获取物料详细信息
     */
    @RequiresPermissions("shopping/public:goods:query")
    @GetMapping(value = "/{goodsId}")
    public AjaxResult getInfo(@PathVariable("goodsId") Long goodsId) {
        return success(publicGoodsService.selectPublicGoodsByGoodsId(goodsId));
    }

    /**
     * 新增物料
     */
    @RequiresPermissions("shopping/public:goods:add")
    @Log(title = "物料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicGoods publicGoods) {
        AjaxResult ajaxResult = remoteCodeRulesService.getInfo(2L);
        Object obj = ajaxResult.get("data");
        String str = JSON.toJSONString(obj);
        PublicCodeRules p = JSONObject.parseObject(str, PublicCodeRules.class);
//        String id = SnowflakeGetId.getCode(p);
        publicGoods.setGoodsCode(SnowflakeGetId.getCode(p));
        return toAjax(publicGoodsService.insertPublicGoods(publicGoods));
    }

    /**
     * 修改物料
     */
    @RequiresPermissions("shopping/public:goods:edit")
    @Log(title = "物料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicGoods publicGoods) {
        return toAjax(publicGoodsService.updatePublicGoods(publicGoods));
    }

    /**
     * 删除物料
     */
    @RequiresPermissions("shopping/public:goods:remove")
    @Log(title = "物料", businessType = BusinessType.DELETE)
    @DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable Long[] goodsIds) {
        return toAjax(publicGoodsService.deletePublicGoodsByGoodsIds(goodsIds));
    }

    /**
     * |
     * 查询一级分类
     *
     * @return
     */
    @GetMapping("/findCategoryList")
    public AjaxResult selOne() {
        return success(publicCategoryService.selectTwoByOne());
    }
}
