package com.watimer.study.security.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.watimer.study.security.core.dao.SysRoleDao;
import com.watimer.study.security.core.entity.SysRoleEntity;
import com.watimer.study.security.core.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * @author Watimer
 * @Description 角色业务实现
 * @date 2020/1/11
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

}