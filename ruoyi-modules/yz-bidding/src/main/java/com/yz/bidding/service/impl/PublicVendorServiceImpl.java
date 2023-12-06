package com.yz.bidding.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

import ch.qos.logback.classic.net.SocketNode;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.system.api.domain.PublicCodeRules;
import com.ruoyi.system.api.domain.PublicContacts;
import com.ruoyi.system.api.domain.PublicQualification;
import com.ruoyi.system.api.util.SnowflakeGetId;
import com.yz.bidding.mapper.PublicCodeRulesMapper;
import com.yz.bidding.mapper.PublicContactsMapper;
import com.yz.bidding.mapper.PublicQualificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.bidding.mapper.PublicVendorMapper;
import com.ruoyi.system.api.domain.PublicVendor;
import com.yz.bidding.service.IPublicVendorService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 供应商Service业务层处理
 *
 * @author zhangye
 * @date 2023-11-21
 */
@Service
@Transactional
public class PublicVendorServiceImpl implements IPublicVendorService {
    @Resource
    private PublicVendorMapper publicVendorMapper;
    @Resource
    private PublicCodeRulesMapper publicCodeRulesMapper;
    @Resource
    private PublicContactsMapper publicContactsMapper;
    @Resource
    private PublicQualificationMapper publicQualificationMapper;

    @Override
    public int insertVendor(Map<String, String> map) {
        System.out.println(map);
        int x = 0;
        Date date = new Date();
        // 编号使用 查询对应编码规则
        PublicCodeRules codeRules = publicCodeRulesMapper.selectPublicCodeRulesByCodeRulesId(1L);
        // 创建工具类对象
        SnowflakeGetId snowflakeGetId = new SnowflakeGetId(1, 1);
        // 获取编码
        String vendorNumber = snowflakeGetId.getCode(codeRules);
        // 供应商对象
        PublicVendor vendor = new PublicVendor();
        vendor.setAbbreviated(map.get("abbreviated"));
        vendor.setRanges(map.get("ranges"));
        vendor.setVendorNumber(vendorNumber); // 编号
        vendor.setCauses(map.get("causes"));
        vendor.setContractTypeTypeId(Long.parseLong(map.get("contractTypeTypeId")));
        vendor.setVendorTypeStateId(Long.parseLong(map.get("vendorTypeStateId")));
        vendor.setCreateBy(map.get("createBy"));
        vendor.setWarehouseAddress(map.get("warehouseAddress"));
        vendor.setDelegates(map.get("delegates"));
        vendor.setEmail(map.get("email"));
        vendor.setResponsible(map.get("responsible"));
        vendor.setResponsiblePhone(map.get("responsiblePhone"));
        vendor.setFax(map.get("fax"));
        vendor.setCreateTime(date);
        vendor.setIsBlacklist(1L);
        Instant format = null;
        format = Instant.parse(map.get("addTime"));
        date = Date.from(format);
        vendor.setAddTime(date);
        vendor.setIndustrialCommercial(map.get("industrialCommercial"));
        vendor.setProfile(map.get("profile"));
//        PublicVendor vendor1 = publicVendorMapper.insertVendor(vendor);
        if (map.get("vendorId") == null) // 添加
        {
            x = publicVendorMapper.insertPublicVendor(vendor);
        } else {
            // 修改
            vendor.setVendorId(Long.parseLong(map.get("vendorId")));
            vendor.setUpdateBy(map.get("updateBy"));
            vendor.setUpdateTime(new Date());
            x = publicVendorMapper.updatePublicVendor(vendor);
        }

        int vid = Math.toIntExact(vendor.getVendorId());
        PublicContacts contacts = new PublicContacts();
        contacts.setContactsVendorId((long) vid);
        contacts.setCall(map.get("call"));
        contacts.setDivision(map.get("division"));
        contacts.setPhone(map.get("phone"));
        contacts.setJob(map.get("job"));
        contacts.setMailbox(map.get("mailbox"));
        if (map.get("vendorId") == null) // 添加
        {
            x = publicContactsMapper.insertPublicContacts(contacts);
        } else // 修改
        {
            contacts.setContactsId(Long.parseLong(map.get("contactsId")));
            x = publicContactsMapper.updatePublicContacts(contacts);
        }
        String strQualification = JSON.toJSONString(map.get("qualificationList"));

        strQualification = strQualification.replace("\\", "");
        strQualification = strQualification.substring(strQualification.indexOf("\"") + 1);
        strQualification = strQualification.substring(0, strQualification.lastIndexOf("\"") + 1);
        System.out.println(strQualification);
        List<PublicQualification> qualificationList = null;
        JSONArray objects = JSONUtil.parseArray(strQualification);
        qualificationList = JSONUtil.toList(objects, PublicQualification.class);
        if (map.get("vendorId") != null)
            x = publicQualificationMapper.deleteVendorId(map.get("vendorId"));
        for (PublicQualification q : qualificationList) {
            q.setQualificationVendorId((long) vid);
            if (map.get("vendorId") == null) // 添加
            {
                x = publicQualificationMapper.insertPublicQualification(q);
            } else {
                // 修改
                x = publicQualificationMapper.insertPublicQualification(q);
            }

        }

        return x;
    }

    @Override
    public PublicVendor findVendorDetailed(int vid) {
        return publicVendorMapper.findVendorDetailed(vid);
    }

    /**
     * 查询供应商
     *
     * @param vendorId 供应商主键
     * @return 供应商
     */
    @Override
    public PublicVendor selectPublicVendorByVendorId(Long vendorId) {
        return publicVendorMapper.selectPublicVendorByVendorId(vendorId);
    }

    /**
     * 查询供应商列表
     *
     * @param publicVendor 供应商
     * @return 供应商
     */
    @Override
    public List<PublicVendor> selectPublicVendorList(PublicVendor publicVendor) {
        return publicVendorMapper.selectPublicVendorList(publicVendor);
    }

    @Override
    public List<PublicVendor> showsPublicVendorList(Long vendor_id) {
        return publicVendorMapper.showsPublicVendorList(vendor_id);
    }

    /**
     * 新增供应商
     *
     * @param publicVendor 供应商
     * @return 结果
     */
    @Override
    public int insertPublicVendor(PublicVendor publicVendor) {
        publicVendor.setCreateTime(DateUtils.getNowDate());
        return publicVendorMapper.insertPublicVendor(publicVendor);
    }

    /**
     * 修改供应商
     *
     * @param publicVendor 供应商
     * @return 结果
     */
    @Override
    public int updatePublicVendor(PublicVendor publicVendor) {
        publicVendor.setUpdateTime(DateUtils.getNowDate());
        return publicVendorMapper.updatePublicVendor(publicVendor);
    }

    /**
     * 批量删除供应商
     *
     * @param vendorIds 需要删除的供应商主键
     * @return 结果
     */
    @Override
    public int deletePublicVendorByVendorIds(Long[] vendorIds) {
        return publicVendorMapper.deletePublicVendorByVendorIds(vendorIds);
    }

    /**
     * 删除供应商信息
     *
     * @param vendorId 供应商主键
     * @return 结果
     */
    @Override
    public int deletePublicVendorByVendorId(Long vendorId) {
        return publicVendorMapper.deletePublicVendorByVendorId(vendorId);
    }
}
