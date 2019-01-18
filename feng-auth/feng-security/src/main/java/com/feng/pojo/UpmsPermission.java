package com.feng.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class UpmsPermission implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 服务提供账号操作菜单
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 服务提供账号操作菜单名字
     */
    private String name;

    /**
     * 服务提供账号操作菜单关键字
     */
    @Column(name = "option_key")
    private String optionKey;

    /**
     * 父级菜单
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * (目录1、菜单2、按钮3、uri4)
     */
    private Integer type;

    /**
     * 路径：/order/{*}
     */
    private String uri;

    /**
     * 权限：order:btn_add
     */
    private String permissions;

    /**
     * 允许的请求方式：POST
     */
    private String method;

    /**
     * 排序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 图标
     */
    private String icon;

    /**
     * 禁用0、正常1
     */
    private Integer enabled;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 0表示普通权限，1表示vip权限，主要针对于注册
     */
    private Integer vipPms;

    /**
     * 所属系统
     */
    @Column(name = "system_id")
    private Integer systemId;
}