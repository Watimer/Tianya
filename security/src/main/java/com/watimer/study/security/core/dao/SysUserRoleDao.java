package com.watimer.study.security.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.watimer.study.security.core.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Watimer
 * @Description 用户与角色关系DAO
 * @date 2020/1/11
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {

}
