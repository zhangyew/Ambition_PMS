package com.yz.bidding.service;

import java.util.List;

import com.ruoyi.system.api.domain.*;

/**
 * 合同Service接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface IPublicAgreementService
{
    /**
     * 显示使用的合同(合同签订)
     * @param contractParent
     * @return
     */
    public List<PublicAgreement> ShowPublicAgreement(Long contractParent);

    /**
     * 查询合同申请表列表
     *
     * @param publicAgreement 合同申请表
     * @return 合同申请表集合
     */
    public List<PublicAgreement> selectPublicAgreementList(PublicAgreement publicAgreement);

    /**
     * 新增合同申请表
     *
     * @param publicAgreement 合同申请表
     * @return 结果
     */
    public int insertPublicAgreement(PublicAgreement publicAgreement, PublicContractdetails publicContractdetails, PublicSignings publicSignings, List<PublicPayment> publicPayment, List<PublicAnnex> publicAnnex);

    /**
     * 修改合同申请表
     *
     * @param publicAgreement 合同申请表
     * @return 结果
     */
    public int updatePublicAgreement(PublicAgreement publicAgreement);

    /**
     * 批量删除合同申请表
     *
     * @param contractIds 需要删除的合同申请表主键集合
     * @return 结果
     */
    public int deletePublicAgreementByContractIds(Long[] contractIds);

    /**
     * 删除合同申请表信息
     *
     * @param contractId 合同申请表主键
     * @return 结果
     */
    public int deletePublicAgreementByContractId(Long contractId);
}
