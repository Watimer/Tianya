package com.watimer.study.security.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.watimer.study.security.core.entity.SysMenuEntity;
import com.watimer.study.security.core.entity.SysRoleEntity;
import com.watimer.study.security.core.entity.SysUserEntity;

import java.util.List;

/**
 * @author Watimer
 * @Description 系统用户业务接口
 * @date 2020/1/11
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 根据用户名查询实体
     * @Author Watimer
     * @CreateTime 2020/1/11
     * @Param  username 用户名
     * @Return SysUserEntity 用户实体
     */
    SysUserEntity selectUserByName(String username);
    /**
     * 根据用户ID查询角色集合
     * @Author Watimer
     * @CreateTime 2020/1/11
     * @Param  userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    List<SysRoleEntity> selectSysRoleByUserId(Long userId);
    /**
     * 根据用户ID查询权限集合
     * @Author Watimer
     * @CreateTime 2020/1/11
     * @Param  userId 用户ID
     * @Return List<SysMenuEntity> 角色名集合
     */
    List<SysMenuEntity> selectSysMenuByUserId(Long userId);
}
