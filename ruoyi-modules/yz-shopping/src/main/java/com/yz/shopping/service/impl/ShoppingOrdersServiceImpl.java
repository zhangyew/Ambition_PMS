package com.yz.shopping.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.system.api.RemoteFileService;
import com.ruoyi.system.api.domain.PublicAnnex;
import com.ruoyi.system.api.domain.SysFile;
import com.yz.bidding.domain.BiddingTenderNotice;
import com.yz.bidding.mapper.PublicAnnexMapper;
import com.yz.shopping.domain.ShoppingBuyPlan;
import com.yz.shopping.domain.ShoppingDemand;
import com.yz.shopping.mapper.ShoppingDemandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.ShoppingOrdersMapper;
import com.yz.shopping.domain.ShoppingOrders;
import com.yz.shopping.service.IShoppingOrdersService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 采购订单表Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-20
 */
@Service
public class ShoppingOrdersServiceImpl implements IShoppingOrdersService 
{
    @Autowired
    private ShoppingOrdersMapper shoppingOrdersMapper;

    @Autowired
    private ShoppingDemandMapper shoppingDemandMapper;

    @Resource
    private PublicAnnexMapper publicAnnexMapper;


    /**
     * 查询采购订单表
     * 
     * @param orderId 采购订单表主键
     * @return 采购订单表
     */
    @Override
    public ShoppingOrders selectShoppingOrdersByOrderId(Long orderId)
    {
        ShoppingOrders orders= shoppingOrdersMapper.selectShoppingOrdersByOrderId(orderId);
        if (ObjectUtils.isEmpty(orders)) {
            return null;
        }
        if (!ObjectUtils.isEmpty(orders.getOrderMaterialId())){
            String[] str = orders.getOrderMaterialId().split(",");
            List<ShoppingDemand> shoppingDemands = new ArrayList<>();
            for (String s : str) {
                ShoppingDemand shoppingDemand = shoppingDemandMapper.selectShoppingDemandByDemandId(Long.parseLong(s));
                shoppingDemands.add(shoppingDemand);
            }
            orders.setShoppingDemands(shoppingDemands);
        }
        return orders ;
    }

    /**
     * 查询采购订单表列表
     * 
     * @param shoppingOrders 采购订单表
     * @return 采购订单表
     */
    @Override
    public List<ShoppingOrders> selectShoppingOrdersList(ShoppingOrders shoppingOrders)
    {
        return shoppingOrdersMapper.selectShoppingOrdersList(shoppingOrders);
    }

    /**
     * 供应商首页（我的订单）
     * @param oSupplierId
     * @return
     */
    @Override
    public List<ShoppingOrders> showOrderSupplierId(Long oSupplierId) {
        return shoppingOrdersMapper.showOrderSupplierId(oSupplierId);
    }

    /**
     * 收货单（详情显示）
     * @param orderId
     * @return
     */
    @Override
    public ShoppingOrders showsDetailsReceipt(Long orderId) {
        return shoppingOrdersMapper.showsDetailsReceipt(orderId);
    }

    @Override
    public int addOrders(ShoppingOrders shoppingOrders, List<PublicAnnex> annexList) {
        shoppingOrders.setCreateTime(DateUtils.getNowDate());
        shoppingOrders.setTypeOrderState(0L);
        String id = "";
        for (ShoppingDemand sd : shoppingOrders.getShoppingDemands()) {
//            int row = shoppingDemandMapper.insertShoppingDemand(sd);
//            if (row <= 0) {
//                throw new RuntimeException("采购订单详情添加失败");
//            }
            id += sd.getDemandId() + ",";
        }
        id = id.substring(0, id.lastIndexOf(","));
        shoppingOrders.setOrderMaterialId(id);
        for (PublicAnnex a : annexList) {
            a.setUpTime(new Date());//上传时间
            int x = publicAnnexMapper.insertPublicAnnex(a);
            if (x <= 0) {
                throw new RuntimeException("采购订单附件添加失败");
            }
        }
        int row = shoppingOrdersMapper.insertShoppingOrders(shoppingOrders);
        if (row <= 0) {
            throw new RuntimeException("采购订单添加失败");
        }
        return row;
    }

    /**
     * 新增采购订单表
     * 
     * @param shoppingOrders 采购订单表
     * @return 结果
     */
    @Override
    public int insertShoppingOrders(ShoppingOrders shoppingOrders)
    {
        shoppingOrders.setCreateTime(DateUtils.getNowDate());
        shoppingOrders.setTypeOrderState(0L);
        String id = "";
        for (ShoppingDemand sd : shoppingOrders.getShoppingDemands()) {
//            int row = shoppingDemandMapper.insertShoppingDemand(sd);
//            if (row <= 0) {
//                throw new RuntimeException("采购订单详情添加失败");
//            }
            id += sd.getDemandId() + ",";
        }
        id = id.substring(0, id.lastIndexOf(","));
        shoppingOrders.setOrderMaterialId(id);
//        for (PublicAnnex a : list) {
//            a.setUpTime(new Date());//上传时间
//           int x = publicAnnexMapper.insertPublicAnnex(a);
//            if (x <= 0) {
//                throw new RuntimeException("采购订单附件添加失败");
//            }
//        }
        int row = shoppingOrdersMapper.insertShoppingOrders(shoppingOrders);
        if (row <= 0) {
            throw new RuntimeException("采购订单添加失败");
        }
        return row;
//        return shoppingOrdersMapper.insertShoppingOrders(shoppingOrders);
    }

    /**
     * 修改采购订单表
     * 
     * @param shoppingOrders 采购订单表
     * @return 结果
     */
    @Override
    public int updateShoppingOrders(ShoppingOrders shoppingOrders)
    {
        shoppingOrders.setUpdateTime(DateUtils.getNowDate());
        return shoppingOrdersMapper.updateShoppingOrders(shoppingOrders);
    }

    /**
     * 修改待收货状态
     * @param orderId 采购订单表
     * @return
     */
    @Override
    public int updateOrderState(Long orderId) {
        return shoppingOrdersMapper.updateOrderState(orderId);
    }

    /**
     * 批量删除采购订单表
     * 
     * @param orderIds 需要删除的采购订单表主键
     * @return 结果
     */
    @Override
    public int deleteShoppingOrdersByOrderIds(Long[] orderIds)
    {
        return shoppingOrdersMapper.deleteShoppingOrdersByOrderIds(orderIds);
    }

    /**
     * 删除采购订单表信息
     * 
     * @param orderId 采购订单表主键
     * @return 结果
     */
    @Override
    public int deleteShoppingOrdersByOrderId(Long orderId)
    {
        return shoppingOrdersMapper.deleteShoppingOrdersByOrderId(orderId);
    }

    @Override
    public int updateExamine(ShoppingOrders shoppingOrders) {
        return shoppingOrdersMapper.updateExamine(shoppingOrders);
    }
}
