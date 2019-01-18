package com.feng.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhangyinglong on 2019/1/18.
 */

@Data
@NoArgsConstructor
@Table(name = "test_date")
@Entity
public class TestDate extends BaseEntity{


    private String param;

    /**
     * 创建时间
     */
    @Column(name = "create_time0")
    @CreatedDate
    private Long createTime0;

    @LastModifiedDate
    @Column(name = "update_time0")
    private Long updateTime0;


    @Column(name = "create_date1",updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createDate1;
    @Column(name = "update_date1",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateDate1;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date2",updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date createDate2;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date2", insertable = false, updatable = false)
    @org.hibernate.annotations.UpdateTimestamp
    private Date updateDate2;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date3", updatable = false)
    @org.hibernate.annotations.Generated(GenerationTime.NEVER)
    private Date createDate3;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date3",insertable = false, updatable = false)
    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    private Date updateDate3;

}
