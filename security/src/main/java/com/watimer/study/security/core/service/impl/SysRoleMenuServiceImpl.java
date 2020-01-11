package com.watimer.study.security.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.watimer.study.security.core.dao.SysRoleMenuDao;
import com.watimer.study.security.core.entity.SysRoleMenuEntity;
import com.watimer.study.security.core.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * @param
 * @author Watimer
 * @Description 角色与权限业务实现
 * @date 2020/1/11
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {

}