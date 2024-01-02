package com.yz.bidding.mapper;

import java.util.List;

import com.yz.bidding.domain.BiddingTender;
import org.apache.ibatis.annotations.Param;

/**
 * 投标Mapper接口
 *
 * @author zhangye
 * @date 2023-11-21
 */
public interface BiddingTenderMapper {

    /**
     * 查找该项目下状态为初审通过的投标信息
     * @param id
     * @return
     */
    public List<BiddingTender> findTendersStateByProjectsId(String id);
    Integer TenderSum();
    /**
     * 根据项目Id和状态查询投标信息
     *
     * @param pid
     * @param zt
     * @return
     */
    public List<BiddingTender> findTendersByProjectsId(@Param("pid") String pid
            , @Param("zt") String zt,@Param("sid")String sid);

    /**
     * 查询投标
     *
     * @param tenderId 投标主键
     * @return 投标
     */
    public BiddingTender selectBiddingTenderByTenderId(Long tenderId);

    /**
     * 查询投标列表
     *
     * @param biddingTender 投标
     * @return 投标集合
     */
    public List<BiddingTender> selectBiddingTenderList(BiddingTender biddingTender);

    /**
     * 新增投标
     *
     * @param biddingTender 投标
     * @return 结果
     */
    public int insertBiddingTender(BiddingTender biddingTender);

    /**
     * 修改投标
     *
     * @param biddingTender 投标
     * @return 结果
     */
    public int updateBiddingTender(BiddingTender biddingTender);

    /**
     * 删除投标
     *
     * @param tenderId 投标主键
     * @return 结果
     */
    public int deleteBiddingTenderByTenderId(Long tenderId);

    /**
     * 批量删除投标
     *
     * @param tenderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBiddingTenderByTenderIds(Long[] tenderIds);

    /**
     * 查询是否投标
     * @return
     */
    int selBidCount(Long tnId,Long tsId);
}
