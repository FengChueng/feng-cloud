package com.feng.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class UpmsRole implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编号
     *
     * @mbg.generated
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 角色标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 角色描述
     *
     * @mbg.generated
     */
    private String description;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Long ctime;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Long orders;
}