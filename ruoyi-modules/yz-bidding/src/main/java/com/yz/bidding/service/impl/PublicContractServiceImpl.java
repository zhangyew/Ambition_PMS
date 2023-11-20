package com.yz.bidding.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicContractMapper;
import com.ruoyi.system.api.domain.PublicContract;
import com.yz.bidding.service.IPublicContractService;

/**
 * 合同Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicContractServiceImpl implements IPublicContractService 
{
    @Autowired
    private PublicContractMapper publicContractMapper;

    /**
     * 查询合同
     * 
     * @param contractId 合同主键
     * @return 合同
     */
    @Override
    public PublicContract selectPublicContractByContractId(Long contractId)
    {
        return publicContractMapper.selectPublicContractByContractId(contractId);
    }

    /**
     * 查询合同列表
     * 
     * @param publicContract 合同
     * @return 合同
     */
    @Override
    public List<PublicContract> selectPublicContractList(PublicContract publicContract)
    {
        return publicContractMapper.selectPublicContractList(publicContract);
    }

    /**
     * 新增合同
     * 
     * @param publicContract 合同
     * @return 结果
     */
    @Override
    public int insertPublicContract(PublicContract publicContract)
    {
        publicContract.setCreateTime(DateUtils.getNowDate());
        return publicContractMapper.insertPublicContract(publicContract);
    }

    /**
     * 修改合同
     * 
     * @param publicContract 合同
     * @return 结果
     */
    @Override
    public int updatePublicContract(PublicContract publicContract)
    {
        publicContract.setUpdateTime(DateUtils.getNowDate());
        return publicContractMapper.updatePublicContract(publicContract);
    }

    /**
     * 批量删除合同
     * 
     * @param contractIds 需要删除的合同主键
     * @return 结果
     */
    @Override
    public int deletePublicContractByContractIds(Long[] contractIds)
    {
        return publicContractMapper.deletePublicContractByContractIds(contractIds);
    }

    /**
     * 删除合同信息
     * 
     * @param contractId 合同主键
     * @return 结果
     */
    @Override
    public int deletePublicContractByContractId(Long contractId)
    {
        return publicContractMapper.deletePublicContractByContractId(contractId);
    }
}
