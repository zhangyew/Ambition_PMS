package com.ruoyi.system.api.factory;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.system.api.RemoteCodeRulesService;
import com.ruoyi.system.api.RemotePublicAnnexService;
import com.ruoyi.system.api.domain.PublicAnnex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 日志服务降级处理
 *
 * @author ruoyi
 */
@Component
public class RemotePublicAnnexFallbackFactory implements FallbackFactory<RemotePublicAnnexService> {
    private static final Logger log = LoggerFactory.getLogger(RemotePublicAnnexService.class);

    @Override
    public RemotePublicAnnexService create(Throwable throwable) {
        log.error("获取编码规则详细信息调用失败:{}", throwable.getMessage());
        return new RemotePublicAnnexService() {
            @Override
            public AjaxResult add(PublicAnnex publicAnnex) {
                return AjaxResult.error("获取编码规则详细信息调用失败:" + throwable.getMessage());

            }

            @Override
            public List<PublicAnnex> findAnnexByOrder(Long oid) {
                return null;
            }
        };
    }
}
