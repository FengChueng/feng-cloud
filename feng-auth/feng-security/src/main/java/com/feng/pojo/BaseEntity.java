package com.feng.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangyinglong on 2019/1/18.
 */

@Setter
@Getter
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
@EntityListeners(value = AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;


    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "insert_time")
    protected Date insertTime;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "update_time")
    protected Date updateTime;

}
