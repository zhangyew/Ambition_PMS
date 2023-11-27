package com.yz.bidding.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicContractdetailsMapper;
import com.ruoyi.system.api.domain.PublicContractdetails;
import com.yz.bidding.service.IPublicContractdetailsService;

import javax.annotation.Resource;

/**
 * 合同明细Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicContractdetailsServiceImpl implements IPublicContractdetailsService 
{
    @Resource
    private PublicContractdetailsMapper publicContractdetailsMapper;

    /**
     * 查询合同明细
     * 
     * @param contractdetailsId 合同明细主键
     * @return 合同明细
     */
    @Override
    public PublicContractdetails selectPublicContractdetailsByContractdetailsId(Long contractdetailsId)
    {
        return publicContractdetailsMapper.selectPublicContractdetailsByContractdetailsId(contractdetailsId);
    }

    /**
     * 查询合同明细列表
     * 
     * @param publicContractdetails 合同明细
     * @return 合同明细
     */
    @Override
    public List<PublicContractdetails> selectPublicContractdetailsList(PublicContractdetails publicContractdetails)
    {
        return publicContractdetailsMapper.selectPublicContractdetailsList(publicContractdetails);
    }

    /**
     * 新增合同明细
     * 
     * @param publicContractdetails 合同明细
     * @return 结果
     */
    @Override
    public int insertPublicContractdetails(PublicContractdetails publicContractdetails)
    {
        publicContractdetails.setCreateTime(DateUtils.getNowDate());
        return publicContractdetailsMapper.insertPublicContractdetails(publicContractdetails);
    }

    /**
     * 修改合同明细
     * 
     * @param publicContractdetails 合同明细
     * @return 结果
     */
    @Override
    public int updatePublicContractdetails(PublicContractdetails publicContractdetails)
    {
        publicContractdetails.setUpdateTime(DateUtils.getNowDate());
        return publicContractdetailsMapper.updatePublicContractdetails(publicContractdetails);
    }

    /**
     * 批量删除合同明细
     * 
     * @param contractdetailsIds 需要删除的合同明细主键
     * @return 结果
     */
    @Override
    public int deletePublicContractdetailsByContractdetailsIds(Long[] contractdetailsIds)
    {
        return publicContractdetailsMapper.deletePublicContractdetailsByContractdetailsIds(contractdetailsIds);
    }

    /**
     * 删除合同明细信息
     * 
     * @param contractdetailsId 合同明细主键
     * @return 结果
     */
    @Override
    public int deletePublicContractdetailsByContractdetailsId(Long contractdetailsId)
    {
        return publicContractdetailsMapper.deletePublicContractdetailsByContractdetailsId(contractdetailsId);
    }
}
