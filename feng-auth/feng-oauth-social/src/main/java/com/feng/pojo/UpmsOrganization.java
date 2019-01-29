package com.feng.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
//@Entity
public class UpmsOrganization implements Serializable {

    /**
     * 所属上级
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 组织描述
     */
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "insert_time",updatable = false,columnDefinition = "timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @org.hibernate.annotations.CreationTimestamp
//    @CreatedDate
    private Date insertTime;

    @Column(name = "insert_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    private static final long serialVersionUID = 1L;

}