package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.system.api.domain.PublicAnnex;
import com.ruoyi.system.api.factory.RemoteCodeRulesFallbackFactory;
import com.ruoyi.system.api.factory.RemotePublicAnnexFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文件服务
 *
 * @author ruoyi
 */
@FeignClient(contextId = "RemotePublicAnnexService", value = ServiceNameConstants.BIDDING_SERVICE, fallbackFactory = RemotePublicAnnexFallbackFactory.class)
public interface RemotePublicAnnexService {

    /**
     * 获取编码规则详细信息
     */
    @PostMapping(value = "/annex")
    public AjaxResult add(@RequestBody PublicAnnex publicAnnex);

    /**
     * 订单id查询所有附件
     *
     * @param oid
     * @return
     */
    @GetMapping("/annex/findAnnexByOrder")
    public List<PublicAnnex> findAnnexByOrder(@RequestParam("oid") Long oid);
}
