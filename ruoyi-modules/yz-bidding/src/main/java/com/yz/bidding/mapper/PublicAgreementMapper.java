package com.yz.bidding.mapper;

import java.util.List;
import com.ruoyi.system.api.domain.PublicAgreement;
import com.ruoyi.system.api.domain.PublicContractdetails;

/**
 * 合同申请表Mapper接口
 *
 * @author zhangye
 * @date 2023-11-23
 */
public interface PublicAgreementMapper
{
    /**
     * 查询合同申请表
     *
     * @param contractId 合同申请表主键
     * @return 合同申请表
     */
    public PublicAgreement selectPublicAgreementByContractId(Long contractId);

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
    public int insertPublicAgreement(PublicAgreement publicAgreement);

    /**
     * 修改合同申请表
     *
     * @param publicAgreement 合同申请表
     * @return 结果
     */
    public int updatePublicAgreement(PublicAgreement publicAgreement);

    /**
     * 删除合同申请表
     *
     * @param contractId 合同申请表主键
     * @return 结果
     */
    public int deletePublicAgreementByContractId(Long contractId);

    /**
     * 批量删除合同申请表
     *
     * @param contractIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicAgreementByContractIds(Long[] contractIds);

    /**
     * 批量删除合同明细
     *
     * @param contractIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicContractdetailsByConContractIds(Long[] contractIds);

    /**
     * 批量新增合同明细
     *
     * @param publicContractdetailsList 合同明细列表
     * @return 结果
     */
    public int batchPublicContractdetails(List<PublicContractdetails> publicContractdetailsList);


    /**
     * 通过合同申请表主键删除合同明细信息
     *
     * @param contractId 合同申请表ID
     * @return 结果
     */
    public int deletePublicContractdetailsByConContractId(Long contractId);

}
