package com.watimer.study.security.controller;

import com.watimer.study.security.common.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Watimer
 * @Description 初始页面
 * @date 2020/1/11
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    /**
     * 首页
     * @Author Watimer
     * @CreateTime 2020/1/11
     * @Return Map<String,Object> 返回数据MAP
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Map<String,Object> userLogin(){
        // 组装参数
        Map<String,Object> result = new HashMap<>();
        result.put("title","这里是首页不需要权限和登录拦截");
        return ResultUtil.resultSuccess(result);
    }
}
