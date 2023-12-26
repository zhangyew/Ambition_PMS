package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.system.api.domain.PublicPayment;
import com.ruoyi.system.api.factory.RemotePaymentFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 付款服务
 * 
 * @author ruoyi
 */
@FeignClient(contextId = "RemotePaymentService", value = ServiceNameConstants.SHOPPING_SERVICE, fallbackFactory = RemotePaymentFallbackFactory.class)
public interface RemotePaymentService
{

    /**
     * 新增合同付款付款项
     */
    @PostMapping(value = "/payment/")
    public PublicPayment insertPublicPayment(@RequestBody PublicPayment publicPayment);


}
