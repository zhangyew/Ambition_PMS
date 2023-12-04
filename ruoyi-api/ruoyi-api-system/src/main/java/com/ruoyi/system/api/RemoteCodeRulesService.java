package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.system.api.domain.SysFile;
import com.ruoyi.system.api.factory.RemoteCodeRulesFallbackFactory;
import com.ruoyi.system.api.factory.RemoteFileFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务
 * 
 * @author ruoyi
 */
@FeignClient(contextId = "RemoteCodeRulesService", value = ServiceNameConstants.BIDDING_SERVICE, fallbackFactory = RemoteCodeRulesFallbackFactory.class)
public interface RemoteCodeRulesService
{

    /**
     * 获取编码规则详细信息
     */
    @GetMapping(value = "/rules/{codeRulesId}")
    public AjaxResult getInfo(@PathVariable("codeRulesId") Long codeRulesId);
}
