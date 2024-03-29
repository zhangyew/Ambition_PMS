package com.ruoyi.system.api.factory;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.system.api.RemotePaymentService;
import com.ruoyi.system.api.domain.PublicPayment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.ResponseEntity;

public class RemotePaymentFallbackFactory implements FallbackFactory<RemotePaymentService> {
    private static final Logger log = LoggerFactory.getLogger(RemotePaymentService.class);

    @Override
    public RemotePaymentService create(Throwable throwable) {
        log.error("获取新增信息调用失败:{}", throwable.getMessage());
        return new RemotePaymentService() {
            @Override
            public PublicPayment insertPublicPayment(PublicPayment publicPayment) {
                System.out.println("服务出错");
                return publicPayment;
            }
        };
    }
}
