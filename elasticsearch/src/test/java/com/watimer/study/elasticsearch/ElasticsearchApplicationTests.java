package com.watimer.study.elasticsearch;

import com.watimer.study.elasticsearch.document.store.StoreBaseInfo;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.Resource;
import java.net.UnknownHostException;
import java.util.UUID;

@SpringBootTest
class ElasticsearchApplicationTests {

    @Resource
    ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void contextLoads() throws UnknownHostException {
        StoreBaseInfo storeBaseInfo = new StoreBaseInfo();
        storeBaseInfo.setStoreId(UUID.randomUUID().toString());
        storeBaseInfo.setStoreName("测试");

        elasticsearchTemplate.createIndex(UUID.randomUUID().toString(),storeBaseInfo);

    }

}
