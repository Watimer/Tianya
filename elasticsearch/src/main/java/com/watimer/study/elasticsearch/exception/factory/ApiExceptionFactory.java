package com.watimer.study.elasticsearch.exception.factory;


import com.watimer.study.elasticsearch.exception.ApiException;

/**
 * @author 李锋镝
 * @date Create at 13:39 2019/9/5
 */
public interface ApiExceptionFactory {

    String prefix();

    default ApiException apply(String errorCode, String errorMsg) {
        return new ApiException(this.prefix() + errorCode, errorMsg);
    }
}
