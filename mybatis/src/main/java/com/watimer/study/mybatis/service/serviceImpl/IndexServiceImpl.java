package com.watimer.study.mybatis.service.serviceImpl;

import com.watimer.study.mybatis.dao.IndexDao;
import com.watimer.study.mybatis.entity.Product;
import com.watimer.study.mybatis.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/6/4
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexDao indexDao;

    @Override
    public List<Product> listProduct() {
        return indexDao.listProduct();
    }
}
