package com.watimer.study.mybatis.entity;

import lombok.Data;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/6/4
 */
@Data
public class ProductColor {

    private Integer id;

    private Integer product_size_id;

    private Integer product_model_id;

    private String product_code;

    private String product_color;
}
