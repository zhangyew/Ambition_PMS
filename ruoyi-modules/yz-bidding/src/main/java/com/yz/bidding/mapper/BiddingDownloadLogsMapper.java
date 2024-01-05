package com.yz.bidding.mapper;

import java.util.List;
import com.yz.bidding.domain.BiddingDownloadLogs;

/**
 * 标书下载记录表Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface BiddingDownloadLogsMapper 
{

    /**
     * 查询招标项目下的所有标书下载记录
     * @param nid
     * @return
     */
    public List<BiddingDownloadLogs> findDownloadLogsByTenderId(String nid);

    /**
     * 查询标书下载记录表
     * 
     * @param downloadLogsId 标书下载记录表主键
     * @return 标书下载记录表
     */
    public BiddingDownloadLogs selectBiddingDownloadLogsByDownloadLogsId(Long downloadLogsId);

    /**
     * 查询标书下载记录表列表
     * 
     * @param biddingDownloadLogs 标书下载记录表
     * @return 标书下载记录表集合
     */
    public List<BiddingDownloadLogs> selectBiddingDownloadLogsList(BiddingDownloadLogs biddingDownloadLogs);

    /**
     * 新增标书下载记录表
     * 
     * @param biddingDownloadLogs 标书下载记录表
     * @return 结果
     */
    public int insertBiddingDownloadLogs(BiddingDownloadLogs biddingDownloadLogs);

    /**
     * 修改标书下载记录表
     * 
     * @param biddingDownloadLogs 标书下载记录表
     * @return 结果
     */
    public int updateBiddingDownloadLogs(BiddingDownloadLogs biddingDownloadLogs);

    /**
     * 删除标书下载记录表
     * 
     * @param downloadLogsId 标书下载记录表主键
     * @return 结果
     */
    public int deleteBiddingDownloadLogsByDownloadLogsId(Long downloadLogsId);

    /**
     * 批量删除标书下载记录表
     * 
     * @param downloadLogsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBiddingDownloadLogsByDownloadLogsIds(Long[] downloadLogsIds);
}
