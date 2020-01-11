package com.watimer.study.security.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.watimer.study.security.core.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @param
 * @author Watimer
 * @Description 权限DAO
 * @date 2020/1/11
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenuEntity> {
}
