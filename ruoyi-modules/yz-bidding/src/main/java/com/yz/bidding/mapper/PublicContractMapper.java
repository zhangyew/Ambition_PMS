package com.yz.bidding.mapper;

import java.util.List;
import com.ruoyi.system.api.domain.PublicContract;

/**
 * 合同Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicContractMapper 
{
    /**
     * 查询合同
     * 
     * @param contractId 合同主键
     * @return 合同
     */
    public PublicContract selectPublicContractByContractId(Long contractId);

    /**
     * 查询合同列表
     * 
     * @param publicContract 合同
     * @return 合同集合
     */
    public List<PublicContract> selectPublicContractList(PublicContract publicContract);

    /**
     * 新增合同
     * 
     * @param publicContract 合同
     * @return 结果
     */
    public int insertPublicContract(PublicContract publicContract);

    /**
     * 修改合同
     * 
     * @param publicContract 合同
     * @return 结果
     */
    public int updatePublicContract(PublicContract publicContract);

    /**
     * 删除合同
     * 
     * @param contractId 合同主键
     * @return 结果
     */
    public int deletePublicContractByContractId(Long contractId);

    /**
     * 批量删除合同
     * 
     * @param contractIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicContractByContractIds(Long[] contractIds);
}
