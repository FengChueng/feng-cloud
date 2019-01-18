package com.feng.pojo;

import java.io.Serializable;

public class UpmsUserPermission implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 权限编号
     */
    private Integer permissionId;

    /**
     * 权限类型(-1:减权限,1:增权限)
     */
    private Byte type;

    private static final long serialVersionUID = 1L;

}