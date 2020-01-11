package com.watimer.study.security.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.watimer.study.security.core.entity.SysMenuEntity;
import com.watimer.study.security.core.entity.SysRoleEntity;
import com.watimer.study.security.core.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Watimer
 * @Description 系统用户DAO
 * @date 2020/1/11
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    /**
     * 通过用户ID查询角色集合
     * @Author Watimer
     * @CreateTime 2020/1/11
     * @Param  userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    List<SysRoleEntity> selectSysRoleByUserId(Long userId);
    /**
     * 通过用户ID查询权限集合
     * @Author Watimer
     * @CreateTime 2020/1/11
     * @Param  userId 用户ID
     * @Return List<SysMenuEntity> 角色名集合
     */
    List<SysMenuEntity> selectSysMenuByUserId(Long userId);

}