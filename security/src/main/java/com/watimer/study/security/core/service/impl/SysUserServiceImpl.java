package com.watimer.study.security.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.watimer.study.security.core.dao.SysUserDao;
import com.watimer.study.security.core.entity.SysMenuEntity;
import com.watimer.study.security.core.entity.SysRoleEntity;
import com.watimer.study.security.core.entity.SysUserEntity;
import com.watimer.study.security.core.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Watimer
 * @Description 系统用户业务实现
 * @date 2020/1/11
 */

@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    /**
     * 根据用户名查询实体
     * @Author Watimer
     * @CreateTime 2020/1/11
     * @Param  username 用户名
     * @Return SysUserEntity 用户实体
     */
    @Override
    public SysUserEntity selectUserByName(String username) {
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUserEntity::getUsername,username);
        return this.baseMapper.selectOne(queryWrapper);
    }
    /**
     * 通过用户ID查询角色集合
     * @Author Watimer
     * @CreateTime 2020/1/11
     * @Param  userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    @Override
    public List<SysRoleEntity> selectSysRoleByUserId(Long userId) {
        return this.baseMapper.selectSysRoleByUserId(userId);
    }

    /**
     * 根据用户ID查询权限集合
     * @Author Watimer
     * @CreateTime 2020/1/11
     * @Param userId 用户ID
     * @Return List<SysMenuEntity> 角色名集合
     */
    @Override
    public List<SysMenuEntity> selectSysMenuByUserId(Long userId) {
        return this.baseMapper.selectSysMenuByUserId(userId);
    }
}