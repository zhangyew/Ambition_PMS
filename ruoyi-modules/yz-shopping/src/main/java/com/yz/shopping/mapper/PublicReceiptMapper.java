package com.yz.shopping.mapper;

import java.util.List;
import com.ruoyi.system.api.domain.PublicReceipt;

/**
 * 收货单Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicReceiptMapper 
{
    /**
     * 查询收货单
     * 
     * @param receiptId 收货单主键
     * @return 收货单
     */
    public PublicReceipt selectPublicReceiptByReceiptId(Long receiptId);

    /**
     * 查询收货单列表
     * 
     * @param publicReceipt 收货单
     * @return 收货单集合
     */
    public List<PublicReceipt> selectPublicReceiptList(PublicReceipt publicReceipt);

    /**
     * 新增收货单
     * 
     * @param publicReceipt 收货单
     * @return 结果
     */
    public int insertPublicReceipt(PublicReceipt publicReceipt);

    /**
     * 修改收货单
     * 
     * @param publicReceipt 收货单
     * @return 结果
     */
    public int updatePublicReceipt(PublicReceipt publicReceipt);

    /**
     * 删除收货单
     * 
     * @param receiptId 收货单主键
     * @return 结果
     */
    public int deletePublicReceiptByReceiptId(Long receiptId);

    /**
     * 批量删除收货单
     * 
     * @param receiptIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicReceiptByReceiptIds(Long[] receiptIds);
}
