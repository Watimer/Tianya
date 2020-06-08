package com.watimer.study.mybatis.entity;

import lombok.Data;

import java.util.List;

/**
 * @param
 * @author watimer
 * @Description
 * @date 2020/6/4
 */
@Data
public class Product {

    private String pi_code;
    private String pi_name;
    private Integer pi_status;
    private String pi_category;
    private String pi_unit;
    private String pi_head_url;

    private List<ProductSize> productSizes;
}
