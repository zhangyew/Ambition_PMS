package com.yz.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import com.yz.shopping.domain.ShoppingDemand;
import com.yz.shopping.domain.ShoppingOrders;
import com.yz.shopping.mapper.ShoppingDemandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.PublicReceiptMapper;
import com.ruoyi.system.api.domain.PublicReceipt;
import com.yz.shopping.service.IPublicReceiptService;

import javax.annotation.Resource;

/**
 * 收货单Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicReceiptServiceImpl implements IPublicReceiptService 
{
    @Resource
    private PublicReceiptMapper publicReceiptMapper;
    @Resource
    private ShoppingDemandMapper shoppingDemandMapper;

    /**
     * 查询收货单
     *
     * @param receiptId 收货单主键
     * @return 收货单
     */
    @Override
    public PublicReceipt selectPublicReceiptByReceiptId(Long receiptId)
    {
        return publicReceiptMapper.selectPublicReceiptByReceiptId(receiptId);
    }

    /**
     * 查询待收货单列表
     *
     * @param publicReceipt 收货单
     * @return 收货单
     */
    @Override
    public List<PublicReceipt> selectPublicReceiptList(PublicReceipt publicReceipt)
    {
        List<PublicReceipt> publicReceipts = publicReceiptMapper.selectPublicReceiptList(publicReceipt);
        List<PublicReceipt> receipts =new ArrayList<>();
        System.out.println("publicReceipt："+publicReceipts);
        PublicReceipt publicReceipt1=new PublicReceipt();
        for(PublicReceipt r : publicReceipts){
            Long count=0L;
            String [] str=r.getOrderMaterialId().split(",");
            for (String s: str) {
                ShoppingDemand shoppingDemand=shoppingDemandMapper.selectShoppingDemandByDemandId(Long.parseLong(s));
                Long amount=   shoppingDemand.getDemandCount();
                count+=amount;

            }
            r.setDemandCount(count);
            receipts.add(r);

        }
        return receipts;
    }
    /**
     * 查询收货单列表
     *
     * @param publicReceipt 收货单
     * @return 收货单
     */
    @Override
    public List<PublicReceipt> ShowsPublicReceiptList(PublicReceipt publicReceipt) {
        return publicReceiptMapper.ShowsPublicReceiptList(publicReceipt);
    }

    /**
     * 新增收货单
     *
     * @param publicReceipt 收货单
     * @return 结果
     */
    @Override
    public int insertPublicReceipt(PublicReceipt publicReceipt)
    {
        publicReceipt.setCreateTime(DateUtils.getNowDate());
        return publicReceiptMapper.insertPublicReceipt(publicReceipt);
    }

    /**
     * 修改收货单
     *
     * @param publicReceipt 收货单
     * @return 结果
     */
    @Override
    public int updatePublicReceipt(PublicReceipt publicReceipt)
    {
        publicReceipt.setUpdateTime(DateUtils.getNowDate());
        return publicReceiptMapper.updatePublicReceipt(publicReceipt);
    }

    /**
     * 批量删除收货单
     *
     * @param receiptIds 需要删除的收货单主键
     * @return 结果
     */
    @Override
    public int deletePublicReceiptByReceiptIds(Long[] receiptIds)
    {
        return publicReceiptMapper.deletePublicReceiptByReceiptIds(receiptIds);
    }

    /**
     * 删除收货单信息
     *
     * @param receiptId 收货单主键
     * @return 结果
     */
    @Override
    public int deletePublicReceiptByReceiptId(Long receiptId)
    {
        return publicReceiptMapper.deletePublicReceiptByReceiptId(receiptId);
    }
}
