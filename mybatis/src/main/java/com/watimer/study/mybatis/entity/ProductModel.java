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
public class ProductModel {

    private Integer id;

    private Integer product_size_id;

    private String product_model;

    private List<ProductColor> productColors;

    private List<ProductImage> productImages;
}
