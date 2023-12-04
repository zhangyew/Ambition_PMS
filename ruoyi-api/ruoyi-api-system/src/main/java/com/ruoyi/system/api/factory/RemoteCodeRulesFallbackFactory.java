package com.ruoyi.system.api.factory;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.system.api.RemoteCodeRulesService;
import com.ruoyi.system.api.RemoteUserService;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 日志服务降级处理
 *
 * @author ruoyi
 */
@Component
public class RemoteCodeRulesFallbackFactory implements FallbackFactory<RemoteCodeRulesService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteCodeRulesService.class);

    @Override
    public RemoteCodeRulesService create(Throwable throwable) {
        log.error("获取编码规则详细信息调用失败:{}", throwable.getMessage());
        return new RemoteCodeRulesService() {
            @Override
            public AjaxResult getInfo(Long codeRulesId) {
                return AjaxResult.error("获取编码规则详细信息调用失败:" + throwable.getMessage());

            }
        };
    }
}
