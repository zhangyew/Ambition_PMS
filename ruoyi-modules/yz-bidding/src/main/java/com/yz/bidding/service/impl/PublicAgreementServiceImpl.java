package com.yz.bidding.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.system.api.RemoteCodeRulesService;
import com.ruoyi.system.api.RemotePaymentService;
import com.ruoyi.system.api.domain.*;
import com.ruoyi.system.api.util.SnowflakeGetId;
import com.yz.bidding.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
    @Resource
    private PublicContractdetailsMapper publicContractDetailsMapper;
    @Resource
    private PublicCodeRulesMapper publicCodeRulesMapper;
    @Resource
    private PublicSigningsMapper publicSigningsMapper;
    @Autowired
    private RemotePaymentService remotePaymentService;

    @Resource
    private PublicAnnexMapper publicAnnexMapper;

    /**
     * 显示使用的合同(合同签订)
     * @param contractParent
     * @return
     */
    @Override
    public List<PublicAgreement> ShowPublicAgreement(Long contractParent){
        return publicAgreementMapper.ShowPublicAgreement(contractParent);
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
    public int insertPublicAgreement(PublicAgreement publicAgreement, PublicContractdetails publicContractdetails, PublicSignings publicSignings , List<PublicPayment> publicPayment ,List<PublicAnnex> publicAnnex)
    {
        publicAgreement.setCreateTime(DateUtils.getNowDate());
        publicContractdetails.setCreateTime(DateUtils.getNowDate());
        PublicAgreement agreement = publicAgreement;
        PublicContractdetails contractdetails=publicContractdetails;
        List<PublicPayment> publicPayments=publicPayment;
        List<PublicAnnex> publicAnnexs = publicAnnex;
        int x=0;
        PublicSignings signings =publicSignings;
        //合同申请
        x = publicAgreementMapper.insertPublicAgreement(publicAgreement);
        Long contract= agreement.getContractId();
        //付款详情
        String id = "";
        for (PublicPayment sd : publicPayments) {
            PublicPayment r =remotePaymentService.insertPublicPayment(sd);
            System.out.println(r);
            id += r.getPaymentId() + ",";
        }
        id = id.substring(0, id.lastIndexOf(","));
//        System.out.println("显示付款详情："+id);
        //合同详情
        PublicCodeRules rules = publicCodeRulesMapper.selectPublicCodeRulesByCodeRulesId(10L);
        contractdetails.setContractdetailsNumber(SnowflakeGetId.getCode(rules));
        contractdetails.setContractId(contract);
        contractdetails.setContractdetailsState(3L);
        contractdetails.setContractdetailsPaymentId(id);
        if (x <= 0) {
            throw new RuntimeException("采购需求添加失败");
        }
        x = publicContractDetailsMapper.insertPublicContractdetails(contractdetails);
        Long details= contractdetails.getContractdetailsId();
        //签署状态
        signings.setSigningContractdetailsId(details);
        x =publicSigningsMapper.insertPublicSignings(signings);
        //附件上传
        for (PublicAnnex ne : publicAnnex) {
            ne.setSupplyId(details);
            ne.setUpTime(DateUtils.getNowDate());

            x=publicAnnexMapper.insertPublicAnnex(ne);
        }
        return x;
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
//        publicAgreement.setUpdateTime(DateUtils.getNowDate());
//        publicAgreementMapper.deletePublicContractdetailsByContractId(publicAgreement.getContractId());
//        insertPublicContractdetails(publicAgreement);
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

//    /**
//     * 新增合同明细信息
//     *
//     * @param publicAgreement 合同申请表对象
//     */
//    public void insertPublicContractdetails(PublicAgreement publicAgreement)
//    {
//        List<PublicContractdetails> publicContractdetailsList = publicAgreement.getPublicContractdetailsList();
//        Long contractId = publicAgreement.getContractId();
//        if (StringUtils.isNotNull(publicContractdetailsList))
//        {
//            List<PublicContractdetails> list = new ArrayList<PublicContractdetails>();
//            for (PublicContractdetails publicContractdetails : publicContractdetailsList)
//            {
//                publicContractdetails.setContractId(contractId);
//                list.add(publicContractdetails);
//            }
//            if (list.size() > 0)
//            {
//                publicAgreementMapper.batchPublicContractdetails(list);
//            }
//        }
//    }
}
