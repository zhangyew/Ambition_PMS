package com.yz.bidding.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.api.domain.PublicVendor;
import com.yz.bidding.domain.BiddingTenderProjects;
import org.apache.ibatis.annotations.Param;

/**
 * 招标项目Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface BiddingTenderProjectsMapper 
{

    /**
     * 修改招标项目审核状态
     * @param id
     * @param zt
     * @return
     */
    public int updateStates(@Param("id") String id,@Param("zt") String zt);

    /**
     * 查询招标项目详情
     * @param pid
     * @return
     */
    public BiddingTenderProjects findProjectById(String pid);

    /**
     * 查询招标项目
     * 
     * @param tenderProjectsId 招标项目主键
     * @return 招标项目
     */
    public BiddingTenderProjects selectBiddingTenderProjectsByTenderProjectsId(Long tenderProjectsId);

    /**
     * 查询招标项目列表
     * 
     * @param biddingTenderProjects 招标项目
     * @return 招标项目集合
     */
    public List<BiddingTenderProjects> selectBiddingTenderProjectsList(BiddingTenderProjects biddingTenderProjects);

    /**
     * 项目显示（合同签订）
     * @param tenderProjectsNumber
     * @return
     */
    public List<BiddingTenderProjects> agreementTenderProjects(String tenderProjectsNumber);

    /**
     * 合同签订物料信息
     * @param tenderProjectsId
     * @param noticeSupplierId
     * @return
     */
    public List<BiddingTenderProjects> SHowsProjectRelatedItems(@Param("tenderProjectsId") Long tenderProjectsId,@Param("noticeSupplierId")Long noticeSupplierId);

    /**
     * 投标单物料信息
     * @param tenderProjectsId
     * @param vendorId
     * @return
     */
    public List<BiddingTenderProjects> deskShows(@Param("tenderNoticeId") Long tenderNoticeId,@Param("tenderProjectsId") Long tenderProjectsId,@Param("vendorId")Long vendorId);

    public List<Map<String,Object>> htShowVendorId(@Param("tenderProjectsId")Long tenderProjectsId);


    /**
     * 新增招标项目
     * 
     * @param biddingTenderProjects 招标项目
     * @return 结果
     */
    public int insertBiddingTenderProjects(BiddingTenderProjects biddingTenderProjects);

    /**
     * 修改招标项目
     * 
     * @param biddingTenderProjects 招标项目
     * @return 结果
     */
    public int updateBiddingTenderProjects(BiddingTenderProjects biddingTenderProjects);

    /**
     * 删除招标项目
     * 
     * @param tenderProjectsId 招标项目主键
     * @return 结果
     */
    public int deleteBiddingTenderProjectsByTenderProjectsId(Long tenderProjectsId);

    /**
     * 批量删除招标项目
     * 
     * @param tenderProjectsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBiddingTenderProjectsByTenderProjectsIds(Long[] tenderProjectsIds);
}
