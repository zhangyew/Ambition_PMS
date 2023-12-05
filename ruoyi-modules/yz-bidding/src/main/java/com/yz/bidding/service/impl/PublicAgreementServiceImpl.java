package com.yz.bidding.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.system.api.domain.PublicContractdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicAgreementMapper;
import com.ruoyi.system.api.domain.PublicAgreement;
import com.yz.bidding.service.IPublicAgreementService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 合同Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicAgreementServiceImpl implements IPublicAgreementService
{
    @Resource
    private PublicAgreementMapper publicAgreementMapper;

    /**
     * 查询合同申请表
     *
     * @param contractId 合同申请表主键
     * @return 合同申请表
     */
    @Override
    public PublicAgreement selectPublicAgreementByContractId(Long contractId)
    {
        return publicAgreementMapper.selectPublicAgreementByContractId(contractId);
    }

    /**
     * 查询合同申请表列表
     *
     * @param publicAgreement 合同申请表
     * @return 合同申请表
     */
    @Override
    public List<PublicAgreement> selectPublicAgreementList(PublicAgreement publicAgreement)
    {
        return publicAgreementMapper.selectPublicAgreementList(publicAgreement);
    }

    /**
     * 新增合同申请表
     *
     * @param publicAgreement 合同申请表
     * @return 结果
     */
    @Transactional
    @Override
    public int insertPublicAgreement(PublicAgreement publicAgreement)
    {
        publicAgreement.setCreateTime(DateUtils.getNowDate());
        int rows = publicAgreementMapper.insertPublicAgreement(publicAgreement);
        insertPublicContractdetails(publicAgreement);
        return rows;
    }

    /**
     * 修改合同申请表
     *
     * @param publicAgreement 合同申请表
     * @return 结果
     */
    @Transactional
    @Override
    public int updatePublicAgreement(PublicAgreement publicAgreement)
    {
        publicAgreement.setUpdateTime(DateUtils.getNowDate());
        publicAgreementMapper.deletePublicContractdetailsByContractId(publicAgreement.getContractId());
        insertPublicContractdetails(publicAgreement);
        return publicAgreementMapper.updatePublicAgreement(publicAgreement);
    }

    /**
     * 批量删除合同申请表
     *
     * @param contractIds 需要删除的合同申请表主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePublicAgreementByContractIds(Long[] contractIds)
    {
        publicAgreementMapper.deletePublicContractdetailsByContractIds(contractIds);
        return publicAgreementMapper.deletePublicAgreementByContractIds(contractIds);
    }

    /**
     * 删除合同申请表信息
     *
     * @param contractId 合同申请表主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePublicAgreementByContractId(Long contractId)
    {
        publicAgreementMapper.deletePublicContractdetailsByContractId(contractId);
        return publicAgreementMapper.deletePublicAgreementByContractId(contractId);
    }

    /**
     * 新增合同明细信息
     *
     * @param publicAgreement 合同申请表对象
     */
    public void insertPublicContractdetails(PublicAgreement publicAgreement)
    {
        List<PublicContractdetails> publicContractdetailsList = publicAgreement.getPublicContractdetailsList();
        Long contractId = publicAgreement.getContractId();
        if (StringUtils.isNotNull(publicContractdetailsList))
        {
            List<PublicContractdetails> list = new ArrayList<PublicContractdetails>();
            for (PublicContractdetails publicContractdetails : publicContractdetailsList)
            {
                publicContractdetails.setContractId(contractId);
                list.add(publicContractdetails);
            }
            if (list.size() > 0)
            {
                publicAgreementMapper.batchPublicContractdetails(list);
            }
        }
    }
}
