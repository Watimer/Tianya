package com.watimer.study.mybatis.entity;

import lombok.Data;

import java.util.List;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/6/4
 */

@Data
public class ProductSize {

    private Integer id;

    private String product_code;

    private String product_size;

    private List<ProductModel> productModels;
}
