package com.yz.bidding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.BiddingDownloadLogsMapper;
import com.yz.bidding.domain.BiddingDownloadLogs;
import com.yz.bidding.service.IBiddingDownloadLogsService;

/**
 * 标书下载记录表Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class BiddingDownloadLogsServiceImpl implements IBiddingDownloadLogsService 
{
    @Autowired
    private BiddingDownloadLogsMapper biddingDownloadLogsMapper;

    /**
     * 查询标书下载记录表
     * 
     * @param downloadLogsId 标书下载记录表主键
     * @return 标书下载记录表
     */
    @Override
    public BiddingDownloadLogs selectBiddingDownloadLogsByDownloadLogsId(Long downloadLogsId)
    {
        return biddingDownloadLogsMapper.selectBiddingDownloadLogsByDownloadLogsId(downloadLogsId);
    }

    /**
     * 查询标书下载记录表列表
     * 
     * @param biddingDownloadLogs 标书下载记录表
     * @return 标书下载记录表
     */
    @Override
    public List<BiddingDownloadLogs> selectBiddingDownloadLogsList(BiddingDownloadLogs biddingDownloadLogs)
    {
        return biddingDownloadLogsMapper.selectBiddingDownloadLogsList(biddingDownloadLogs);
    }

    /**
     * 新增标书下载记录表
     * 
     * @param biddingDownloadLogs 标书下载记录表
     * @return 结果
     */
    @Override
    public int insertBiddingDownloadLogs(BiddingDownloadLogs biddingDownloadLogs)
    {
        return biddingDownloadLogsMapper.insertBiddingDownloadLogs(biddingDownloadLogs);
    }

    /**
     * 修改标书下载记录表
     * 
     * @param biddingDownloadLogs 标书下载记录表
     * @return 结果
     */
    @Override
    public int updateBiddingDownloadLogs(BiddingDownloadLogs biddingDownloadLogs)
    {
        return biddingDownloadLogsMapper.updateBiddingDownloadLogs(biddingDownloadLogs);
    }

    /**
     * 批量删除标书下载记录表
     * 
     * @param downloadLogsIds 需要删除的标书下载记录表主键
     * @return 结果
     */
    @Override
    public int deleteBiddingDownloadLogsByDownloadLogsIds(Long[] downloadLogsIds)
    {
        return biddingDownloadLogsMapper.deleteBiddingDownloadLogsByDownloadLogsIds(downloadLogsIds);
    }

    /**
     * 删除标书下载记录表信息
     * 
     * @param downloadLogsId 标书下载记录表主键
     * @return 结果
     */
    @Override
    public int deleteBiddingDownloadLogsByDownloadLogsId(Long downloadLogsId)
    {
        return biddingDownloadLogsMapper.deleteBiddingDownloadLogsByDownloadLogsId(downloadLogsId);
    }
}
