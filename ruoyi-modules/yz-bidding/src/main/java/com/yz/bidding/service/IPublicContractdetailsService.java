package com.yz.bidding.service;

import java.util.List;
import com.ruoyi.system.api.domain.PublicContractdetails;

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
    public PublicContractdetails selectPublicContractdetailsByContractdetailsId(Long contractdetailsId);

    /**
     * 查询合同明细列表
     * 
     * @param publicContractdetails 合同明细
     * @return 合同明细集合
     */
    public List<PublicContractdetails> selectPublicContractdetailsList(PublicContractdetails publicContractdetails);

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
}
