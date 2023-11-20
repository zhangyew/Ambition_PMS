package com.yz.shopping.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.PublicPaymentMapper;
import com.ruoyi.system.api.domain.PublicPayment;
import com.yz.shopping.service.IPublicPaymentService;

/**
 * 合同付款Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicPaymentServiceImpl implements IPublicPaymentService 
{
    @Autowired
    private PublicPaymentMapper publicPaymentMapper;

    /**
     * 查询合同付款
     * 
     * @param paymentId 合同付款主键
     * @return 合同付款
     */
    @Override
    public PublicPayment selectPublicPaymentByPaymentId(Long paymentId)
    {
        return publicPaymentMapper.selectPublicPaymentByPaymentId(paymentId);
    }

    /**
     * 查询合同付款列表
     * 
     * @param publicPayment 合同付款
     * @return 合同付款
     */
    @Override
    public List<PublicPayment> selectPublicPaymentList(PublicPayment publicPayment)
    {
        return publicPaymentMapper.selectPublicPaymentList(publicPayment);
    }

    /**
     * 新增合同付款
     * 
     * @param publicPayment 合同付款
     * @return 结果
     */
    @Override
    public int insertPublicPayment(PublicPayment publicPayment)
    {
        publicPayment.setCreateTime(DateUtils.getNowDate());
        return publicPaymentMapper.insertPublicPayment(publicPayment);
    }

    /**
     * 修改合同付款
     * 
     * @param publicPayment 合同付款
     * @return 结果
     */
    @Override
    public int updatePublicPayment(PublicPayment publicPayment)
    {
        publicPayment.setUpdateTime(DateUtils.getNowDate());
        return publicPaymentMapper.updatePublicPayment(publicPayment);
    }

    /**
     * 批量删除合同付款
     * 
     * @param paymentIds 需要删除的合同付款主键
     * @return 结果
     */
    @Override
    public int deletePublicPaymentByPaymentIds(Long[] paymentIds)
    {
        return publicPaymentMapper.deletePublicPaymentByPaymentIds(paymentIds);
    }

    /**
     * 删除合同付款信息
     * 
     * @param paymentId 合同付款主键
     * @return 结果
     */
    @Override
    public int deletePublicPaymentByPaymentId(Long paymentId)
    {
        return publicPaymentMapper.deletePublicPaymentByPaymentId(paymentId);
    }
}
