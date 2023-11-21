package com.yz.shopping.mapper;

import java.util.List;
import com.ruoyi.system.api.domain.PublicUser;

/**
 * 用户表Mapper接口
 * 
 * @author zhangye
 * @date 2023-11-21
 */
public interface PublicUserMapper 
{

    /**
     * 采购部登录
     * @param account
     * @param password
     * @return
     */
    public PublicUser login(String account,String password);


    /**
     * 查询用户表
     * 
     * @param userId 用户表主键
     * @return 用户表
     */
    public PublicUser selectPublicUserByUserId(Long userId);

    /**
     * 查询用户表列表
     * 
     * @param publicUser 用户表
     * @return 用户表集合
     */
    public List<PublicUser> selectPublicUserList(PublicUser publicUser);

    /**
     * 新增用户表
     * 
     * @param publicUser 用户表
     * @return 结果
     */
    public int insertPublicUser(PublicUser publicUser);

    /**
     * 修改用户表
     * 
     * @param publicUser 用户表
     * @return 结果
     */
    public int updatePublicUser(PublicUser publicUser);

    /**
     * 删除用户表
     * 
     * @param userId 用户表主键
     * @return 结果
     */
    public int deletePublicUserByUserId(Long userId);

    /**
     * 批量删除用户表
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePublicUserByUserIds(Long[] userIds);
}
