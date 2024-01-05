package com.yz.bidding.mapper;

import java.util.List;
import com.ruoyi.system.api.domain.PublicContractdetails;
import com.yz.bidding.vo.PurchaseContractsVo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

/**
 * 合同明细Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicContractdetailsMapper
{
    /**
     * 查询合同明细
     * 
     * @param contractdetailsId 合同明细主键
     * @return 合同明细
     */
    public List<PurchaseContractsVo> selectContractDetailsId(Long contractdetailsId);
    /**
     * 查询合同明细
     *
     * @param contractdetailsId 合同明细主键
     * @return 合同明细
     */
    public PublicContractdetails selectPublicContractdetailsByContractdetailsId(Long contractdetailsId);

    int upConState(Long conId);
    int upCon(Long conId);
    /**
     * 查询合同明细列表
     * 
     * @param publicContractdetails 合同明细
     * @return 合同明细集合
     */
    public List<PublicContractdetails> selectPublicContractdetailsList(PublicContractdetails publicContractdetails);

    /**
     * 供应商合同列表
     * @param
     * @param vendorId
     * @return
     */
    public List<PublicContractdetails> selectVendorList(@Param("vendorId")Long vendorId);

    /**
     * 供应商首页（我的合同）
     * @param vendorId
     * @return
     */
    public List<PublicContractdetails> VendorContractId(@Param("vendorId") Long vendorId);

    /**
     * 合同总数
     * @return
     */
    public Integer ContractCount();

    /**
     * 合同总金额
     * @return
     */
    public Double ContractSum();

    /**
     * 合同总数
     * @return
     */
    public Integer ContractCounts(@Param("vendorId")Long vendorId);

    /**
     * 合同总金额
     * @return
     */
    public Double ContractSums(@Param("vendorId")Long vendorId);

    /**
     * 新增合同明细
     * 
     * @param publicContractdetails 合同明细
     * @return 结果
     */
    public int insertPublicContractdetails(PublicContractdetails publicContractdetails);

    /**
     * 修改合同明细
     * 
     * @param publicContractdetails 合同明细
     * @return 结果
     */
    public int updatePublicContractdetails(PublicContractdetails publicContractdetails);

    /**
     * 删除合同明细
     * 
     * @param contractdetailsId 合同明细主键
     * @return 结果
     */
    public int deletePublicContractdetailsByContractdetailsId(Long contractdetailsId);

    /**
     * 批量删除合同明细
     * 
     * @param contractdetailsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicContractdetailsByContractdetailsIds(Long[] contractdetailsIds);
}
