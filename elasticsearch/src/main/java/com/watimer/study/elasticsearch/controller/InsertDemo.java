package com.watimer.study.elasticsearch.controller;

import com.watimer.study.elasticsearch.docindex.repo.StoreRepository;
import com.watimer.study.elasticsearch.document.StoreDocument;
import com.watimer.study.elasticsearch.document.store.StoreBaseInfo;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @param
 * @author yan
 * @Description
 * @date 2020/7/27
 */
@ComponentScan
public class InsertDemo extends Thread{

    public InsertDemo(String name){
        super(name);
    }

    @Resource
    private StoreRepository storeRepository;

//    StoreRepository storeRepository = (StoreRepository)SpringContextUtil.getBeanById("storeRepository");


    @Override
    public void run() {
        synchronized ("11"){
            insert(1,1,1000000);
        }
    }


    private String insert(int a, int numStart, int numEnd){
        for(int i = numStart;i<numEnd;i++){
            StoreBaseInfo storeBaseInfo = new StoreBaseInfo();
            String uuid = UUID.randomUUID().toString();
            storeBaseInfo.setStoreId(uuid);
            storeBaseInfo.setStoreName("测试");
            storeBaseInfo.setStatus(UUID.randomUUID().toString());
            storeBaseInfo.setRegionCode(UUID.randomUUID().toString());
            storeBaseInfo.setRegionName(UUID.randomUUID().toString());
            storeBaseInfo.setStoreNo(UUID.randomUUID().toString());
            storeBaseInfo.setUpdatedUserName(UUID.randomUUID().toString());
            StoreDocument storeDocument = new StoreDocument();
            storeDocument.setBaseInfo(storeBaseInfo);
            storeDocument.setId(UUID.randomUUID().toString());

            storeRepository.save(storeDocument);
            System.out.println(i);
//            storeRepository.deleteAll();
        }
        return getName() +"： "+ a;
    }

    private StoreRepository getStoreRepository(StoreRepository storeRepository) {
        return storeRepository;
    }
}
