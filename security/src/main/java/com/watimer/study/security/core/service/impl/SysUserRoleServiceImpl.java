package com.watimer.study.security.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.watimer.study.security.core.dao.SysUserRoleDao;
import com.watimer.study.security.core.entity.SysUserRoleEntity;
import com.watimer.study.security.core.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author Watimer
 * @Description 用户与角色业务实现
 * @date 2020/1/11
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

}