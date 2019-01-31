package com.feng.service;


import com.feng.domain.SysRole;
import com.feng.dto.RoleDto;
import com.feng.vo.Result;

import java.util.List;

/**
 * Created on 2018/2/9.
 *
 * @author zlf
 * @since 1.0
 */
public interface SysRoleService extends MerryyouBaseService<SysRole>{

    List<RoleDto> findAlls();

    Result saveRole(String data);

    RoleDto findRole(String id);

    Result<String> delRoles(String ids);
}
