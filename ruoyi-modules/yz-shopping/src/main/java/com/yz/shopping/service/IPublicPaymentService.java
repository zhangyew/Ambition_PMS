package com.yz.shopping.service;

import java.util.List;
import com.ruoyi.system.api.domain.PublicPayment;

/**
 * 合同付款Service接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface IPublicPaymentService 
{
    /**
     * 查询合同付款
     * 
     * @param paymentId 合同付款主键
     * @return 合同付款
     */
    public PublicPayment selectPublicPaymentByPaymentId(Long paymentId);

    /**
     * 查询合同付款列表
     * 
     * @param publicPayment 合同付款
     * @return 合同付款集合
     */
    public List<PublicPayment> selectPublicPaymentList(PublicPayment publicPayment);

    /**
     * 新增合同付款
     * 
     * @param publicPayment 合同付款
     * @return 结果
     */
    public int insertPublicPayment(PublicPayment publicPayment);

    /**
     * 修改合同付款
     * 
     * @param publicPayment 合同付款
     * @return 结果
     */
    public int updatePublicPayment(PublicPayment publicPayment);

    /**
     * 批量删除合同付款
     * 
     * @param paymentIds 需要删除的合同付款主键集合
     * @return 结果
     */
    public int deletePublicPaymentByPaymentIds(Long[] paymentIds);

    /**
     * 删除合同付款信息
     * 
     * @param paymentId 合同付款主键
     * @return 结果
     */
    public int deletePublicPaymentByPaymentId(Long paymentId);
}
