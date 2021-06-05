package com.learning.learning.entity.satoken;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Model: 系统角色表
 * @author jbk-xiao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XRole implements Serializable  {

    private static final long serialVersionUID = 1L;

    // ---------- 表中字段 ----------
    /** 角色id，--主键、自增 */
    public Long id;

    /** 角色名称, 唯一约束 */
    public String name;

    /** 角色详细描述 */
    public String info;

    /** 是否锁定(1=是,2=否), 锁定之后不可随意删除, 防止用户误操作 */
    public Integer isLock;

    /** 创建时间 */
    public Timestamp createTime;
}
