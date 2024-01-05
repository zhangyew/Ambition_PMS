package com.yz.bidding.service;

import java.util.List;
import java.util.Map;

import com.yz.bidding.domain.BiddingNotice;
import com.yz.bidding.domain.BiddingTender;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 中标公告Service接口
 *
 * @author zhangye
 * @date 2023-11-21
 */
public interface IBiddingNoticeService {

    /**
     * 查询供应商公告信息
     * @param id
     * @return
     */
    public List<Map<String,Object>> findNotice(String id);

    /**
     * 查找项目下需要发送招标通知的集合
     *
     * @param id
     * @return
     */
    public List<Map<String, Object>> findNoticeTenderById(String id);

    /**
     * 查询项目下的中标结果公示
     *
     * @param id
     * @return
     */
    public List<BiddingNotice> findNoticeAllById(String id);

    /**
     * 添加中标公告
     *
     * @param notice
     * @return
     */
    public int updateNotice(List<BiddingNotice> notice);

    /**
     * 添加中标公告
     *
     * @param notice
     * @return
     */
    public int addNotice(List<BiddingTender> notice);

    /**
     * 查询中标公告
     *
     * @param noticeId 中标公告主键
     * @return 中标公告
     */
    public BiddingNotice selectBiddingNoticeByNoticeId(Long noticeId);

    /**
     * 查询中标公告列表
     *
     * @param biddingNotice 中标公告
     * @return 中标公告集合
     */
    public List<BiddingNotice> selectBiddingNoticeList(BiddingNotice biddingNotice);

    public List<BiddingNotice> selAll();

    /**
     * 供应商首页（通知公告）
     *
     * @return 通知公告集合
     */
    public List<BiddingNotice> showsNoticeList();

    /**
     * 新增中标公告
     *
     * @param biddingNotice 中标公告
     * @return 结果
     */
    public int insertBiddingNotice(BiddingNotice biddingNotice);

    /**
     * 修改中标公告
     *
     * @param biddingNotice 中标公告
     * @return 结果
     */
    public int updateBiddingNotice(BiddingNotice biddingNotice);

    /**
     * 批量删除中标公告
     *
     * @param noticeIds 需要删除的中标公告主键集合
     * @return 结果
     */
    public int deleteBiddingNoticeByNoticeIds(Long[] noticeIds);

    /**
     * 删除中标公告信息
     *
     * @param noticeId 中标公告主键
     * @return 结果
     */
    public int deleteBiddingNoticeByNoticeId(Long noticeId);
}
