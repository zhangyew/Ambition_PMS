package com.yz.bidding.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import com.yz.bidding.vo.PurchaseContractsVo;
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

    @Override
    public PublicContractdetails selectPublicContractdetailsByContractdetailsId(Long contractdetailsId) {
        return publicContractdetailsMapper.selectPublicContractdetailsByContractdetailsId(contractdetailsId);
    }

    /**
     * 查询合同明细
     * 
     * @param contractdetailsId 合同明细主键
     * @return 合同明细
     */
    @Override
    public List<PurchaseContractsVo> selectContractDetailsId(Long contractdetailsId)
    {
        System.out.println(publicContractdetailsMapper.selectContractDetailsId(contractdetailsId));
        return publicContractdetailsMapper.selectContractDetailsId(contractdetailsId);
    }

    /**
     * 查询合同所有列表
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
     * 供应商合同列表
     * @param
     * @param vendorId
     * @return
     */
    @Override
    public List<PublicContractdetails> selectVendorList(Long vendorId) {
        return publicContractdetailsMapper.selectVendorList(vendorId);
    }

    /**
     * 供应商首页（我的合同）
     * @param vendorId
     * @return
     */
    @Override
    public List<PublicContractdetails> VendorContractId(Long vendorId) {
        return publicContractdetailsMapper.VendorContractId(vendorId);
    }

    /**
     * 合同总数
     * @return
     */
    @Override
    public Integer ContractCount() {
        return publicContractdetailsMapper.ContractCount();
    }

    /**
     * 合同总金额
     * @return
     */
    @Override
    public Double ContractSum() {
        return publicContractdetailsMapper.ContractSum();
    }

    /**
     * 合同总数
     * @return
     */
    @Override
    public Integer ContractCounts(Long vendorId) {
        return publicContractdetailsMapper.ContractCounts(vendorId);
    }

    /**
     * 合同总金额
     * @return
     */
    @Override
    public Double ContractSums(Long vendorId) {
        return publicContractdetailsMapper.ContractSums(vendorId);
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

    @Override
    public int upConState(Long conId) {
        return publicContractdetailsMapper.upConState(conId);
    }

    @Override
    public int upCon(Long conId) {
        return publicContractdetailsMapper.upCon(conId);
    }
}
