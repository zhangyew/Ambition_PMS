package com.yz.bidding.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.system.api.domain.PublicAnnex;
import com.yz.bidding.domain.BiddingTenderProjects;
import com.yz.bidding.mapper.PublicAgreementMapper;
import com.yz.bidding.mapper.PublicAnnexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingTenderNoticeMapper;
import com.yz.bidding.domain.BiddingTenderNotice;
import com.yz.bidding.service.IBiddingTenderNoticeService;

import javax.annotation.Resource;

/**
 * 招标公告Service业务层处理
 *
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class BiddingTenderNoticeServiceImpl implements IBiddingTenderNoticeService {
    @Resource
    private BiddingTenderNoticeMapper biddingTenderNoticeMapper;
    @Resource
    private PublicAnnexMapper publicAnnexMapper;

    @Override
    public List<Map<String,Object>> findTenderNoticeList(String id,String name) {
        return biddingTenderNoticeMapper.findTenderNoticeList(id,name);
    }

    @Override
    public int addTenderNotice(BiddingTenderNotice bid, List<PublicAnnex> list) {
        int x = 0;
        BiddingTenderNotice notice = bid;
        if (notice.getTenderNoticeId() != null) {
            // 修改
            x = publicAnnexMapper.deleteAnnexTextByNoticeId(notice.getTenderNoticeId().toString());
            x = biddingTenderNoticeMapper.updateBiddingTenderNotice(notice);
        } else {
            x = biddingTenderNoticeMapper.insertBiddingTenderNotice(notice);
        }
        for (PublicAnnex a : list) {
            a.setAnnexText(notice.getTenderNoticeId().toString());
            a.setUpTime(new Date());
            x = publicAnnexMapper.insertPublicAnnex(a);
        }
        return x;
    }

    @Override
    public int updateState(String id, String zt) {
        return biddingTenderNoticeMapper.updateState(id, zt);
    }

    @Override
    public BiddingTenderProjects findNoticeById(String pid, String tid) {
        return biddingTenderNoticeMapper.findNoticeById(pid, tid);
    }

    /**
     * 查询招标公告
     *
     * @param tenderNoticeId 招标公告主键
     * @return 招标公告
     */
    @Override
    public BiddingTenderNotice selectBiddingTenderNoticeByTenderNoticeId(Long tenderNoticeId) {
        return biddingTenderNoticeMapper.selectBiddingTenderNoticeByTenderNoticeId(tenderNoticeId);
    }

    /**
     * 查询招标公告列表
     *
     * @param biddingTenderNotice 招标公告
     * @return 招标公告
     */
    @Override
    public List<BiddingTenderNotice> selectBiddingTenderNoticeList(BiddingTenderNotice biddingTenderNotice) {
        return biddingTenderNoticeMapper.selectBiddingTenderNoticeList(biddingTenderNotice);
    }

    /**
     * 供应商首页（招投标信息显示）
     *
     * @return
     */
    @Override
    public List<BiddingTenderNotice> ShowsTenderNoticeList() {
//        return biddingTenderNoticeMapper.ShowsTenderNoticeList();
        return new ArrayList<>();
    }

    /**
     * 供应商首页（通知公告）
     * @return
     */
    @Override
    public List<BiddingTenderNotice> displayTenderNoticeList() {
        return biddingTenderNoticeMapper.displayTenderNoticeList();
    }

    /**
     * 新增招标公告
     *
     * @param biddingTenderNotice 招标公告
     * @return 结果
     */
    @Override
    public int insertBiddingTenderNotice(BiddingTenderNotice biddingTenderNotice) {
        return biddingTenderNoticeMapper.insertBiddingTenderNotice(biddingTenderNotice);
    }

    /**
     * 修改招标公告
     *
     * @param biddingTenderNotice 招标公告
     * @return 结果
     */
    @Override
    public int updateBiddingTenderNotice(BiddingTenderNotice biddingTenderNotice) {
        return biddingTenderNoticeMapper.updateBiddingTenderNotice(biddingTenderNotice);
    }

    /**
     * 批量删除招标公告
     *
     * @param tenderNoticeIds 需要删除的招标公告主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderNoticeByTenderNoticeIds(Long[] tenderNoticeIds) {
        return biddingTenderNoticeMapper.deleteBiddingTenderNoticeByTenderNoticeIds(tenderNoticeIds);
    }

    /**
     * 删除招标公告信息
     *
     * @param tenderNoticeId 招标公告主键
     * @return 结果
     */
    @Override
    public int deleteBiddingTenderNoticeByTenderNoticeId(Long tenderNoticeId) {
        return biddingTenderNoticeMapper.deleteBiddingTenderNoticeByTenderNoticeId(tenderNoticeId);
    }

    @Override
    public List<BiddingTenderNotice> showsNoticeList() {
        return biddingTenderNoticeMapper.showsNoticeList();
    }
}
