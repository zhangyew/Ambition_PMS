package com.yz.bidding.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.system.api.domain.PublicCodeRules;
import com.ruoyi.system.api.util.SnowflakeGetId;
import com.yz.bidding.domain.BiddingTender;
import com.yz.bidding.mapper.PublicCodeRulesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingNoticeMapper;
import com.yz.bidding.domain.BiddingNotice;
import com.yz.bidding.service.IBiddingNoticeService;

/**
 * 中标公告Service业务层处理
 *
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class BiddingNoticeServiceImpl implements IBiddingNoticeService {
    @Autowired
    private BiddingNoticeMapper biddingNoticeMapper;
    @Autowired
    private PublicCodeRulesMapper codeRulesMapper;

    @Override
    public List<Map<String, Object>> findNoticeTenderById(String id) {
        return biddingNoticeMapper.findNoticeTenderById(id);
    }

    @Override
    public List<BiddingNotice> findNoticeAllById(String id) {
        return biddingNoticeMapper.findNoticeAllById(id);
    }

    @Override
    public int updateNotice(List<BiddingNotice> notice) {
        int x = 0;
        for (BiddingNotice n : notice) {
            x = biddingNoticeMapper.updateBiddingNotice(n);
        }
        return x;
    }

    @Override
    public int addNotice(List<BiddingTender> notice) {
        int x = 0;
        for (BiddingTender n : notice) {
            BiddingNotice biddingNotice = new BiddingNotice();
            biddingNotice.setNoticeDate(new Date());
            PublicCodeRules codeRules = codeRulesMapper.selectPublicCodeRulesByCodeRulesId(15L);
            biddingNotice.setNoticeClod(SnowflakeGetId.getCode(codeRules));
            biddingNotice.setNoticeSupplierId(n.getTenderSupplierId());
            biddingNotice.setNoticeProjectId(Long.parseLong(n.getTenderAnnexId()));
            biddingNotice.setNoticeTitle(n.getTenderSupplierName() + "中标公示");
            System.out.println(biddingNotice);
            x = biddingNoticeMapper.insertBiddingNotice(biddingNotice);
        }
        return x;
    }

    /**
     * 查询中标公告
     *
     * @param noticeId 中标公告主键
     * @return 中标公告
     */
    @Override
    public BiddingNotice selectBiddingNoticeByNoticeId(Long noticeId) {
        return biddingNoticeMapper.selectBiddingNoticeByNoticeId(noticeId);
    }

    /**
     * 查询中标公告列表
     *
     * @param biddingNotice 中标公告
     * @return 中标公告
     */
    @Override
    public List<BiddingNotice> selectBiddingNoticeList(BiddingNotice biddingNotice) {
        return biddingNoticeMapper.selectBiddingNoticeList(biddingNotice);
    }

    @Override
    public List<BiddingNotice> selAll() {
        return biddingNoticeMapper.selAll();
    }

    /**
     * 供应商首页（通知公告）
     *
     * @return
     */
    @Override
    public List<BiddingNotice> showsNoticeList() {
        return biddingNoticeMapper.showsNoticeList();
    }

    /**
     * 新增中标公告
     *
     * @param biddingNotice 中标公告
     * @return 结果
     */
    @Override
    public int insertBiddingNotice(BiddingNotice biddingNotice) {
        return biddingNoticeMapper.insertBiddingNotice(biddingNotice);
    }

    /**
     * 修改中标公告
     *
     * @param biddingNotice 中标公告
     * @return 结果
     */
    @Override
    public int updateBiddingNotice(BiddingNotice biddingNotice) {
        return biddingNoticeMapper.updateBiddingNotice(biddingNotice);
    }

    /**
     * 批量删除中标公告
     *
     * @param noticeIds 需要删除的中标公告主键
     * @return 结果
     */
    @Override
    public int deleteBiddingNoticeByNoticeIds(Long[] noticeIds) {
        return biddingNoticeMapper.deleteBiddingNoticeByNoticeIds(noticeIds);
    }

    /**
     * 删除中标公告信息
     *
     * @param noticeId 中标公告主键
     * @return 结果
     */
    @Override
    public int deleteBiddingNoticeByNoticeId(Long noticeId) {
        return biddingNoticeMapper.deleteBiddingNoticeByNoticeId(noticeId);
    }
}
