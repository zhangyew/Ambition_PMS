package com.yz.shopping.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yz.shopping.mapper.PublicUserMapper;
import com.ruoyi.system.api.domain.PublicUser;
import com.yz.shopping.service.IPublicUserService;

/**
 * 用户表Service业务层处理
 * 
 * @author zhangye
 * @date 2023-11-21
 */
@Service
public class PublicUserServiceImpl implements IPublicUserService 
{
    @Autowired
    private PublicUserMapper publicUserMapper;

    @Override
    public PublicUser login(String account, String password) {
        return publicUserMapper.login(account, password);
    }

    /**
     * 查询用户表
     * 
     * @param userId 用户表主键
     * @return 用户表
     */
    @Override
    public PublicUser selectPublicUserByUserId(Long userId)
    {
        return publicUserMapper.selectPublicUserByUserId(userId);
    }

    /**
     * 查询用户表列表
     * 
     * @param publicUser 用户表
     * @return 用户表
     */
    @Override
    public List<PublicUser> selectPublicUserList(PublicUser publicUser)
    {
        return publicUserMapper.selectPublicUserList(publicUser);
    }

    /**
     * 新增用户表
     * 
     * @param publicUser 用户表
     * @return 结果
     */
    @Override
    public int insertPublicUser(PublicUser publicUser)
    {
        publicUser.setCreateTime(DateUtils.getNowDate());
        return publicUserMapper.insertPublicUser(publicUser);
    }

    /**
     * 修改用户表
     * 
     * @param publicUser 用户表
     * @return 结果
     */
    @Override
    public int updatePublicUser(PublicUser publicUser)
    {
        publicUser.setUpdateTime(DateUtils.getNowDate());
        return publicUserMapper.updatePublicUser(publicUser);
    }

    /**
     * 批量删除用户表
     * 
     * @param userIds 需要删除的用户表主键
     * @return 结果
     */
    @Override
    public int deletePublicUserByUserIds(Long[] userIds)
    {
        return publicUserMapper.deletePublicUserByUserIds(userIds);
    }

    /**
     * 删除用户表信息
     * 
     * @param userId 用户表主键
     * @return 结果
     */
    @Override
    public int deletePublicUserByUserId(Long userId)
    {
        return publicUserMapper.deletePublicUserByUserId(userId);
    }
}
