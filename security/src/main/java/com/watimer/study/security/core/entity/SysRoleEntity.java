package com.watimer.study.security.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Watimer
 * @Description 角色实体
 * @date 2020/1/11
 */
@Data
@TableName("sys_role")
public class SysRoleEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 角色ID
     */
    @TableId
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;
}
