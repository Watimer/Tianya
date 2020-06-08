package com.watimer.study.mybatis.dao;

import com.watimer.study.mybatis.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/6/4
 */
@Repository
public interface IndexDao {
    List<Product> listProduct();
}
