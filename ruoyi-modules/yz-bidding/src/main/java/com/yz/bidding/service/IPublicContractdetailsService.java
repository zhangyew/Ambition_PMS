package com.yz.bidding.service;

import java.util.List;
import com.ruoyi.system.api.domain.PublicContractdetails;
import com.yz.bidding.vo.PurchaseContractsVo;

/**
 * 合同明细Service接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface IPublicContractdetailsService 
{
    /**
     * 查询合同明细
     * 
     * @param contractdetailsId 合同明细主键
     * @return 合同明细
     */
    public List<PurchaseContractsVo> selectContractDetailsId(Long contractdetailsId);

    /**
     * 查询合同明细列表
     * 
     * @param publicContractdetails 合同明细
     * @return 合同明细集合
     */
    public List<PublicContractdetails> selectPublicContractdetailsList(PublicContractdetails publicContractdetails);

    /**
     * 供应商首页（我的合同）
     * @param vendorId
     * @return
     */
    public List<PublicContractdetails> VendorContractId(Long vendorId);

    /**
     * 合同总数
     * @return
     */
    public Integer ContractCount();

    /**
     * 合同总金额
     * @return
     */
    public Double ContractSum();

    /**
     * 新增合同明细
     * 
     * @param publicContractdetails 合同明细
     * @return 结果
     */
    public int insertPublicContractdetails(PublicContractdetails publicContractdetails);

    /**
     * 修改合同明细
     * 
     * @param publicContractdetails 合同明细
     * @return 结果
     */
    public int updatePublicContractdetails(PublicContractdetails publicContractdetails);

    /**
     * 批量删除合同明细
     * 
     * @param contractdetailsIds 需要删除的合同明细主键集合
     * @return 结果
     */
    public int deletePublicContractdetailsByContractdetailsIds(Long[] contractdetailsIds);

    /**
     * 删除合同明细信息
     * 
     * @param contractdetailsId 合同明细主键
     * @return 结果
     */
    public int deletePublicContractdetailsByContractdetailsId(Long contractdetailsId);

    int upConState(Long conId);
}
