package com.watimer.study.security.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.watimer.study.security.core.entity.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Watimer
 * @Description 角色权限关系DAO
 * @date 2020/1/11
 */
@Mapper
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenuEntity> {

}
