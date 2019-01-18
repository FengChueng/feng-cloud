package com.feng.api;


import com.feng.pojo.LoginModel;
import com.feng.pojo.User;
import com.feng.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zhangyinglong on 2018/11/27.
 */
@Slf4j
@Api("用户api")
@RequestMapping("test")
@RestController
public class TestApi {
    Map<Integer,User> userInfo = new HashMap<>();
    Map<String,String> tokens = new HashMap<>();
    Integer primaryKey = 1;

    @PostConstruct
    public void init(){
        userInfo.put("zyl".hashCode(),new User(primaryKey++, "zyl", "123"));
    }

    @ApiOperation("注册")
    @PostMapping(value = "/user/register",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> register(@RequestParam String name, @RequestParam String pwd){
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)){
            return ResponseEntity.status(400).body("请填写用户名和密码");
        }
        if(userInfo.containsKey(name.trim().hashCode())){
            return ResponseEntity.status(400).body("用户名已存在");
        }
        User user = new User(primaryKey++, name, pwd);
        userInfo.put(name.hashCode(),user);
        log.info("当前创建用户：{}", JsonUtils.parse(user));
        return ResponseEntity.ok("创建成功");
    }

    @ApiOperation("登录")
    @PostMapping(value = "/user/login",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> login(@RequestBody LoginModel userinfo){
        log.info("用户登录:{}",userinfo.toString());
        String name = userinfo.getName();
        String pwd = userinfo.getPwd();
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)){
            return ResponseEntity.status(400).body("用户或密码错误");
        }
        User user = userInfo.get(name.trim().hashCode());
        if(user == null){
            return ResponseEntity.status(400).body("用户或密码错误");
        }
        if(!pwd.equals(user.getPassword())){
            return ResponseEntity.status(400).body("用户或密码错误");
        }
        String token = UUID.randomUUID().toString();
        tokens.put(token,name);
        return ResponseEntity.ok(token);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/user/info/{name}")
    public ResponseEntity<?> test(@PathVariable String name){
        log.info("获取用户信息:{}",name);
        if(StringUtils.isEmpty(name)){
            return ResponseEntity.status(400).body("用户不存在");
        }
        User user = userInfo.get(name.trim().hashCode());
        return ResponseEntity.ok(user);
    }

    @ApiOperation("根据token获取用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token",paramType = "header",dataTypeClass = String.class)
    })
    @GetMapping("/user/info")
    public ResponseEntity<?> userinfo(@RequestHeader String token){
        if(StringUtils.isEmpty(token)){
            return ResponseEntity.status(400).body("用户不存在");
        }
        String username = tokens.get(token);
        User user = userInfo.get(username.trim().hashCode());
        return ResponseEntity.ok(user);
    }

}
