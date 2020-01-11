package com.watimer.study.security.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.watimer.study.security.core.dao.SysMenuDao;
import com.watimer.study.security.core.entity.SysMenuEntity;
import com.watimer.study.security.core.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * @param
 * @author Watimer
 * @Description 权限业务实现
 * @date 2020/1/11
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {
}
