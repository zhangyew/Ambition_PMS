package com.yz.bidding.service.impl;

import java.util.List;

import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.system.api.domain.PublicSuppliedMaterials;
import com.yz.bidding.mapper.PublicSuppliedMaterialsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicSupplyMapper;
import com.ruoyi.system.api.domain.PublicSupply;
import com.yz.bidding.service.IPublicSupplyService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 供应商供货表Service业务层处理
 *
 * @author zhangye
 * @date 2023-11-21
 */
@Service
@Transactional
public class PublicSupplyServiceImpl implements IPublicSupplyService {
    @Resource
    private PublicSupplyMapper publicSupplyMapper;
    @Resource
    private PublicSuppliedMaterialsMapper suppliedMaterialsMapper;

    @Override
    public int insertSupping(PublicSupply publicSupply, List<PublicSuppliedMaterials> list) {
        int x = 0;
        PublicSupply supply = new PublicSupply();
        supply = publicSupply;
        if (supply.getSupplyId() == null) //新增
            x = publicSupplyMapper.insertPublicSupply(supply);
        else {
            // 修改
            x = publicSupplyMapper.updatePublicSupply(supply);
            x = suppliedMaterialsMapper.deleteSupplieById(supply.getSupplyId());
        }
        for (PublicSuppliedMaterials p : list) {
            p.setSupplyId(supply.getSupplyId());
            x = suppliedMaterialsMapper.insertPublicSuppliedMaterials(p);
        }

        return x;
    }

    @Override
    public PublicSupply findSupplyById(String sid) {
        return publicSupplyMapper.findPublicSupplyById(sid);
    }

    /**
     * 查询供应商供货表
     *
     * @param supplyId 供应商供货表主键
     * @return 供应商供货表
     */
    @Override
    public PublicSupply selectPublicSupplyBySupplyId(Long supplyId) {
        return publicSupplyMapper.selectPublicSupplyBySupplyId(supplyId);
    }

    /**
     * 查询供应商供货表列表
     *
     * @param publicSupply 供应商供货表
     * @return 供应商供货表
     */
    @Override
    public List<PublicSupply> selectPublicSupplyList(PublicSupply publicSupply) {
        return publicSupplyMapper.selectPublicSupplyList(publicSupply);
    }

    /**
     * 新增供应商供货表
     *
     * @param publicSupply 供应商供货表
     * @return 结果
     */
    @Override
    public int insertPublicSupply(PublicSupply publicSupply) {
        publicSupply.setCreateTime(DateUtils.getNowDate());
        return publicSupplyMapper.insertPublicSupply(publicSupply);
    }

    /**
     * 修改供应商供货表
     *
     * @param publicSupply 供应商供货表
     * @return 结果
     */
    @Override
    public int updatePublicSupply(PublicSupply publicSupply) {
        publicSupply.setUpdateTime(DateUtils.getNowDate());
        return publicSupplyMapper.updatePublicSupply(publicSupply);
    }

    /**
     * 批量删除供应商供货表
     *
     * @param supplyIds 需要删除的供应商供货表主键
     * @return 结果
     */
    @Override
    public int deletePublicSupplyBySupplyIds(Long[] supplyIds) {
        return publicSupplyMapper.deletePublicSupplyBySupplyIds(supplyIds);
    }

    /**
     * 删除供应商供货表信息
     *
     * @param supplyId 供应商供货表主键
     * @return 结果
     */
    @Override
    public int deletePublicSupplyBySupplyId(Long supplyId) {
        return publicSupplyMapper.deletePublicSupplyBySupplyId(supplyId);
    }
}
