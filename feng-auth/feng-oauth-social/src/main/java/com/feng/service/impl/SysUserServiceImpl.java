package com.feng.service.impl;


import com.feng.domain.SysRole;
import com.feng.domain.SysUser;
import com.feng.dto.UserDto;
import com.feng.repository.SysRoleRepository;
import com.feng.repository.SysUserRepository;
import com.feng.security.social.SecurityConstants;
import com.feng.service.SysUserService;
import com.feng.uitls.ResultEnum;
import com.feng.uitls.ResultUtil;
import com.feng.vo.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/2/1 0001.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SysUserRepository userRepository;

    @Autowired
    private SysRoleRepository roleRepository;

    @Override
    public SysUser save(SysUser user) {
        user.setDelFlag("0");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtoList = new ArrayList<>();
        UserDto userDto;
        List<SysUser> userList = userRepository.findAll();
        for (SysUser user : userList) {
            userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public UserDto findOne(String id) {

        SysUser sysUser = userRepository.findById(id).get();
        if (sysUser != null) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(sysUser, userDto);
            List<SysRole> roleList = sysUser.getRoles();
            String roles = "";
            if (roleList != null && roleList.size() > 0) {
                for (SysRole role : roleList) {
                    roles += role.getId() + ",";
                }
            }
            userDto.setRoles(roles);
            return userDto;
        }
        return null;
    }

    @Override
    public Result save(String data) {
        List<UserDto> userDtoList = new Gson().fromJson(data,
                new TypeToken<List<UserDto>>() {
                }.getType());
        UserDto userDto = userDtoList.get(0);
        String roles = userDto.getRoles();
        if (StringUtils.isEmpty(roles)) return ResultUtil.error(ResultEnum.FAIL.getCode(), "请选择该用户角色！");
        List<SysRole> roleList = new ArrayList<>();
        SysRole sysRole;
        for (String str : roles.split(",")) {
            sysRole = roleRepository.findById(str).get();
            roleList.add(sysRole);
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        sysUser.setPassword(bCryptPasswordEncoder.encode(SecurityConstants.DEFAULT_PASSWORD));
        sysUser.getRoles().addAll(roleList);
        SysUser user = userRepository.save(sysUser);
        BeanUtils.copyProperties(user, userDto);
        return ResultUtil.success("用户保存成功！");
    }

    @Override
    public Result<String> delUsers(String ids) {
        if (StringUtils.isEmpty(ids)) return ResultUtil.error(ResultEnum.FAIL.getCode(), "请选择要删除的行！");
        String[] userIds = ids.split(",");
        for (String id : userIds) {
            userRepository.deleteById(id);
        }
        return ResultUtil.success("删除成功！");
    }
}
