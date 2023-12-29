package com.yz.bidding.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.system.api.domain.PublicAgreement;
import com.ruoyi.system.api.domain.PublicAnnex;
import com.ruoyi.system.api.domain.PublicContractdetails;
import com.ruoyi.system.api.domain.PublicPayment;
import com.yz.bidding.mapper.PublicAnnexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingTenderMapper;
import com.yz.bidding.domain.BiddingTender;
import com.yz.bidding.service.IBiddingTenderService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 投标Service业务层处理
 *
 * @author zhangye
 * @date 2023-11-21
 */
@Service
@Transactional
public class BiddingTenderServiceImpl implements IBiddingTenderService {
    @Resource
    private BiddingTenderMapper biddingTenderMapper;
    @Autowired
    private PublicAnnexMapper annexMapper;

    @Override
    public int bidEvaluation(List<BiddingTender> biddingTender, List<PublicAnnex> list) {
        int x = 0;
        for (BiddingTender bidder : biddingTender) {
            x = biddingTenderMapper.updateBiddingTender(bidder);
        }
        if (list != null) {
            for (PublicAnnex publicAnnex : list) {
                publicAnnex.setUpTime(new Date());
                x = annexMapper.insertPublicAnnex(publicAnnex);
            }
        }
        return x;
    }

    @Override
    public List<BiddingTender> findTendersStateByProjectsId(String id) {
        return biddingTenderMapper.findTendersStateByProjectsId(id);
    }

    @Override
    public int updateStateByTenderId(BiddingTender biddingTender) {
        return biddingTenderMapper.updateBiddingTender(biddingTender);
    }

    @Override
    public List<BiddingTender> findTendersByProjectsId(String pid, String zt,String sid) {
        return biddingTenderMapper.findTendersByProjectsId(pid, zt,sid);
    }

    @Override
    public int selBidCount(Long tnId,Long tsId) {
        return biddingTenderMapper.selBidCount(tnId,tsId);
    }

    /**
     * 查询投标
     *
     * @param tenderId 投标主键
     * @return 投标
     */
    @Override
    public BiddingTender selectBiddingTenderByTenderId(Long tenderId) {
        return biddingTenderMapper.selectBiddingTenderByTenderId(tenderId);
    }

    /**
     * 查询投标列表
     *
     * @param biddingTender 投标
     * @return 投标
     */
    @Override
    public List<BiddingTender> selectBiddingTenderList(BiddingTender biddingTender) {
        return biddingTenderMapper.selectBiddingTenderList(biddingTender);
    }

    /**
     * 新增投标
     *
     * @param biddingTender 投标
     * @return 结果
     */
    @Override
    public int insertBiddingTender(BiddingTender biddingTender) {

        return biddingTenderMapper.insertBiddingTender(biddingTender);
    }

    @Override
    public int insertBiddingTender(BiddingTender biddingTender, List<PublicAnnex> publicAnnex) {
        biddingTender.setTenderTime(DateUtils.getNowDate());
        BiddingTender tender = biddingTender;
        List<PublicAnnex> annex = publicAnnex;
        int x=0;
        //附件上传
        String id = "";
        for (PublicAnnex ne : annex) {
            ne.setUpTime(DateUtils.getNowDate());
            x=annexMapper.insertPublicAnnex(ne);
            id=ne.getAnnexId().toString();
        }
        tender.setTenderAnnexId(id);
        x=biddingTenderMapper.insertBiddingTender(tender);
        return x;
    }

    /**
     * 修改投标
     *
     * @param biddingTender 投标
     * @return 结果
     */
    @Override
    public int updateBiddingTender(BiddingTender biddingTender) {
        return biddingTenderMapper.updateBiddingTender(biddingTender);
    }

    /**
     * 批量删除投标
     *
     * @param tenderIds 需要删除的投标主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderByTenderIds(Long[] tenderIds) {
        return biddingTenderMapper.deleteBiddingTenderByTenderIds(tenderIds);
    }

    /**
     * 删除投标信息
     *
     * @param tenderId 投标主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderByTenderId(Long tenderId) {
        return biddingTenderMapper.deleteBiddingTenderByTenderId(tenderId);
    }
}
