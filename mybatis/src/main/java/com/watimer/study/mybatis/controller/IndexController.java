package com.watimer.study.mybatis.controller;

import com.watimer.study.mybatis.entity.Product;
import com.watimer.study.mybatis.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/6/4
 */
@RestController
@RequestMapping("Index")
@CrossOrigin()
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "listProduct",method = RequestMethod.GET)
    @ResponseBody
    public List<Product> listProduct(){
        List<Product> productList = indexService.listProduct();
        return productList;
    }
}
