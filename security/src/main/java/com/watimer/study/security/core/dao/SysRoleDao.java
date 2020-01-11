package com.watimer.study.security.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.watimer.study.security.core.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Watimer
 * @Description 角色DAO
 * @date 2020/1/11
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
}
